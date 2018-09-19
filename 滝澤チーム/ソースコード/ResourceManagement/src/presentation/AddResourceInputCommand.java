package presentation;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exception.CommandException;
import dto.ResourceClassDTO;
import service.AddResourceInputService;

public class AddResourceInputCommand implements Command {

	private String nextPage = null;

	public AddResourceInputCommand(String nextPage) {//=set ter
		this.nextPage = nextPage;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException,
			SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		String resourceClassId = request.getParameter("class");
		AddResourceInputService service = new AddResourceInputService();
		ResourceClassDTO dto = service.getClassName(Integer.parseInt(resourceClassId));
		request.getSession().setAttribute("inputResourceClassDTO", dto);

		return nextPage;
	}

}
