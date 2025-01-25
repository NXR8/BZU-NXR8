package edu.birzeit.GUI;

import edu.birzeit.GUI.EventHandlerCalsses.ReadEmployeeFromFileButtonHandler;
import edu.birzeit.GUI.EventHandlerCalsses.SaveEmployeeToFileButtonHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class EmployeeRecordTab {
    private Button addEmployeeButton, viewEmployeeButton, readFromFileButton, saveToFileButton;
    private final ImageView mainImageView = new ImageView(new Image(getClass().getResource("/images/HR_Department.png").toExternalForm()));
    private final VBox mainVBox;
    private final HBox buttonHBox;

    public EmployeeRecordTab() {
        mainVBox = new VBox(20);

        buttonHBox = new HBox(20);
        
        mainImageView.setFitHeight(335);
        
        mainImageView.setFitWidth(335);

        // Add Employee
        addEmployeeButton = new Button();
        ImageView addEmployeeImageView = new ImageView(new Image(getClass().getResource("/icon/addUser.png").toExternalForm()));
        addEmployeeImageView.setFitHeight(50);
        addEmployeeImageView.setFitWidth(50);
        addEmployeeButton.setGraphic(addEmployeeImageView);
        addEmployeeButton.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
        // Action to be performed when the button is clicked
        addEmployeeButton.setOnMouseEntered(event -> {
            addEmployeeButton.setScaleX(1.1); // Increase the scale by 10%
            addEmployeeButton.setScaleY(1.1); 
            addEmployeeButton.setStyle("-fx-background-color: lightgreen; -fx-border-color: darkgreen; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        addEmployeeButton.setOnMouseExited(event -> {
            addEmployeeButton.setScaleX(1); // Reset to normal scale
            addEmployeeButton.setScaleY(1);
            addEmployeeButton.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        addEmployeeButton.setOnAction(e -> {
            AddEmployee.display();
        });

        // View Employee
        viewEmployeeButton = new Button();
        ImageView viewEmployeeImageView = new ImageView(new Image(getClass().getResource("/icon/viewUser.png").toExternalForm()));
        viewEmployeeImageView.setFitHeight(50);
        viewEmployeeImageView.setFitWidth(50);
        viewEmployeeButton.setGraphic(viewEmployeeImageView);
        viewEmployeeButton.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
        // Action to be performed when the button is clicked
        viewEmployeeButton.setOnMouseEntered(event -> {
            viewEmployeeButton.setScaleX(1.1); // Increase the scale by 10%
            viewEmployeeButton.setScaleY(1.1); 
            viewEmployeeButton.setStyle("-fx-background-color: lightgreen; -fx-border-color: darkgreen; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        viewEmployeeButton.setOnMouseExited(event -> {
            viewEmployeeButton.setScaleX(1); // Reset to normal scale
            viewEmployeeButton.setScaleY(1);
            viewEmployeeButton.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        viewEmployeeButton.setOnAction(event -> {
            ViewEmployee.display();
        });

        // Read From File
        readFromFileButton = new Button();
        ImageView readFromFileImageView = new ImageView(new Image(getClass().getResource("/icon/read.png").toExternalForm()));
        readFromFileImageView.setFitHeight(50);
        readFromFileImageView.setFitWidth(50);
        readFromFileButton.setGraphic(readFromFileImageView);
        readFromFileButton.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
        // Action to be performed when the button is clicked
        readFromFileButton.setOnMouseEntered(event -> {
            readFromFileButton.setScaleX(1.1); // Increase the scale by 10%
            readFromFileButton.setScaleY(1.1); 
            readFromFileButton.setStyle("-fx-background-color: lightgreen; -fx-border-color: darkgreen; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        readFromFileButton.setOnMouseExited(event -> {
            readFromFileButton.setScaleX(1); // Reset to normal scale
            readFromFileButton.setScaleY(1);
            readFromFileButton.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        ReadEmployeeFromFileButtonHandler readEmployeeFromFileButtonHandler = new ReadEmployeeFromFileButtonHandler();
        readFromFileButton.setOnAction(readEmployeeFromFileButtonHandler);

        // Save To File
        saveToFileButton = new Button();
        ImageView saveToFileImageView = new ImageView(new Image(getClass().getResource("/icon/save.png").toExternalForm()));
        saveToFileImageView.setFitHeight(50);
        saveToFileImageView.setFitWidth(50);
        saveToFileButton.setGraphic(saveToFileImageView);
        saveToFileButton.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
        // Action to be performed when the button is clicked
        saveToFileButton.setOnMouseEntered(event -> {
            saveToFileButton.setScaleX(1.1); // Increase the scale by 10%
            saveToFileButton.setScaleY(1.1); 
            saveToFileButton.setStyle("-fx-background-color: lightgreen; -fx-border-color: darkgreen; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        saveToFileButton.setOnMouseExited(event -> {
            saveToFileButton.setScaleX(1); // Reset to normal scale
            saveToFileButton.setScaleY(1);
            saveToFileButton.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        SaveEmployeeToFileButtonHandler saveEmployeeToFileButtonHandler = new SaveEmployeeToFileButtonHandler();
        saveToFileButton.setOnAction(saveEmployeeToFileButtonHandler);

        buttonHBox.getChildren().addAll(addEmployeeButton, viewEmployeeButton, readFromFileButton, saveToFileButton);
        buttonHBox.setAlignment(Pos.CENTER);

        mainVBox.getChildren().addAll(mainImageView, buttonHBox);
        mainVBox.setSpacing(20);
        mainVBox.setAlignment(Pos.CENTER);

    }

    public VBox getMainVBox() {
        return mainVBox;
    }
    
}
