package presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.EmployeeDTO;
import dto.ResourceDTO;
import dto.SelectedReserveTermDTO;

public class CompleteCommand implements Command{
	private String nextPage = null;

	public CompleteCommand(String nextPage) {
		this.nextPage = nextPage;
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session  = request.getSession(true);
		SelectedReserveTermDTO selectedReserveTermDTO = (SelectedReserveTermDTO) session.getAttribute("SelectedReserveTermDTO");
		ResourceDTO resourceDTO = (ResourceDTO) session.getAttribute("ResourceDTO");
		EmployeeDTO employeeDTO = (EmployeeDTO) session.getAttribute("EmployeeDTO");
		ReserveService a = new ReserveService();
		int reserveId = a.reserve(selectedReserveTermDTO,resourceDTO,employeeDTO);
		session.setAttribute("reserveId",reserveId);

		return nextPage ;

		;
	}
}
