package edu.birzeit;

import edu.birzeit.GUI.MyMenu;
import edu.birzeit.GUI.MyTabs;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {

    private static Scene scene;
    private static BorderPane root;
    private static MyMenu menu;
    private static MyTabs tabs;

    @SuppressWarnings("exports")
    @Override
    public void start(Stage stage) {

        root = new BorderPane();
        menu = new MyMenu();
        tabs = new MyTabs();
        
        root.setTop(menu.getMenuBar());

        root.setCenter(tabs.getTabPane());
        // scene = new Scene(label, 99999, 99999);
        scene = new Scene(root, 1080, 980);
        stage.setScene(scene);
        stage.setTitle("Birzeit University/Registration Department");
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}