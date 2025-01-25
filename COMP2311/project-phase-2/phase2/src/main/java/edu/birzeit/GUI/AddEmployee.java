package edu.birzeit.GUI;

import edu.birzeit.GUI.EventHandlerCalsses.AddEmployeeButtonHandler;
import edu.birzeit.form.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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

public class AddEmployee {
    private final Label empnoLabel, firstNameLabel, lastNameLabel, dateOfBirthLabel, designationLabel, emailLabel, phoneNumberLabel, streetLabel, cityLabel, countryLabel, educationLabel, employeeTypeLabel;
    private static TextField empnoTextField;
    private final TextField firstNameTextField, lastNameTextField, designationTextField, emailTextField, phoneNumberTextField, streetTextField, cityTextField, countryTextField;
    private Button addEmployeeButton, clear, mainPage;
    private final RadioButton PhD, Master, Bachelor, secondarySchoolButton, primarySchoolButton;
    private final ComboBox<String> employeeTypeComboBox;
    private MyFileChooser myFileChooser;
    private final MyDatePicker myDatePicker;
    private static GridPane centerGridPane;
    private static VBox imageAndTypeVBox;
    private static HBox actionButtonHBox;
    private static Stage stage;
    private static BorderPane mainBorderPane;
    private final ToggleGroup educationToggleGroup;
    private final ObservableList<Employee> employeesObservableList = FXCollections.observableArrayList();

    private static final AddEmployee instance = new AddEmployee();

    public static AddEmployee getInstance() {
        return instance;
    }
    
