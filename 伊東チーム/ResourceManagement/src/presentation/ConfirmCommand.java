package presentation;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Exception.CommandException;
import dto.ResourceDTO;
import service.ReserveService;

public class ConfirmCommand implements Command {

	private String nextPage = null;

	public ConfirmCommand(String nextPage) {

		this.nextPage = nextPage;

	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, SQLException {
		// getParametervaluesメソッド
		String[] resources = request.getParameterValues("RESOURCES");

		//ReserveServiceを生成
		ReserveService reserveService = new ReserveService();


		//findNameメソッド

		ArrayList<ResourceDTO> resourceDTO = reserveService.findName(resources);


		//セッションを取得する　getSessionメソッド
		HttpSession session = request.getSession(true);

		//setAttributeメソッド
		session.setAttribute("resourceDTO", resourceDTO);

		if(nextPage != null) {
			return nextPage;
		}else {
			throw new CommandException("nextPage=null");
		}

	}

}
