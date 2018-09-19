package dto;

public class EmployeeDTO {

	private String empId;
	private String name;

	public EmployeeDTO() {

	}

	public EmployeeDTO(String empId,String name) {
		this.empId=empId;
		this.name=name;
	}

	public String getEmpId() {
		return empId;
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
