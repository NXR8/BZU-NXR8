package edu.birzeit.form.ComparatorClasses;

import java.util.Comparator;
import edu.birzeit.form.Employee;

public class LastNameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        // Compare employees by last name in descending order
        return emp1.getLastName().compareTo(emp2.getLastName()); // Descending order
    }
}
