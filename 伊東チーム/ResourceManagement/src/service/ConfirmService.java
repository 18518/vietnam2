package service;

import java.util.ArrayList;

import dao.DAOFactory;
import dao.ResourceDAO;
import domain.Resource;
import dto.ResourceDTO;

public class ConfirmService {
	public ConfirmService() {

	}
	public ArrayList<ResourceDTO> findName(String[] resources){
		DAOFactory daofactory = DAOFactory.getInstance();
		ResourceDAO resourceDAO = daofactory.getResourceDAO();
		ArrayList<Resource> resourceList =resourceDAO.findName(resources);
		ArrayList<ResourceDTO> resourceDTO=new ArrayList<ResourceDTO>();
		for(int i=0 ; resourceList.size()<i ; i++) {
			resourceDTO.add(new ResourceDTO(resourceList.get(i).getResourceld(),resourceList.get(i).getResourceName()));
		}

	}
}
