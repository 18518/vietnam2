package presentation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Exception.CommandException;
import dto.EmployeeDTO;
import dto.ReserveDTO;
import service.CancelService;

public class ReferDetailCommand implements Command {

	private static final int DIGIT_RESERVE_ID =8;

	private String nextPage = null;

	public ReferDetailCommand(String nextPage) {
		this.nextPage = nextPage;

	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, SQLException {

		// リクエストからパラメータ（reserveId）を取得する
		String reserveid;
		reserveid =request.getParameter("reserveId");

		//入力されたreserveIdが数字の8ｹﾀか判断する
		if(!isRightReserveId(reserveid)) {
			throw new CommandException("予約番号が正しくありません。");
		}

		//reserveIdをStringからintへ変換
		int reserveId = Integer.parseInt(reserveid);

		//セッションを取得する
		HttpSession session = request.getSession(true);

		//セッションからパラメータ（EmployeeDTOを取得する）
		EmployeeDTO employeeDTO = (EmployeeDTO)session.getAttribute("employee");

		//社員IDを取得する
		String empId = employeeDTO.getEmpId();

		//サービスを生成する
		CancelService cancelService = new CancelService();

		//予約番号と社員番号から該当の予約を探す
		ArrayList<ReserveDTO> reserveDTO = cancelService.find(reserveId,empId);

		//セッションにreserveDTOを登録する
		session.setAttribute("reserveDTO", reserveDTO);

		return nextPage;
	}


	public boolean isRightReserveId(String reserveId){

		//数字チェック
		boolean flg = Pattern.matches("^[0-9]*$", reserveId);

		//桁数チェック
		if(reserveId.length() == DIGIT_RESERVE_ID) {
			return flg;
		}else {
			flg = false;
			return flg;
		}



	}


}
