
public class Volunteer {
	String associationName;

	public Volunteer(String associationName) {
		this.associationName = associationName;
	}
	public Volunteer() {
	}

	public double pay() {
        return 0;
    }
	@Override
	public String toString() {
		return "Volunteer [associationName=" + associationName + "]";
	}


}
