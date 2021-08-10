package kr.co.ictedu.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ictedu.board.model.BoardDAO;
import kr.co.ictedu.board.model.BoardVO;

// 구현 클래스이기 때문에 implements를 합니다.
public class BoardWriteService implements IBoardService{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
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
