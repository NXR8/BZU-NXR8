module edu.birzeit {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;

    opens edu.birzeit to javafx.fxml;
    opens edu.birzeit.form to javafx.base;

    exports edu.birzeit;
}
