package edu.birzeit.GUI.EventHandlerCalsses;

import java.io.IOException;
import java.io.PrintWriter;

import edu.birzeit.GUI.AddEmployee;
import edu.birzeit.form.Employee;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class SaveEmployeeToFileButtonHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirm Save");
        confirmAlert.setHeaderText("Save Employee Data");
        confirmAlert.setContentText("Are you sure you want to save the data to the file?");

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

            try (PrintWriter writer = new PrintWriter("Data.txt")) {
                for (Employee employee : AddEmployee.getInstance().getEmployeesObservableList()) {
                    writer.println(employee.toString());
                }
            }
            catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error Saving to File");
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
}