package presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogOffCommand implements Command {

	private String nextPage = null;


	public LogOffCommand(String nextpage) {
		this.nextPage = nextpage;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		request.getSession(true).invalidate();
		return "/login.jsp";
	}


}