package presentation;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exception.CommandException;

public class ErrorCommand implements Command {
	String nextPage;

	public ErrorCommand(String nextPage) {
		this.nextPage =nextPage;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, SQLException {
		return "/error.jsp";
	}

}
