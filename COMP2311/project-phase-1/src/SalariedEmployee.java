
public class SalariedEmployee {
	double  annualSalary;

	public double getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(double annualSalary) {
		if (validateAnnualSalary(annualSalary)){
			this.annualSalary = annualSalary;
		}
		else{
			System.out.println("Invalid noOfWeeks. Must betwen 21600 and 120,000");
		}

	}

	@Override
	public String toString() {
		return "SalariedEmployee [annualSalary=" + annualSalary + "]";
	}

	boolean validateAnnualSalary(double annualSalary) {
            return annualSalary >= 21600 || annualSalary <= 120000;
    }

	public double pay() {
		if (validateAnnualSalary(annualSalary)){
			return (annualSalary / 12);
		}
		return 0;
	}

	public SalariedEmployee(double annualSalary) {
		this.annualSalary = annualSalary;
	}

	public SalariedEmployee() {
	}
}
