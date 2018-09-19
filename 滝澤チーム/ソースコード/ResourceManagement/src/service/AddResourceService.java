package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOFactory;
import dao.ResourceClassDAO;
import domain.ResourceClass;
import dto.ResourceClassDTO;

public class AddResourceService {

	public ArrayList<ResourceClassDTO> getResourceClasses() throws SQLException{

		DAOFactory daoFactory=DAOFactory.getInstance();
		ResourceClassDAO classDAO=daoFactory.getClassDAO();

		ArrayList<ResourceClass> showName = new ArrayList<ResourceClass>();
		showName = classDAO.showName();
		ArrayList<ResourceClassDTO> resourceClassDTO =new ArrayList<ResourceClassDTO>();
		for( int i = 0 ;i<showName.size();i++) {
			int tmp = showName.get(i).getClassId();
			String tmh = showName.get(i).getClassName();
			resourceClassDTO.add(new ResourceClassDTO(tmp,tmh));
		}

		return resourceClassDTO;
	}

}
