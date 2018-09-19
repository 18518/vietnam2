package presentation;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exception.CommandException;
import dto.ResourceClassDTO;
import service.AvailableResourceService;

public class DeleteResourceCommand implements Command {

	String nextPage = null;

	public DeleteResourceCommand(String nextPage) {
		this.nextPage = nextPage;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException,
			SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		AvailableResourceService service=new AvailableResourceService();
		ArrayList<ResourceClassDTO> showName = new ArrayList<ResourceClassDTO>();
		showName=service.getResourceClass();
		request.getSession().setAttribute("deleteClassDTO", showName);

		return nextPage;
	}

}
