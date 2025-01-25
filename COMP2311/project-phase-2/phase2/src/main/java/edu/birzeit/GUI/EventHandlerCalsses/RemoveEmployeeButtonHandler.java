package edu.birzeit.GUI.EventHandlerCalsses;

import edu.birzeit.GUI.AddEmployee;
import edu.birzeit.GUI.RemoveEmployee;
import edu.birzeit.form.Employee;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class RemoveEmployeeButtonHandler implements EventHandler<ActionEvent> {

    
    @Override
    public void handle(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Deletion");
        alert.setHeaderText("Are you sure you want to delete this employee?");
        alert.setContentText("Employee number: " + RemoveEmployee.getInstance().getEmpnoTextField().getText() + " will be deleted.");
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
            Employee employee = RemoveEmployee.getCurrentEmployee();
            AddEmployee.getInstance().getEmployeesObservableList().remove(employee);
            afterClick(employee);

        }
    }

    private void afterClick(Employee employee) {
        if (AddEmployee.getInstance().getEmployeesObservableList().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No Employees Left");
            alert.setHeaderText("The employee list is now empty.");
            alert.setContentText("The window will be closed.");
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
                RemoveEmployee.getInstance().getStage().close();
            }
        }

        else{
            int index = AddEmployee.getInstance().getEmployeesObservableList().indexOf(employee);
            if (index < AddEmployee.getInstance().getEmployeesObservableList().size() - 1) {
                RemoveEmployee.getInstance().getRightButton().fireEvent(new ActionEvent());
            }
            else {
                RemoveEmployee.getInstance().getLeftButton().fireEvent(new ActionEvent());
            }
        }
    }
}