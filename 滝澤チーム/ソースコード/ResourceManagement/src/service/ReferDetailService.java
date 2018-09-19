package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOFactory;
import dao.ReserveDAO;
import dao.ResourceDAO;
import domain.Reserve;
import domain.Resource;
import dto.ReserveDTO;
import dto.ResourceDTO;

public class ReferDetailService {

	public ReferDetailService() {
	}

	public ArrayList<ReserveDTO> find(int reserveId,String empId) throws SQLException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		ReserveDAO reserveDAO = daoFactory.getReserveDAO();
		ArrayList<Reserve> reserve = new ArrayList<Reserve>();
		ArrayList<ReserveDTO> reserveDTO = new ArrayList<ReserveDTO>();

		reserve=reserveDAO.find(reserveId,empId);
		for(int i=0; i<reserve.size(); i++) {
			reserveDTO.add(new ReserveDTO(reserve.get(i).getReserveId(),reserve.get(i).getLendDate(),reserve.get(i).getReturnDate(),reserve.get(i).getEmpld(),reserve.get(i).getResourceId()));
		}
		return reserveDTO;
	}

	public ArrayList<ResourceDTO> findName(int[] resourceIds) throws SQLException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		ResourceDAO resourceDAO = daoFactory.getResourceDAO();
		ArrayList<Resource> resource = new ArrayList<Resource>();
		resource=resourceDAO.findName(resourceIds);
		ArrayList<ResourceDTO> resourceDTO = new ArrayList<ResourceDTO>();
		for(int i=0; i<resource.size(); i++) {
		resourceDTO.add(new ResourceDTO(resource.get(i).getResourceId(),resource.get(i).getResourceName()));
		}
		return resourceDTO;
	}

}
