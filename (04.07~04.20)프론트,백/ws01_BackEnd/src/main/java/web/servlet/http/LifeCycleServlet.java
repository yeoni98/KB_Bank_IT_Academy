package web.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/Life" }, loadOnStartup = 1)
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LifeCycleServlet() {
		super();
		System.out.println("1. LifeCycleS호출...컨테이너에 의해서...");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		System.out.println("2. init()호출...컨테이너에 의해서...");
	}

	@Override
	public void destroy() {

		super.destroy();
		System.out.println("4.. destroy()호출...컨테이너에 의해서...");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("3. doGet()호출...컨테이너에 의해서...");


		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		System.out.println("3. doPost()호출...컨테이너에 의해서...");
	}

}
