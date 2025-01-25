package edu.birzeit.form;

import edu.birzeit.GUI.AddEmployee;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

public abstract class Employee {
    private static int initEmpno = 1000;
    private final SimpleStringProperty empno;
    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty dateOfBirth;
    private Address address;
    private SimpleStringProperty phoneNumber;
    private SimpleStringProperty email;
    private SimpleStringProperty nationality;
    private SimpleStringProperty designation;
    private SimpleStringProperty education;
    private Image image;
    private final AddEmployee addEmployee = AddEmployee.getInstance();

    public Employee(String firstName, String lastName, String dateOfBirth, Address address, String phoneNumber, String email, String nationality, String designation, String education, String pathOfPhoto) {
        
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setNationality(nationality);
        setDesignation(designation);
        setEducation(education);
        this.image = new Image(pathOfPhoto);
        this.empno = new SimpleStringProperty(initEmpno++ + "");
    }

    public Employee(Employee employee, String firstName, String lastName, String dateOfBirth, Address address, String phoneNumber, String email, String nationality, String designation, String education, String pathOfPhoto) {
        this.empno = new SimpleStringProperty(employee.getEmpno());
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setNationality(nationality);
        setDesignation(designation);
        setEducation(education);
        this.image = new Image(pathOfPhoto);
    }

    public static boolean isValidName(String name) {
        return name.matches("^[a-zA-Z]+$");
    }

    public static boolean isValidPhoneNumber(String number) {
        // Not 10 digits?
        return number.matches("^(059|056)\\d{6}$"); // Check if the number starts with 059 or 056 and has 9 digits
    }

    public static boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z][a-zA-Z0-9]{3,}@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$"); // Check if the email is valid
    }
    
    public abstract double payment(); // Abstract method

    public String getEmpno() {
        return empno.get();
    }

    public String getFirstName() {
        return firstName.get();
    }
    
    public final void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty.");
        }
        if (!isValidName(firstName)) {
            throw new IllegalArgumentException("First name should contain only characters.");
        }
        this.firstName = new SimpleStringProperty(firstName);
    }
    
    public String getLastName() {
        return lastName.get();
    }
    
    public final void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty.");
        }
        if (!isValidName(lastName)) {
            throw new IllegalArgumentException("Last name should contain only characters.");
        }
        this.lastName = new SimpleStringProperty(lastName);
    }
    
    public String getDateOfBirth() {
        return dateOfBirth.get();
    }
    
    public final void setDateOfBirth(String dateOfBirth) {
        if (!(addEmployee.getMyDatePicker().isValidDate())) {
            throw new IllegalArgumentException("Employee must be at least 16 years old.");
        }
        this.dateOfBirth = new SimpleStringProperty(dateOfBirth);
    }
    
    public Address getAddress() {
        return address;
    }
    
    public final void setAddress(Address address) {
        this.address = address;
    }
    
    public String getPhoneNumber() {
        return phoneNumber.get();
    }
    
    public final void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty.");
        }
        if (!isValidPhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number format. For example, '(059 | 056)123456'.");
        }
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
    }
    
    public String getEmail() {
        return email.get();
    }
    
    public final void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty.");
        }
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format. For example, 'example123@example.com'.");
        }
        this.email = new SimpleStringProperty(email);
    }
    
    public String getNationality() {
        return nationality.get();
    }
    
    public final void setNationality(String nationality) {
        this.nationality = new SimpleStringProperty(nationality);
    }
    
    public String getDesignation() {
        return designation.get();
    }
    
    public final void setDesignation(String designation) {
        if (designation == null || designation.trim().isEmpty()) {
            throw new IllegalArgumentException("Designation cannot be empty.");
        }
        this.designation = new SimpleStringProperty(designation);
    }
    
    public String getEducation() {
        return education.get();
    }
    
    public final void setEducation(String education) {
        this.education = new SimpleStringProperty(education);
    }
    
    public Image getImage() {
        return image;
    }
    
    public void setImage(Image image) {
        this.image = image;
    }

    public static int getInitEmpno() {
        return initEmpno;
    }

    public static void unChangeInitEmpno() {
        initEmpno--;
    }
}
