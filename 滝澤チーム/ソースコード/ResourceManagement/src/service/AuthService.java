package service;

import java.sql.SQLException;

import dao.DAOFactory;
import dao.EmployeeDAO;
import domain.Employee;
import dto.EmployeeDTO;

public class AuthService {//sat nhan ten dang nhap

	public AuthService() {

	}

	public EmployeeDTO authenticate(String empId,String password) throws SQLException {
		DAOFactory DAOFactory =dao.DAOFactory.getInstance();
		EmployeeDAO employeeDAO = DAOFactory.getEmployeeDAO();
		Employee employee=employeeDAO.find(empId);
		EmployeeDTO employeeDTO=null;
		if(employee.getPassword().equals(password)) {
		employeeDTO = new EmployeeDTO(employee.getEmpId(),employee.getName(),employee.getManagerId());
		}

		return employeeDTO;
	}
}
