package presentation;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.ReserveTermDTO;
import dto.ResourceClassDTO;
import service.AvailableResourceService;


public class AvailableResourcesCommand  implements Command {
	String nextPage = null;

	public AvailableResourcesCommand(String nextPage) {
		this.nextPage = nextPage;
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		LocalDateTime toDay = LocalDateTime.now();
		ReserveTermDTO rt = new ReserveTermDTO(toDay);
		HttpSession session = request.getSession(true);
		session.setAttribute("reserveTerm", rt);
		AvailableResourceService availableResourceService = new AvailableResourceService();

		ArrayList<ResourceClassDTO> resourceClassDTO = new ArrayList<ResourceClassDTO>();
		resourceClassDTO=availableResourceService.getResourceClass();
		session.setAttribute("resourceClassDTO", resourceClassDTO);

		for(ResourceClassDTO dto:resourceClassDTO) {
			System.out.println(dto.getClassId());
			System.out.println(dto.getClassName());
		}

		return nextPage;
	}



}


