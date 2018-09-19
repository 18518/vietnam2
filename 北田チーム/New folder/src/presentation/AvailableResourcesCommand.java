package presentation;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.ResourceClassDTO;

public class AvailableResourcesCommand implements Command{
	private String nextPage = null;
	public AvailableResourcesCommand(String nextPage) {
			this.nextPage = nextPage;
	}
	public String execute(HttpServletRequest request, HttpServletResponse response) {
//		LocalDateTime ldt = LocalDateTime.now();
//		ReserveTermDTO a = new ReserveTermDTO(ldt);
//
//		HttpSession session  = request.getSession(true);
//		session.setAttribute("selectedReserveBean","SelectedReserveBean");
		ResourceClassDTO resourceClassDTO1 = new ResourceClassDTO(1,"会議室");
		ResourceClassDTO resourceClassDTO2 = new ResourceClassDTO(2,"ブロジェクター");
		ResourceClassDTO resourceClassDTO3 = new ResourceClassDTO(3,"マイク・スピーカーセット");
		ResourceClassDTO resourceClassDTO4 = new ResourceClassDTO(4,"レーザーポインタ");
		ResourceClassDTO resourceClassDTO5 = new ResourceClassDTO(5,"WIFIルータNEC");
		ResourceClassDTO resourceClassDTO6 = new ResourceClassDTO(6,"WIFIルータGLOCALNET");
		ResourceClassDTO resourceClassDTO7 = new ResourceClassDTO(7,"WIFIルータHUAWEI");
		ResourceClassDTO resourceClassDTO8 = new ResourceClassDTO(8,"出張用iPadMiniセット");


		ArrayList<ResourceClassDTO> resourceClassDTOs = new ArrayList<ResourceClassDTO>();
		resourceClassDTOs.add(resourceClassDTO1);
		resourceClassDTOs.add(resourceClassDTO2);
		resourceClassDTOs.add(resourceClassDTO3);
		resourceClassDTOs.add(resourceClassDTO4);
		resourceClassDTOs.add(resourceClassDTO5);
		resourceClassDTOs.add(resourceClassDTO6);
		resourceClassDTOs.add(resourceClassDTO7);
		resourceClassDTOs.add(resourceClassDTO8);
		HttpSession session  = request.getSession(true);
		session.setAttribute("classes",resourceClassDTOs);
		return nextPage;
		}



	}


