package servlet.login;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberVO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		//session 안에는 클라이언트를 구분하기 위한 고유값 jessionID
		System.out.println("JESSIONID:: " +session.getId());
		//
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		//비즈니스 로직 호출.. id, pswd가 있으면 vo 리턴
		MemberVO pvo = new MemberVO(id, password, "길복순", "여의도");
		
		//바인딩
		session.setAttribute("vo", pvo);
		response.sendRedirect("BuyServlet");
	}

}
