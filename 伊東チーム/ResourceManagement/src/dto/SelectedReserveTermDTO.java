package dto;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class SelectedReserveTermDTO {
	private LocalDateTime lendDate ;
	private LocalDateTime returnDate ;

	public SelectedReserveTermDTO(){
	}
	public SelectedReserveTermDTO(String lendYM,String lendD,String lendH,String lendM,
			String returnYM,String returnD,String returnH,String returnM){

		lendDate =getLocalDateTimeLendDate(lendYM,lendD,lendH,lendM);
		returnDate =getLocalDateTimeReturnDate(returnYM,returnD,returnH,returnM);
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

	public LocalDateTime getLocalDateTimeLendDate(String yearmonth,String day,String hour,String minute) {
		StringBuilder sbyearmonth = new StringBuilder();
		StringBuilder sbday = new StringBuilder();
		StringBuilder sbminute = new StringBuilder();
		if(yearmonth.length() == 5) {

			sbyearmonth.append(yearmonth);
			sbyearmonth.insert(4, "0");
			yearmonth = sbyearmonth.toString();
			System.out.println(yearmonth);
		}
		if(day.length() == 1) {

			sbday.append(day);
			sbday.insert(1, "0");
			day = sbday.toString();
			System.out.println(day);
		}

		if(minute.length() == 1) {
			sbminute.append(minute);
			sbminute.insert(1, "0");
			minute = sbminute.toString();
			System.out.println(minute);
		}

		String stLendDate = yearmonth
				+day
				+hour
				+minute;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
		 LocalDateTime lendDate = LocalDateTime.parse(stLendDate, dtf);

		return lendDate;
	}

	public LocalDateTime getLocalDateTimeReturnDate(String yearmonth,String day,String hour,String minute) {
		StringBuilder sbyearmonth = new StringBuilder();
		StringBuilder sbday = new StringBuilder();
		StringBuilder sbminute = new StringBuilder();
		if(yearmonth.length() == 5) {

			sbyearmonth.append(yearmonth);
			sbyearmonth.insert(4, "0");
			yearmonth = sbyearmonth.toString();
			System.out.println(yearmonth);
		}
		if(day.length() == 1) {

			sbday.append(day);
			sbday.insert(1, "0");
			day = sbday.toString();
			System.out.println(day);
		}
		if(minute.length() == 1) {
			sbminute.append(minute);
			sbminute.insert(1, "0");
			minute = sbminute.toString();
			System.out.println(minute);
		}



		String stReturnDate = yearmonth
				+day
				+hour
				+minute;
		System.out.println(stReturnDate);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
		 LocalDateTime returnDate = LocalDateTime.parse(stReturnDate, dtf);

		return returnDate;
	}

}
