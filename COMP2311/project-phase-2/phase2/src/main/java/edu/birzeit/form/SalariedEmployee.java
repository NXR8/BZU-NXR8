package edu.birzeit.form;

public class SalariedEmployee extends Employee {

    private double annualSalary;

    public SalariedEmployee(String firstName, String lastName, String dateOfBirth, Address address, String phoneNumber, String email, String nationality, String designation, String education, String pathOfPhoto) {
        super(firstName, lastName, dateOfBirth, address, phoneNumber, email, nationality, designation, education, pathOfPhoto);
    }
    

    public SalariedEmployee(Employee employee, String firstName, String lastName, String dateOfBirth, Address address, String phoneNumber, String email, String nationality, String designation, String education, String pathOfPhoto, double annualSalary) {
        super(employee, firstName, lastName, dateOfBirth, address, phoneNumber, email, nationality, designation, education, pathOfPhoto);
        setAnnualSalary(annualSalary);
    }

    public SalariedEmployee(String firstName, String lastName, String dateOfBirth, Address address, String phoneNumber, String email, String nationality, String designation, String education, String pathOfPhoto, double annualSalary) {
        super(firstName, lastName, dateOfBirth, address, phoneNumber, email, nationality, designation, education, pathOfPhoto);
        setAnnualSalary(annualSalary);
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public final void setAnnualSalary(double annualSalary) {
        if (annualSalary >= 4075 && annualSalary <= 25000) {
            this.annualSalary = annualSalary;
        }
        else{
            throw new IllegalArgumentException("Invalid annual salary value. Please enter a value between 4075 and 25000.");
        }
    }

    @Override
    public double payment() {
        return annualSalary/12;
    }


    @Override
    public String toString() {
        return "SalariedEmployee," + getEmpno() + "," + getFirstName() + "," + getLastName() + "," + getDateOfBirth() + "," + getAddress() + "," + getPhoneNumber() + "," + getEmail() + "," + getNationality() + "," + getDesignation() + "," + getEducation() + "," + getImage().getUrl() + "," + getAnnualSalary();
    }
    

    
}
