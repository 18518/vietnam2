package dto;

import java.time.LocalDateTime;

public class ReserveDTO {
	private int reserveId;
	private String empId;
	private LocalDateTime lenDate = LocalDateTime.now();
	private LocalDateTime returnDate = LocalDateTime.now();
	private String empName;
	private String resourceId;

	public ReserveDTO() {

	}

	public ReserveDTO(LocalDateTime lenDate, LocalDateTime returnDate) {
		this.lenDate = lenDate;
		this.returnDate = returnDate;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public int getReserveId() {
		return reserveId;
	}
	public void setReserveId(int reserveId) {
		this.reserveId = reserveId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public LocalDateTime getLenDate() {
		return lenDate;
	}
	public void setLenDate(LocalDateTime lenDate) {
		this.lenDate = lenDate;
	}
	public LocalDateTime getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}

}
