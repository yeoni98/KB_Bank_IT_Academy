package web.servlet.life;

/*
 * Servlet API와
 * 컨테이너가 어떻게 CALLBACK 메소드를 호출하는지..순서 확인
 * 
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns={"/Life"}, loadOnStartup = 1) //pre loading 으로 할 거면 startup = 1
//@WebServlet("/Life")  // 주석 처리하면 d.d파일 못 불러오니까 실행 안 됨 (d.d파일 만들거나(servlet-mapping, anotation 하거나 둘 중 하나는 해야 됨)
class ServletLifeCycleTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int count = 0; // 필드 추가

    public ServletLifeCycleTest() {
    	System.out.println("1. 서블릿 객체 생성...컨테이너에 의해서...");
    }

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
    	System.out.println("2. init()호출...컨테이너에 의해서...");
	}

	public void destroy() {
    	System.out.println("4. destroy()호출...컨테이너에 의해서...호출 되고, 서블릿 죽고, 컨테이너 죽음");

		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("3. doGet()호출...컨테이너에 의해서...요청때마다 계속 호출");
    	// 클라이언트의 요청을 처리..
    	PrintWriter out = response.getWriter();
    	
    	out.println("<body bgcolor = 'yellow'>");
    	out.println("<h3>LifeCycle CallBack Method...</h3>");
    	out.println("<b>Count :: "+ ++count + "</b>");
    	out.println("</body>");
    	out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("3. doPost()호출...컨테이너에 의해서...요청때마다 계속 호출(get/post 둘 중 하나)");

	}

}
