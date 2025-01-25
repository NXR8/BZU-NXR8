
public class HourlyEmployee {
	short hours;
	float rate;

	public HourlyEmployee(short hours, float rate) {
		this.hours = hours;
		this.rate = rate;
	}

	public HourlyEmployee() {
	}

	public short getHours() {
		return hours;
	}

	public void setHours(short hours) {
		if (hours >= 1 && hours <= 288){
			this.hours = hours;
		}
		else{
            System.out.println("Invalid hours. Must betwen 1 and 288");
		}
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		if (rate >= 8 && rate <= 30){
			this.rate = rate;
		}
		else{
            System.out.println("Invalid rate. Must betwen 8 30");
		}
	}
		public double pay() {
			if (hours > 120){
				return ((hours * rate) + ((hours - 120)*0.5)*rate);
			}

			else{
				return (hours * rate);
			}
	    }

		@Override
		public String toString() {
			return "HourlyEmployee [hours=" + hours + ", rate=" + rate + "]";
		}




}
