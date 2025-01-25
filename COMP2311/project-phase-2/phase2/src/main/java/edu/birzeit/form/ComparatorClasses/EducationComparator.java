package edu.birzeit.form.ComparatorClasses;

import java.util.Comparator;
import edu.birzeit.form.Employee;

public class EducationComparator implements Comparator<Employee> {

    // List of education levels in descending order of priority
    private static final String[] EDUCATION_ORDER = {
        "PhD", "Master", "Bachelor", "Secondary School", "Primary School"
    };

    @Override
    public int compare(Employee emp1, Employee emp2) {
        // Get the priority index of each employee's education level
        int index1 = getEducationIndex(emp1.getEducation());
        int index2 = getEducationIndex(emp2.getEducation());
        // Compare the indices in descending order
        return Integer.compare(index1, index2); // Descending order
    }

    // Helper method to get the priority index of an education level
    private int getEducationIndex(String education) {
        // Loop through the EDUCATION_ORDER array to find the index of the education level
        for (int i = 0; i < EDUCATION_ORDER.length; i++) {
            if (EDUCATION_ORDER[i].equals(education)) {
                return i; // Return the index if found
            }
        }
        return -1; // Return -1 if the education level is not found
    }
}
