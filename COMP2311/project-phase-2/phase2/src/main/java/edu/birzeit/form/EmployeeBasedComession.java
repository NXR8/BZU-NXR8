package edu.birzeit.form;

public class EmployeeBasedComession extends CommessionEmployee {
    private double basedSalary;
    

    public EmployeeBasedComession(String firstName, String lastName, String dateOfBirth, Address address, String phoneNumber, String email, String nationality, String designation, String education, String pathOfPhoto) {
        super(firstName, lastName, dateOfBirth, address, phoneNumber, email, nationality, designation, education, pathOfPhoto);
    }


    public EmployeeBasedComession(Employee employee, String firstName, String lastName, String dateOfBirth, Address address, String phoneNumber, String email, String nationality, String designation, String education, String pathOfPhoto, double soldItemsPerMonth, double basedSalary) {
        super(employee, firstName, lastName, dateOfBirth, address, phoneNumber, email, nationality, designation, education, pathOfPhoto, soldItemsPerMonth);
        this.basedSalary = basedSalary;
    }
    
    public EmployeeBasedComession(String firstName, String lastName, String dateOfBirth, Address address, String phoneNumber, String email, String nationality, String designation, String education, String pathOfPhoto, double soldItemsPerMonth, double basedSalary) {
        super(firstName, lastName, dateOfBirth, address, phoneNumber, email, nationality, designation, education, pathOfPhoto);
        this.basedSalary = basedSalary;
    }

    @Override
    public double payment() {
        return super.payment() + basedSalary;
    }


    public double getBasedSalary() {
        return basedSalary;
    }


    public void setBasedSalary(double basedSalary) {
        if (basedSalary < 0) {
            throw new IllegalArgumentException("Based salary cannot be negative.");
        }
        this.basedSalary = basedSalary;
    }


    @Override
    public String toString() {
        return "EmployeeBasedComession," + getEmpno() + "," + getFirstName() + "," + getLastName() + "," + getDateOfBirth() + "," + getAddress() + "," + getPhoneNumber() + "," + getEmail() + "," + getNationality() + "," + getDesignation() + "," + getEducation() + "," + getImage().getUrl() + "," + getSoldItemsPerMonth() + "," + getBasedSalary();
    }

    
    
}
