package kr.co.ictedu.board.service;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ictedu.board.model.BoardDAO;

public class BoardDeleteService implements IBoardService{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 세션 쓰는법
		HttpSession session = null;
		session = request.getSession();
		
		String id_session = (String)session.getAttribute("id_session");
		
		// 접속하자마자 바로 전체 데이터만 들고오면 됨
		if(id_session == null) {
			try {
				// 서비스 내부에서 포워딩을 시키면
				// 리다이렉트가 아니기 때문에 실행됨.
				String ui = "user/user_login_form.jsp";
				RequestDispatcher dp = request.getRequestDispatcher(ui);
				dp.forward(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		try {
			String bId = request.getParameter("bId");
			
			BoardDAO dao = BoardDAO.getInstance();
			int deleteboard = dao.deleteboard(bId);
			
			if(deleteboard == 0) {
				System.out.println("삭제에 실패하였습니다.");
			} else if(deleteboard == 1) {
				System.out.println("삭제를 성공하였습니다.");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
