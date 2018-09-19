package dto;

import java.time.LocalDateTime;

public class ReserveDTO {
	private int reserveId;
	private String empId;
	private LocalDateTime lendDate = LocalDateTime.now();
	private LocalDateTime returnDate = LocalDateTime.now();
	private int resourceId;



	public ReserveDTO(int reserveId,  LocalDateTime lendDate, LocalDateTime returnDate,String empId,
			int resourceId) {

		this.reserveId = reserveId;
		this.empId = empId;
		this.lendDate = lendDate;
		this.returnDate = returnDate;
		this.resourceId = resourceId;
	}

	public ReserveDTO(LocalDateTime lendDate, LocalDateTime returnDate) {
		this.lendDate = lendDate;
		this.returnDate = returnDate;
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
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
	public LocalDateTime getLendDate() {
		return lendDate;
	}
	public void setLenDate(LocalDateTime lendDate) {
		this.lendDate = lendDate;
	}
	public LocalDateTime getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}


}
