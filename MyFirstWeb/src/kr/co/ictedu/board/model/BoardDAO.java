package kr.co.ictedu.board.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	
	private int SUCCESS = 1;
	private int FAIL = 0;
	
	// 싱글턴 패턴과 커넥션 풀을 적용해서
	// DAO의 연결부(생성자, getInstance())까지 작성해주세요.
	private DataSource ds;
	
	// 싱글톤 패턴
	private BoardDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static BoardDAO dao = new BoardDAO();
	
	public static BoardDAO getInstance() {
		if(dao == null){
			dao = new BoardDAO();
		}
		return dao;
	}
	
	public int write(BoardVO board) {
		// Connection, PreparedStatement 객체 선언
		Connection con = null;
		PreparedStatement pstmt = null;
		
		// 구문 작성
		// bId는 auto_increment가 뭍어있으므로 입력은 필요없다.
		// bName, btitle, bContent는 폼에서 날려준 걸 넣는다.
		// bDate는 자동으로 현재 서버시간을 입력함
		// bHit는 자동으로 0을 입력함
		try {
			// 커넥션 생성 및 pstmt에 쿼리문을 넣고 완성시켜서 실행까지 하고
			// close()로 메모리 회수까지 해주세요.
			con = ds.getConnection();
			String sql = "INSERT INTO jspboard"
					+ " (bname, btitle, bcontent, bdate, bhit)"
					+ "VALUES (?, ?, ?, now(), 0)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getbName());
			pstmt.setString(2, board.getbTitle());
			pstmt.setString(3, board.getbContent());
			
			pstmt.executeUpdate();
			
			return SUCCESS;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
	 		try {
	 			if(con != null && !con.isClosed()) {
	 				con.close();
	 			}
	 			if(pstmt != null && !pstmt.isClosed()) {
	 				pstmt.close();
	 			}
	 		} catch (Exception e){
	 			e.printStackTrace();
	 		}
		}
		return FAIL;
	} // end write
	
	// 모든 게이글의 정보를 DB로부터 얻어올 메서드
	public List<BoardVO> getBoardList(){
		// 내부에서 사용할 변수 선언
		
		List<BoardVO> boardList = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;		
		ResultSet rs = null;
		
		// SQL문 작성
		String sql = "SELECT * FROM jspboard ORDER BY bId DESC";
		try {
			// 커넥션 연결 후 DB에 쿼리 쏴주시고
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// boardList에 DB내 모든 글을 저장해주세요.
			while(rs.next()) {
				BoardVO board = new BoardVO();
				
				board.setbId(rs.getInt("bid"));
				board.setbName(rs.getString("bname"));
				board.setbTitle(rs.getString("btitle"));
				board.setbContent(rs.getString("bcontent"));
				board.setbDate(rs.getTimestamp("bdate"));
				board.setbHit(rs.getInt("bhit"));
				
				boardList.add(board);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
	 		try {
	 			if(con != null && !con.isClosed()) {
	 				con.close();
	 			}
	 			if(pstmt != null && !pstmt.isClosed()) {
	 				pstmt.close();
	 			}
	 			if(rs != null && !rs.isClosed()) {
	 				rs.close();
	 			}
	 			
	 		} catch (Exception e){
	 			e.printStackTrace();
	 		}
		}
		return boardList;
	} // end getBoardList
	
	public BoardVO getBoardDetail(String bId) {
		// bId에 해당하는 글 정보를 가져와서 리턴하도록 로직을 작성해주세요.
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		BoardVO board = new BoardVO();
		
		String sql = "SELECT * FROM jspboard WHERE bid=?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board.setbId(rs.getInt("bid"));
				board.setbName(rs.getString("bname"));
				board.setbTitle(rs.getString("btitle"));
				board.setbContent(rs.getString("bcontent"));
				board.setbDate(rs.getTimestamp("bdate"));
				board.setbHit(rs.getInt("bhit"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
	 		try {
	 			if(con != null && !con.isClosed()) {
	 				con.close();
	 			}
	 			if(pstmt != null && !pstmt.isClosed()) {
	 				pstmt.close();
	 			}
	 			if(rs != null && !rs.isClosed()) {
	 				rs.close();
	 			}
	 			
	 		} catch (Exception e){
	 			e.printStackTrace();
	 		}
		}
		return board;
	} // end getBoardDetail
	
	public int deleteboard(String bId) {
		// bId에 해당하는 글 정보를 가져와서 리턴하도록 로직을 작성해주세요.
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM jspboard WHERE bid=?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bId);
			pstmt.executeUpdate();
			
			return SUCCESS;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
	 		try {
	 			if(con != null && !con.isClosed()) {
	 				con.close();
	 			}
	 			if(pstmt != null && !pstmt.isClosed()) {
	 				pstmt.close();
	 			}
	 		} catch (Exception e){
	 			e.printStackTrace();
	 		}
		}
		return FAIL;
	} // end deleteboard
	
	public int boardUpdate(BoardVO board) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE jspboard SET bHit=?, bDate=?, bName=?, btitle=?, bcontent=? WHERE bid=?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, board.getbHit());
			pstmt.setTimestamp(2, board.getbDate());
			pstmt.setString(3, board.getbName());
			pstmt.setString(4, board.getbTitle());
			pstmt.setString(5, board.getbContent());
			pstmt.setLong(6, board.getbId());
			pstmt.executeUpdate();
			
			return SUCCESS;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
	 		try {
	 			if(con != null && !con.isClosed()) {
	 				con.close();
	 			}
	 			if(pstmt != null && !pstmt.isClosed()) {
	 				pstmt.close();
	 			}
	 		} catch (Exception e){
	 			e.printStackTrace();
	 		}
		}
		return FAIL;
	} // end boardUpdate
}
