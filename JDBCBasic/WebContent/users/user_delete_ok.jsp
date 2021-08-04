<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String upw = request.getParameter("pw");
	String s_pw = (String)session.getAttribute("s_pw");
	String s_id = (String)session.getAttribute("s_id");

	Connection con = null;
	PreparedStatement pstmt = null;
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost/ict03";
		con = DriverManager.getConnection(url, "root", "mysql");
		
		
		if(s_pw.equals(upw)){
			String sql = "DELETE FROM users WHERE uid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s_id);
			pstmt.executeUpdate();
			// 세션 파기는 두 번 실행할 수 없으므로
			// 로직당 한 번만 실행되도록 배치한다.
			session.invalidate();
		} else {
			session.invalidate();
			response.sendRedirect("user_logout.jsp");
		}
		
	} catch(SQLException e){
		System.out.println("에러 : " + e);
	} finally {
		try{
			if(con != null && !con.isClosed()){
				con.close();
			}
			if(pstmt != null && !pstmt.isClosed()){
				pstmt.close();
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	// DELETE구문이 실행된것과는 별개로 session은 따로 말소시켜야 합니다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원 탈퇴가 완료되었습니다.</h3>
</body>
</html>