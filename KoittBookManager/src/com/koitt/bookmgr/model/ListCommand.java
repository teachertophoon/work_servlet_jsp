package com.koitt.bookmgr.model;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.bookmgr.dao.BookDao;
import com.koitt.bookmgr.vo.Book;

public class ListCommand implements Command {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, SQLException {
		// 포워딩 할 페이지 URL
		String page = "./book/list.jsp";
		
		// 데이터베이스로부터 게시판 목록을 가져와서 저장할 리스트 변수
		List<Book> list = null;
		
		// 데이터베이스로부터 게시판 목록을 가져옴
		BookDao dao = new BookDao();
		list = dao.selectAll();
		
		// JSP 페이지로 포워딩 할 데이터를 설정
		req.setAttribute("list", list);
		
		return page;
	}

}
