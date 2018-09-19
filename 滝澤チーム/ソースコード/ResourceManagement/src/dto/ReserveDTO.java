package dto;

import java.time.LocalDateTime;

import utils.DateUtil;

public class ReserveDTO {
	int reserveId;
	String empId;
	int resourceId;
	LocalDateTime lendDate;
	LocalDateTime returnDate;
	String formatLendDate;
	String formatReturnDate;

	public ReserveDTO() {


	}
	public ReserveDTO(LocalDateTime lendDate,LocalDateTime returnDate) {
		this.lendDate = lendDate;
		this.returnDate=returnDate;
	}
	public ReserveDTO(int reserveId,LocalDateTime lendDate,LocalDateTime returnDate,String empId,int resourceId) {
		this.reserveId = reserveId;
		this.lendDate = lendDate;
		this.returnDate=returnDate;
		this.empId = empId;
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
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public String getFormatLendDate() {
		return DateUtil. getFormatDateTime(lendDate);
	}

	public String getFormatReturnDate() {
		return DateUtil. getFormatDateTime(returnDate);
	}
}
