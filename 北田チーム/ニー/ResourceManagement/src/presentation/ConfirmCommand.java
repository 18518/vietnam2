package presentation;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Exception.CommandException;


public class ConfirmCommand implements Command {
	private String nextPage = null ;
	
	public ConfirmCommand (String nextPage) {
		this.nextPage = nextPage;
	}
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, SQLException {
		String[] resourceIds = request.getParameterValues("RESOURCES ");
		ReserveService reserveService = new ReserveService();
		ArrayList<String> resourceDTO = new ArrayList<String>();
		reserveService.findName(resourceIds);
		HttpSession session = request.getSession();
		session.setAttribute("RESOURCES ", resourceDTO);//resourceDTO
		return nextPage;
	}
	
	
}
