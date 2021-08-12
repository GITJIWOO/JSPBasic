package kr.co.ictedu.board.service;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ictedu.board.model.BoardDAO;
import kr.co.ictedu.board.model.BoardVO;

// 구현 클래스이기 때문에 implements를 합니다.
public class BoardWriteService implements IBoardService{
	
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
		
		// getParameter로 폼에서 쏜 데이터를 들고오게 해주세요.
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String bTitle = request.getParameter("title");
			String bContent = request.getParameter("write");
			String bWriter = request.getParameter("user");
			// DAO생성
			BoardDAO dao = BoardDAO.getInstance();
			// VO생성
			BoardVO board = new BoardVO();
			board.setbTitle(bTitle);
			board.setbContent(bContent);
			board.setbName(bWriter);
			
			int resultCode = dao.write(board);
			
			if(resultCode == 0) {
				System.out.println("에러 발생으로 글이 입력되지 않았습니다.");
			} else if(resultCode == 1) {
				System.out.println("DB에 글이 잘 입력되었습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end execute
}
