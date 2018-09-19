package service;

import java.util.ArrayList;

import dao.DAOFactory;
import dao.ReserveDAO;
import domain.Reserve;
import dto.ReserveDTO;

public class CancelService {
	public CancelService() {

	}

	public ArrayList<ReserveDTO> find(int reserveId ,String empId ) {
		DAOFactory daofactory = DAOFactory.getInstance();
		ReserveDAO reserveDAO = daofactory.getReserveDAO();
		ArrayList<Reserve> reserveList=reserveDAO.find(reserveId,empId);
		ArrayList<ReserveDTO> reserveDTO=new ArrayList<ReserveDTO>();
		for(int i=0 ; reserveList.size()<i ; i++) {
			reserveDTO.add(new ReserveDTO(reserveList.get(i). getReserveId() ,reserveList.get(i).getLendDate(),reserveList.get(i).getReturnDate(),reserveList.get(i).getEmpId(),reserveList.get(i).getResourceId()));
		}
		return reserveDTO;
	}

	public void delete(int reserveId, int resourceId ){
	DAOFactory daofactory = DAOFactory.getInstance();
	ReserveDAO reserveDAO = daofactory.getReserveDAO();
	reserveDAO.delete(reserveId, resourceId);
	}
}
