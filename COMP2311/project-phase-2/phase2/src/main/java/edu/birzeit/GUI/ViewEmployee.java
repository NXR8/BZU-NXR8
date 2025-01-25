package edu.birzeit.GUI;

import edu.birzeit.form.CommessionEmployee;
import edu.birzeit.form.Employee;
import edu.birzeit.form.EmployeeBasedComession;
import edu.birzeit.form.HourlyEmployee;
import edu.birzeit.form.SalariedEmployee;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewEmployee {

    private Label empnoLabel;
    private TextField empnoTextField;
    private Button searchButton, updateButton, deleteButton, mainPageButton;
    private TableView<Employee> tableView;
    private static Stage stage;
    private HBox empnoHBox;
    private HBox buttonHBox;
    private static VBox actionAndTableViewVBox;
    private int select = 0;
    
    private final static ViewEmployee instance = new ViewEmployee();

    public static ViewEmployee getInstance() {
        return instance;
    }

    @SuppressWarnings("unchecked")
    private ViewEmployee() {
        empnoLabel = new Label("Employee No:");
        empnoTextField = new TextField();
        empnoTextField.setStyle("-fx-focus-color: green; -fx-faint-focus-color: transparent;");

        empnoHBox = new HBox(20);
        empnoHBox.getChildren().addAll(empnoLabel, empnoTextField);

        searchButton = new Button();
        ImageView searchButtonImageView = new ImageView(new Image(getClass().getResource("/icon/search.png").toExternalForm()));
        searchButtonImageView.setFitHeight(50);
        searchButtonImageView.setFitWidth(50);
        searchButton.setGraphic(searchButtonImageView);
        searchButtonImageView.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
        // Action to be performed when the button is clicked
        searchButton.setOnMouseEntered(event -> {
            searchButton.setScaleX(1.1); // Increase the scale by 10%
            searchButton.setScaleY(1.1); 
            searchButton.setStyle("-fx-background-color: lightgreen; -fx-border-color: darkgreen; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        searchButton.setOnMouseExited(event -> {
            searchButton.setScaleX(1); // Reset to normal scale
            searchButton.setScaleY(1);
            searchButton.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
        });

        searchButton.setOnAction(event -> {
            SearchEmployee.getInstance().display(empnoTextField.getText());
        });

        updateButton = new Button();
        ImageView updateButtonImageView = new ImageView(new Image(getClass().getResource("/icon/update.png").toExternalForm()));
        updateButtonImageView.setFitHeight(50);
        updateButtonImageView.setFitWidth(50);
        updateButton.setGraphic(updateButtonImageView);
        updateButtonImageView.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
        // Action to be performed when the button is clicked
        updateButton.setOnMouseEntered(event -> {
            updateButton.setScaleX(1.1); // Increase the scale by 10%
            updateButton.setScaleY(1.1); 
            updateButton.setStyle("-fx-background-color: lightgreen; -fx-border-color: darkgreen; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        updateButton.setOnMouseExited(event -> {
            updateButton.setScaleX(1); // Reset to normal scale
            updateButton.setScaleY(1);
            updateButton.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
        });

        updateButton.setOnAction(event -> {
            if (select == 0) {
                for (Employee employee : AddEmployee.getInstance().getEmployeesObservableList()) {
                    if (employee.getEmpno().equals(empnoTextField.getText())) {
                        UpdateEmployee.display(employee);
                        break;
                    }
                }
            }
            if (select == 1) {
                UpdateEmployee.display(tableView.getSelectionModel().getSelectedItem());
            }
        });

        deleteButton = new Button();
        ImageView deleteButtonImageView = new ImageView(new Image(getClass().getResource("/icon/deleteColumns.png").toExternalForm()));
        deleteButtonImageView.setFitHeight(50);
        deleteButtonImageView.setFitWidth(50);
        deleteButton.setGraphic(deleteButtonImageView);
        deleteButtonImageView.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
        // Action to be performed when the button is clicked
        deleteButton.setOnMouseEntered(event -> {
            deleteButton.setScaleX(1.1); // Increase the scale by 10%
            deleteButton.setScaleY(1.1); 
            deleteButton.setStyle("-fx-background-color: lightgreen; -fx-border-color: darkgreen; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        deleteButton.setOnMouseExited(event -> {
            deleteButton.setScaleX(1); // Reset to normal scale
            deleteButton.setScaleY(1);
            deleteButton.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
        });

        deleteButton.setOnAction(event -> {
            if (select == 0) {
                for (Employee employee : AddEmployee.getInstance().getEmployeesObservableList()) {
                    if (employee.getEmpno().equals(empnoTextField.getText())) {
                        RemoveEmployee.display(employee);
                        break;
                    }
                }
            }
            else if (select == 1) {
                RemoveEmployee.display(tableView.getSelectionModel().getSelectedItem());
            }
        });

        mainPageButton = new Button();
        ImageView mainPageButtonImageView = new ImageView(new Image(getClass().getResource("/icon/mainPage.png").toExternalForm()));
        mainPageButtonImageView.setFitHeight(50);
        mainPageButtonImageView.setFitWidth(50);
        mainPageButton.setGraphic(mainPageButtonImageView);
        mainPageButtonImageView.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
        // Action to be performed when the button is clicked
        mainPageButton.setOnMouseEntered(event -> {
            mainPageButton.setScaleX(1.1); // Increase the scale by 10%
            mainPageButton.setScaleY(1.1); 
            mainPageButton.setStyle("-fx-background-color: lightgreen; -fx-border-color: darkgreen; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        mainPageButton.setOnMouseExited(event -> {
            mainPageButton.setScaleX(1); // Reset to normal scale
            mainPageButton.setScaleY(1);
            mainPageButton.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
        });

        mainPageButton.setOnAction(event -> {
            stage.close();
        });

        buttonHBox = new HBox(20);
        buttonHBox.getChildren().addAll(searchButton, updateButton, deleteButton, mainPageButton);

        // Create TableView
        tableView = new TableView<>();
        tableView.setStyle("-fx-focus-color: green; -fx-selection-bar: green; -fx-selection-bar-non-focused: green;");

        TableColumn<Employee, String> empnoColumn = new TableColumn<>("Employee No");
        empnoColumn.setCellValueFactory(new PropertyValueFactory<>("empno"));

        TableColumn<Employee, String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Employee, String> lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Employee, String> dateOfBirthColumn = new TableColumn<>("Date of Birth");
        dateOfBirthColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));

        TableColumn<Employee, String> phoneNumberColumn = new TableColumn<>("Phone Number");
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        TableColumn<Employee, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Employee, String> nationalityColumn = new TableColumn<>("Nationality");
        nationalityColumn.setCellValueFactory(new PropertyValueFactory<>("nationality"));

        TableColumn<Employee, String> designationColumn = new TableColumn<>("Designation");
        designationColumn.setCellValueFactory(new PropertyValueFactory<>("designation"));

        TableColumn<Employee, String> educationColumn = new TableColumn<>("Education");
        educationColumn.setCellValueFactory(new PropertyValueFactory<>("education"));

        TableColumn<Employee, String> employeeTypeColumn = new TableColumn<>("Employee Type");
        employeeTypeColumn.setCellValueFactory(cellData -> {
            Employee employee = cellData.getValue();
            if (employee instanceof HourlyEmployee) {
                return new SimpleStringProperty("Hourly Employee");
            }
            else if (employee instanceof SalariedEmployee) {
                return new SimpleStringProperty("Salaried Employee");
            }
            else if (employee instanceof EmployeeBasedComession) {
                return new SimpleStringProperty("Employee Based Comession");
            }
            else if (employee instanceof CommessionEmployee) {
                return new SimpleStringProperty("Commession Employee");
            }
            else{
                return new SimpleStringProperty("");
            }
        });

        TableColumn<Employee, String> addressColumn = new TableColumn<>("Address");
        addressColumn.setCellValueFactory(cellData -> {
            Employee employee = cellData.getValue();
            return new SimpleStringProperty(employee.getAddress().toString());
        });

        TableColumn<Employee, String> salaryColumn = new TableColumn<>("Salary");
        salaryColumn.setCellValueFactory(cellData -> {
            Employee employee = cellData.getValue();
            return new SimpleStringProperty(String.valueOf(employee.payment()));
        });

        tableView.getColumns().addAll(
            empnoColumn, firstNameColumn, lastNameColumn, dateOfBirthColumn,
            phoneNumberColumn, emailColumn, nationalityColumn, designationColumn, educationColumn, 
            addressColumn, employeeTypeColumn, salaryColumn
        );

        tableView.setItems(AddEmployee.getInstance().getEmployeesObservableList());

        actionAndTableViewVBox = new VBox(20);
        actionAndTableViewVBox.setPadding(new Insets(10));
        actionAndTableViewVBox.getChildren().addAll(empnoHBox, buttonHBox, tableView);

        empnoTextField.setOnKeyTyped(e -> {
            select = 0;
            if (e.getCode() == KeyCode.ENTER) {
                searchButton.fire();
            }
        });

        tableView.setOnMouseClicked(e -> {
            select = 1;
        });
    }

    public static void display() {
        // System.out.println("display");
        if (stage != null) {
            stage.close();
        }

        BorderPane mainBorderPane = new BorderPane();
        MyMenu myMenu = new MyMenu();
        mainBorderPane.setTop(myMenu.getMenuBar());
        mainBorderPane.setCenter(actionAndTableViewVBox);

        Scene scene = new Scene(mainBorderPane, 800, 600);
        stage = new Stage();
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setTitle("View Employee");
        stage.show();
    }
}
