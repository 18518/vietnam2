package presentation;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exception.CommandException;

public class ReferCommand implements Command{


	private String nextPage=null;

	public ReferCommand(String nextPage) {
		this.nextPage=nextPage;
	}


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException,
			SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		return nextPage;
	}

}
