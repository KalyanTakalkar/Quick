

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/UserInput")
public class UserInput extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");	
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title> kalyan web first page in java </title>");
		out.print("</head>");
		out.print("<body>");	
		out.print("<form action='/Output_On_Screen/OutputOnScreen' method='post'>");
		out.print("Enter Your Frist Name<Input Type = 'Text' Name = fname><br><br>");
		out.print("Enter Your Middle Name<Input Type = 'Text' Name = mname><br><br>");
		out.print("Enter Your Last Name<Input Type = 'Text' Name = lname><br><br>");
		out.print("<Input Type = 'Submit'Value = 'Submit'>");
		out.print("</form>");
		out.print("</body>");
		out.print("</html>");

	}

}
