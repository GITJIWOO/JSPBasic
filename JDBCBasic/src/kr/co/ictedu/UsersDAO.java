package kr.co.ictedu;

import java.sql.*;

// DAO클래스는 DB연동을 전담해 처리합니다
public class UsersDAO {
	
	// DB주소 아이디 패스워드 미리 저장
	private static final String url = "jdbc:mysql://localhost/ict03";
	private static final String DBID = "root";
	private static final String DBPW = "mysql";
	
	// 메서드 결과에 따른 리턴값 상수로 표기
	private static final int ID_DELETE_SUCCESS = 1;
	private static final int ID_DELETE_FAIL = 0;
	private static final int ID_LOGIN_SUCCESS = 1;
	private static final int ID_LOGIN_FAIL = 0;
	
	/*
	 * DAO 클래스는 하나의 객체만으로도 DB연동을 수행할 수 있기 때문에
	 * 메모리 관리 차원에서 클래스의 객체를 단 1개만 생성하도록
	 * 싱글톤 패턴을 적용하여 클래스를 디자인합니다.
	 */
	
	// 싱글톤 패턴 클래스 디자인 방법
	// 1. 외부에서 객체를 new 키워드로 만들어 쓸 수 없도록 생성자에
	// private을 붙여줍니다.
	private UsersDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 2. 외부에서 객체생성을 못 하기 때문에 자기 클래스 내부에서 그냥
	// 스스로 자기 자신을 1개 생성합니다.
	private static UsersDAO dao = new UsersDAO();
	
	// 3. 외부에서 객체 생성이 필요할 때 public 선언으로 처리한
	// getter를 이용해 2에서 만든 객체를 리턴만 해줍니다.
	// 이러면 UsersDAO는 참조형 변수이기 때문에 주소값만 전달합니다.
	public static UsersDAO getInstance() {
		return dao;
	}
	
	// 회원가입을 처리하는 메서드 선언
	// DB에 들어가는 데이터, 혹은 DB에서 출력되어 나오는 데이터
	// 모두가 UsersVO내부 자료 형식을 벗어날 수 없으므로
	// 대다수 입출력은 전부 VO를 매개로 진행합니다.
	public int usersJoin(UsersVO user) {
		// users_join.jsp에서 가져온 코드를 이곳에 붙여넣기를 합니다.
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DriverManager.getConnection(url, DBID, DBPW);
			
			// 1. INSERT쿼리문을 작성합니다.
			String sql = "INSERT INTO users VALUES(?, ?, ?, ?)";
			
			// 2. 만든 쿼리문의 ? 자리에 적용할 자바 변수를 집어넣습니다.
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUid());
			pstmt.setString(2, user.getUpw());
			pstmt.setString(3, user.getUname());
			pstmt.setString(4, user.getEmail());
			
			// 3. 만든 쿼리문 실행하기
			pstmt.executeUpdate();
			
	 	} catch (SQLException e) {
	 		System.out.println("에러 : " + e);
	 	} finally {
	 		try {
	 			if(con != null && !con.isClosed()) {
	 				con.close();
	 			}
	 			if(pstmt != null && !pstmt.isClosed()) {
	 				pstmt.close();
	 			}
	 		} catch (SQLException e){
	 			e.printStackTrace();
	 		}
	 	}
		return 1;
	} // end usersJoin
	
	// usersDelete
	// 원래 대다수 DAO는 UsersVO 하나로 모든 처리를 해결할 수 있습니다.
	// 다만 삭제로직은 폼에서 날린 비밀번호와 원래 DB에 저장되어있던 비밀번호를
	// 비교해야 하기 때문에 폼에서 날린 비밀번호를 추가로 입력받습니다.
	public int usersDelete(UsersVO user, String dpw) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			// UsersVO에 입력된 비밀번호와 폼에서 날린 dpw를 비교
			if(user.getUpw().equals(dpw)) {
				con = DriverManager.getConnection(url, DBID, DBPW);
				
				String sql = "DELETE FROM users WHERE uid=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user.getUid());
				
				pstmt.executeUpdate();
				
				// 내부적으로 session, response 등 내장객체에 대한
				// 처리를 할 수 없으므로, 결과 정보만 리턴
				return ID_DELETE_SUCCESS;
			} else {
				// 비밀번호를 틀리게 입력한 경우
				return ID_DELETE_FAIL;
				
			}
			
	 	} catch (SQLException e) {
	 		System.out.println("에러 : " + e);
	 	} finally {
	 		try {
	 			if(con != null && !con.isClosed()) {
	 				con.close();
	 			}
	 			if(pstmt != null && !pstmt.isClosed()) {
	 				pstmt.close();
	 			}
	 		} catch (SQLException e){
	 			e.printStackTrace();
	 		}
	 	}
		// 상단 try블럭 내에서 로직이 처리가 안 되어서 여기까지 코드가
		// 도달했다는 자체로 이미 뭔가 실행이 누락되었다는 이야기이므로
		// 0을 리턴
		return ID_DELETE_FAIL;
	} // end usersDelete
	
	public int usersLogin(UsersVO user) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, DBID, DBPW);
			
			String sql = "SELECT * FROM users WHERE uid=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUid());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbId = rs.getString("uid");
				String dbPw = rs.getString("upw");
				
				if(user.getUid().equals(dbId) && user.getUpw().equals(dbPw)){
					return ID_LOGIN_SUCCESS;
				} else {
					return ID_LOGIN_FAIL;
				}
			} else {
				return ID_LOGIN_FAIL;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
				if(pstmt != null && !pstmt.isClosed()){
					pstmt.close();
				}
				if(rs != null && !rs.isClosed()){
					rs.close();
				}
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		return ID_LOGIN_FAIL;
	} // end usersLogin
	
	// getUsersInfo 메서드
	// 수정 로직을 사용하기 전에 수정할 티켓 아이디의 정보를 얻어오기 위해ㅔ
	// 사용하는 메서드로 아이디, 비밀번호, 이름, 이메일을 UsersVO에 넣어서
	// 리턴합니다.
	public UsersVO getUsersInfo(UsersVO user) {
		
		// DB연결 후 입력받은 user의 .getUid()를 이용해 조회구문 완성
		// 이후 ResultSet에 담겨있는 자료를 다시 다 꺼내서
		// 새로 선언한 UsersVO 변수에 입력해준 후
		// ResultSet에 있던 자료를 입력받은 UsersVO를 리턴
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		UsersVO resultSet = new UsersVO();
		
		try {
			con = DriverManager.getConnection(url, DBID, DBPW);
			
			String sql = "SELECT * FROM users WHERE uid=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUid());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// 이후 ResultSet에 담겨있는 자료를 다시 다 꺼내서
				// 새로 선언한 UsersVO 변수에 입력해준 후
				resultSet.setUid(rs.getString("uid"));
				resultSet.setUpw(rs.getString("upw"));
				resultSet.setUname(rs.getString("uname"));
				resultSet.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
				if(pstmt != null && !pstmt.isClosed()){
					pstmt.close();
				}
				if(rs != null && !rs.isClosed()){
					rs.close();
				}
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		return resultSet;
	}
}