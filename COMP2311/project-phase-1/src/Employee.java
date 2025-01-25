public class Employee {
    private String empno;
    private String department;

    public Employee(String empno, String department) {
        this.empno = empno;
        this.department = department;
    }

    public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double pay() {
        return 0;
    }

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", department=" + department + "]";
	}


}
