package presentation;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Exception.CommandException;
import dto.EmployeeDTO;
import dto.ResourceDTO;
import dto.SelectedReserveTermDTO;
import service.ReserveService;

public class CompleteCommand implements Command {

	private String nextPage = null;

	//コンストラクタ
	public CompleteCommand(String nextPage) {
		this.nextPage = nextPage;
	}

	//executeメソッドをoverrideする
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, SQLException {

		// getSessionメソッド（セッションを取得する）
		HttpSession session = request.getSession(true);

		//getAttributeメソッド（セッションに保存してあるSelectedReserveDTOを取得する）
		SelectedReserveTermDTO selectedReserveDTO = (SelectedReserveTermDTO)session.getAttribute("selectedReserveDTO");

		//getAttributeメソッド（セッションに保存してあるResourceDTOを取得する）
		ResourceDTO resourceDTO = (ResourceDTO)session.getAttribute("resourceDTO");

		//getAttributeメソッド（セッションに保存してあるEmployeeDTOを取得する）
		EmployeeDTO employeeDTO = (EmployeeDTO)session.getAttribute("employeeDTO");

		//ReserveServiceを生成する
		ReserveService reserveService = new ReserveService();

		//reserveメソッドを実行しreserveIdを取得
		String reserveId  = reserveService.reserve(selectedReserveDTO,resourceDTO,employeeDTO);

		//reserveIdをセッションに登録する
		session.setAttribute("reserveId", reserveId);

		return nextPage;
	}

}
