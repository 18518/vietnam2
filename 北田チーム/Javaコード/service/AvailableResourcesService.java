package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOFactory;
import dao.ResourceClassDAO;
import domain.ResourceClass;
import dto.ResourceClassDTO;


public class AvailableResourcesService {

	public AvailableResourcesService() {
		
	}
	public ArrayList<ResourceClassDTO> getResourceClass() throws SQLException{
		DAOFactory instance = DAOFactory.getInstance();
		ResourceClassDAO resourceClassDAO = instance.getResourceClassDAO();
		
		ArrayList<ResourceClass> resourceClass = resourceClassDAO.showName();
		
		ArrayList<ResourceClassDTO> resourceClassDTO = new ArrayList<ResourceClassDTO>();
		for(int i = 0; i < resourceClass.size(); i ++) {
			//create
			ResourceClass rc = resourceClass.get(i);
			ResourceClassDTO resourceClassDTO1 = new ResourceClassDTO(rc.getClassId(), rc.getClassName());
			//add
			resourceClassDTO.add(resourceClassDTO1);
			
		}
		return resourceClassDTO;
	}
	
	
	
	
	
}
