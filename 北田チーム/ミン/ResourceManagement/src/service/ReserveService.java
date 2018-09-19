package service;

import java.util.ArrayList;

import dao.DAOFactory;
import dao.ResourceDAO;
import domain.Resource;
import dto.EmployeeDTO;
import dto.ResourceDTO;
import dto.SelectedReserveTermDTO;

public class ReserveService {
	public ReserveService() {

	}
	public int reserve(SelectedReserveTermDTO selectedReserveTermDTO, ResourceDTO resourceDTO, EmployeeDTO employeeDTO) {
		return  0;
	}
	public int createReserveId() {
		return 0;
	}


	public ArrayList<ResourceDTO> findName(int resourceIds){
		DAOFactory daofactory = DAOFactory.getInstance();
		ResourceDAO resourceDAO = daofactory.getResourceDAO();
		ArrayList<Resource> resourceList =resourceDAO.findName(resourceIds);
		ArrayList<ResourceDTO> resourceDTO=new ArrayList<ResourceDTO>();
		for(int i=0 ; resourceList.size()<i ; i++) {
			resourceDTO.add(new ResourceDTO(resourceList.get(i).getResourceId(),resourceList.get(i).getresourceName()));
		}


	return resourceDTO ;


	}

}
