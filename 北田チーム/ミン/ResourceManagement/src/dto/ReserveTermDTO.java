package dto;

import java.time.LocalDateTime;

public class ReserveTermDTO {
	private LocalDateTime today;
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public void setToday(LocalDateTime today) {
		this.today = today;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public ReserveTermDTO() {

	}

	

	public ReserveTermDTO(LocalDateTime today) {
		this.today = today;
		this.year = today.getYear();
		this.month = today.getMonthValue();
		this.day = today.getDayOfMonth();
		this.hour = today.getHour();
		this.minute = today.getMinute();
	}

	public LocalDateTime getToday() {
		return today;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

}
