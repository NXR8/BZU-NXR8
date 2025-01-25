package edu.birzeit.GUI.EventHandlerCalsses;

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
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;

public class AddEmployeeButtonHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        AddEmployee addEmployee = AddEmployee.getInstance();

        // Get the selected radio button
        RadioButton selectedRadioButton = (RadioButton) addEmployee.getEducationToggleGroup().getSelectedToggle();

        try {
            Employee employee = null;
            switch (addEmployee.getEmployeeTypeComboBox().getValue()) {
                case "Hourly Employee":
                    employee = new HourlyEmployee(addEmployee.getFirstNameTextField().getText(), addEmployee.getLastNameTextField().getText(), addEmployee.getMyDatePicker().getDate(), new Address(addEmployee.getCountryTextField().getText(), addEmployee.getCityTextField().getText(), addEmployee.getStreetTextField().getText()), addEmployee.getPhoneNumberTextField().getText(), addEmployee.getEmailTextField().getText(), addEmployee.getCountryTextField().getText(), addEmployee.getDesignationTextField().getText(), selectedRadioButton.getText(), addEmployee.getMyFileChooser().getImageView().getImage().getUrl());
                    break;
                case "Salaried Employee":
                    employee = new SalariedEmployee(addEmployee.getFirstNameTextField().getText(), addEmployee.getLastNameTextField().getText(), addEmployee.getMyDatePicker().getDate(), new Address(addEmployee.getCountryTextField().getText(), addEmployee.getCityTextField().getText(), addEmployee.getStreetTextField().getText()), addEmployee.getPhoneNumberTextField().getText(), addEmployee.getEmailTextField().getText(), addEmployee.getCountryTextField().getText(), addEmployee.getDesignationTextField().getText(), selectedRadioButton.getText(), addEmployee.getMyFileChooser().getImageView().getImage().getUrl());
                    break;
                case "Commession Employee":
                    employee = new CommessionEmployee(addEmployee.getFirstNameTextField().getText(), addEmployee.getLastNameTextField().getText(), addEmployee.getMyDatePicker().getDate(), new Address(addEmployee.getCountryTextField().getText(), addEmployee.getCityTextField().getText(), addEmployee.getStreetTextField().getText()), addEmployee.getPhoneNumberTextField().getText(), addEmployee.getEmailTextField().getText(), addEmployee.getCountryTextField().getText(), addEmployee.getDesignationTextField().getText(), selectedRadioButton.getText(), addEmployee.getMyFileChooser().getImageView().getImage().getUrl());
                    break;
                case "Employee Based Comession":
                    employee = new EmployeeBasedComession(addEmployee.getFirstNameTextField().getText(), addEmployee.getLastNameTextField().getText(), addEmployee.getMyDatePicker().getDate(), new Address(addEmployee.getCountryTextField().getText(), addEmployee.getCityTextField().getText(), addEmployee.getStreetTextField().getText()), addEmployee.getPhoneNumberTextField().getText(), addEmployee.getEmailTextField().getText(), addEmployee.getCountryTextField().getText(), addEmployee.getDesignationTextField().getText(), selectedRadioButton.getText(), addEmployee.getMyFileChooser().getImageView().getImage().getUrl());
                    break;
                default:
                    break;
            }

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Addition");
            alert.setHeaderText("Are you sure you want to add this employee?");
            alert.setContentText("Employee number: " + addEmployee.getEmpnoTextField().getText() + " will be added.");
            // alert.showAndWait();
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

            if (alert.getResult() == ButtonType.OK) {
                addEmployee.getEmployeesObservableList().add(employee);
                addEmployee.getEmpnoTextField().setText(Employee.getInitEmpno() + "");
                addEmployee.getClear().fireEvent(event);
            }
            else if (alert.getResult() == ButtonType.CANCEL) {
                Employee.unChangeInitEmpno();
            }


        }
        
        catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("An error occurred");
            alert.setContentText(e.getMessage());
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
}