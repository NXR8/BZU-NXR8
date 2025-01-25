
public class WeeklyEmployee {
	byte noOfWeeks;
	float  wagePerWeek;

	public WeeklyEmployee(byte noOfWeeks, float wagePerWeek) {
		this.noOfWeeks = noOfWeeks;
		this.wagePerWeek = wagePerWeek;
	}
	public WeeklyEmployee() {
	}
	public byte getNoOfWeeks() {
		return noOfWeeks;
	}
	public void setNoOfWeeks(byte noOfWeeks) {
		if (validateNoOfWeeks(noOfWeeks)){
			this.noOfWeeks = noOfWeeks;
		}
		else{
			System.out.println("Invalid noOfWeeks. Must betwen 1 and 4");
		}
	}
	public float getWagePerWeek() {
		return wagePerWeek;
	}
	public void setWagePerWeek(float wagePerWeek) {
		if (validateWagePerWeek(wagePerWeek)){
			this.wagePerWeek = wagePerWeek;
		}
		else{
			System.out.println("Invalid wagePerWeek. Must betwen 300 and 700");
		}
	}
	@Override
	public String toString() {
		return "WeeklyEmployee [noOfWeeks=" + noOfWeeks + ", wagePerWeek=" + wagePerWeek + "]";
	}


	boolean validateNoOfWeeks(byte noOfWeeks) {
            return noOfWeeks >= 1 || noOfWeeks <= 4;
    }

	boolean validateWagePerWeek(float wagePerWeek) {
            return wagePerWeek >= 300 || wagePerWeek <= 700;
    }

	public double pay() {
			return (noOfWeeks * wagePerWeek);
    }
}
