package presentation;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Exception.CommandException;
import dto.EmployeeDTO;
import dto.ReserveDTO;
import dto.ResourceDTO;
import service.ReferDetailService;

public class ReferDetailCommand implements Command{
	private static int DIGIT_RESERVE_ID = 8;
	private String nextPage;
	public ReferDetailCommand(String nextPage) {
		this.nextPage=nextPage;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException,
			SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		int reserveId= Integer.parseInt(request.getParameter("reserveId"));
		isRightReserveId(reserveId);
		HttpSession session = request.getSession(true);

		EmployeeDTO employeeDTO = (EmployeeDTO) session.getAttribute("employeeDTO");
		String empId = employeeDTO.getEmpId();
		ReferDetailService referDetailService = new ReferDetailService();
		ArrayList<ReserveDTO> reserveDTO = new ArrayList<ReserveDTO>();
		reserveDTO =referDetailService.find(reserveId,empId);
		ArrayList<ResourceDTO> resourceDTO = new ArrayList<ResourceDTO>();
		int[] resourceIds = new int[reserveDTO.size()];
		for(int i=0; i<reserveDTO.size(); i++) {
			resourceIds[i]=reserveDTO.get(i).getResourceId();
		//	System.out.println("resourceId:"+reserveDTO.get(i).getResourceId());
		}
		resourceDTO =  referDetailService.findName(resourceIds);
		for(ResourceDTO dto:resourceDTO) {
			System.out.println(dto.getResourceId());
			System.out.println(dto.getResourceName());
		}

		session.setAttribute("reserveCancelDTO", reserveDTO);
		session.setAttribute("resourceDTO", resourceDTO);

		return nextPage;
	}
	public  boolean isRightReserveId(int reserveId) {
		if(String.valueOf(reserveId).length() == DIGIT_RESERVE_ID) {
			return true;
		}else {
			return false;
		}

	}





}
