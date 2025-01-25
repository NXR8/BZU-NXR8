# Project README

## Overview

This project involves the construction of a class hierarchy to model various types of staff members within an organization. Each class has specific attributes and methods that adhere to defined rules for input validation. The primary classes include `StaffMember`, `Volunteer`, `Employee`, `Address`, `HourlyEmployee`, `WeeklyEmployee`, `SalariedEmployee`, `ContractEmployee`, `CommissionEmployee`, and `EmployeeBasedCommission`. 

## Classes and Responsibilities

1. **StaffMember**
   - **Attributes**: 
     - First Name (String)
     - Last Name (String)
     - Date of Birth (String)
     - Address (Address object)
     - Mobile Number (String)
     - Personal Email (String)
     - Work Email (String)
   - **Methods**:
     - Setters and Getters for all attributes
     - `toString()`
     - Validation methods for input
     - `pay()`: Returns double (default to 0)

2. **Volunteer**
   - **Attributes**: 
     - Association Name (String)
   - **Methods**:
     - Setters and Getters
     - `toString()`
     - `pay()`: Returns double (default to 0)

3. **Employee**
   - **Attributes**: 
     - Employee Number (String)
     - Department (Department)
   - **Methods**:
     - Setters and Getters
     - `toString()`
     - `pay()`: Returns double (default to 0)

4. **Address**
   - **Attributes**: 
     - State (String)
     - City (String)
     - Street (String)
   - **Methods**:
     - Setters and Getters
     - `toString()`
     - Validation methods for attributes

5. **HourlyEmployee**
   - **Attributes**: 
     - Hours (short)
     - Rate (float)
   - **Methods**:
     - Setters and Getters
     - `toString()`
     - Validation methods for rate
     - `pay()`: Calculates salary with possible overtime

6. **WeeklyEmployee**
   - **Attributes**: 
     - Number of Weeks (byte)
     - Wage per Week (float)
   - **Methods**:
     - Setters and Getters
     - `toString()`
     - Validation methods for attributes
     - `pay()`: Calculates monthly salary

7. **SalariedEmployee**
   - **Attributes**: 
     - Annual Salary (double)
   - **Methods**:
     - Setters and Getters
     - `toString()`
     - Validation methods for annual salary
     - `pay()`: Calculates monthly salary

8. **ContractEmployee**
   - **Attributes**: 
     - Rate of Contract (double)
     - Number of Months (byte)
   - **Methods**:
     - Setters and Getters
     - `toString()`
     - Validation methods for attributes
     - `pay()`: Calculates monthly salary

9. **CommissionEmployee**
   - **Attributes**: 
     - Items Sold (double)
     - Price (double)
   - **Methods**:
     - Setters and Getters
     - `toString()`
     - `pay()`: Calculates monthly salary based on sales

10. **EmployeeBasedCommission**
    - **Attributes**: 
      - Based Salary (double)
    - **Methods**:
      - Setters and Getters
      - `toString()`
      - `pay()`: Calculates total salary including commission

## Input Validation

Each class implements rigorous input validation to ensure data integrity:
- Names must be alphabetic.
- Dates of birth must ensure the individual is at least 16 years old and not set in the future.
- Mobile numbers and emails must adhere to specific formats.
- Attributes in the `Address` class must not contain special characters or be empty.

## Installation and Usage

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/yourproject.git
   cd yourproject
   ```

2. **Compile the Code**
   Ensure you have a Java compiler installed, then run:
   ```bash
   javac *.java
   ```

3. **Run the Application**
   Execute the main application file:
   ```bash
   java Main
   ```

## Future Enhancements
- Implement unit tests for each class.
- Enhance user interface for easier data entry.
- Integrate a database for persistent data storage.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments
- Inspired by real-world organizational structures and employment types. 
- Thanks to the community for support and suggestions. 

--- 

Feel free to modify or expand upon this README to fit your project's specific needs!
