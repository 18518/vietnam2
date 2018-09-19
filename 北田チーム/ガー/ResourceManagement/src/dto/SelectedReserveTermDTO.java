package dto;

import java.time.LocalDateTime;

public class SelectedReserveTermDTO {
	private LocalDateTime lendDate;
	private LocalDateTime returnDate;
	
	public SelectedReserveTermDTO(LocalDateTime lendDate, LocalDateTime returnDate) {
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
	public void setReturntDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}

}
