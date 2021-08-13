package kr.co.ictedu.board.service;

import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ictedu.board.model.BoardDAO;
import kr.co.ictedu.board.model.BoardVO;

// IBoardService 구현하기
public class BoardUpdateService implements IBoardService {
	
	// 오버라이딩된 메서드 내부 작성하
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
		
		// 1. 파라미터 6개 받아오기
		String strbId = request.getParameter("bId");
		int bId = Integer.parseInt(strbId);
		
		String strbHit = request.getParameter("bHit");
		int bHit = Integer.parseInt(strbHit);
		
		String tsbDate = request.getParameter("bDate");
		Timestamp bDate = java.sql.Timestamp.valueOf(tsbDate);
		
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		// 2. VO 생성해서 세터로 저장하기
		BoardVO board = new BoardVO();
		
		board.setbId(bId);
		board.setbHit(bHit);
		board.setbDate(bDate);
		board.setbName(bName);
		board.setbTitle(bTitle);
		board.setbContent(bContent);
		
		// 3. DAO 생성 및 update로직 호출(update로직은 직접 작성해주세요.)
		BoardDAO dao = BoardDAO.getInstance();
		int resultSet = dao.boardUpdate(board);
		System.out.println(board);
		if(resultSet == 0) {
			System.out.println("수정 실패");
		} else if(resultSet == 1) {
			System.out.println("수정 성공");
		}
		request.setAttribute("board", board);
	}
}
