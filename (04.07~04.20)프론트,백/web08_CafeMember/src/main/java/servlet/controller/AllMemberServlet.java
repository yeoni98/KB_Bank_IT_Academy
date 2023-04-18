package servlet.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

/**
 * Servlet implementation class AllMemberServlet
 */
@WebServlet("/AllMember")
public class AllMemberServlet extends HttpServlet {
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
        
        try {
        	ArrayList<MemberVO> list = MemberDAOImpl.getInstance().showAllMember();
        	request.setAttribute("list", list);
        	request.getRequestDispatcher("allView.jsp").forward(request, response);
        }catch(Exception e) {
        	
        }

}
}
