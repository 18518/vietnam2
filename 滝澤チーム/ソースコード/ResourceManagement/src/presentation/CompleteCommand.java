package presentation;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Exception.CommandException;
import dto.EmployeeDTO;
import dto.ResourceDTO;
import dto.SelectedReserveTermDTO;
import service.CompleteService;


public class CompleteCommand implements Command{
	String nextPage = null;

	public CompleteCommand(String nextPage) {
		super();
		this.nextPage = nextPage;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		HttpSession session = request.getSession(true);
		SelectedReserveTermDTO selectedReserveTermDTO=(SelectedReserveTermDTO) session.getAttribute("selectedReserveTermDTO");
		ArrayList<ResourceDTO> resourceDTOs = (ArrayList<ResourceDTO>) session.getAttribute("resourceDTO");
		EmployeeDTO employeeDTO = (EmployeeDTO) session.getAttribute("employeeDTO");

		CompleteService completeService = new CompleteService();

		int reserveId=completeService.reserve(selectedReserveTermDTO, resourceDTOs, employeeDTO);

		session.setAttribute("reserveId", reserveId);


		return nextPage;
	}




}
