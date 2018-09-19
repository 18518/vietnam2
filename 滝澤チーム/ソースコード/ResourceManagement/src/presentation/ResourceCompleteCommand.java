package presentation;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Exception.CommandException;
import dto.ResourceClassDTO;
import dto.ResourceInputDTO;
import service.ResourceCompleteService;

public class ResourceCompleteCommand implements Command {

	private String nextPage;

	public ResourceCompleteCommand(String nextPage) {
		this.nextPage = nextPage;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException,
			SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		HttpSession session = request.getSession(true);
		ArrayList<ResourceInputDTO> resourceInputDTO = (ArrayList<ResourceInputDTO>)session.getAttribute("resourceInputDTO");
		ResourceClassDTO resourceClassDTO=(ResourceClassDTO)session.getAttribute("addResourceClassDTO");
		ResourceCompleteService resourceCompleteService = new ResourceCompleteService();

		if(!resourceCompleteService.findClass(resourceClassDTO.getClassId())) {
		resourceCompleteService.insertClass(String.valueOf(resourceClassDTO.getClassId()),resourceClassDTO.getClassName());
		}
		for(ResourceInputDTO resourceDTO:resourceInputDTO) {
			System.out.println("resourceDTO.getResourceId():"+resourceDTO.getResourceId());
		resourceCompleteService.insertResource(resourceDTO.getResourceId(),resourceDTO.getResourceName(), resourceDTO.getClassName());
		}
		return nextPage;
	}


}
