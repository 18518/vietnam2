package service;

import java.sql.SQLException;
import java.time.LocalDateTime;
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


	public ArrayList<ResourceDTO> getResources(LocalDateTime lendDate, LocalDateTime returnDate, int classId) throws SQLException{
		DAOFactory daofactory = DAOFactory.getInstance();
		ReserveDAO reserveDAO = daofactory.getReserveDAO();
		ArrayList<Resource> resources =reserveDAO.search(lendDate,  returnDate, classId);
		ArrayList<ResourceDTO> resourceDTO=new ArrayList<ResourceDTO>();
		for(int i=0 ; resources.size()<i ; i++) {
			resourceDTO.add(new ResourceDTO(resources.get(i).getResourceId(),resources.get(i).getresourceName()));
		}
		return resourceDTO ;

	}
}
