package presentation;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exception.CommandException;

public class MenuCommand implements Command{
	private String nextPage = null ;

	public MenuCommand(String nextPage) {
		this.nextPage = nextPage;
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, SQLException {
		/**/
		return nextPage;
	}
}
