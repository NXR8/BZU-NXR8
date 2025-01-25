package edu.birzeit.GUI;

import edu.birzeit.form.CommessionEmployee;
import edu.birzeit.form.ComparatorClasses.EducationComparator;
import edu.birzeit.form.ComparatorClasses.FirstNameComparator;
import edu.birzeit.form.ComparatorClasses.LastNameComparator;
import edu.birzeit.form.ComparatorClasses.PaymentComparator;
import edu.birzeit.form.Employee;
import edu.birzeit.form.EmployeeBasedComession;
import edu.birzeit.form.HourlyEmployee;
import edu.birzeit.form.SalariedEmployee;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SortedBy {

    private static Button sortByFirstNameButton, sortByLastNameButton, sortByEducationButton, sortBySalaryButton;
    private TableView<Employee> tableView;
    private static Stage stage;
    private HBox buttonHBox;
    private static VBox actionAndTableViewVBox;
    private ObservableList<Employee> employeesObservableList = FXCollections.observableArrayList(AddEmployee.getInstance().getEmployeesObservableList());

    private final static SortedBy instance = new SortedBy();

    public static SortedBy getInstance() {
        return instance;
    }

    @SuppressWarnings("unchecked")
    private SortedBy() {

        Bindings.bindContent(employeesObservableList, AddEmployee.getInstance().getEmployeesObservableList());

        sortByFirstNameButton = new Button("Sort By First Name");
        // sortByFirstNameButton.setMaxSize(50, 50);
        sortByFirstNameButton.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
        // Action to be performed when the button is clicked
        sortByFirstNameButton.setOnMouseEntered(event -> {
            sortByFirstNameButton.setScaleX(1.1); // Increase the scale by 10%
            sortByFirstNameButton.setScaleY(1.1); 
            sortByFirstNameButton.setStyle("-fx-background-color: lightgreen; -fx-border-color: darkgreen; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        sortByFirstNameButton.setOnMouseExited(event -> {
            sortByFirstNameButton.setScaleX(1); // Reset to normal scale
            sortByFirstNameButton.setScaleY(1);
            sortByFirstNameButton.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
        });

        sortByFirstNameButton.setOnAction(event -> {
            employeesObservableList.sort(new FirstNameComparator());
            stage.setTitle("Sorted By First Name");
        });

        sortByLastNameButton = new Button("Sort By Last Name");
        // sortByLastNameButton.setMaxSize(50, 50);
        sortByLastNameButton.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
        // Action to be performed when the button is clicked
        sortByLastNameButton.setOnMouseEntered(event -> {
            sortByLastNameButton.setScaleX(1.1); // Increase the scale by 10%
            sortByLastNameButton.setScaleY(1.1); 
            sortByLastNameButton.setStyle("-fx-background-color: lightgreen; -fx-border-color: darkgreen; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        sortByLastNameButton.setOnMouseExited(event -> {
            sortByLastNameButton.setScaleX(1); // Reset to normal scale
            sortByLastNameButton.setScaleY(1);
            sortByLastNameButton.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
        });

        sortByLastNameButton.setOnAction(event -> {
            employeesObservableList.sort(new LastNameComparator());
            stage.setTitle("Sorted By Last Name");
        });

        sortByEducationButton = new Button("Sort By Education");
        // sortByEducationButton.setMaxSize(50, 50);
        sortByEducationButton.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
        // Action to be performed when the button is clicked
        sortByEducationButton.setOnMouseEntered(event -> {
            sortByEducationButton.setScaleX(1.1); // Increase the scale by 10%
            sortByEducationButton.setScaleY(1.1); 
            sortByEducationButton.setStyle("-fx-background-color: lightgreen; -fx-border-color: darkgreen; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        sortByEducationButton.setOnMouseExited(event -> {
            sortByEducationButton.setScaleX(1); // Reset to normal scale
            sortByEducationButton.setScaleY(1);
            sortByEducationButton.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
        });

        sortByEducationButton.setOnAction(event -> {
            employeesObservableList.sort(new EducationComparator());  
            stage.setTitle("Sorted By Education");  
        });

        sortBySalaryButton = new Button("Sort By Salary");
        // sortBySalaryButton.setMaxSize(50, 50);
        sortBySalaryButton.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
        // Action to be performed when the button is clicked
        sortBySalaryButton.setOnMouseEntered(event -> {
            sortBySalaryButton.setScaleX(1.1); // Increase the scale by 10%
            sortBySalaryButton.setScaleY(1.1); 
            sortBySalaryButton.setStyle("-fx-background-color: lightgreen; -fx-border-color: darkgreen; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        sortBySalaryButton.setOnMouseExited(event -> {
            sortBySalaryButton.setScaleX(1); // Reset to normal scale
            sortBySalaryButton.setScaleY(1);
            sortBySalaryButton.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
        });

        sortBySalaryButton.setOnAction(event -> {
            employeesObservableList.sort(new PaymentComparator());  
            stage.setTitle("Sorted By Salary");  
        });

        buttonHBox = new HBox(20);
        buttonHBox.getChildren().addAll(sortByFirstNameButton, sortByLastNameButton, sortByEducationButton, sortBySalaryButton);

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
        // To set the type of employee in the table
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
        // To set the address of employee in the table
        addressColumn.setCellValueFactory(cellData -> {
            Employee employee = cellData.getValue();
            return new SimpleStringProperty(employee.getAddress().toString());
        });

        TableColumn<Employee, String> salaryColumn = new TableColumn<>("Salary");
        // To set the Salary of employee in the table
        salaryColumn.setCellValueFactory(cellData -> {
            Employee employee = cellData.getValue();
            return new SimpleStringProperty(String.valueOf(employee.payment()));
        });

        tableView.getColumns().addAll(
            empnoColumn, firstNameColumn, lastNameColumn, dateOfBirthColumn,
            phoneNumberColumn, emailColumn, nationalityColumn, designationColumn, educationColumn, 
            addressColumn, employeeTypeColumn, salaryColumn
        );

        tableView.setItems(employeesObservableList);

        actionAndTableViewVBox = new VBox(20);
        actionAndTableViewVBox.setPadding(new Insets(10));
        actionAndTableViewVBox.getChildren().addAll(buttonHBox, tableView);
    }
    
    public static void display(int select) {
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
        stage.setTitle("Sorted By");
        switch (select) {
            case 0:
                sortByFirstNameButton.fireEvent(new ActionEvent());
                stage.setTitle("Sorted By First Name");
                break;
            case 1:
                sortByLastNameButton.fireEvent(new ActionEvent());
                stage.setTitle("Sorted By Last Name");
                break;
            case 2:
                sortByEducationButton.fireEvent(new ActionEvent());
                stage.setTitle("Sorted By Education");
                break;
            case 3:
                sortBySalaryButton.fireEvent(new ActionEvent());
                stage.setTitle("Sorted By Salary");
                break;
            default:
                break;
        }
        stage.show();
    }

    public static void chooseBotton() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Choose");
        alert.setHeaderText("Choose Sort By: ");

        ButtonType sortByFirstNameButtonType = new ButtonType("Sort By First Name");
        ButtonType sortByLastNameButtonType = new ButtonType("Sort By Last Name");
        ButtonType sortByEducationButtonType = new ButtonType("Sort By Education");
        ButtonType sortBySalaryButtonType = new ButtonType("Sort By Salary");
        ButtonType cancelButtonType = new ButtonType("Cancel");
        alert.getButtonTypes().setAll(sortByFirstNameButtonType, sortByLastNameButtonType, sortByEducationButtonType, sortBySalaryButtonType, cancelButtonType);

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

        if (alert.getResult() == sortByFirstNameButtonType) {
            display(0);
        } else if (alert.getResult() == sortByLastNameButtonType) {
            display(1);
        } else if (alert.getResult() == sortByEducationButtonType) {
            display(2);
        } else if (alert.getResult() == sortBySalaryButtonType) {
            display(3);
        }
    }    
}
