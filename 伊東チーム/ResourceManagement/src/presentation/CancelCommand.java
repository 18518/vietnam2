package presentation;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Exception.CommandException;
import dto.ReserveDTO;

public class CancelCommand implements Command {
	private String nextPage = null;

	public CancelCommand() {
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
	throws CommandException, SQLException {

	String[] resourceId = request.getParameterValues("resourceIds");

	HttpSession session = request.getSession(true);

	ReserveDTO reserveDTO =(ReserveDTO)session.getAttribute("reserveDTO");

	int reserveId = reserveDTO.getReserveId();

	//String kara int
	int[] resourceIds = new int[resourceId.length];

	for(int i=0;i<resourceId.length-1;i++) {
	resourceIds[i]=Integer.parseInt(resourceId[i]);
	}

	CancelService cancelService = new CancelService();


	cancelService.delete(reserveId,resourceIds);


	return nextPage;
	}


}