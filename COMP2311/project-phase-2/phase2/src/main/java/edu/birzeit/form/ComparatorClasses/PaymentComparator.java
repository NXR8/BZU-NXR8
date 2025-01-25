package edu.birzeit.form.ComparatorClasses;

import java.util.Comparator;
import edu.birzeit.form.Employee;

public class PaymentComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        // Compare employees by salary in descending order
        return Double.compare(emp2.payment(), emp1.payment()); // Descending order
    }
}
