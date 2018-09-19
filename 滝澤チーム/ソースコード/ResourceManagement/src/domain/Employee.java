package domain;

public class Employee {
	private String empId;
	private String name;
	private String password;
	private int managerId;

	public int getManagerId() {
		return managerId;
	}



	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}



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

	public Employee(String empId, String name, String password, int managerId) {
		super();
		this.empId = empId;
		this.name = name;
		this.password = password;
		this.managerId = managerId;
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
