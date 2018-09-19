package presentation;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Exception.CommandException;
import dto.ResourceClassDTO;
import service.ResourceInputService;

public class ResourceInputCommand implements Command{

	private String nextPage;

	public ResourceInputCommand(String nextPage) {
		this.nextPage = nextPage;
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException,
	SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		//String[] resourceName =request.getParameterValues("addResources");
		String resourceClassId =request.getParameter("class");

		String resourceClassName;
		ResourceInputService resourceInputService = new ResourceInputService();

		System.out.println(resourceClassId);
		if(resourceClassId.equals("other")){
			System.out.println(resourceInputService.getClassIdMAX());
			resourceClassId=String.valueOf(resourceInputService.getClassIdMAX()+1);
			resourceClassName = request.getParameter("className");
			System.out.println(resourceClassName);
			//resourceInputService.insertClass(resourceClassId, resourceClassName);
		}
		else {
			int[] resourceClassIds= {Integer.parseInt(resourceClassId)};
			resourceClassName=resourceInputService.findName(resourceClassIds).get(0).getClassName();
		}

		//resourceConfirmService.getResourceIdMAX();

		ResourceClassDTO addResourceClassDTO = new ResourceClassDTO(Integer.parseInt(resourceClassId),resourceClassName);

		HttpSession session = request.getSession(true);
		session.setAttribute("addResourceClassDTO", addResourceClassDTO);
		System.out.println(addResourceClassDTO.getClassName());


		//resourceConfirmService.insertResource(resource,resourceClassId);


		return nextPage;
	}

}
