
public class ContractEmployee {
	double rateOfconstract;
	byte noOfMonths;
	public double getRateOfconstract() {
		return rateOfconstract;
	}
	public void setRateOfconstract(double rateOfconstract) {
		this.rateOfconstract = rateOfconstract;
	}
	public byte getNoOfMonths() {
		return noOfMonths;
	}
	public void setNoOfMonths(byte noOfMonths) {
		this.noOfMonths = noOfMonths;
	}
	@Override
	public String toString() {
		return "ContractEmployee [rateOfconstract=" + rateOfconstract + ", noOfMonths=" + noOfMonths + "]";
	}
	public ContractEmployee(double rateOfconstract, byte noOfMonths) {
		super();
		this.rateOfconstract = rateOfconstract;
		this.noOfMonths = noOfMonths;
	}
	public ContractEmployee() {
	}

	boolean validateContractSalary(double rateOfconstract) {
            return rateOfconstract >= 1 || rateOfconstract <= 10000;
    }

	public double pay() {
		if (validateContractSalary(rateOfconstract)){
			return (rateOfconstract / noOfMonths);
		}
		return 0;

	}



}
