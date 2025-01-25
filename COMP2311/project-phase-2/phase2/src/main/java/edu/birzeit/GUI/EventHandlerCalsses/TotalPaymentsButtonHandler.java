package edu.birzeit.GUI.EventHandlerCalsses;

import edu.birzeit.GUI.AddEmployee;
import edu.birzeit.form.Employee;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class TotalPaymentsButtonHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Total Payments");
        alert.setHeaderText("Total Payments for All Employees");
        alert.setContentText("Total Payments: " + getTotalPayments());

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

    private double getTotalPayments() {
        double total = 0;
        for (Employee employee : AddEmployee.getInstance().getEmployeesObservableList()) {
            total += employee.payment();
        }
        return total;
    }
    
}
