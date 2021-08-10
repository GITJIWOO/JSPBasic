package kr.co.ictedu.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;

import kr.co.ictedu.board.model.BoardDAO;
import kr.co.ictedu.board.model.BoardVO;

public class BoardDetailService implements IBoardService {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// url에 묻어온 글 번호를 getParameter를 이용해 얻습니다.
		String bId = request.getParameter("bid");
		
		// DAO를 생성합니다.
		BoardDAO dao = BoardDAO.getInstance();
		
		// DAO에 글 번호를 넘겨서 detail페이지 데이터를 얻어옵니다.
		BoardVO boardDetail = new BoardVO();
		boardDetail = dao.getBoardDetail(bId);
		
		// 포워딩을 위해 setAttribute()로 데이터를 실어줍니다.
		request.setAttribute("boardDetail", boardDetail);
	}
}