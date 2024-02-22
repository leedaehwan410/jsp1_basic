package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//서블릿이 되기 위한 먗깆;
//URL 이 필요합니다.
@WebServlet(description="처음 만드는 서블릿",urlPatterns = { "/first.cc" })
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 로거를 작동시키기 위한 변수 선언 : 메소드 인자는 현재 클래스 이름
	private static final Logger logger = LoggerFactory.getLogger(FirstServlet.class);
	
       
 
    public FirstServlet() {
        super();
    }
//    get 요청을 처리하는 메소드 - 인자 타입 2개 xxxRequest, xxxResponse
//							 요청과 응답에 대한 처리를 할 수 있습니다.
//	 사용자 요청을 request 객체에 저장하면서 동시에 응답을 전달할 객체 response 가 만들어집니다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		//사용자의 요청에 대한 정보 출력 (request 객체의 속성값) : 로그 출력에서 {} 는 결과값 표시
		logger.info("\n[MyInfo] : request URL : {} , URI : {} , 컨텍스트패스 : {} " , 
		request.getRequestURL(),request.getRequestURI(), request.getContextPath());
		
		//테스트 : 서블릿에서 html 출력 응답도 만들어 봅니다.
		//out 은 jsp는 내장객체(선언없이 사용), 서블릿은 직접 생성 (response 객체로 생성합니다.)
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>WELCOME</title></head>");
		out.print("<body><h2>Hello world!!</h2>");
		out.print("현재 날짜와 시간 :" + LocalDateTime.now());
		out.print("</body>");
		out.print("</html>");
		
	}
}