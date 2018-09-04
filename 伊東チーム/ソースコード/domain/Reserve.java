
	package domain;

	import java.time.LocalDateTime;

	public class Reserve {
		private static final int DIGIT_ID =8;
		private int reserveId;
		private LocalDateTime lendDate = LocalDateTime.now();
		private LocalDateTime returnDate = LocalDateTime.now();
		private String empld;
		private int  resourceId;



		public Reserve(LocalDateTime lendDate, LocalDateTime returnDate, String empld) {
			super();
			this.lendDate = lendDate;
			this.returnDate = returnDate;
			this.empld = empld;
		}
		public int getDIGIT_ID() {
			return DIGIT_ID;
		}

		public int getReserveId() {
			return reserveId;
		}
		public void setReserveId(int reserveId) {
			this.reserveId = reserveId;
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
		public int getResourceId() {
			return resourceId;
		}
		public void setResourceId(int resourceId) {
			this.resourceId = resourceId;
		}


	}

