package edu.birzeit.form.ComparatorClasses;

import java.util.Comparator;
import edu.birzeit.form.Employee;

public class FirstNameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        // Compare employees by first name in descending order
        return emp1.getFirstName().compareTo(emp2.getFirstName()); // Descending order
    }
}
