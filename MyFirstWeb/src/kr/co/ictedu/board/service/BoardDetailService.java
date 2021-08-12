package kr.co.ictedu.board.service;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ictedu.board.model.BoardDAO;
import kr.co.ictedu.board.model.BoardVO;

public class BoardDetailService implements IBoardService {
	
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
		
		// url에 묻어온 글 번호를 getParameter를 이용해 얻음
		String bId = request.getParameter("bId");
		// DAO 생성
		BoardDAO dao = BoardDAO.getInstance();
		
		// 먼저 조회수를 올리고 가져와야 최신 조회수를 표시할 수 있다
		dao.upHit(bId);
		
		// DAO에 글 번호를 넘겨서 detail페이지 데이터를 얻어옴
		BoardVO board = dao.getBoardDetail(bId);
		System.out.println("서비스 내부 데이터 : " + board);
		
		// 포워딩을 위해 setAttribute()로 데이터를 실어준다.
		request.setAttribute("board", board);
		
	}
}