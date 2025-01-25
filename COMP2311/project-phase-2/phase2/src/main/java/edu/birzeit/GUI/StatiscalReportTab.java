package edu.birzeit.GUI;

import edu.birzeit.GUI.EventHandlerCalsses.TotalPaymentsButtonHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class StatiscalReportTab {
    private Button maxSalaryPerType, totalPayments, sortedEmployees;
    private final ImageView mainImageView = new ImageView(new Image(getClass().getResource("/images/S_Department.png").toExternalForm()));
    private final VBox mainVBox;
    private final HBox buttonHBox;

    public StatiscalReportTab() {
        mainVBox = new VBox(20);

        buttonHBox = new HBox(20);
        
        mainImageView.setFitHeight(335);
        
        mainImageView.setFitWidth(335);

        // Statiscal Report layout
        maxSalaryPerType = new Button();
        ImageView maxSalaryPerTypeImageView = new ImageView(new Image(getClass().getResource("/icon/maxSalaryPerType.png").toExternalForm()));
        maxSalaryPerTypeImageView.setFitHeight(50);
        maxSalaryPerTypeImageView.setFitWidth(50);
        maxSalaryPerType.setGraphic(maxSalaryPerTypeImageView);
        maxSalaryPerType.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
        // Action to be performed when the button is clicked
        maxSalaryPerType.setOnMouseEntered(event -> {
            maxSalaryPerType.setScaleX(1.1); // Increase the scale by 10%
            maxSalaryPerType.setScaleY(1.1); 
            maxSalaryPerType.setStyle("-fx-background-color: lightgreen; -fx-border-color: darkgreen; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        maxSalaryPerType.setOnMouseExited(event -> {
            maxSalaryPerType.setScaleX(1); // Reset to normal scale
            maxSalaryPerType.setScaleY(1);
            maxSalaryPerType.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        maxSalaryPerType.setOnAction(e -> {
            MaxSalaryPerType.display();
        });

        // View Employee
        totalPayments = new Button();
        ImageView totalPaymentsImageView = new ImageView(new Image(getClass().getResource("/icon/totalPayments2.png").toExternalForm()));
        totalPaymentsImageView.setFitHeight(50);
        totalPaymentsImageView.setFitWidth(50);
        totalPayments.setGraphic(totalPaymentsImageView);
        totalPayments.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
        // Action to be performed when the button is clicked
        totalPayments.setOnMouseEntered(event -> {
            totalPayments.setScaleX(1.1); // Increase the scale by 10%
            totalPayments.setScaleY(1.1); 
            totalPayments.setStyle("-fx-background-color: lightgreen; -fx-border-color: darkgreen; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        totalPayments.setOnMouseExited(event -> {
            totalPayments.setScaleX(1); // Reset to normal scale
            totalPayments.setScaleY(1);
            totalPayments.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        TotalPaymentsButtonHandler totalPaymentsButtonHandler = new TotalPaymentsButtonHandler();
        totalPayments.setOnAction(totalPaymentsButtonHandler);

        // Read From File
        sortedEmployees = new Button();
        ImageView sortedEmployeesImageView = new ImageView(new Image(getClass().getResource("/icon/sortedEmployees.png").toExternalForm()));
        sortedEmployeesImageView.setFitHeight(50);
        sortedEmployeesImageView.setFitWidth(50);
        sortedEmployees.setGraphic(sortedEmployeesImageView);
        sortedEmployees.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
        // Action to be performed when the button is clicked
        sortedEmployees.setOnMouseEntered(event -> {
            sortedEmployees.setScaleX(1.1); // Increase the scale by 10%
            sortedEmployees.setScaleY(1.1); 
            sortedEmployees.setStyle("-fx-background-color: lightgreen; -fx-border-color: darkgreen; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        sortedEmployees.setOnMouseExited(event -> {
            sortedEmployees.setScaleX(1); // Reset to normal scale
            sortedEmployees.setScaleY(1);
            sortedEmployees.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        sortedEmployees.setOnAction(e -> {
            SortedBy.chooseBotton();
        });

        buttonHBox.getChildren().addAll(maxSalaryPerType, totalPayments, sortedEmployees);
        buttonHBox.setAlignment(Pos.CENTER);

        mainVBox.getChildren().addAll(mainImageView, buttonHBox);
        mainVBox.setSpacing(20);
        mainVBox.setAlignment(Pos.CENTER);
    }

    public VBox getMainVBox() {
        return mainVBox;
    }    
}
