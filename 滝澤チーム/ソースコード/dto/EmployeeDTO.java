package dto;

public class EmployeeDTO {

	private String empId;
	private String empName;


	EmployeeDTO(){

	}
	EmployeeDTO(String empId, String empName){
		this.empId = empId;
		this.empName = empName;

	}

	public String getEmpId() {
		return empId;
	}
	public void setEmpld(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
}
