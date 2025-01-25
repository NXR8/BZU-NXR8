package edu.birzeit.GUI;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class MyTabs {

    private final TabPane tabPane;
    private final Tab employeeTab, reportTab;
    private final EmployeeRecordTab employeeRecordTab = new EmployeeRecordTab();
    private final StatiscalReportTab statiscalReportTab = new StatiscalReportTab();
    
    public MyTabs() {

        tabPane = new TabPane();

        employeeTab = new Tab("Employee Record");
        employeeTab.setClosable(false);
        employeeTab.setContent(employeeRecordTab.getMainVBox());

        reportTab = new Tab("Statistical Report");
        reportTab.setClosable(false);
        reportTab.setContent(statiscalReportTab.getMainVBox());

        tabPane.getTabs().addAll(employeeTab, reportTab);
    }

    public TabPane getTabPane() {
        return tabPane;
    }
}
