
package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOFactory;
import dao.ResourceClassDAO;
import domain.ResourceClass;
import dto.ResourceClassDTO;

public class AvailableResourceService {
	public AvailableResourceService() {

	}
	public ArrayList<ResourceClassDTO> getResourceClass() throws SQLException {
		//		public ArrayList<Class> getClass(LocalDateTime lendDateLocalDateTime returnDate, int[] classId) throws SQLException {

		DAOFactory DAOFactory =dao.DAOFactory.getInstance();
		//ReserveDAO ReserveDAO = DAOFactory.getReserveDAO() ;
		ResourceClassDAO classDAO =DAOFactory.getClassDAO() ;
		//ArrayList<Resource> resourceIds = new ArrayList<Resource>();
		//resourceIds=ReserveDAO.search(lendDate, returnDate, classId);
		//findName = ResourceDAO.findName(resourceIds);
		ArrayList<ResourceClass> showName = new ArrayList<ResourceClass>();
		showName = classDAO.showName();
		ArrayList<ResourceClassDTO> resourceClassDTO =new ArrayList<ResourceClassDTO>();
		for( int i = 0 ;i<showName.size();i++) {
			int tmp = showName.get(i).getClassId();//lay classid bo vao tmp
			String tmh = showName.get(i).getClassName();//lay className bo vao tmh roi tao bien moi them vao
			resourceClassDTO.add(new ResourceClassDTO(tmp,tmh) );//mang resourceClassDTO
		}
		//ArrayList<ResourceDTO> allAvailableResource = new ArrayList<ResourceDTO>();
		return resourceClassDTO;
		}
	}


