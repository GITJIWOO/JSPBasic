package kr.co.ictedu.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ictedu.board.model.BoardDAO;

public class BoardDeleteService implements IBoardService{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
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
