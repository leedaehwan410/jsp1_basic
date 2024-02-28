package servlet.day3;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import project.dao.TblProductDao;
import project.vo.ProductVo;
import servlet.FirstServlet;

@WebServlet(urlPatterns = {"/productReg.cc"}, description = "상품 등록")
public class productReg extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = LoggerFactory.getLogger(productReg.class);


   //화면을 보여주는 서블릿이므로 GET
   @Override
   protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
	   logger.info("[MyInfo]상품등록 화면 요청되었습니다.");
	   //forward 만 필요합니다.
      RequestDispatcher dispatcher = req.getRequestDispatcher("/day3/productReg.jsp");
      dispatcher.forward(req, resp);
   }
   
   //register.jsp 화면에서 입력된 값을 post 방식으로 전달 받기
   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   logger.info("[MyInfo]고객등록 데이터 저장이 요청되었습니다.");
	   
	   //POST : 요청값 인코딩 필수 
	   req.setCharacterEncoding("UTF-8");
	   String pcode = req.getParameter("pcode");
	   String category = req.getParameter("category");
	   String pname = req.getParameter("pname");
	   String temp = req.getParameter("price");
	   //나이가 필수 입력이 아니라면 값이 비어 있습니다. 그 때 parseInt 결과 확인합시다. => 오류
	   int price = 0;
	   //form 태그 요소의 name="age" 가 있으므로 temp 가 null 일 경우는 없습니다. 
	   if(temp.length() !=0) 
		   price=Integer.parseInt(temp);
	   
	   //dao 의 메소드 인자로 전달할 vo 객체 생성하기
	   ProductVo vo = new ProductVo(pcode, category, pname, price);
	   logger.info("\t 입력 값 vo : {}",vo);
	   
	   //db에 저장하기
	   TblProductDao dao = new TblProductDao();
	   int result = dao.insert(vo);    //pk 아이디 중복값있으면 무결성 오류
    
	   // 서버가 클라이언트에게 "customers.cc로 요청을 보내라." 응답을 보냅니다.
//	   resp.sendRedirect("products.cc");   //=> 대신에 alert 출력
	   //리다이렉트는 웹페이지의 자바스크립트, out.print 출력을 못합니다.
	   
	   String message = "상품 등록이 완료되었습니다.";
	   if(result ==0)
		   message = "상품 등록 오류가 생겼습니다.";
	   
	   resp.setContentType("text/html; charset=UTF-8");
	   PrintWriter out = resp.getWriter();
	   out.print("<script>");
	   out.print("alert('"+message+"');");
	   out.print("location.href='products.cc';");
	   out.print("</script>");
		   
	   
   }
	
}