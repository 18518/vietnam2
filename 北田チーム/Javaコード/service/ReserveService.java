package service;

import java.util.ArrayList;

import dao.DAOFactory;
import dao.ReserveDAO;
import dao.ResourceClassDAO;
import domain.Resource;
import dto.ResourceDTO;





public class ReserveService {
	public ReserveService() {

	}
	public int reserve(AvailableResourcesService availableResourcesService , DAOFactory daoFactory, ResourceClassDAO resourceClassDAO, ReserveDAO reserveDAO ) {
		return  0;
	}
	public int createReserveId() {
		return 0;
	}


	public ArrayList<ResourceDTO> findName(int resourceIds){
		DAOFactory daofactory = DAOFactory.getInstance();
		ReserveDAO reserveDAO = daofactory.getReserveDAO();
		ArrayList<Resource> reserveList =reserveDAO.searchName(resourceId, resourceName);
		ArrayList<ResourceDTO> resourceDTO=new ArrayList<ResourceDTO>();
		for(int i=0 ; resourceList.size()<i ; i++) {
			resourceDTO.add(new ResourceDTO(resourceList.get(i).getResourceId(),resourceList.get(i).getresourceName()));
		}


	return resourceDTO ;


	}

}
