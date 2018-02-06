package com.koitt.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.koitt.board.util.DBUtil;
import com.koitt.board.vo.Users;

public class UsersDao {
	
	public List<Users> selectAll() throws ClassNotFoundException, SQLException {
		Connection conn = DBUtil.getInstance().getConnection();
		
		String sql = "SELECT * FROM users ORDER BY NO DESC";	// 최근 가입순으로 정렬
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<Users> list = new ArrayList<Users>();
		while (rs.next()) {
			Users users = new Users();
			
			users.setEmail(rs.getString("email"));
			users.setName(rs.getString("name"));
			users.setNo(rs.getInt("no"));
			users.setPassword(rs.getString("password"));
			
			list.add(users);
		}
		
		DBUtil.getInstance().close(rs);
		DBUtil.getInstance().close(pstmt);
		DBUtil.getInstance().close(conn);
		
		return list;
	}
}
