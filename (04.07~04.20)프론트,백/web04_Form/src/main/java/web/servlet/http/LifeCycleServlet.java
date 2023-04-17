package web.servlet.http;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Life")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public LifeCycleServlet() {
        super();
        
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
	}
	@Override
	public void destroy() {
		
		super.destroy();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
