package edu.birzeit.GUI;

import edu.birzeit.form.CommessionEmployee;
import edu.birzeit.form.ComparatorClasses.PaymentComparator;
import edu.birzeit.form.Employee;
import edu.birzeit.form.EmployeeBasedComession;
import edu.birzeit.form.HourlyEmployee;
import edu.birzeit.form.SalariedEmployee;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MaxSalaryPerType {

    private Button updateButton, deleteButton, mainPageButton;
    private static TableView<Employee> tableView;
    private static Stage stage;
    private HBox buttonHBox;
    private static VBox actionAndTableViewVBox;
    private final static MaxSalaryPerType instance = new MaxSalaryPerType();

    public static MaxSalaryPerType getInstance() {
        return instance;
    }

    @SuppressWarnings("unchecked")
    private MaxSalaryPerType() {

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
            UpdateEmployee.display(tableView.getSelectionModel().getSelectedItem());
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
            RemoveEmployee.display(tableView.getSelectionModel().getSelectedItem());
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
        buttonHBox.getChildren().addAll(updateButton, deleteButton, mainPageButton);

        // Create TableView
        tableView = new TableView<>();

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
            else if (employee instanceof EmployeeBasedComession) { // Put it before CommessionEmployee becuse it is instance of it
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

        actionAndTableViewVBox = new VBox(20);
        actionAndTableViewVBox.setPadding(new Insets(10));
        actionAndTableViewVBox.getChildren().addAll(buttonHBox, tableView);

    }

    public static void display() {

        maxSalaryPerType();
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
        stage.setTitle("Max Salary Per Type");
        stage.show();
    }

    private static void maxSalaryPerType() {
        ObservableList<Employee> maxSalaryPerType = FXCollections.observableArrayList();
        ObservableList<Employee> hourlyEmployees = FXCollections.observableArrayList();
        ObservableList<Employee> salariedEmployees = FXCollections.observableArrayList();
        ObservableList<Employee> employeeBasedComessions = FXCollections.observableArrayList();
        ObservableList<Employee> commessionEmployees = FXCollections.observableArrayList();

        for (Employee employee : AddEmployee.getInstance().getEmployeesObservableList()) {
            if (employee instanceof HourlyEmployee) {
                hourlyEmployees.add(employee);
            }
            else if (employee instanceof SalariedEmployee) {
                salariedEmployees.add(employee);
            }
            else if (employee instanceof EmployeeBasedComession) {
                employeeBasedComessions.add(employee);
            }
            else if (employee instanceof CommessionEmployee) {
                commessionEmployees.add(employee);
            }
        }

        hourlyEmployees.sort(new PaymentComparator());
        salariedEmployees.sort(new PaymentComparator());
        employeeBasedComessions.sort(new PaymentComparator());
        commessionEmployees.sort(new PaymentComparator());

        if (!hourlyEmployees.isEmpty()) {
            maxSalaryPerType.add(hourlyEmployees.get(0));
        }
        else if (!salariedEmployees.isEmpty()) {
            maxSalaryPerType.add(salariedEmployees.get(0));
        }
        else if (!employeeBasedComessions.isEmpty()) {
            maxSalaryPerType.add(employeeBasedComessions.get(0));
        }
        else if (!commessionEmployees.isEmpty()) {
            maxSalaryPerType.add(commessionEmployees.get(0));
        }
        tableView.setItems(maxSalaryPerType);
    }
    
}
