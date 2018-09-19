package service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import dao.DAOFactory;
import dao.ReserveDAO;
import domain.Resource;
import dto.ResourceDTO;

public class ReserveService {

	private static final int resourcelds = 0;
	public ReserveService(){

	}

//	public int reserve(SelectedReserveTermDTO selectReserveDTO,ReserveDTO[] resourceDTOs, EmployeeDTO employeeDTO) throws SQLException {
//
//		String employeeId=employeeDTO.getEmpId();
//		LocalDateTime lendDate = selectReserveDTO.getLendDate();
//		LocalDateTime returnDate = selectReserveDTO.getReturnDate();
//		DAOFactory daoFactory  = DAOFactory.getInstance();
//		ReserveDAO reserveDAO =daoFactory.getReserveDAO();
//		int reserveId=0;
//
//		while(!(reserveDAO.isUniqueId(reserveId)) ){
//			reserveId=createReserveId();
//		}
//
//		for(int i=0; i<resourceDTOs.length; i++) {
//		Reserve reserve=new Reserve(reserveId,lendDate,returnDate,employeeDTO.getEmpId(),resourceDTOs[i].getReserveId());
//		reserveDAO.insert(reserve);
//		}
//
////		ArrayList<Resource> resourceIds = new ArrayList<Resource>();
////		resourceIds=ReserveDAO.search(lendDate, returnDate, classId);
////		findName = ResourceDAO.findName(resourceIds);
////
////		ArrayList<ResourceDTO> allAvailableResource = new ArrayList<ResourceDTO>();
//		return reserveId;
//	}
//
//	private int createReserveId() {
//		int reserveId=0;
//		Random r = new Random();
//		while(String.valueOf(reserveId).length()!=8) {
//			reserveId = r.nextInt(99999999);
//		}
//		return reserveId;


//	public ArrayList<Resource> findName(int[] resourceIds) throws SQLException {
//		DAOFactory daoFactory  = DAOFactory.getInstance();
//		ResourceDAO resourceDAO =daoFactory.getResouceDAO();
//		resourceDAO.findName(resourcelds);
//		ArrayList<Resource> resource = new ArrayList<Resource>();
//		//Resource resourceId = new Resource(resourceId,resourceName);
//		return resource;
//
//	}



	public ArrayList<ResourceDTO> getResources(LocalDateTime lendDate, LocalDateTime returnDate, int[] classId) throws SQLException {

		DAOFactory daoFactory = DAOFactory.getInstance();
		ReserveDAO reserveDAO = daoFactory.getReserveDAO();
		
		ArrayList<Resource> resources = new ArrayList<Resource>();
		resources=reserveDAO.search(lendDate,returnDate,classId);
		
		ArrayList<ResourceDTO> resourceDTO = new ArrayList<ResourceDTO>();
		for(int i=0; i<resources.size(); i++) {
			resourceDTO.add(new ResourceDTO(resources.get(i).getResourceId(),resources.get(i).getResourceName()));
		}
		return resourceDTO;
	}

}
