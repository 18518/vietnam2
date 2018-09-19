package presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MenuCommand implements Command {

	private String nextPage = null;

	public MenuCommand(String nextpage) {
		this.nextPage = nextpage;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return nextPage;
	}

}
