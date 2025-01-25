package edu.birzeit.GUI.EventHandlerCalsses;

import java.io.File;
import java.util.Scanner;

import edu.birzeit.GUI.AddEmployee;
import edu.birzeit.form.Address;
import edu.birzeit.form.CommessionEmployee;
import edu.birzeit.form.Employee;
import edu.birzeit.form.EmployeeBasedComession;
import edu.birzeit.form.HourlyEmployee;
import edu.birzeit.form.SalariedEmployee;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ReadEmployeeFromFileButtonHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirm Read");
        confirmAlert.setHeaderText("Read Employee Data");
        confirmAlert.setContentText("Are you sure you want to read the data from the file?\n\nIf the employee number is not existing we will add it as a new employee.");
        confirmAlert.getDialogPane().getButtonTypes().forEach(buttonType -> {
            Button button = (Button) confirmAlert.getDialogPane().lookupButton(buttonType);
            button.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
            // Action to be performed when the button is clicked
            button.setOnMouseEntered(ee -> {
                button.setScaleX(1.1); // Increase the scale by 10%
                button.setScaleY(1.1); 
                button.setStyle("-fx-background-color: lightgreen; -fx-border-color: darkgreen; -fx-border-width: 2px; -fx-border-radius: 5px;");
    
            });
    
            button.setOnMouseExited(ee -> {
                button.setScaleX(1); // Reset to normal scale
                button.setScaleY(1);
                button.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
            });
    
        });

        confirmAlert.showAndWait();

        if (confirmAlert.getResult() == ButtonType.OK) {
            try (Scanner input = new Scanner(new File("Data.txt"))) {
                while (input.hasNext()) {
                    String line = input.nextLine();
                    String[] parts = line.split(",");

                    if (parts.length < 15) {
                        System.out.println("Invalid line format: " + line);
                        continue;
                    }

                    String empNo = parts[1];
                    Employee existingEmployee = findEmployeeByEmpNo(empNo);

                    if (existingEmployee != null) {
                        showComparisonAlert(parts, existingEmployee);
                    }
                    else {
                        addNewEmployee(parts);
                    }
                }
            } catch (Exception e) {
                showErrorAlert("Error reading file: " + e.getMessage());
            }
        }
    }

    private Employee findEmployeeByEmpNo(String empNo) {
        for (Employee employee : AddEmployee.getInstance().getEmployeesObservableList()) {
            if (employee.getEmpno().equals(empNo)) {
                return employee;
            }
        }
        return null;
    }

    private void showComparisonAlert(String[] parts, Employee employee) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Compare Data");
        alert.setHeaderText("Compare Data from Array and File.");

        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Info \\ Employee"), 0, 0);
        gridPane.add(new Label("From File"), 1, 0);
        gridPane.add(new Label("From Array"), 2, 0);

        gridPane.add(new Label("Employee Number: "), 0, 1);
        gridPane.add(new Label(parts[1]), 1, 1);
        gridPane.add(new Label(employee.getEmpno()), 2, 1);

        gridPane.add(new Label("First Name: "), 0, 2);
        gridPane.add(new Label(parts[2]), 1, 2);
        gridPane.add(new Label(employee.getFirstName()), 2, 2);

        gridPane.add(new Label("Last Name: "), 0, 3);
        gridPane.add(new Label(parts[3]), 1, 3);
        gridPane.add(new Label(employee.getLastName()), 2, 3);

        gridPane.add(new Label("Date of Birth: "), 0, 4);
        gridPane.add(new Label(parts[4]), 1, 4);
        gridPane.add(new Label(employee.getDateOfBirth()), 2, 4);

        gridPane.add(new Label("Address: "), 0, 5);
        gridPane.add(new Label(parts[5] + "/" + parts[6] + "/" + parts[7]), 1, 5);
        gridPane.add(new Label(employee.getAddress().toString()), 2, 5);

        gridPane.add(new Label("Phone Number: "), 0, 6);
        gridPane.add(new Label(parts[8]), 1, 6);
        gridPane.add(new Label(employee.getPhoneNumber()), 2, 6);

        gridPane.add(new Label("Email: "), 0, 7);
        gridPane.add(new Label(parts[9]), 1, 7);
        gridPane.add(new Label(employee.getEmail()), 2, 7);

        gridPane.add(new Label("Nationality: "), 0, 8);
        gridPane.add(new Label(parts[10]), 1, 8);
        gridPane.add(new Label(employee.getNationality()), 2, 8);

        gridPane.add(new Label("Designation: "), 0, 9);
        gridPane.add(new Label(parts[11]), 1, 9);
        gridPane.add(new Label(employee.getDesignation()), 2, 9);

        gridPane.add(new Label("Education: "), 0, 10);
        gridPane.add(new Label(parts[12]), 1, 10);
        gridPane.add(new Label(employee.getEducation()), 2, 10);

        switch (parts[0]) {
            case "HourlyEmployee":
                addHourlyEmployeeDetails(gridPane, parts, (HourlyEmployee) employee);
                break;
            case "SalariedEmployee":
                addSalariedEmployeeDetails(gridPane, parts, (SalariedEmployee) employee);
                break;
            case "CommessionEmployee":
                addCommissionEmployeeDetails(gridPane, parts, (CommessionEmployee) employee);
                break;
            case "EmployeeBasedComession":
                addEmployeeBasedCommissionDetails(gridPane, parts, (EmployeeBasedComession) employee);
                break;
            default:
                break;
        }

        alert.getDialogPane().setContent(gridPane);
        ButtonType overrideButton = new ButtonType("Override");
        ButtonType addNewButton = new ButtonType("Add as New Employee");
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(overrideButton, addNewButton, cancelButton);

        alert.getDialogPane().getButtonTypes().forEach(buttonType -> {
            Button button = (Button) alert.getDialogPane().lookupButton(buttonType);
            button.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
            // Action to be performed when the button is clicked
            button.setOnMouseEntered(ee -> {
                button.setScaleX(1.1); // Increase the scale by 10%
                button.setScaleY(1.1); 
                button.setStyle("-fx-background-color: lightgreen; -fx-border-color: darkgreen; -fx-border-width: 2px; -fx-border-radius: 5px;");
    
            });
    
            button.setOnMouseExited(ee -> {
                button.setScaleX(1); // Reset to normal scale
                button.setScaleY(1);
                button.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
            });
    
        });

        alert.showAndWait();

        if (alert.getResult() == overrideButton) {
            overrideEmployee(parts, employee);
        } else if (alert.getResult() == addNewButton) {
            addNewEmployee(parts);
        }
    }

    private void addHourlyEmployeeDetails(GridPane gridPane, String[] parts, HourlyEmployee employee) {
        gridPane.add(new Label("Hours: "), 0, 11);
        gridPane.add(new Label(parts[14]), 1, 11);
        gridPane.add(new Label(String.valueOf(employee.getHours())), 2, 11);

        gridPane.add(new Label("Rate: "), 0, 12);
        gridPane.add(new Label(parts[15]), 1, 12);
        gridPane.add(new Label(String.valueOf(employee.getRate())), 2, 12);

        gridPane.add(new Label("Salary: "), 0, 13);
        double salary = calculateHourlySalary(Double.parseDouble(parts[14]), Double.parseDouble(parts[15]));
        gridPane.add(new Label(String.valueOf(salary)), 1, 13);
        gridPane.add(new Label(String.valueOf(employee.payment())), 2, 13);

        gridPane.add(new Label("Type: "), 0, 14);
        gridPane.add(new Label(parts[0]), 1, 14);
        gridPane.add(new Label("HourlyEmployee"), 2, 14);

        gridPane.add(new Label("Image: "), 0, 15);
        gridPane.add(new ImageView(new Image(parts[13])), 1, 15);
        gridPane.add(new ImageView(employee.getImage()), 2, 15);
    }

    private double calculateHourlySalary(double hours, double rate) {
        if (hours > 140) {
            return (rate * hours) + ((hours - 140) * rate * 0.7);
        }
        return rate * hours;
    }

    private void addSalariedEmployeeDetails(GridPane gridPane, String[] parts, SalariedEmployee employee) {
        gridPane.add(new Label("AnnualSalary: "), 0, 11);
        gridPane.add(new Label(parts[14]), 1, 11);
        gridPane.add(new Label(String.valueOf(employee.getAnnualSalary())), 2, 11);

        gridPane.add(new Label("Salary: "), 0, 12);
        double annualSalary = Double.parseDouble(parts[14]);
        gridPane.add(new Label(String.valueOf(annualSalary / 12)), 1, 12);
        gridPane.add(new Label(String.valueOf(employee.payment())), 2, 12);

        gridPane.add(new Label("Type: "), 0, 13);
        gridPane.add(new Label(parts[0]), 1, 13);
        gridPane.add(new Label("SalariedEmployee"), 2, 13);

        gridPane.add(new Label("Image: "), 0, 14);
        gridPane.add(new ImageView(new Image(parts[13])), 1, 14);
        gridPane.add(new ImageView(employee.getImage()), 2, 14);
    }

    private void addCommissionEmployeeDetails(GridPane gridPane, String[] parts, CommessionEmployee employee) {
        gridPane.add(new Label("Sold Items Per Month: "), 0, 11);
        gridPane.add(new Label(parts[14]), 1, 11);
        gridPane.add(new Label(String.valueOf(employee.getSoldItemsPerMonth())), 2, 11);

        gridPane.add(new Label("Salary: "), 0, 13);
        double salary = calculateCommissionSalary(Double.parseDouble(parts[14]));
        gridPane.add(new Label(String.valueOf(salary)), 1, 13);
        gridPane.add(new Label(String.valueOf(employee.payment())), 2, 13);

        gridPane.add(new Label("Type: "), 0, 14);
        gridPane.add(new Label(parts[0]), 1, 14);
        gridPane.add(new Label("CommessionEmployee"), 2, 14);

        gridPane.add(new Label("Image: "), 0, 15);
        gridPane.add(new ImageView(new Image(parts[13])), 1, 15);
        gridPane.add(new ImageView(employee.getImage()), 2, 15);
    }

    private double calculateCommissionSalary(double soldItemsPerMonth) {
        if (soldItemsPerMonth > 3775) {
            return soldItemsPerMonth * 0.05;
        } else if (soldItemsPerMonth > 2800) {
            return soldItemsPerMonth * 0.03;
        } else {
            return soldItemsPerMonth * 0.015;
        }
    }

    private void addEmployeeBasedCommissionDetails(GridPane gridPane, String[] parts, EmployeeBasedComession employee) {
        gridPane.add(new Label("Sold Items Per Month: "), 0, 11);
        gridPane.add(new Label(parts[14]), 1, 11);
        gridPane.add(new Label(String.valueOf(employee.getSoldItemsPerMonth())), 2, 11);

        gridPane.add(new Label("Based Salary: "), 0, 12);
        gridPane.add(new Label(parts[15]), 1, 12);
        gridPane.add(new Label(String.valueOf(employee.getBasedSalary())), 2, 12);

        gridPane.add(new Label("Salary: "), 0, 13);
        double salary = calculateEmployeeBasedCommissionSalary(Double.parseDouble(parts[14]), Double.parseDouble(parts[15]));
        gridPane.add(new Label(String.valueOf(salary)), 1, 13);
        gridPane.add(new Label(String.valueOf(employee.payment())), 2, 13);

        gridPane.add(new Label("Type: "), 0, 14);
        gridPane.add(new Label(parts[0]), 1, 14);
        gridPane.add(new Label("EmployeeBasedComession"), 2, 14);

        gridPane.add(new Label("Image: "), 0, 15);
        gridPane.add(new ImageView(new Image(parts[13])), 1, 15);
        gridPane.add(new ImageView(employee.getImage()), 2, 15);
    }

    private double calculateEmployeeBasedCommissionSalary(double soldItemsPerMonth, double basedSalary) {
        if (soldItemsPerMonth > 3775) {
            return soldItemsPerMonth * 0.05 + basedSalary;
        } else if (soldItemsPerMonth > 2800) {
            return soldItemsPerMonth * 0.03 + basedSalary;
        } else {
            return soldItemsPerMonth * 0.015 + basedSalary;
        }
    }

    private void overrideEmployee(String[] parts, Employee employee) {
        switch (parts[0]) {
            case "HourlyEmployee":
                AddEmployee.getInstance().getEmployeesObservableList().set(AddEmployee.getInstance().getEmployeesObservableList().indexOf(employee),new HourlyEmployee(employee, parts[2], parts[3], parts[4], new Address(parts[5], parts[6], parts[7]), parts[8], parts[9], parts[10], parts[11], parts[12], parts[13], Short.parseShort(parts[14]), Float.parseFloat(parts[15])));
                break;
            case "SalariedEmployee":
                AddEmployee.getInstance().getEmployeesObservableList().set(AddEmployee.getInstance().getEmployeesObservableList().indexOf(employee), new SalariedEmployee(employee, parts[2], parts[3], parts[4], new Address(parts[5], parts[6], parts[7]), parts[8], parts[9], parts[10], parts[11], parts[12], parts[13], Double.parseDouble(parts[14])));
                break;
            case "CommessionEmployee":
                AddEmployee.getInstance().getEmployeesObservableList().set(AddEmployee.getInstance().getEmployeesObservableList().indexOf(employee), new CommessionEmployee(employee, parts[2], parts[3], parts[4], new Address(parts[5], parts[6], parts[7]), parts[8], parts[9], parts[10], parts[11], parts[12], parts[13], Double.parseDouble(parts[14])));
                break;
            case "EmployeeBasedComession":
                AddEmployee.getInstance().getEmployeesObservableList().set(AddEmployee.getInstance().getEmployeesObservableList().indexOf(employee), new EmployeeBasedComession(employee, parts[2], parts[3], parts[4], new Address(parts[5], parts[6], parts[7]), parts[8], parts[9], parts[10], parts[11], parts[12], parts[13], Double.parseDouble(parts[14]), Double.parseDouble(parts[15])));
                break;
            default:
                break;
        }
    }

    private void addNewEmployee(String[] parts) {
        switch (parts[0]) {
            case "HourlyEmployee":
                AddEmployee.getInstance().getEmployeesObservableList().add(new HourlyEmployee(parts[2], parts[3], parts[4], new Address(parts[5], parts[6], parts[7]), parts[8], parts[9], parts[10], parts[11], parts[12], parts[13], Short.parseShort(parts[14]), Float.parseFloat(parts[15])));
                break;
            case "SalariedEmployee":
                AddEmployee.getInstance().getEmployeesObservableList().add(new SalariedEmployee(parts[2], parts[3], parts[4], new Address(parts[5], parts[6], parts[7]), parts[8], parts[9], parts[10], parts[11], parts[12], parts[13], Double.parseDouble(parts[14])));
                break;
            case "CommessionEmployee":
                AddEmployee.getInstance().getEmployeesObservableList().add(new CommessionEmployee(parts[2], parts[3], parts[4], new Address(parts[5], parts[6], parts[7]), parts[8], parts[9], parts[10], parts[11], parts[12], parts[13], Double.parseDouble(parts[14])));
                break;
            case "EmployeeBasedComession":
                AddEmployee.getInstance().getEmployeesObservableList().add(new EmployeeBasedComession(parts[2], parts[3], parts[4], new Address(parts[5], parts[6], parts[7]), parts[8], parts[9], parts[10], parts[11], parts[12], parts[13], Double.parseDouble(parts[14]), Double.parseDouble(parts[15])));
                break;
            default:
                break;
        }
    }

    private void showErrorAlert(String message) {
        System.out.println(message);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error Saving to File");
        alert.setContentText(message);
        alert.getDialogPane().getButtonTypes().forEach(buttonType -> {
            Button button = (Button) alert.getDialogPane().lookupButton(buttonType);
            button.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
            // Action to be performed when the button is clicked
            button.setOnMouseEntered(ee -> {
                button.setScaleX(1.1); // Increase the scale by 10%
                button.setScaleY(1.1); 
                button.setStyle("-fx-background-color: lightgreen; -fx-border-color: darkgreen; -fx-border-width: 2px; -fx-border-radius: 5px;");
    
            });
    
            button.setOnMouseExited(ee -> {
                button.setScaleX(1); // Reset to normal scale
                button.setScaleY(1);
                button.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
            });
    
        });

        alert.showAndWait();
    }
}