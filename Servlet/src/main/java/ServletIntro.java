import javax.servlet.http.HttpServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

public class ServletIntro extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException{
		System.out.println("This is the service method of first servlet...........");
		System.out.println("Kalayn @ 123");
	}
}
