package edu.birzeit.GUI;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.util.StringConverter;

public class MyDatePicker {

    private final DatePicker datePicker;

    public MyDatePicker() {
        this.datePicker = new DatePicker();
        this.datePicker.setValue(((LocalDate.now()).minus(Period.ofYears(16)).minus(Period.ofDays(1))));

        // Style the DatePicker
        this.datePicker.setStyle("-fx-focus-color: green; -fx-faint-focus-color: transparent;");

        // Define the date format as "DD/MM/YYYY"
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Apply the custom format to the DatePicker
        this.datePicker.setConverter(new StringConverter<>() {
            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date); // Format the date as "DD/MM/YYYY"
                }
                else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter); // Parse the date to "DD/MM/YYYY"
                }
                else {
                    return null;
                }
            }
        });

        this.datePicker.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);

                // Disable dates older than 16 years
                if (item.isAfter(LocalDate.now().minus(Period.ofYears(16)))) {
                    setDisable(true); // Disable the cell
                    setStyle("-fx-background-color: #ffc0cb;"); // Set the background color
                } else {
                    setDisable(false); // Enable the cell

                    // Change the background color when selected
                    selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
                        if (isNowSelected) {
                            setStyle("-fx-background-color: green; -fx-text-fill: white;");
                        }
                    });
                    // Change the background color when hovered
                    hoverProperty().addListener((obs, wasHovered, isNowHovered) -> {
                        if (isNowHovered) {
                            setStyle("-fx-background-color: green; -fx-text-fill: white;");
                        } else {
                            setStyle(""); // Reset the background color
                        }
                    });
                }
            }
        });
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public String getDate() {
        return this.datePicker.getValue().getDayOfMonth() + "/" + this.datePicker.getValue().getMonthValue() + "/" + this.datePicker.getValue().getYear();
    }

    public boolean isValidDate() {
        return this.datePicker.getValue().isBefore((LocalDate.now()).minus(Period.ofYears(16)));
    }
}