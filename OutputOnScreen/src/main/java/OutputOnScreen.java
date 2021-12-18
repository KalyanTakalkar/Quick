

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/OutputOnScreen")
public class OutputOnScreen extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String fname = request.getParameter("fname");
			String mname = request.getParameter("mname");
			String lname = request.getParameter("lname");
			String fullName = fname+" "+mname+" "+lname;
			out.print("<html>"
					+ "<head>"
					+ "<title>Output</title>"
					+ "</head>"
					+ "<body>"
					+ "<h1>Hello  " + fullName
					+ "</h1>"
					+ "</body>"
					+ "</html>");
	}

}
