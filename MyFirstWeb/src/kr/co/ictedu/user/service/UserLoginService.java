package kr.co.ictedu.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ictedu.user.model.UsersDAO;
import kr.co.ictedu.user.model.UsersVO;

public class UserLoginService implements IUserService{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			// 폼에서 날린 데이터 받기
			String uid = request.getParameter("uid");
			String upw = request.getParameter("upw");
			
			// 세션 쓰는 법
			HttpSession session = null;
			session = request.getSession();
			
			// VO 생성 및 데이터 입력
			UsersVO user = new UsersVO();
			user.setUid(uid);
			user.setUpw(upw);
			
			// dao 호출
			UsersDAO dao = UsersDAO.getInstance();
			
			int resultCode = dao.usersLogin(user);
			
			if(resultCode ==  1) {
				// 통과시 세션 발급
				session.setAttribute("id_session", uid);
				session.setAttribute("pw_session", upw);
			} else if(resultCode == 0) {
				session.setAttribute("login", "fail");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}