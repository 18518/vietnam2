package domain;

public class Employee {
	private String empId;
	private String name;
	private String password;

	public Employee() {

	}

	public Employee(String empId) {
		this.empId = empId;
	}

	public Employee(String empId,String name, String password) {
		this.empId=empId;
		this.name=name;
		this.password=password;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
