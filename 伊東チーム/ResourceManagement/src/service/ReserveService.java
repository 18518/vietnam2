package service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import dao.DAOFactory;
import dao.ReserveDAO;
import domain.Resource;
import dto.ResourceDTO;

public class ReserveService {
	private static final String lendDate = null;
	private static final String returnDate = null;
	private static final String empId = null;
	private static final String resourceId = null;
	public ReserveService() {
	}
	public ArrayList<ResourceDTO> getResources(LocalDateTime lendDate, LocalDateTime returnDate, int classId){
		DAOFactory daofactory = DAOFactory.getInstance();
		ReserveDAO reserveDAO = daofactory.getReserveDAO();
		ArrayList<Resource> resourceList =reserveDAO.search(lendDate, returnDate, classId);
		ArrayList<ResourceDTO> resourceDTO=new ArrayList<ResourceDTO>();
		for(int i=0 ; resourceList.size()<i ; i++) {
			resourceDTO.add(new ResourceDTO(resourceList.get(i).getResourceld(),resourceList.get(i).getResourceName()));
			}
			return resourceDTO;
		}
	}
