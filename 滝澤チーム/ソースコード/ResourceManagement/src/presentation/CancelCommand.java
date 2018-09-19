package presentation;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Exception.CommandException;
import dto.ReserveDTO;
import service.CancelService;

public class CancelCommand implements Command {
	private String nextPage = null;

	public CancelCommand(String nextPage) {
		super();
		this.nextPage = nextPage;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException,
			SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
			String[] strResourceIds =request.getParameterValues("resource");
			int[] resourceIds = new int[strResourceIds.length];
			for(int i = 0 ; i<strResourceIds.length; i++) {
				resourceIds[i] = Integer.parseInt(strResourceIds[i]);
			}



			HttpSession session = request.getSession(true);
			ArrayList<ReserveDTO> reserveDTO=new ArrayList<ReserveDTO>();
			reserveDTO =(ArrayList<ReserveDTO>)session.getAttribute("reserveCancelDTO");
			int reserveId =reserveDTO.get(0).getReserveId();
			System.out.println("reserveId:"+reserveId);
			CancelService cancelService = new CancelService();
			cancelService.delete(reserveId, resourceIds);
		return nextPage;
	}

}
