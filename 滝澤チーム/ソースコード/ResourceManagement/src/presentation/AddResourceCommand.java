package presentation;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exception.CommandException;
import dto.ResourceClassDTO;
import service.AddResourceService;
import service.DeleteCompleteService;

public class AddResourceCommand implements Command {

	private String nextPage = null;

	public AddResourceCommand(String nextPage) {//=set ter
		this.nextPage = nextPage;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException,
			SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		AddResourceService service = new AddResourceService();
		ArrayList<ResourceClassDTO> resourceClassDTO = new ArrayList<ResourceClassDTO>();
		DeleteCompleteService deleteService = new DeleteCompleteService();
		deleteService.deleteResourceClass();
		resourceClassDTO = service.getResourceClasses();
		request.getSession(true).setAttribute("resourceAddDTO", resourceClassDTO);



		return nextPage;
	}

}