    private AddEmployee() {

        empnoLabel = new Label("Employee Number:");
        empnoTextField = new TextField();
        empnoTextField.setText(Employee.getInitEmpno() + "");
        empnoTextField.setDisable(true);
        empnoTextField.setMaxSize(50, 1);

        HBox empno = new HBox(10);
        empno.setAlignment(Pos.CENTER_LEFT);
        empno.getChildren().addAll(empnoLabel, empnoTextField);
        
        myFileChooser = new MyFileChooser(null);

        employeeTypeLabel = new Label("Employee Type:");
        employeeTypeComboBox = new ComboBox<>();
        employeeTypeComboBox.getItems().addAll("Hourly Employee", "Salaried Employee", "Commession Employee", "Employee Based Comession");
        employeeTypeComboBox.setValue("Hourly Employee");
        employeeTypeComboBox.setMaxSize(90, 2);
        employeeTypeComboBox.setStyle("-fx-focus-color: green; -fx-faint-focus-color: transparent; -fx-cell-hover-color: green; -fx-selection-bar: green; ");
        
        HBox employeeTypeHBox = new HBox(10);
        employeeTypeHBox.setAlignment(Pos.CENTER_LEFT);
        employeeTypeHBox.getChildren().addAll(employeeTypeLabel, employeeTypeComboBox);

        imageAndTypeVBox = new VBox(50);
        imageAndTypeVBox.setPadding(new javafx.geometry.Insets(20, 20, 0, 20));
        imageAndTypeVBox.getChildren().addAll(empno, employeeTypeHBox, myFileChooser.getLayout());
        imageAndTypeVBox.setAlignment(Pos.TOP_LEFT);
        
        firstNameLabel = new Label("First Name:");
        firstNameTextField = new TextField();
        firstNameTextField.setStyle("-fx-focus-color: green; -fx-faint-focus-color: transparent;");

        lastNameLabel = new Label("Last Name:");
        lastNameTextField = new TextField();
        lastNameTextField.setStyle("-fx-focus-color: green; -fx-faint-focus-color: transparent;");

        dateOfBirthLabel = new Label("Date Of Birth:");
        myDatePicker = new MyDatePicker();

        designationLabel = new Label("Designation:");
        designationTextField = new TextField();
        designationTextField.setStyle("-fx-focus-color: green; -fx-faint-focus-color: transparent;");

        emailLabel = new Label("Email:");
        emailTextField = new TextField();
        emailTextField.setStyle("-fx-focus-color: green; -fx-faint-focus-color: transparent;");

        phoneNumberLabel = new Label("Phone Number:");
        phoneNumberTextField = new TextField();
        phoneNumberTextField.setStyle("-fx-focus-color: green; -fx-faint-focus-color: transparent;");

        streetLabel = new Label("Street:");
        streetTextField = new TextField();
        streetTextField.setStyle("-fx-focus-color: green; -fx-faint-focus-color: transparent;");
        cityLabel = new Label("City:");
        cityTextField = new TextField();
        cityTextField.setStyle("-fx-focus-color: green; -fx-faint-focus-color: transparent;");
        countryLabel = new Label("Country:");
        countryTextField = new TextField();
        countryTextField.setStyle("-fx-focus-color: green; -fx-faint-focus-color: transparent;");

        educationLabel = new Label("Education:");
        PhD = new RadioButton("PhD");
        PhD.setStyle("-fx-selected-mark-color: green; -fx-focus-color: green; -fx-faint-focus-color: transparent;");
        Master = new RadioButton("Master");
        Master.setStyle("-fx-selected-mark-color: green; -fx-focus-color: green; -fx-faint-focus-color: transparent;");
        Bachelor = new RadioButton("Bachelor");
        Bachelor.setStyle("-fx-selected-mark-color: green; -fx-focus-color: green; -fx-faint-focus-color: transparent;");
        Bachelor.setSelected(true);
        secondarySchoolButton = new RadioButton("Secondary School");
        secondarySchoolButton.setStyle("-fx-selected-mark-color: green; -fx-focus-color: green; -fx-faint-focus-color: transparent;");
        primarySchoolButton = new RadioButton("Primary School");
        primarySchoolButton.setStyle("-fx-selected-mark-color: green; -fx-focus-color: green; -fx-faint-focus-color: transparent;");

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
        // centerGridPane.add(addressLabel, 0, 2);
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

        addEmployeeButton = new Button();
        ImageView addEmployeeImageView = new ImageView(new Image(getClass().getResource("/icon/addDetails.png").toExternalForm()));
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

        AddEmployeeButtonHandler addEmployeeButtonHandler = new AddEmployeeButtonHandler();
        addEmployeeButton.setOnAction(addEmployeeButtonHandler);


        clear = new Button();
        ImageView clearImageView = new ImageView(new Image(getClass().getResource("/icon/clear.png").toExternalForm()));
        clearImageView.setFitHeight(50);
        clearImageView.setFitWidth(50);
        clear.setGraphic(clearImageView);
        clear.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
        // Action to be performed when the button is clicked
        clear.setOnMouseEntered(event -> {
            clear.setScaleX(1.1); // Increase the scale by 10%
            clear.setScaleY(1.1); 
            clear.setStyle("-fx-background-color: lightgreen; -fx-border-color: darkgreen; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        clear.setOnMouseExited(event -> {
            clear.setScaleX(1); // Reset to normal scale
            clear.setScaleY(1);
            clear.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        clear.setOnAction(event -> {
            firstNameTextField.clear();
            lastNameTextField.clear();
            emailTextField.clear();
            phoneNumberTextField.clear();
            designationTextField.clear();
            streetTextField.clear();
            cityTextField.clear();
            countryTextField.clear();
            myFileChooser.getImageView().setImage(new Image(getClass().getResource("/icon/defaultUser.png").toExternalForm()));

        });
        
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

        actionButtonHBox = new HBox(10);
        actionButtonHBox.setAlignment(Pos.CENTER);
        actionButtonHBox.getChildren().addAll(addEmployeeButton, clear, mainPage);
        actionButtonHBox.setPadding(new Insets(10));

    }

    public ToggleGroup getEducationToggleGroup() {
        return educationToggleGroup;
    }

    public ObservableList<Employee> getEmployeesObservableList() {
        return employeesObservableList;
    }

    public TextField getEmpnoTextField() {
        return empnoTextField;
    }

    public TextField getFirstNameTextField() {
        return firstNameTextField;
    }

    public TextField getLastNameTextField() {
        return lastNameTextField;
    }

    public TextField getDesignationTextField() {
        return designationTextField;
    }

    public TextField getEmailTextField() {
        return emailTextField;
    }

    public TextField getPhoneNumberTextField() {
        return phoneNumberTextField;
    }

    public TextField getStreetTextField() {
        return streetTextField;
    }

    public TextField getCityTextField() {
        return cityTextField;
    }

    public TextField getCountryTextField() {
        return countryTextField;
    }

    public Button getClear() {
        return clear;
    }

    public ComboBox<String> getEmployeeTypeComboBox() {
        return employeeTypeComboBox;
    }

    public MyFileChooser getMyFileChooser() {
        return myFileChooser;
    }

    public MyDatePicker getMyDatePicker() {
        return myDatePicker;
    }

    public static void display() {
        // System.out.println("display");
        if (stage != null) {
            stage.close();
        }
        empnoTextField.setText(Employee.getInitEmpno() + "");
        mainBorderPane = new BorderPane();
        MyMenu myMenu = new MyMenu();
        mainBorderPane.setTop(myMenu.getMenuBar());
        mainBorderPane.setLeft(imageAndTypeVBox);
        mainBorderPane.setCenter(centerGridPane);
        mainBorderPane.setBottom(actionButtonHBox);
        // mainBorderPane.setPadding(new javafx.geometry.Insets(0, 10, 10, 10));

        Scene scene = new Scene(mainBorderPane, 800, 600);
        stage = new Stage();
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setTitle("Add Employee");
        stage.show();
        
    }
}
