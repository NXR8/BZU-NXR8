package edu.birzeit.GUI.EventHandlerCalsses;

import edu.birzeit.GUI.AddEmployee;
import edu.birzeit.GUI.UpdateEmployee;
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

public class UpdateEmployeeButtonHandler implements EventHandler<ActionEvent> {

    
    @Override
    public void handle(ActionEvent event) {
        UpdateEmployee updateEmployee = UpdateEmployee.getInstance();
        RadioButton selectedRadioButton = (RadioButton) updateEmployee.getEducationToggleGroup().getSelectedToggle();

        try {
            Employee employee = null;
            switch (updateEmployee.getEmployeeTypeComboBox().getValue()) {
                case "Hourly Employee":
                    employee = new HourlyEmployee(UpdateEmployee.getCurrentEmployee(), updateEmployee.getFirstNameTextField().getText(), updateEmployee.getLastNameTextField().getText(), updateEmployee.getMyDatePicker().getDate(), new Address(updateEmployee.getCountryTextField().getText(), updateEmployee.getCityTextField().getText(), updateEmployee.getStreetTextField().getText()), updateEmployee.getPhoneNumberTextField().getText(), updateEmployee.getEmailTextField().getText(), updateEmployee.getCountryTextField().getText(), updateEmployee.getDesignationTextField().getText(), selectedRadioButton.getText(), updateEmployee.getMyFileChooser().getImageView().getImage().getUrl(), Short.parseShort(updateEmployee.getHoursTextField().getText()), Float.parseFloat(updateEmployee.getRateTextField().getText()));
                    break;
                case "Salaried Employee":
                    employee = new SalariedEmployee(UpdateEmployee.getCurrentEmployee(), updateEmployee.getFirstNameTextField().getText(), updateEmployee.getLastNameTextField().getText(), updateEmployee.getMyDatePicker().getDate(), new Address(updateEmployee.getCountryTextField().getText(), updateEmployee.getCityTextField().getText(), updateEmployee.getStreetTextField().getText()), updateEmployee.getPhoneNumberTextField().getText(), updateEmployee.getEmailTextField().getText(), updateEmployee.getCountryTextField().getText(), updateEmployee.getDesignationTextField().getText(), selectedRadioButton.getText(), updateEmployee.getMyFileChooser().getImageView().getImage().getUrl(), Double.parseDouble(updateEmployee.getAnnualSalaryTextField().getText()));
                    break;
                case "Commession Employee":
                    employee = new CommessionEmployee(UpdateEmployee.getCurrentEmployee(), updateEmployee.getFirstNameTextField().getText(), updateEmployee.getLastNameTextField().getText(), updateEmployee.getMyDatePicker().getDate(), new Address(updateEmployee.getCountryTextField().getText(), updateEmployee.getCityTextField().getText(), updateEmployee.getStreetTextField().getText()), updateEmployee.getPhoneNumberTextField().getText(), updateEmployee.getEmailTextField().getText(), updateEmployee.getCountryTextField().getText(), updateEmployee.getDesignationTextField().getText(), selectedRadioButton.getText(), updateEmployee.getMyFileChooser().getImageView().getImage().getUrl(), Double.parseDouble(updateEmployee.getSoldItemsPerMonthTextField().getText()));
                    break;
                case "Employee Based Comession":
                    employee = new EmployeeBasedComession(UpdateEmployee.getCurrentEmployee(), updateEmployee.getFirstNameTextField().getText(), updateEmployee.getLastNameTextField().getText(), updateEmployee.getMyDatePicker().getDate(), new Address(updateEmployee.getCountryTextField().getText(), updateEmployee.getCityTextField().getText(), updateEmployee.getStreetTextField().getText()), updateEmployee.getPhoneNumberTextField().getText(), updateEmployee.getEmailTextField().getText(), updateEmployee.getCountryTextField().getText(), updateEmployee.getDesignationTextField().getText(), selectedRadioButton.getText(), updateEmployee.getMyFileChooser().getImageView().getImage().getUrl(), Double.parseDouble(updateEmployee.getSoldItemsPerMonthTextField().getText()), Double.parseDouble(updateEmployee.getBasedSalaryTextField().getText()));
                    break;
                default:
                    break;
            }

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Update");
            alert.setHeaderText("Are you sure you want to update this employee?");
            alert.setContentText("Employee number: " + updateEmployee.getEmpnoTextField().getText() + " will be updated.");
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
                // int currentIndex = AddEmployee.getInstance().getEmployeesObservableList().indexOf(UpdateEmployee.getCurrentEmployee());
                // AddEmployee.getInstance().getEmployeesObservableList().set(currentIndex, employee);
                UpdateEmployee.getInstance();
                AddEmployee.getInstance().getEmployeesObservableList().set(AddEmployee.getInstance().getEmployeesObservableList().indexOf(UpdateEmployee.getCurrentEmployee()), employee);
                
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