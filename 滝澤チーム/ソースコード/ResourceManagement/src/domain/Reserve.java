package domain;

import java.time.LocalDateTime;
import java.util.Random;

import dto.SelectedReserveTermDTO;

public class Reserve {
	Random randomid;
	int DIGIT_ID = 8;
	int reserveId;
	LocalDateTime lendDate;
	LocalDateTime returnDate;
	String empld;
	int resourceId;

	public Reserve() {

	}
	public Reserve(LocalDateTime lendDate,LocalDateTime returnDate,String empld) {
		this.lendDate = lendDate;
		this.returnDate=returnDate;
		this.empld=empld;
	}

	public Reserve(int reserveId,LocalDateTime lendDate,LocalDateTime returnDate,String empld,int resourceId) {
		this.reserveId = reserveId;
		this.lendDate = lendDate;
		this.returnDate=returnDate;
		this.empld=empld;
		this.resourceId=resourceId;
	}

	public int getReserveId() {
		return reserveId;
	}
	public void setReserveId(int reserveId) {
		this.reserveId = reserveId;
	}
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceld(int resourceld) {
		this.resourceId = resourceld;
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
	public SelectedReserveTermDTO getReserve() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}


}
