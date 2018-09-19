
	package dto;
	import java.time.LocalDateTime;
	public class ReserveTermDTO {
		private LocalDateTime today ;
		ReserveTermDTO(){

		}
		ReserveTermDTO(LocalDateTime today) {
		this.today = today;
		}
		public LocalDateTime getToday() {
			return today;
		}
	}

