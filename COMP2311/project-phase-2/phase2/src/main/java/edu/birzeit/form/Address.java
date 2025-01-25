package edu.birzeit.form;

import javafx.beans.property.SimpleStringProperty;

public class Address {
    private SimpleStringProperty country;
    private SimpleStringProperty city;
    private SimpleStringProperty street;

    public Address() {
    }

    public Address(String country, String city, String street) {
        setCountry(country);
        setCity(city);
        setStreet(street);
    }

    public final void setCountry(String country) {
        if (country == null || country.trim().isEmpty()) {
            throw new IllegalArgumentException("Country cannot be empty.");
        }
        else if (isValidString(country)) {
            this.country = new SimpleStringProperty(country);
        } else {
            throw new IllegalArgumentException("Invalid country name.");
        }
    }

    public final void setCity(String city) {
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("City cannot be empty.");
        }
        else if (isValidString(city)) {
            this.city = new SimpleStringProperty(city);
        } else {
            throw new IllegalArgumentException("Invalid city name.");
        }
    }

    public final void setStreet(String street) {
        if (street == null || street.trim().isEmpty()) {
            throw new IllegalArgumentException("Street cannot be empty.");
        }
        else if (isValidString(street)) {
            this.street = new SimpleStringProperty(street);
        } else {
            throw new IllegalArgumentException("Invalid street name.");
        }
    }

    public String getCountry() {
        return country.get();
    }

    public String getCity() {
        return city.get();
    }

    public String getStreet() {
        return street.get();
    }

    // Helper method to validate string
    private boolean isValidString(String str) {
        if (str == null || str.isEmpty() || str.matches("^[\\s]+$") || str.equals("")) {
            return false;
        }
        return str.matches("^[a-zA-Z0-9][a-zA-Z0-9\\s]+[a-zA-Z0-9]$");
    }

    @Override
    public String toString() {
        return  country.get() + "," + city.get() + "," + street.get();
    }
}