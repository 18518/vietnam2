package presentation;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Exception.CommandException;
import dto.ResourceDTO;

public class ReserveCommand implements Command{
	private String nextPage = null ;
	public ReserveCommand (String nextPage) {
		this.nextPage = nextPage;
	}
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, SQLException {
//		String[] reserveIds = request.getParameterValues("AvailableResourceDTO");
//		String lendDate=request.getParameter("");
//		String returnDate=request.getParameter("");
//		String classId =request.getParameter("");
//		//SelectedReserveTermDTO ssd = new SelectedReserveTermDTO(lendDate, returnDate);
//		HttpSession session = request.getSession(true);

		//AvailableResourcesService ars = new AvailableResourcesService();
//		ars.getResources(lendDate, returnDate, classId);
//		ArrayList<String> AvailableResoursDTO = new ArrayList<String>();
//		session.setAttribute("AvailableResourceDTO", "availableResourceResourceDTO");

		ArrayList<ResourceDTO> resoursDTOs = new ArrayList<ResourceDTO>();

		ResourceDTO resource1 = new ResourceDTO(1, "AAA");
		ResourceDTO resource2 = new ResourceDTO(2, "BBB");

		resoursDTOs.add(resource1);
		resoursDTOs.add(resource2);

		HttpSession session = request.getSession(true);
		session.setAttribute("resources",resoursDTOs);
		return nextPage;

	}

}
