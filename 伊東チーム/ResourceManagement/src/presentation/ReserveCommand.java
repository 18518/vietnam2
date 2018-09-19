package presentation;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Exception.CommandException;
import dto.ResourceDTO;
import dto.SelectedReserveTermDTO;
import service.AvailableResourcesService;

public class ReserveCommand implements Command {

	String nextPage = null;

	public ReserveCommand(String nextPage) {
		this.nextPage = nextPage;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, SQLException {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
		//貸出日時取得と変換
		String stLendDate =  request.getParameter("LEND_YEAR_MONTH")
							+request.getParameter("LEND_DAY")
							+request.getParameter("LEND_HOUR")
							+request.getParameter("LEND_MINUTE");


	        LocalDateTime lendDate = LocalDateTime.parse(stLendDate, dtf);

		//返却日時取得
		String stReturnDate =  request.getParameter("RETURN_YEAR_MONTH")
				+request.getParameter("RETURN_DAY")
				+request.getParameter("RETURN_HOUR")
				+request.getParameter("RETURN_MINUTE");

	        LocalDateTime returnDate = LocalDateTime.parse(stReturnDate, dtf);

		//リソース種別取得
		String[] classId =request.getParameterValues("classId");

		//String[]からint[]へ変換

		int[] classIds = new int[classId.length];

		for(int i =0;i<classIds.length-1;i++) {
			classIds[i] = Integer.parseInt(classId[i]);
		}

		SelectedReserveTermDTO selectedReserveTermDTO = new SelectedReserveTermDTO(lendDate,returnDate);

		//セッションの取得
		HttpSession session = request.getSession(true);

		//SelectedReserveTermDTOをセッションに登録
		session.setAttribute("selecetReserveTermDTO", selectedReserveTermDTO);

		//AvailableResourcesServiceの生成
		AvailableResourcesService availableResourcesService = new AvailableResourcesService();

		//getResourcesメソッドで空いているリソースのリストを取得
		ArrayList<ResourceDTO> resources = availableResourcesService.getResources(lendDate,returnDate,classIds);

		//セッションに空いているリソースのリストを登録
		session.setAttribute("AvailableResourceDTO", resources);

		return nextPage;
	}

}
