package dto;
import java.time.LocalDateTime;
public class SelectedReserveDTO {
	private LocalDateTime lendDate ;
	private LocalDateTime returnDate ;
	SelectedReserveDTO(){
	}
	SelectedReserveDTO(LocalDateTime lendDate, LocalDateTime returnDate){
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
