package domain;

import java.time.LocalDateTime;
import java.util.Random;

public class Reserve {
	Random randomid;
	int DIGIT_ID = 8;
	int reserved;
	LocalDateTime lendDate;
	LocalDateTime returnDate;
	String empld;
	int resourceld;

	public Reserve() {

	}
	public Reserve(LocalDateTime lendDate,LocalDateTime returnDate,String empld) {
		this.lendDate = lendDate;
		this.returnDate=returnDate;
		this.empld=empld;
	}
	public int getReserved() {
		return reserved;
	}
	public void setReserved(int reserved) {
		this.reserved = reserved;
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
	public String getEmpld() {
		return empld;
	}
	public void setEmpld(String empld) {
		this.empld = empld;
	}


}
