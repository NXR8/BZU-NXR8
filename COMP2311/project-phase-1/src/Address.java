
public class Address {
    String state;
    String city;
    String street;

    public Address() {
    }

    public Address(String city, String state, String street) {
        setCity(city);
        setState(state);
        setStreet(street);
    }

    public String getState() {
        return state;
    }

    public final void setState(String state) {
        // this.state = state;
        if (state.matches("[A-Za-z]+")) {
            this.state = state;
        } else {
            System.out.println("Invalid state name.");
            // throw new IllegalArgumentException("Invalid state name.");
        }
    }

    public String getCity() {
        return city;
    }

    public final void setCity(String city) {
        // this.city = city;
        if (city.matches("[A-Za-z]+")) {
            this.city = city;
        } else {
            System.out.println("Invalid city name.");
            // throw new IllegalArgumentException("Invalid city name.");
        }
    }

    public String getStreet() {
        return street;
    }

    public final void setStreet(String street) {
        // this.street = street;
        if (street.matches("[A-Za-z]+")) {
            this.street = street;
        } else {
            System.out.println("Invalid street name.");
            // throw new IllegalArgumentException("Invalid street name.");
        }
    }

	@Override
	public String toString() {
		return "Address [state=" + state + ", city=" + city + ", street=" + street + "]";
	}




}
