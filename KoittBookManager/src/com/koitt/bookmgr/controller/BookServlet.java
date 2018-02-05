package com.koitt.bookmgr.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.bookmgr.model.Command;
import com.koitt.bookmgr.model.ListCommand;

public class BookServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		this.doProcess(req, resp);
	}
	
	private void doProcess(HttpServletRequest req, HttpServletResponse resp) {
		try {
			// 1. 클라이언트로부터 전달받은 request 내용 인코딩 설정
			req.setCharacterEncoding("utf-8");
			
			// 2. 쿼리문자열의 cmd 파라미터 값을 가져온다.
			String cmd = req.getParameter("cmd");
			
			// 3. cmd 값이 없을 때 예외처리
			if (cmd == null || cmd.trim().length() == 0) {
				cmd = "CMD_LIST";
			}
			
			// 4. 분기 처리 시 필요한 변수들을 선언
			String page = null;
			Command command = null;
			
			switch (cmd) {
				case "CMD_LIST":
					command = new ListCommand();
					page = command.execute(req, resp);
					break;
			}
			
			// 5. 서블릿에서 데이터베이스로부터 가져온 데이터를 JSP 페이지로 포워딩
			RequestDispatcher rd = req.getRequestDispatcher(page);
			rd.forward(req, resp);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
