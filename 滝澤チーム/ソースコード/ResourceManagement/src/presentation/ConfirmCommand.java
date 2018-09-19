package presentation;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Exception.CommandException;
import dto.ResourceDTO;
import service.ComfirmService;

public class ConfirmCommand implements Command {
	String nextPage;

	public ConfirmCommand(String nextPage) {
		super();
		this.nextPage = nextPage;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, SQLException {

		String[] resourceId=request.getParameterValues("lendResource");
		int[] resourceIds=new int[resourceId.length];
		for(int i=0; i<resourceIds.length; i++) {
			resourceIds[i]=Integer.parseInt(resourceId[i]);
		}

		ArrayList<ResourceDTO> resourceDTO= new ArrayList<ResourceDTO>();
		ComfirmService comfirmService = new ComfirmService();
		resourceDTO=comfirmService.findName(resourceIds);
		HttpSession session =request.getSession(true);

		for(ResourceDTO dto:resourceDTO) {
			System.out.println(dto.getResourceId());
			System.out.println(dto.getResourceName());
		}
		session.setAttribute("resourceDTO", resourceDTO);

		return nextPage;
	}

}
