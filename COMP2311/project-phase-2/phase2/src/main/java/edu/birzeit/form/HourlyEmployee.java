package edu.birzeit.form;

public class HourlyEmployee extends Employee {
    private short hours;
    private float rate;



    public HourlyEmployee(String firstName, String lastName, String dateOfBirth, Address address, String phoneNumber, String email, String nationality, String designation, String education, String pathOfPhoto) {
        super(firstName, lastName, dateOfBirth, address, phoneNumber, email, nationality, designation, education, pathOfPhoto);
    }

    public HourlyEmployee(Employee employee, String firstName, String lastName, String dateOfBirth, Address address, String phoneNumber, String email, String nationality, String designation, String education, String pathOfPhoto, short hours, float rate) {
        super(employee, firstName, lastName, dateOfBirth, address, phoneNumber, email, nationality, designation, education, pathOfPhoto);
        setHours(hours);
        setRate(rate);
    }

    public HourlyEmployee(String firstName, String lastName, String dateOfBirth, Address address, String phoneNumber, String email, String nationality, String designation, String education, String pathOfPhoto, short hours, float rate) {
        super(firstName, lastName, dateOfBirth, address, phoneNumber, email, nationality, designation, education, pathOfPhoto);
        setHours(hours);
        setRate(rate);
    }

    @Override
    public double payment() {
        if (hours > 140) {
            return (rate * hours) + ((hours - 140) * rate * 0.7);
        }
        return (rate * hours);
    }

    public short getHours() {
        return hours;
    }

    public float getRate() {
        return rate;
    }

    public final void setHours(short hours) {
        if (hours >= 1 && hours <= 288){
            this.hours = hours;
        }
        else{
            throw new IllegalArgumentException("Hours must be between 1 and 288");
        }
    }

    public final void setRate(float rate) {
        if (rate <= 6 && rate >= 1){
            this.rate = rate;
        }
        else{
            throw new IllegalArgumentException("Rate must be between 1 and 6");
        }
    }

    @Override
    public String toString() {
        return "HourlyEmployee," + getEmpno() + "," + getFirstName() + "," + getLastName() + "," + getDateOfBirth() + "," + getAddress() + "," + getPhoneNumber() + "," + getEmail() + "," + getNationality() + "," + getDesignation() + "," + getEducation() + "," + getImage().getUrl() + "," + getHours() + "," + getRate();
    }

}
