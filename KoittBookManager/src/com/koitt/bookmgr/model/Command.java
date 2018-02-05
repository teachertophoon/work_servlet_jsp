package com.koitt.bookmgr.model;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	
	String execute(HttpServletRequest req, HttpServletResponse resp)
			throws ClassNotFoundException, SQLException;
}
