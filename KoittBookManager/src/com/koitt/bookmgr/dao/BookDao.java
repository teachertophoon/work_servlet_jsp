package com.koitt.bookmgr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.koitt.bookmgr.util.DBUtil;
import com.koitt.bookmgr.vo.Book;

public class BookDao {
	
	public List<Book> selectAll() throws ClassNotFoundException, SQLException {
		// 1. 데이터베이스 커넥션 객체 가져오기
		Connection conn = DBUtil.getInstance().getConnection();
		
		// 2. SQL문 작성 (책 번호 내림차순 정렬, 최신등록 책 우선)
		String sql = "SELECT * FROM book ORDER BY isbn DESC";
		
		// 3. PreparedStatement 객체 생성
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		// 4. SQL문 실행
		ResultSet rs = pstmt.executeQuery();
		
		// 5. ResultSet 객체를 이용하여 게시물 값들을 가져온 뒤 Book 객체에 저장
		List<Book> list = new ArrayList<Book>();
		while (rs.next()) {
			Book book = new Book();
			
			book.setAuthor(rs.getString("author"));
			book.setDescription(rs.getString("description"));
			book.setIsbn(rs.getInt("isbn"));
			book.setPrice(rs.getInt("price"));
			book.setPublisher(rs.getString("publisher"));
			book.setTitle(rs.getString("title"));
			
			// 글 하나에 해당하는 Book 객체를 리스트에 저장
			list.add(book);
		}
		
		// 6. 객체 해제
		DBUtil.getInstance().close(rs);
		DBUtil.getInstance().close(pstmt);
		DBUtil.getInstance().close(conn);
		
		return list;
	}
}
