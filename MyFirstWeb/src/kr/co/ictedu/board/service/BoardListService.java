package kr.co.ictedu.board.service;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ictedu.board.model.BoardDAO;
import kr.co.ictedu.board.model.BoardVO;

public class BoardListService implements IBoardService {
	
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
		// 바로 DAO부터 생성함.
		BoardDAO dao = BoardDAO.getInstance();
		// 전체 리스트 가져오기
		List<BoardVO> boardList = dao.getBoardList();
		
		// 받아온 리스트를 .jsp에 전달받기
		// request에 데이터를 실어놔야 합니다.
		// request.setAtttribute("명칭", 데이터);
		request.setAttribute("boardList", boardList);
	}
}
