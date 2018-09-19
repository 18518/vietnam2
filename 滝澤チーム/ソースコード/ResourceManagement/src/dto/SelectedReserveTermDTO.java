package dto;

import java.time.LocalDateTime;

public class SelectedReserveTermDTO {
	LocalDateTime lendDate;
	LocalDateTime returnDate;
	public SelectedReserveTermDTO() {
		super();
	}
	public SelectedReserveTermDTO(LocalDateTime lendDate, LocalDateTime returnDate) {
		super();
		this.lendDate = lendDate;
		this.returnDate = returnDate;
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
	
}
