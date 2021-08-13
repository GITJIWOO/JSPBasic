package kr.co.ictedu.board.model;

import java.util.List;

/*
- 페이징 처리

페이징처리란 전체 목록을 한 번에 보여주지 않고
일정 개수씩 끊어서 페이지를 만들고

페이지 번호에 따라 보여주는 목록을 조정해주는것입니다.

MySQL에서는 쿼리문을 날릴때 limit구문을 사용해 처리합니다.

limit구문 : SELECT * FROM jspboard limit 0, 10;

첫 번째 글에서부터 10개만 보여주기(1~10번)(1페이지)

2페이지를 조회하는 리미트 구문을 작성해보세요.(11번글 ~ 20번글)
SELECT * FROM jspboard limit 10, 10;

SELECT * FROM jspboard limit 30, 10; (4페이지)
31번째 글에서부터 10개 보여주기(31~40번)

(페이지번호 - 1) * 10 = 각 페이지별 시작번호

- 웹에서의 페이징 처리

게시판 리스트 주소 뒤에 ?page=페이지번호
라는 파라미터를 입력해서 처리합니다.

현재는 boardselect.do로 접속시 모든 데이터를 다 들고와서
화면에 뿌려주도록 설계가 되어있지만,

앞으로는 boardselect.do에 페이지 번호 정보를 같이 넘기고
그 정보에 따라 알맞은 갯수와 순번의 게시물만 보이게 해야합니다.

DAO내부에 select구문이 모든 자료를 가져오기 -> limit조건에 맞는것만 가져오기

- 내비게이션 버튼(페이지 이동 버튼)

1. 전체 글 개수를 구합니다.

2. 한 페이지에 보여줄 글 개수를 정합니다.(10개로 고정)

3. 총 페이지 개수를 구합니다.
	
	예) 강사 컴퓨터 DB 내 글 개수 22개
	
	총 글 개수 % 페이지당 보여줄 글 개수 = 0 인 경우
	총 글 개수 / 페이지당 보여줄 글 개수로 처리하면 됨
	20개 글 존재하고 10개글씩 표현시 => 10개, 10개 2페이지
	
	총 글 개수 % 페이지당 보여줄 글 개수 = 0 이 아닌 경우
	총 글 개수 / 페이지당 보여줄 글 개수 + 1개 로 처리하면 됨
	22개 글 존재하고 10개글씩 표현시 => 10개, 10개, 2개 3페이지

4. 현재 보고있는 페이지가 어느 집단군에 속하는지 알아봅니다.
	
	예) 내가 현재 546페이지를 보는 경우
	1~10
	11~20
	21~30
	...
	541~ 550페이지
	
	541페이지가 시작페이지인데, 이것을 도출해내기 위해서
	1) 546을 페이지당 표현 글 개수로 나눕니다.
	546 / 10 = 54, 540 / 10= 54
	그러나 540은 546과 다른 그룹임
	
	만약 540 % 10 == 0
	540 / 10 - 1 까지 해줌
	딱 떨어진다면 => 이전 구간으로 간주(531~540 구간에 속하므로)
	
	만약 546 % 10 != 0
	546 / 10 을 그대로 사용
	딱 떨어지지 않는다면 현재구간을 그대로 써도 됨.(541~550 구간에 속하므로)
	
	
	내가 보고있는 페이지의 시작페이지 구하기
	현재페이지 % 내비게이션 개수 가 0인경우
	현재페이지 / 내비게이션 개수 * 내비게이션 개수 
	540 / 10 * 10 = 540(531 ~ 540)
	% 내비게이션 개수가 0인경우는 (내비갯수 - 1)을 추가로 빼줍니다.
	540 - (10 - 1) = 531을 시작페이지로 구할 수 있습니다.
	 
	
	현재페이지 % 내비게션 개수 가 0이 아닌경우
	현재페이지 / 내비게이션 개수 * 내비게이션 개수
	546 / 10 * 10 = 540(541~550)
	% 내비게이션 개수가 0이 아닌경우는 1을 더해줍니다.
	540 + 1 = 541
	
	
	해당 페이지의 끝페이지는 시작페이지를 먼저 구해놓은다음
	시작페이지 + (내비게이션 개수  -1 )
	546페이지의 경우 시작 페이지가 541
	541 + (10 - 1) = 550
	
	540페이지의 경우 시작페이지가 531
	531 + (10 - 1) = 540
*/
// VO와 DTO는 크게 구분을 하지 않는 사람들도 있고 구분을 한다고 해도
// 엄격하게 하지는 않는 편입니다.
// 만약 굳이 구분을 해야 한다면, VO는 DB에서 받아온 데이터를 그대로 전달하는쪽에
// 초점이 맞춰져 있다면, DTO는 받아온 데이터를 특수하게 가공해서 전달하는 쪽에
// 초점이 맞춰줘 있다고 보셔도 무방합니다.
public class BoardPageDTO {
	private int total; // 전체 글 개수
	private int currentPage; // 현재 보고있는 페이지
	private List<BoardVO> boardList; // 페이징된 글 목록
	private int totalPages; // 전체 페이지 개수
	private int startPage; // 시작 페이지 번호
	private int endPage; // 끝 페이지 번호
	
