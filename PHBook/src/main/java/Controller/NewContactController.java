package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ContactModel;
import been.Contact;


@WebServlet("/create-new-contact")
public class NewContactController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id =0;
		String name = request.getParameter("name");
		String contact = request.getParameter("contact");
		String dob = request.getParameter("dob");
		
		Contact co = new Contact();
		co.setId(id);
		co.setName(name);
		co.setContact(contact);
		co.setDob(dob);
		
		ContactModel CM = new ContactModel();
		boolean result = CM.create(co);
		

		request.setAttribute("result", result);
		RequestDispatcher dis = request.getRequestDispatcher("newcontact.jsp");
		dis.forward(request, response);		
		
	}

}
