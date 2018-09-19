package dto;
import java.time.LocalDateTime;
public class ReserveTermDTO {

	LocalDateTime today;
	int year;
	int month;
	int day;
	int hour;
	int minute;

	public ReserveTermDTO() {

	}

	public ReserveTermDTO(LocalDateTime today){
		this.today = today;
		year = today.getYear();
		month = today.getMonthValue();
		day =today.getDayOfMonth();
		hour = today.getHour();
		minute = today.getMinute();

		if(minute<15) {
			minute = 15;
		}else if(15<=minute && minute <29) {
			minute =30;
		}else if(30 <= minute && minute <44) {
			minute =45;
		}else {
			minute =00;
		}

	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}
}

