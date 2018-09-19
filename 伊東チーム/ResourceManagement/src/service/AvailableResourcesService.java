package service;

import java.util.ArrayList;

import dao.DAOFactory;
import domain.ResourceClass;
import dto.ResourceClassDTO;

public class AvailableResourcesService {
	public AvailableResourcesService() {

	}
	public ArrayList<ResourceClassDTO> getResourcesClass(){
		ArrayList<ResourceClass> classList=new ArrayList<ResourceClass>();
		ArrayList<ResourceClassDTO> classDTOList=new ArrayList<ResourceClassDTO>();

		DAOFactory daofactory = DAOFactory.getInstance();
		ResourceClassDAO resourceClassDAO = daofactory.getResourceClassDAO();
		classList =resourceClassDAO.showname();
		for(ResourceClass resourceClass: classList) {
			classDTOList.add(new ResourceClassDTO(resourceClass.getClassId(),resourceClass.getClassName()));
		}
		return classDTOList;
	}
}

