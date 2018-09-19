package dto;

public class EmployeeDTO {

	private String empId;
	private String name;
	private int managerId;

	public EmployeeDTO() {

	}

	public EmployeeDTO(String empId,String name) {
		this.empId=empId;
		this.name=name;
	}

	public String getEmpId() {
		return empId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public EmployeeDTO(String empId, String name, int managerId) {
		super();
		this.empId = empId;
		this.name = name;
		this.managerId = managerId;
	}

	public String getName() {
		return name;
	}

	public void setEmpId(String empId) {
		this.empId=empId;
	}
	public void setName(String name) {
		this.name=name;
	}
}
