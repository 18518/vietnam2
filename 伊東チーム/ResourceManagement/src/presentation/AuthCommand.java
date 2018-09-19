package presentation;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exception.CommandException;
import dto.EmployeeDTO;
import service.AuthService;

public class AuthCommand implements Command{
	private String nextPage = null;
	private static int DIGIT_USER_ID = 5;
	private static int DIGIT_MIN_USER_PASSWD=5;
	private static int DIGIT_USER_PASSWD = 7;


	public AuthCommand(String nextPage) {
		this.nextPage=nextPage;
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, SQLException {
		//service以降のコードを描く
		String empId = "";
		String password= "";
		empId = request.getParameter("EMPID");
		if (isRgihtId(empId)) {
				throw new CommandException("IDの桁数が違います");
		}
		password = request.getParameter("PASSWD");

		if (isRgihtPassword(password)) {
			throw new CommandException("パスワードの桁数が違います");
		}

		AuthService authservice = new AuthService();

		EmployeeDTO employeeDTO = authservice.authenticate(empId, password);

		if (employeeDTO != null) {
			request.getSession().setAttribute("employee",employeeDTO);
		}else {
			throw new CommandException("パスワードが異なります");
		}

		return nextPage;
	}


	private boolean isRgihtId(String empId) {
		if (empId.length() == DIGIT_USER_ID) {
			return false;
		}

		return true;
	}

	private boolean isRgihtPassword(String password) {
		if ((password.length() <= DIGIT_USER_PASSWD) && (password.length() >= DIGIT_MIN_USER_PASSWD)) {
			return false;
		}
		return true;
	}


}
