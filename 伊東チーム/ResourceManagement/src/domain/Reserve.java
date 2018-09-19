
	package domain;

	import java.time.LocalDateTime;

	public class Reserve {
		private static final int DIGIT_ID =8;
		private int reserveId;
		private LocalDateTime lendDate = LocalDateTime.now();
		private LocalDateTime returnDate = LocalDateTime.now();
		private String empId;
		private int  resourceId;



		public Reserve(int reserveId, LocalDateTime lendDate, LocalDateTime returnDate, String empId, int resourceId) {
			super();
			this.reserveId = reserveId;
			this.lendDate = lendDate;
			this.returnDate = returnDate;
			this.empId = empId;
			this.resourceId = resourceId;
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










	}

