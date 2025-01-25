public final class EmployeeBasedComession extends CommessionEmployee {
    private double baseSalary;

    public EmployeeBasedComession(double itemSold, double price, double baseSalary) {
        super(itemSold, price);
        setBaseSalary(baseSalary);
    }

    public EmployeeBasedComession() {
    }


    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0) {
        	System.out.println("Base salary cannot be negative");
        }
        else{
            this.baseSalary = baseSalary;
        }
    }

    @Override
    public double pay() {
        return baseSalary + super.pay();
    }

    @Override
    public String toString() {
        return "EmployeeBasedCommission[" + "baseSalary=" + baseSalary + ", itemsSold=" + getItemSold() +", pricePerItem=" + getPrice() +']';
    }
}
