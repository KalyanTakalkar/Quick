package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ContactModel;
import been.Contact;

@WebServlet("/my-contact-list")
public class ViewContactController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactModel model = new ContactModel();
		List<Contact> list = model.getAll();
		
		request.setAttribute("contactList", list);
		RequestDispatcher dis = request.getRequestDispatcher("viewcontact.jsp");
		dis.forward(request, response);
		
	}

}
