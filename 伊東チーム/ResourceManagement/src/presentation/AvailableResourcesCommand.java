package presentation;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Exception.CommandException;
import dto.ClassDTO;
import dto.ReserveTermDTO;
import service.ClassService;

public class AvailableResourcesCommand implements Command {


	private String nextPage = null;


	public AvailableResourcesCommand(String nextPage) {
		this.nextPage = nextPage;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, SQLException {

		//今日の日付取得
		LocalDateTime today = LocalDateTime.now();

		//ReserveTermDTOの生成
		ReserveTermDTO reserveTermDTO = new ReserveTermDTO(today);

		//findNameメソッド

		ClassService classService = new ClassService();

		ArrayList<ClassDTO> classDTOs = classService.showName();


		//セッションの取得
		HttpSession session = request.getSession(true);

		//ReserveTermDTOをセッションの登録
		session.setAttribute("reserveTermDTO", reserveTermDTO);

		//ClassDTOsをセッションに登録

		session.setAttribute("classDTOs",classDTOs);

		return nextPage;
	}

}
