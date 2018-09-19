package presentation;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exception.CommandException;
import dto.ResourceDTO;
import service.DeleteDetailService;

public class DeleteDetailCommand implements Command {

	String nextPage = null;

	public DeleteDetailCommand(String nextPage) {
		this.nextPage = nextPage;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException,
			SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		String[] classIdstr = request.getParameterValues("classId");
		int[] classId = new int[classIdstr.length];
		for (int i = 0; i < classIdstr.length; i++) {
			classId[i] = Integer.parseInt(classIdstr[i]);
		}
		DeleteDetailService service=new DeleteDetailService();
		ArrayList<ResourceDTO> resourceDTO = new ArrayList<ResourceDTO>();
		resourceDTO =service.getResources(classId);

		request.getSession().setAttribute("deleteDetailDTO", resourceDTO);

		return nextPage;
	}

}
