package edu.birzeit.GUI;

import edu.birzeit.GUI.EventHandlerCalsses.ReadEmployeeFromFileButtonHandler;
import edu.birzeit.GUI.EventHandlerCalsses.SaveEmployeeToFileButtonHandler;
import edu.birzeit.GUI.EventHandlerCalsses.TotalPaymentsButtonHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;

public class MyMenu {
    
    private final MenuBar menuBar;
    private final Menu employee, statiscalReport, close, sortedEmployees;
    private final MenuItem addEmployee, viewEmpoyee, readFile, saveFile, closeApp, sortByFirstName, sortByLastName, sortByEducation, sortBySalary, maxSalaryPerType, totalPayments;

    public MyMenu() {
        menuBar = new MenuBar();
        menuBar.setStyle("-fx-background-color: #2E8B57; -fx-text-fill: white;");

        employee = new Menu("Employee");
        employee.setStyle("-fx-background-color: #2E8B57; -fx-text-fill: white;");

        addEmployee = new MenuItem("Add Employee");

        addEmployee.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
        addEmployee.setOnAction(e -> {
            AddEmployee.display();
        });

        viewEmpoyee = new MenuItem("View Employee");

        viewEmpoyee.setAccelerator(KeyCombination.keyCombination("Ctrl+V"));
        viewEmpoyee.setOnAction(e -> {
            ViewEmployee.display();
        });

        readFile = new MenuItem("Read File");

        readFile.setAccelerator(KeyCombination.keyCombination("Ctrl+R"));
        ReadEmployeeFromFileButtonHandler readEmployeeFromFileButtonHandler = new ReadEmployeeFromFileButtonHandler();
        readFile.setOnAction(readEmployeeFromFileButtonHandler);

        saveFile = new MenuItem("Save File");

        saveFile.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
        SaveEmployeeToFileButtonHandler saveEmployeeToFileButtonHandler = new SaveEmployeeToFileButtonHandler();
        saveFile.setOnAction(saveEmployeeToFileButtonHandler);

        employee.getItems().addAll(addEmployee, viewEmpoyee, readFile, saveFile);

        statiscalReport = new Menu("Statiscal Report");
        statiscalReport.setStyle("-fx-background-color: #2E8B57; -fx-text-fill: white;");

        maxSalaryPerType = new MenuItem("Show Employee with Max Salary by Type");

        totalPayments = new MenuItem("Show Total Payments");
        TotalPaymentsButtonHandler totalPaymentsButtonHandler = new TotalPaymentsButtonHandler();
        totalPayments.setOnAction(totalPaymentsButtonHandler);

        sortedEmployees = new Menu("Show Employees Sorted by Criteria");

        sortByFirstName = new MenuItem("Sort by First Name");

        sortByFirstName.setOnAction(e -> {
            SortedBy.display(0);
        });
        sortByLastName = new MenuItem("Sort by Last Name");

        sortByLastName.setOnAction(e -> {
            SortedBy.display(1);
        });
        sortByEducation = new MenuItem("Sort by Education");

        sortByEducation.setOnAction(e -> {
            SortedBy.display(2);
        });
        sortBySalary = new MenuItem("Sort by Salary");

        sortBySalary.setOnAction(e -> {
            SortedBy.display(3);
        });

        sortedEmployees.getItems().addAll(sortByFirstName, sortByLastName, sortByEducation, sortBySalary);

        statiscalReport.getItems().addAll(maxSalaryPerType, totalPayments, sortedEmployees);
        
        closeApp = new MenuItem("Close Application");

        closeApp.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));
        closeApp.setOnAction(e -> System.exit(0));
        close = new Menu("Close");
        close.setStyle("-fx-background-color: #2E8B57; -fx-text-fill: white;");

        close.getItems().add(closeApp);

        menuBar.getMenus().addAll(employee, statiscalReport, close);

    }

    public MenuBar getMenuBar() {
        return menuBar;
    }

}
