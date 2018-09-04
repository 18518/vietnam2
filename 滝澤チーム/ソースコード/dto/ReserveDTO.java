package domain;

import java.time.LocalDateTime;

public class ReserveDTO {
	int reserve;
	String empld;
	String empName;
	LocalDateTime lendDate;
	LocalDateTime returnDate;
	public ReserveDTO() {
	}
	public int getReserve() {
		return reserve;
	}
	public void setReserve(int reserve) {
		this.reserve = reserve;
	}
	public String getEmpld() {
		return empld;
	}
	public void setEmpld(String empld) {
		this.empld = empld;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public LocalDateTime getLendDate() {
		return lendDate;
	}
	public void setLendDate(LocalDateTime lendDate) {
		this.lendDate = lendDate;
	}
	public LocalDateTime getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}
	public ReserveDTO(LocalDateTime lendDate,LocalDateTime returnDate) {
		this.lendDate=lendDate;
		this.returnDate=returnDate;

	}
}
