package service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import dao.DAOFactory;
import dao.ReserveDAO;
import domain.Reserve;
import dto.EmployeeDTO;
import dto.ResourceDTO;
import dto.SelectedReserveTermDTO;

public class CompleteService {
	public CompleteService() {

	}
	public int reserve(SelectedReserveTermDTO selectedReserveTermDTO,ArrayList<ResourceDTO> resourceDTOs,EmployeeDTO employeeDTO) {
		String empId = employeeDTO.getEmpId();
		LocalDateTime lendDate= selectedReserveTermDTO.getLendDate();
		LocalDateTime returnDate= selectedReserveTermDTO.getReturnDate();
		DAOFactory daofactory = DAOFactory.getInstance();
		ReserveDAO reserveDAO = daofactory.getReserveDAO();
		int reserveId = createReserveId();
		while (reserveDAO.isUniqueId(reserveId)) {
			reserveId = createReserveId();
		}
		for(ResourceDTO resourceDTO:resourceDTOs) {
		int resourceId = resourceDTO.getResourceld();
		Reserve reserve =new Reserve( reserveId,lendDate, returnDate,empId,resourceId);
		reserveDAO.insert(reserve);
	}

		return reserveId;
	}
	private int createReserveId() {
		return (int)(Math.random()*100000000);
	}

}
