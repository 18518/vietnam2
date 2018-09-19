package presentation;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exception.CommandException;

public interface Command {
	String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, SQLException;
}