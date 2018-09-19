package presentation;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exception.CommandException;
import dto.ResourceDTO;
import service.DeleteConfirmService;

public class DeleteConfirmCommand implements Command {

	String nextPage;

	public DeleteConfirmCommand(String nextPage) {
		this.nextPage = nextPage;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException,
			SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		String[] resourceId = request.getParameterValues("Resource");
		int[] resourceIds = new int[resourceId.length];
		for (int i = 0; i < resourceIds.length; i++) {
			resourceIds[i] = Integer.parseInt(resourceId[i]);
		}

		ArrayList<ResourceDTO> resourceDTO = new ArrayList<ResourceDTO>();
		DeleteConfirmService service = new DeleteConfirmService();
		resourceDTO = service.findName(resourceIds);
		request.getSession().setAttribute("deleteConfirmDTO", resourceDTO);

		return nextPage;
	}

}
