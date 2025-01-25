package edu.birzeit.GUI;

import java.time.LocalDate;

import edu.birzeit.GUI.EventHandlerCalsses.RemoveEmployeeButtonHandler;
import edu.birzeit.form.CommessionEmployee;
import edu.birzeit.form.Employee;
import edu.birzeit.form.EmployeeBasedComession;
import edu.birzeit.form.HourlyEmployee;
import edu.birzeit.form.SalariedEmployee;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RemoveEmployee {
    private final Label empnoLabel, firstNameLabel, lastNameLabel, dateOfBirthLabel, designationLabel, emailLabel, phoneNumberLabel, streetLabel, cityLabel, countryLabel, educationLabel, employeeTypeLabel, salaryLabel, soldItemsPerMonthLabel, basedSalaryLabel, hoursLabel, rateLabel, annualSalaryLabel;
    private static TextField empnoTextField, firstNameTextField, lastNameTextField, designationTextField, emailTextField, phoneNumberTextField, streetTextField, cityTextField, countryTextField, salaryTextField, soldItemsPerMonthTextField, basedSalaryTextField, hoursTextField, rateTextField, annualSalaryTextField;
    private Button removeEmployeeButton, mainPage, leftButton, rightButton;
    private static RadioButton PhD, Master, Bachelor, secondarySchoolButton, primarySchoolButton;
    private static ComboBox<String> employeeTypeComboBox;
    private static MyFileChooser myFileChooser;
    private static MyDatePicker myDatePicker;
    private static GridPane centerGridPane;
    private static VBox imageAndTypeVBox;
    private static HBox actionButtonHBox;
    private static Stage stage;
    private static BorderPane mainBorderPane;
    private final ToggleGroup educationToggleGroup;
    private static final RemoveEmployee instance = new RemoveEmployee();
    private static Employee currentEmployee;


    public static Employee getCurrentEmployee() {
        return currentEmployee;
    }

    public static RemoveEmployee getInstance() {
        return instance;
    }

    private RemoveEmployee() {

        empnoLabel = new Label("Employee Number:");
        empnoTextField = new TextField();
        empnoTextField.setDisable(true);
        empnoTextField.setMaxSize(50, 1);

        hoursLabel = new Label("Hours:");
        hoursTextField = new TextField();
        hoursTextField.setMaxSize(50, 1);
        hoursTextField.setDisable(true);

        rateLabel = new Label("Rate:");
        rateTextField = new TextField();
        rateTextField.setMaxSize(50, 1);
        rateTextField.setDisable(true);

        annualSalaryLabel = new Label("Annual Salary:");
        annualSalaryTextField = new TextField();
        annualSalaryTextField.setMaxSize(50, 1);
        annualSalaryTextField.setDisable(true);

        soldItemsPerMonthLabel = new Label("Sold Items Per Month:");
        soldItemsPerMonthTextField = new TextField();
        soldItemsPerMonthTextField.setMaxSize(50, 1);
        soldItemsPerMonthTextField.setDisable(true);

        basedSalaryLabel = new Label("Based Salary:");
        basedSalaryTextField = new TextField();
        basedSalaryTextField.setMaxSize(50, 1);
        basedSalaryTextField.setDisable(true);

        salaryLabel = new Label("Salary:");
        salaryTextField = new TextField();
        salaryTextField.setMaxSize(50, 1);
        salaryTextField.setDisable(true);

        HBox empno = new HBox(10);
        empno.setAlignment(Pos.CENTER_LEFT);
        empno.getChildren().addAll(empnoLabel, empnoTextField);

        myFileChooser = new MyFileChooser(null);
        myFileChooser.getChooseImageButton().setDisable(true);

        employeeTypeLabel = new Label("Employee Type:");
        employeeTypeComboBox = new ComboBox<>();
        employeeTypeComboBox.getItems().addAll("Hourly Employee", "Salaried Employee", "Commession Employee", "Employee Based Comession");
        employeeTypeComboBox.setValue("Hourly Employee");
        employeeTypeComboBox.setMaxSize(90, 2);
        employeeTypeComboBox.setDisable(true);

        HBox employeeTypeHBox = new HBox(10);
        employeeTypeHBox.setAlignment(Pos.CENTER_LEFT);
        employeeTypeHBox.getChildren().addAll(employeeTypeLabel, employeeTypeComboBox);

        GridPane employeeTypeGridPane = new GridPane();
        employeeTypeGridPane.setAlignment(Pos.CENTER_LEFT);
        employeeTypeGridPane.setHgap(10);
        employeeTypeGridPane.setVgap(10);
        
        VBox employeeTypeVBox = new VBox(10);
        employeeTypeVBox.setAlignment(Pos.CENTER_LEFT);
        employeeTypeVBox.getChildren().addAll(employeeTypeHBox, employeeTypeGridPane);

        employeeTypeComboBox.setOnAction(e -> {
            employeeTypeGridPane.getChildren().clear();

            switch (employeeTypeComboBox.getValue()) {
                case "Hourly Employee":
                    employeeTypeGridPane.add(hoursLabel, 0, 0);
                    employeeTypeGridPane.add(hoursTextField, 1, 0);
                    employeeTypeGridPane.add(rateLabel, 0, 1);
                    employeeTypeGridPane.add(rateTextField, 1, 1);
                    employeeTypeGridPane.add(salaryLabel, 0, 2);
                    employeeTypeGridPane.add(salaryTextField, 1, 2);
                    break;
                case "Salaried Employee":
                    employeeTypeGridPane.add(annualSalaryLabel, 0, 0);
                    employeeTypeGridPane.add(annualSalaryTextField, 1, 0);
                    employeeTypeGridPane.add(salaryLabel, 0, 1);
                    employeeTypeGridPane.add(salaryTextField, 1, 1);
                    break;
                case "Commession Employee":
                    employeeTypeGridPane.add(soldItemsPerMonthLabel, 0, 0);
                    employeeTypeGridPane.add(soldItemsPerMonthTextField, 1, 0);
                    employeeTypeGridPane.add(salaryLabel, 0, 1);
                    employeeTypeGridPane.add(salaryTextField, 1, 1);
                    break;
                case "Employee Based Comession":
                    employeeTypeGridPane.add(basedSalaryLabel, 0, 0);
                    employeeTypeGridPane.add(basedSalaryTextField, 1, 0);
                    employeeTypeGridPane.add(soldItemsPerMonthLabel, 0, 1);
                    employeeTypeGridPane.add(soldItemsPerMonthTextField, 1, 1);
                    employeeTypeGridPane.add(salaryLabel, 0, 2);
                    employeeTypeGridPane.add(salaryTextField, 1, 2);
                    break;
                default:
                    break;
            }
        });

        imageAndTypeVBox = new VBox(50);
        imageAndTypeVBox.setPadding(new javafx.geometry.Insets(20, 20, 0, 20));
        imageAndTypeVBox.getChildren().addAll(empno, employeeTypeVBox, myFileChooser.getLayout());
        imageAndTypeVBox.setAlignment(Pos.TOP_LEFT);
        
        firstNameLabel = new Label("First Name:");
        firstNameTextField = new TextField();
        firstNameTextField.setDisable(true);

        lastNameLabel = new Label("Last Name:");
        lastNameTextField = new TextField();
        lastNameTextField.setDisable(true);

        dateOfBirthLabel = new Label("Date Of Birth:");
        myDatePicker = new MyDatePicker();
        myDatePicker.getDatePicker().setDisable(true);

        designationLabel = new Label("Designation:");
        designationTextField = new TextField();
        designationTextField.setDisable(true);

        emailLabel = new Label("Email:");
        emailTextField = new TextField();
        emailTextField.setDisable(true);

        phoneNumberLabel = new Label("Phone Number:");
        phoneNumberTextField = new TextField();
        phoneNumberTextField.setDisable(true);

        streetLabel = new Label("Street:");
        streetTextField = new TextField();
        streetTextField.setDisable(true);
        cityLabel = new Label("City:");
        cityTextField = new TextField();
        cityTextField.setDisable(true);
        countryLabel = new Label("Country:");
        countryTextField = new TextField();
        countryTextField.setDisable(true);

        educationLabel = new Label("Education:");
        PhD = new RadioButton("PhD");
        PhD.setDisable(true);
        Master = new RadioButton("Master");
        Master.setDisable(true);
        Bachelor = new RadioButton("Bachelor");
        Bachelor.setDisable(true);
        secondarySchoolButton = new RadioButton("Secondary School");
        secondarySchoolButton.setDisable(true);
        primarySchoolButton = new RadioButton("Primary School");
        primarySchoolButton.setDisable(true);

        educationToggleGroup = new ToggleGroup();
        PhD.setToggleGroup(educationToggleGroup);
        Master.setToggleGroup(educationToggleGroup);
        Bachelor.setToggleGroup(educationToggleGroup);
        secondarySchoolButton.setToggleGroup(educationToggleGroup);
        primarySchoolButton.setToggleGroup(educationToggleGroup);

        centerGridPane = new GridPane();
        centerGridPane.setPadding(new javafx.geometry.Insets(20));
        centerGridPane.setVgap(10);
        centerGridPane.setHgap(10);
        centerGridPane.add(firstNameLabel, 0, 0);
        centerGridPane.add(firstNameTextField, 1, 0);
        centerGridPane.add(lastNameLabel, 2, 0);
        centerGridPane.add(lastNameTextField, 3, 0);
        centerGridPane.add(dateOfBirthLabel, 4, 0);
        centerGridPane.add(myDatePicker.getDatePicker(), 5, 0);

        centerGridPane.add(emailLabel, 0, 5);
        centerGridPane.add(emailTextField, 1, 5);
        centerGridPane.add(phoneNumberLabel, 2, 5);
        centerGridPane.add(phoneNumberTextField, 3, 5);
        centerGridPane.add(designationLabel, 4,5);
        centerGridPane.add(designationTextField, 5, 5);
        centerGridPane.add(streetLabel, 0, 10);
        centerGridPane.add(streetTextField, 1, 10);
        centerGridPane.add(cityLabel, 2, 10);
        centerGridPane.add(cityTextField, 3, 10);
        centerGridPane.add(countryLabel, 4, 10);
        centerGridPane.add(countryTextField, 5, 10);
        centerGridPane.add(educationLabel, 0, 15);
        centerGridPane.add(PhD, 1, 15);
        centerGridPane.add(Master, 2, 15);
        centerGridPane.add(Bachelor, 3, 15);
        centerGridPane.add(secondarySchoolButton, 4, 15);
        centerGridPane.add(primarySchoolButton, 5, 15);

        removeEmployeeButton = new Button();
        ImageView removeEmployeeImageView = new ImageView(new Image(getClass().getResource("/icon/removeUser.png").toExternalForm()));
        removeEmployeeImageView.setFitHeight(50);
        removeEmployeeImageView.setFitWidth(50);
        removeEmployeeButton.setGraphic(removeEmployeeImageView);
        removeEmployeeButton.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
        // Action to be performed when the button is clicked
        removeEmployeeButton.setOnMouseEntered(event -> {
            removeEmployeeButton.setScaleX(1.1); // Increase the scale by 10%
            removeEmployeeButton.setScaleY(1.1); 
            removeEmployeeButton.setStyle("-fx-background-color: lightgreen; -fx-border-color: darkgreen; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        removeEmployeeButton.setOnMouseExited(event -> {
            removeEmployeeButton.setScaleX(1); // Reset to normal scale
            removeEmployeeButton.setScaleY(1);
            removeEmployeeButton.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
        });

        RemoveEmployeeButtonHandler removeEmployeeButtonHandler = new RemoveEmployeeButtonHandler();
        removeEmployeeButton.setOnAction(removeEmployeeButtonHandler);

        
        mainPage = new Button();
        ImageView mainPageImageView = new ImageView(new Image(getClass().getResource("/icon/mainPage.png").toExternalForm()));
        mainPageImageView.setFitHeight(50);
        mainPageImageView.setFitWidth(50);
        mainPage.setGraphic(mainPageImageView);
        mainPage.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
        // Action to be performed when the button is clicked
        mainPage.setOnMouseEntered(event -> {
            mainPage.setScaleX(1.1); // Increase the scale by 10%
            mainPage.setScaleY(1.1); 
            mainPage.setStyle("-fx-background-color: lightgreen; -fx-border-color: darkgreen; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        mainPage.setOnMouseExited(event -> {
            mainPage.setScaleX(1); // Reset to normal scale
            mainPage.setScaleY(1);
            mainPage.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        mainPage.setOnAction(event -> {
            stage.close();
        });

        leftButton = new Button();
        ImageView leftButtonImageView = new ImageView(new Image(getClass().getResource("/icon/left.png").toExternalForm()));
        leftButtonImageView.setFitHeight(50);
        leftButtonImageView.setFitWidth(50);
        leftButton.setGraphic(leftButtonImageView);
        leftButton.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
        // Action to be performed when the button is clicked
        leftButton.setOnMouseEntered(event -> {
            leftButton.setScaleX(1.1); // Increase the scale by 10%
            leftButton.setScaleY(1.1); 
            leftButton.setStyle("-fx-background-color: lightgreen; -fx-border-color: darkgreen; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        leftButton.setOnMouseExited(event -> {
            leftButton.setScaleX(1); // Reset to normal scale
            leftButton.setScaleY(1);
            leftButton.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        leftButton.setOnAction(event -> {

            int currentIndex = AddEmployee.getInstance().getEmployeesObservableList().indexOf(currentEmployee);

            if (currentIndex > 0){
                currentEmployee = AddEmployee.getInstance().getEmployeesObservableList().get(currentIndex - 1);
                updateScene(currentEmployee);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("End of List");
                alert.setHeaderText(null);
                alert.setContentText("No previous employee available.");
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
        });

        rightButton = new Button();
        ImageView rightButtonImageView = new ImageView(new Image(getClass().getResource("/icon/left.png").toExternalForm()));
        rightButtonImageView.setRotate(180);
        rightButtonImageView.setFitHeight(50);
        rightButtonImageView.setFitWidth(50);
        rightButton.setGraphic(rightButtonImageView);
        rightButton.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
        // Action to be performed when the button is clicked
        rightButton.setOnMouseEntered(event -> {
            rightButton.setScaleX(1.1); // Increase the scale by 10%
            rightButton.setScaleY(1.1); 
            rightButton.setStyle("-fx-background-color: lightgreen; -fx-border-color: darkgreen; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        rightButton.setOnMouseExited(event -> {
            rightButton.setScaleX(1); // Reset to normal scale
            rightButton.setScaleY(1);
            rightButton.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        rightButton.setOnAction(event -> {

            int currentIndex = AddEmployee.getInstance().getEmployeesObservableList().indexOf(currentEmployee);

            if (currentIndex < (AddEmployee.getInstance().getEmployeesObservableList().size() -1)){
                currentEmployee = AddEmployee.getInstance().getEmployeesObservableList().get(currentIndex + 1);
                updateScene(currentEmployee);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("End of List");
                alert.setHeaderText(null);
                alert.setContentText("No next employee available.");
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
        });

        actionButtonHBox = new HBox(10);
        actionButtonHBox.setAlignment(Pos.CENTER);
        actionButtonHBox.getChildren().addAll(removeEmployeeButton, mainPage, leftButton, rightButton);
        actionButtonHBox.setPadding(new Insets(10));

    }

    public TextField getEmpnoTextField() {
        return empnoTextField;
    }

    public Stage getStage() {
        return stage;
    }

    public Button getLeftButton() {
        return leftButton;
    }

    public Button getRightButton() {
        return rightButton;
    }

    private static void updateScene(Employee employee) {

        empnoTextField.setText(employee.getEmpno());
        firstNameTextField.setText(employee.getFirstName());
        lastNameTextField.setText(employee.getLastName());
        String[] date = employee.getDateOfBirth().split("/");
        myDatePicker.getDatePicker().setValue(LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0])));
        designationTextField.setText(employee.getDesignation());
        emailTextField.setText(employee.getEmail());
        phoneNumberTextField.setText(employee.getPhoneNumber());
        streetTextField.setText(employee.getAddress().getStreet());
        cityTextField.setText(employee.getAddress().getCity());
        countryTextField.setText(employee.getAddress().getCountry());
        myFileChooser.getImageView().setImage(employee.getImage());

        if (employee instanceof HourlyEmployee) {
            System.out.println("out Hourly Employee");
            employeeTypeComboBox.setValue("Hourly Employee");
            hoursTextField.setText(((HourlyEmployee) employee).getHours() + "");
            rateTextField.setText(((HourlyEmployee) employee).getRate() + "");
        }
        
        else if (employee instanceof SalariedEmployee) {
            System.out.println("out Salaried Employee");
            employeeTypeComboBox.setValue("Salaried Employee");
            annualSalaryTextField.setText(((SalariedEmployee) employee).getAnnualSalary() + "");
        }
        
        else if (employee instanceof EmployeeBasedComession) {
            System.out.println("out Employee Based Comession");
            employeeTypeComboBox.setValue("Employee Based Comession");
            soldItemsPerMonthTextField.setText(((EmployeeBasedComession) employee).getSoldItemsPerMonth() + "");
            basedSalaryTextField.setText(((EmployeeBasedComession) employee).getBasedSalary() + "");
        }
        
        else if (employee instanceof CommessionEmployee) {
            System.out.println("out Commession Employee");
            employeeTypeComboBox.setValue("Commession Employee");
            soldItemsPerMonthTextField.setText(((CommessionEmployee) employee).getSoldItemsPerMonth() + "");
        }
        salaryTextField.setText(employee.payment() + "");
        switch (employee.getEducation()) {
            case "PhD":
                PhD.setSelected(true);
                break;
            case "Master":
                Master.setSelected(true);
                break;
            case "Bachelor":
                Bachelor.setSelected(true);
                break;
            case "Secondary School":
                secondarySchoolButton.setSelected(true);
                break;
            case "Primary School":
                primarySchoolButton.setSelected(true);
                break;
        }

        employeeTypeComboBox.fireEvent(new ActionEvent());

    }

    public static void display(Employee employee) {
        currentEmployee = employee;

        updateScene(employee);
        if (stage != null) {
            stage.close();
        }

        mainBorderPane = new BorderPane();
        MyMenu myMenu = new MyMenu();
        mainBorderPane.setTop(myMenu.getMenuBar());

        mainBorderPane.setLeft(imageAndTypeVBox);
        mainBorderPane.setCenter(centerGridPane);
        mainBorderPane.setBottom(actionButtonHBox);

        Scene scene = new Scene(mainBorderPane, 800, 600);
        stage = new Stage();
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setTitle("Remove Employee");
        stage.show();
        
    }
}
