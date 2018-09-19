package presentation;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Exception.CommandException;
import dto.ResourceDTO;
import service.DeleteCompleteService;

public class DeleteCompleteCommand implements Command {

	String nextPage;

	public DeleteCompleteCommand(String nextPage) {
		this.nextPage = nextPage;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException,
			SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		HttpSession session = request.getSession(true);
		ArrayList<ResourceDTO> dto = (ArrayList<ResourceDTO>) session.getAttribute("deleteConfirmDTO");
		DeleteCompleteService service = new DeleteCompleteService();

		service.deleteResource(dto);
		service.deleteResourceClass();

		return nextPage;
	}

}
