package kr.co.ictedu.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ictedu.user.model.UsersDAO;
import kr.co.ictedu.user.model.UsersVO;

public class UserJoinService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			String uid = request.getParameter("uid");
			String upw = request.getParameter("upw");
			String uname = request.getParameter("uname");
			String email = request.getParameter("email");
			
			UsersDAO dao = UsersDAO.getInstance();
			UsersVO vo = new UsersVO(uid, upw, uname, email);
			int resultSet = dao.usersJoin(vo);
			
			if(resultSet == 0) {
				System.out.println("가입을 실패하였습니다.");
			} else if(resultSet == 1) {
				System.out.println("가입을 성공했습니다.");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
