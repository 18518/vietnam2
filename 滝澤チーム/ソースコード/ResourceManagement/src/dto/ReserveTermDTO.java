package dto;

import java.time.LocalDateTime;

public class ReserveTermDTO {
	private LocalDateTime today;
	int year;
	int month;
	int day;
	int hour;
	int minute;

	public ReserveTermDTO() {

	}

	public ReserveTermDTO(LocalDateTime today) {
		this.today = today;
		year = today.getYear();
		month = today.getMonthValue();
		day = today.getDayOfMonth();
		hour = today.getHour();
		minute = today.getMinute();
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

	public LocalDateTime getToday() {
		return today;
	}

}
