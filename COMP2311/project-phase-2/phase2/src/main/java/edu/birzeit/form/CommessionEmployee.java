package edu.birzeit.form;

public class CommessionEmployee extends Employee {

    private double soldItemsPerMonth;

    public CommessionEmployee(String firstName, String lastName, String dateOfBirth, Address address, String phoneNumber, String email, String nationality, String designation, String education, String pathOfPhoto) {
        super(firstName, lastName, dateOfBirth, address, phoneNumber, email, nationality, designation, education, pathOfPhoto);
    }

    public CommessionEmployee(Employee employee, String firstName, String lastName, String dateOfBirth, Address address, String phoneNumber, String email, String nationality, String designation, String education, String pathOfPhoto, double soldItemsPerMonth) {
        super(employee, firstName, lastName, dateOfBirth, address, phoneNumber, email, nationality, designation, education, pathOfPhoto);
        setSoldItemsPerMonth(soldItemsPerMonth);
    }

    public CommessionEmployee(String firstName, String lastName, String dateOfBirth, Address address, String phoneNumber, String email, String nationality, String designation, String education, String pathOfPhoto, double soldItemsPerMonth) {
        super(firstName, lastName, dateOfBirth, address, phoneNumber, email, nationality, designation, education, pathOfPhoto);
        setSoldItemsPerMonth(soldItemsPerMonth);
    }
    
    @Override
    public double payment() {
        if (soldItemsPerMonth > 3775){
            return soldItemsPerMonth * 0.05;
        }
        if (soldItemsPerMonth > 2800){
            return soldItemsPerMonth * 0.03;
        }
        else{
            return soldItemsPerMonth * 0.015;
        }
    }

    public double getSoldItemsPerMonth() {
        return soldItemsPerMonth;
    }

    public final void setSoldItemsPerMonth(double soldItemsPerMonth) {
        if (soldItemsPerMonth < 0) {
            throw new IllegalArgumentException("Sold items per month cannot be negative.");
        }
        else {
            this.soldItemsPerMonth = soldItemsPerMonth;
        }
    }

    @Override
    public String toString() {
        return "CommessionEmployee," + getEmpno() + "," + getFirstName() + "," + getLastName() + "," + getDateOfBirth() + "," + getAddress() + "," + getPhoneNumber() + "," + getEmail() + "," + getNationality() + "," + getDesignation() + "," + getEducation() + "," + getImage().getUrl() + "," + getSoldItemsPerMonth();
    }
 
    
    
}
