package presentation;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.ReserveTermDTO;

public class AvailableResourcesCommand implements Command{
	private String nextPage = null;
	public AvailableResourcesCommand(String nextPage) {
			this.nextPage = nextPage;
	}
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		LocalDateTime ldt = LocalDateTime.now();
		ReserveTermDTO a = new ReserveTermDTO(ldt);

		HttpSession session  = request.getSession(true);
		session.setAttribute("selectedReserveBean","SelectedReserveBean");
		return nextPage;
		}



	}


