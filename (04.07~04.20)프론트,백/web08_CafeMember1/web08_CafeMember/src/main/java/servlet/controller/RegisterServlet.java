package servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;


@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// logic 정리
    	
    	//서블릿이 하는 일
    	/*
    	 * 1. 양방향 한글 처리
    	 * 2. form 값 받는다. 
    	 * 3. (VO객체 생성)
    	 * 4.DAO 리턴 받아서 비즈니스 로직 호출 => 가장 중요   
    	 * 5. Attribute  = 반환 값
    	 * 6. 페이지 네비게이션
    	 * 
    	 */
    	//$ 처음에 서블릿 생성(3)
   	 //* 1. 양방향 한글 처리
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//2. form 값 받는다. 
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        
        //3.(VO객체 생성)
        MemberVO pvo = new MemberVO(id,password,name,address);
        
        //4. DAO리턴 받아서 비즈니스 로직 츨략
        try {
        	MemberDAOImpl.getInstance().registerMember(pvo);
			
		} catch (Exception e) {
			//request.getRequestDispatcher("register_result.jsp").forward(request, response);
			response.sendRedirect("AllMember"); // 새로운 요청이 다시 서블릿으로 들어간다.
			//브라우저 거친다 == 새롭게 서블릿을 요청한다. "register_result.jsp를 allView.jsp로 바꾸면 안 되는데 이런식으로 redirect는 가능.
		}
        
    
    }
}
