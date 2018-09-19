package presentation;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Exception.CommandException;
import dto.ResourceDTO;
import dto.SelectedReserveTermDTO;
import service.ReserveService;
import utils.DateUtil;

class ReserveCommand implements Command {
	String nextPage = null;

	public ReserveCommand(String nextPage) {
		this.nextPage = nextPage;
	}

	public String execute(HttpServletRequest request, HttpServletResponse response)

			throws CommandException, SQLException, IllegalAccessException {
		String lendDateYearMonths = request.getParameter("LendDateYearMonth");
		String lendDateDays = request.getParameter("LendDateDay");
		String lendDateHours = request.getParameter("LendDateHour");
		String lendDateMinutes = request.getParameter("LendDateMinute");
		String returnDateYearMonths = request.getParameter("ReturnDateYearMonth");
		String returnDateDays = request.getParameter("ReturnDateDay");
		String returnDateHours = request.getParameter("ReturnDateHour");
		String returnDateMinutes = request.getParameter("ReturnDateMinute");
		String[] classIdstr = request.getParameterValues("classId");
		int[] classId = new int[classIdstr.length];
		for (int i = 0; i < classIdstr.length; i++) {
			classId[i] = Integer.parseInt(classIdstr[i]);
		}

		String lendDateYearMonth = null;
		String lendDateDay = null;
		String lendDateHour = null;
		String lendDateMinute = null;
		String returnDateYearMonth = null;
		String returnDateDay = null;
		String returnDateHour = null;
		String returnDateMinute = null;
		if (lendDateYearMonths.length() == 5) {
			lendDateYearMonth = lendDateYearMonths.substring(0, 4) + "0" + lendDateYearMonths.charAt(4);
		} else {
			lendDateYearMonth = lendDateYearMonths;
		}
		if (lendDateDays.length() == 1) {
			lendDateDay = "0" + lendDateDays;
		} else {
			lendDateDay = lendDateDays;
		}
		if (lendDateHours.length() == 1) {
			lendDateHour = "0" + lendDateHours;
		} else {
			lendDateHour = lendDateHours;
		}
		if (lendDateMinutes.length() == 1) {
			lendDateMinute = "0" + lendDateMinutes;
		} else {
			lendDateMinute = lendDateMinutes;
		}
		if (returnDateYearMonths.length() == 5) {
			returnDateYearMonth = returnDateYearMonths.substring(0, 4) + "0" + returnDateYearMonths.charAt(4);
		} else {
			returnDateYearMonth = returnDateYearMonths;
		}
		if (returnDateDays.length() == 1) {
			returnDateDay = "0" + returnDateDays;
		} else {
			returnDateDay = returnDateDays;
		}
		if (returnDateHours.length() == 1) {
			returnDateHour = "0" + returnDateHours;
		} else {
			returnDateHour = returnDateHours;
		}
		if (returnDateMinutes.length() == 1) {
			returnDateMinute = "0" + returnDateMinutes;
		} else {
			returnDateMinute = returnDateMinutes;
		}
		System.out.println(returnDateYearMonths);
		System.out.println(returnDateYearMonth);

		try {

			String lendDateYear = lendDateYearMonth.substring(0, 4);

			String lendDateMonth = lendDateYearMonth.substring(4, 6);

			String returnDateYear = returnDateYearMonth.substring(0, 4);

			String returnDateMonth = returnDateYearMonth.substring(4, 6);

			LocalDateTime lendDate = LocalDateTime.parse(
					lendDateYear + "-" + lendDateMonth + "-" + lendDateDay + "T" + lendDateHour + ":" + lendDateMinute);

			LocalDateTime returnDate = LocalDateTime.parse(returnDateYear + "-" + returnDateMonth + "-" + returnDateDay
					+ "T" + returnDateHour + ":" + returnDateMinute);

			SelectedReserveTermDTO selectedReserveTermDTO = new SelectedReserveTermDTO(lendDate, returnDate);
			HttpSession session = request.getSession(true);
			session.setAttribute("selectedReserveTermDTO", selectedReserveTermDTO);

			String lendDateStr = DateUtil.getFormatDateTime(lendDate);
			String returnDateStr = DateUtil.getFormatDateTime(returnDate);
			if(lendDate.isAfter(returnDate)) {
				throw new IllegalAccessException("日付が不正です。");
			}
			session.setAttribute("lendDateStr", lendDateStr);
			session.setAttribute("returnDateStr", returnDateStr);

			ReserveService reserveService = new ReserveService();

			ArrayList<ResourceDTO> resourceDTO = new ArrayList<ResourceDTO>();

			resourceDTO = reserveService.getResources(lendDate, returnDate, classId);

			session.setAttribute("reserveServiceDTO", resourceDTO);

		} catch (DateTimeParseException e) {
			throw new CommandException("日付が不正です。");
		}
		return nextPage;
	}
}
