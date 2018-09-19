package service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import dao.DAOFactory;
import dao.ReserveDAO;
import dto.EmployeeDTO;
import dto.ResourceDTO;
import dto.SelectedReserveTermDTO;

public class CompleteService {

	public CompleteService() {
		}

	public int reserve(SelectedReserveTermDTO selectedReserveTermDTO,ArrayList<ResourceDTO> resourceDTOs,EmployeeDTO employeeDTO) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String empId = employeeDTO.getEmpId();

		ArrayList<Integer> resourceId = new ArrayList<Integer>();
		for(int i=0; i<resourceDTOs.size(); i++) {
				resourceId.add(resourceDTOs.get(i).getResourceId());
		}

		LocalDateTime lendDate = selectedReserveTermDTO.getLendDate();

		LocalDateTime returnDate = selectedReserveTermDTO.getReturnDate();

		DAOFactory daoFactory = DAOFactory.getInstance();
		ReserveDAO reserveDAO = daoFactory.getReserveDAO();

		int reserveId=0;
		boolean flag=true;
		while(flag) {
		reserveId=createReserveId();
		flag=reserveDAO.isUniqueId(reserveId);
		}

		for(int i=0; i<resourceId.size(); i++) {
		reserveDAO.insert(reserveId, lendDate, returnDate, empId, resourceId.get(i));
		}

		return reserveId;

	}

	private int createReserveId() {
		return (int)(Math.random()*100000000);
	}
}