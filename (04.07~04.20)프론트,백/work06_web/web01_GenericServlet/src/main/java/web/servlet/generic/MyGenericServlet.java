package web.servlet.generic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// MyGenericServlet은 container/jvm/os/hardware  cgi
public class MyGenericServlet extends GenericServlet {

	// thread
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		out.println("<html><body><h2>");
		out.println("Hello GenericServlet");

		out.println("</html></body></h2>");

		out.close();
	}

}