	// 생성자는 전체 글 개수, 현재 페이지, 페이징된 글 목록을 받아서 가공해
	// 나머지 정보를 얻어냅니다.
	public BoardPageDTO(int total, int currentPage, List<BoardVO> boardList) {
		this.total = total;
		this.currentPage = currentPage;
		this.boardList = boardList;
		
		// 아래부터 위 3개를 토대로 가공해서 나머지 변수를 채웁니다.
		// 글이 없는 경우 페이지 및 버틍 자체가 필요없음
		if(total == 0) {
			this.totalPages = 0;
			this.startPage = 0;
			this.endPage = 0;
		} else {
			// 게시글 총 개수를 이용해 전체 페이지 개수부터 구하기
			totalPages = total / 10;
			if(total % 10 > 0) {
				// 만약 10개로 딱 떨어지지 않는다면
				// 마지막에 페이지를 하나 더 추가해야함
				totalPages += 1;
			}
			
			// 현재 보고있는 페이지 그룹의 시작 번호 구하기.
			int modVal = this.currentPage % 10;
			this.startPage = this.currentPage / 10 * 10 + 1;
			if(modVal == 0) {
				this.startPage -= 10;
			}
			
			// 해당 페이지 그룹의 끝 번호 구하기
			endPage = startPage + (10 - 1);
			// 단, 위에서 구한 명목상의 마지막 번호가
			// totalPages를 초과하는 경우는
			// totalPages로 대신 대입한다.
			if(endPage > totalPages) {
				endPage = totalPages;
			}
			
		}
	} // end constructor
	
	public int getTotal() {
		return total; // 총 글 개수 리턴
	}
	
	public boolean hasNoBoard() {
		return total == 0; // 게시물 표기가 불가능할 때 true 리턴
	}
	
	public boolean hasBoard() {
		return total > 0; // 게시물이 있을 때 true 리턴
	}
	
	public int getTotalPages() {
		return totalPages; //페이지의 총 개수 리턴
	}
	
	public List<BoardVO> getBoardList(){
		return boardList; // 패당 페이지의 표기할 글 목록 리턴
	}
	
	public int getStartPage() {
		return startPage; // 해당 페이지 그룹의 시작번호 리턴
	}
	
	public int getEndPage() {
		return endPage; // 헤당 페이지 그룹의 끝번호 리턴
	}

	@Override
	public String toString() {
		return "BoardPageDTO [total=" + total + ", currentPage=" + currentPage + ", boardList=" + boardList
				+ ", totalPages=" + totalPages + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
}
