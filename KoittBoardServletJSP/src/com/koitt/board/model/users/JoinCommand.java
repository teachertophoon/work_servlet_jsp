package com.koitt.board.model.users;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.board.dao.UsersDao;
import com.koitt.board.model.Command;
import com.koitt.board.vo.Users;

public class JoinCommand implements Command {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws ClassNotFoundException, SQLException {
		// 1. 포워딩할 JSP 페이지명
		String page = "./users/join-ok.jsp";
		
		// 2. 클라이언트로부터 전달받은 값을 변수에 저장
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		
		// 3. insert로 전달할 Users 객체 생성
		Users users = new Users();
		
		// 4. 2번에서 저장한 변수를 users 객체에 저장
		users.setEmail(email);
		users.setName(name);
		users.setPassword(password);
		
		// 5. 4번에서 만든 객체를 Dao로 전달하기 위해 UsersDao 객체 생성
		UsersDao dao = new UsersDao();
		
		// 6. INSERT SQL문 실행을 하는 UsersDao의 insert 메소드로 4번 Users 객체 전달
		dao.insert(users);
		
		// 7. 포워딩 할 JSP 페이지를 UsersServlet(Controller)로 전달
		return page;
	}

	
}




