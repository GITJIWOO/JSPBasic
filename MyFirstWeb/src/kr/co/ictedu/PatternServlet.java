package kr.co.ictedu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class patternServlet2
 */
//*.do로 잡힌 패턴은 .do로 끝나는 접속주소를 모두 잡아옵니다.
//확장자패턴은 /를 빼고 작성합니다.
@WebServlet("*.do")
public class PatternServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatternServlet() {
        super();
        System.out.println("확장자 패턴 생성");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("확장자 패턴 연결");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("확장자 패턴 소멸");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	
	// 만약 요청 메서드(get, post) 상관 없이 처리하게 만들고 싶다면
	// 메서드 하나를 더 만들어서 요청한다.
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 확장자 패턴에서 확장자를 포함한 주소값을 가져오기 위해서
		// 아래 코드를 사용합니다.
		String uri = request.getRequestURI();
		System.out.println("uri패턴 : " + uri);
		
		// 콘솔이 아닌 사용자가 확인할 수 있도록 .jsp 화면에
		// 변수에 담긴 자료를 찍는 out.print(); 사용을 위한
		// 사전 준비
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// jsp페이지가 html형식으로 이뤄져 있음을 알려주는 코드
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(uri.equals("/MyFirstWeb/join.do")) {
			out.print("회원가입 요청 확인");
		} else if(uri.equals("/MyFirstWeb/login.do")) {
			out.print("로그인 요청 확인");
		} else if(uri.equals("/MyFirstWeb/update.do")) {
			out.print("수정 요청 확인");
		} else if(uri.equals("/MyFirstWeb/delete.do")) {
			out.print("탈퇴 요청 확인");
		} else {
			out.print("분류가 되지 않은 요청입니다.");
		}
		
		// PatternSerlet2의 패턴을 .do로 고쳐서 여기 옮겨주세요.
		if(uri.equals("/MyFirstWeb/write.do")) {
			out.print("글쓰기 창으로 이동합니다.");
		} else if(uri.equals("/MyFirstWeb/update.do")) {
			out.print("글 수정 창으로 이동합니다.");
		} else if(uri.equals("/MyFirstWeb/delete.do")) {
			out.print("글 삭제 창으로 이동합니다.");
		} else if(uri.equals("/MyFirstWeb/select.do")) {
			out.print("글 조회 창으로 이동합니다.");
		} else {
			out.print("잘못된 패턴입니다.");
		}
	}

}
