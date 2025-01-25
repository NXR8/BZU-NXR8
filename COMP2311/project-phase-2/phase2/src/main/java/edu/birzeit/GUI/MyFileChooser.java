package edu.birzeit.GUI;

import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MyFileChooser {

    private final ImageView imageView;
    private final Button chooseImageButton;
    private final VBox layout;

    public MyFileChooser(Stage primaryStage) {
        // Create ImageView to display the selected image
        this.imageView = new ImageView();
        this.imageView.setFitWidth(200); // Set the width of the image
        this.imageView.setFitHeight(200); // Set the height of the image
        this.imageView.setImage(new Image(getClass().getResource("/icon/defaultUser.png").toExternalForm())); // Set the default image

        // Create Button to open the file chooser
        this.chooseImageButton = new Button("Choose Image");
        this.chooseImageButton.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");
        // Action to be performed when the button is clicked
        this.chooseImageButton.setOnMouseEntered(event -> {
            this.chooseImageButton.setScaleX(1.1); // Increase the scale by 10%
            this.chooseImageButton.setScaleY(1.1); 
            this.chooseImageButton.setStyle("-fx-background-color: lightgreen; -fx-border-color: darkgreen; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });

        this.chooseImageButton.setOnMouseExited(event -> {
            this.chooseImageButton.setScaleX(1); // Reset to normal scale
            this.chooseImageButton.setScaleY(1);
            this.chooseImageButton.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 5px;");

        });
        this.chooseImageButton.setOnAction(event -> {
            // Create a FileChooser
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Image File");

            // Set file filters to show only image files
            FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg", "*.png", "*.gif", "*.bmp");
            fileChooser.getExtensionFilters().add(imageFilter);

            // Show the file chooser dialog
            File selectedFile = fileChooser.showOpenDialog(primaryStage);

            // If a file is selected, load it into the ImageView
            if (selectedFile != null) {
                Image image = new Image(selectedFile.toURI().toString());
                this.imageView.setImage(image);
            }
        });

        // Create layout and add elements to it
        this.layout = new VBox(10); // VBox with 10 spacing between elements
        this.layout.getChildren().addAll(this.imageView, this.chooseImageButton);
        this.layout.setAlignment(Pos.CENTER); // Center the layout
    }

    public ImageView getImageView() {
        return imageView;
    }

    public Button getChooseImageButton() {
        return chooseImageButton;
    }

    public VBox getLayout() {
        return layout;
    }
}
