
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class StaffMemebr {

    String firstName;
    String lastName;
    String dateBirth;
    Address address;
    String mobileNumber;
    String personalEmail;
    String workEmail;

    public StaffMemebr() {
    }

    public StaffMemebr(String firstName, String lastName, String dateBirth, Address address, String mobileNumber, String personalEmail) {
        setFirstName(firstName);
        setLastName(lastName);
        setDateBirth(dateBirth);
        setAddress(address);
        setMobileNumber(mobileNumber);
        setPersonalEmail(personalEmail);
        this.workEmail = workEmailAuto();
    }

    public String getFirstName() {
        return firstName;
    }

    public final void setFirstName(String FirstName) {
        if (FirstName.matches("[A-Za-z]+")) {
            this.firstName = FirstName;
        } else {
            System.out.println("Invalid first name.");
            // throw new IllegalArgumentException("Invalid first name.");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public final void setLastName(String LastName) {
        if (LastName.matches("[A-Za-z]+")) {
            this.lastName = LastName;
        } else {
            System.out.println("Invalid last name.");
        }
    }

    public String getDateBirth() {
        return dateBirth;
    }

    // public final void setDateBirth(String dateBirth) {
    //     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
    //     // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    //     try {
    //         LocalDate parsedDate = LocalDate.parse(dateBirth, formatter);

    //         // System.out.println("parsedDate.lengthOfMonth(): " + parsedDate.lengthOfMonth());
    //         // System.out.println("Integer.valueOf(dateBirth.split(\"/\")[0]): " + Integer.parseInt(dateBirth.split("/")[0]));

    //         // System.out.println(parsedDate.lengthOfMonth() >= Integer.parseInt(dateBirth.split("/")[0]));

    //         if (!(parsedDate.lengthOfMonth() >= Integer.parseInt(dateBirth.split("/")[0]))){
    //             System.out.println("Day of the month " + dateBirth.split("/")[1] + " must be between 1 and " + parsedDate.lengthOfMonth());
    //         }
    //         else if (parsedDate.isAfter(LocalDate.now())) {
    //             System.out.println("Date of birth cannot be in the future.");
    //         } else if (parsedDate.isBefore(LocalDate.now().minusYears(16))) {
    //             this.dateBirth = parsedDate.format(formatter);
    //         } else if (parsedDate.isBefore(LocalDate.now().minusYears(99))) {
    //             System.out.println("Why you are still alive.");
    //         } else {
    //             System.out.println("Staff member must be at least 16 years old.");
    //         }
    //     } catch (DateTimeParseException e) {
    //         System.out.println("Invalid date format. Use d/M/yyyy.");
    //     }
    // }

    public final void setDateBirth(String dateBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        try {
            LocalDate parsedDate = LocalDate.parse(dateBirth, formatter);

            if (!(parsedDate.lengthOfMonth() >= Integer.parseInt(dateBirth.split("/")[0]))) {
                System.out.println("Day of the month " + dateBirth.split("/")[1] + " must be between 1 and " + parsedDate.lengthOfMonth());
            } else if (parsedDate.isAfter(LocalDate.now())) {
                System.out.println("Date of birth cannot be in the future.");
            } else if (parsedDate.isBefore(LocalDate.now().minusYears(100))) {
                this.dateBirth = parsedDate.format(formatter);
                System.out.println("You've seen it all. What's your secret to sticking around?");
            } else if (parsedDate.isBefore(LocalDate.now().minusYears(90))) {
                this.dateBirth = parsedDate.format(formatter);
                System.out.println("Are you the family historian or just the one who remembers where everyone hid the good snacks?");
            } else if (parsedDate.isBefore(LocalDate.now().minusYears(80))) {
                this.dateBirth = parsedDate.format(formatter);
                System.out.println("Your life spans longer than the existence of many entities that once claimed permanence.");
            } else if (parsedDate.isBefore(LocalDate.now().minusYears(70))) {
                this.dateBirth = parsedDate.format(formatter);
                System.out.println("Do you still plan your days, or do you just see where life takes you??");
            } else if (parsedDate.isBefore(LocalDate.now().minusYears(60))) {
                this.dateBirth = parsedDate.format(formatter);
                System.out.println("Is retirement the goal or just an excuse to finally take that long nap?");
            } else if (parsedDate.isBefore(LocalDate.now().minusYears(50))) {
                this.dateBirth = parsedDate.format(formatter);
                System.out.println("Do you have a bucket list, or is it just a reminder of what you haven't done yet?");
            } else if (parsedDate.isBefore(LocalDate.now().minusYears(40))) {
                this.dateBirth = parsedDate.format(formatter);
                System.out.println("Is 40 the new 30, or do you feel that way when you wake up with aches?");
            } else if (parsedDate.isBefore(LocalDate.now().minusYears(30))) {
                this.dateBirth = parsedDate.format(formatter);
                System.out.println("Have you figured out how to adult, or is it still a work in progress?");
            } else if (parsedDate.isBefore(LocalDate.now().minusYears(20))) {
                this.dateBirth = parsedDate.format(formatter);
                System.out.println("Turning 20 means you're finally an adult. Welcome to the club!");
            } else if (parsedDate.isBefore(LocalDate.now().minusYears(18))) {
                this.dateBirth = parsedDate.format(formatter);
                System.out.println("Turning into an adult means you can finally vote, but do you even know who to vote for?");
            } else if (parsedDate.isBefore(LocalDate.now().minusYears(16))) {
                this.dateBirth = parsedDate.format(formatter);
                System.out.println("Are you ready to take on the world or just your homework?");
            } else {
                System.out.println("Staff member must be at least 16 years old.");
            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Use d/M/yyyy.");
        }
    }


    public final void setAddress(Address address) {
        if (address.getState() != null && address.getCity() != null && address.getStreet() != null) {
            this.address = address;
        } else {
            System.out.println("Invalid address details.");
        }
    }

    public Address getAddress() {
        return address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public final void setMobileNumber(String mobileNumber) {
        if (mobileNumber.startsWith("059") || mobileNumber.startsWith("056")) {
            if (mobileNumber.length() == 10 && mobileNumber.matches("\\d+")) {
                this.mobileNumber = mobileNumber;
            } else {
                System.out.println("Mobile number must be 10 digits long and contain only numbers.");
            }
        } else {
            System.out.println("Mobile number must start with 059 or 056.");
        }

    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public final void setPersonalEmail(String personalEmail) {
        if (personalEmail != null && personalEmail.matches("^[a-zA-Z][a-zA-Z0-9]*@[a-zA-Z]+\\.[a-zA-Z]{2,}$")) {
            this.personalEmail = personalEmail;
        } else {
            System.out.println("Invalid personal email format.");
        }
    }

    public String getWorkEmail() {
        return workEmail;
    }

    private String workEmailAuto() {
        if (firstName != null && lastName != null) {
            return firstName.toLowerCase().charAt(0) + lastName.toLowerCase() + "@nxr8.ps";
        } else {
            return "N/A";
        }
    }

    public double pay() {
        return 0;
    }

    @Override
    public String toString() {
        return "StaffMember{"
                + "firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", dateBirth='" + dateBirth + '\''
                + ", address=" + address
                + ", mobileNumber='" + mobileNumber + '\''
                + ", personalEmail='" + personalEmail + '\''
                + ", workEmail='" + workEmail + '\''
                + '}';
    }

}
