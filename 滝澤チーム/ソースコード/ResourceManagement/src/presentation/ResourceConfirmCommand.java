package presentation;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Exception.CommandException;
import dto.ResourceClassDTO;
import dto.ResourceInputDTO;
import service.ResourceConfirmService;

public class ResourceConfirmCommand implements Command{

	private String nextPage;


	public ResourceConfirmCommand(String nextPage) {
		this.nextPage = nextPage;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException,
			SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		String[] resourceName =request.getParameterValues("addResources");
		HttpSession session = request.getSession(true);
		ResourceClassDTO resourceClassDTO = (ResourceClassDTO)session.getAttribute("addResourceClassDTO");
		//String resourceClassName=resourceClassDTO.getClassName();
		int resourceClassId =resourceClassDTO.getClassId();
		ResourceConfirmService resourceConfirmService = new ResourceConfirmService();
		int resourceIdMAX = resourceConfirmService.getResourceIdMAX();
		ArrayList<ResourceInputDTO> resourceInputDTO = new ArrayList<ResourceInputDTO>();

		for(int i=0; i<resourceName.length; i++) {
			if(!resourceName[i].equals("")) {
		resourceInputDTO.add(new ResourceInputDTO(resourceIdMAX+i+1,resourceName[i],String.valueOf(resourceClassId)));
			}
		}


//		if(resourceClassId.equals("other")) {
//			int maxId = resourceConfirmService.getClassIdMAX() + 1;
//			resourceClassId = String.valueOf(maxId);
//		}

		//resourceConfirmService.getResourceIdMAX();


		session.setAttribute("resourceInputDTO", resourceInputDTO);



		//resourceConfirmService.insertResource(resource,resourceClassId);

		return nextPage;
	}



}
