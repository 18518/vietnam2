package presentation;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Exception.CommandException;
import dto.ResourceDTO;


public class ConfirmCommand implements Command {
	private String nextPage = null ;
	
	public ConfirmCommand (String nextPage) {
		this.nextPage = nextPage;
	}
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, SQLException {
//		String[] resourceIds = request.getParameterValues("RESOURCES");
//		ReserveService reserveService = new ReserveService();
//		reserveService.findName(resourceIds);
//		HttpSession session = request.getSession();
//		session.setAttribute("RESOURCES", resourceDTO);//resourceDTO
		
		//test
		ArrayList<ResourceDTO> resourceDTO = new ArrayList<>();
		ResourceDTO  resource1 = new ResourceDTO(1, "aa");
		ResourceDTO  resource2 = new ResourceDTO(2, "bbb");
		resourceDTO.add(resource1);
		resourceDTO.add(resource2);
		HttpSession session = request.getSession();
		session.setAttribute("RESOURCES", resourceDTO);
		return nextPage;
	}
	
	
}
