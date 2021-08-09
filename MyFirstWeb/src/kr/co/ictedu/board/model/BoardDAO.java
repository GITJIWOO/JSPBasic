package kr.co.ictedu.board.model;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	// 싱글턴 패턴과 커넥션 풀을 적용해서
	// DAO의 연결부(생성자, getInstance())까지 작성해주세요.
	private DataSource ds;
	
	// 싱글톤 패턴
	public BoardDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static BoardDAO dao = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return dao;
	}
}