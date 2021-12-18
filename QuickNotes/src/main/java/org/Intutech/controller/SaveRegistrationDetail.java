package org.Intutech.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Intutech.Been.Source;
import org.Intutech.model.QuickModel;

@WebServlet("/save-details")
public class SaveRegistrationDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name");
		String email = request.getParameter("EMail");
		String pass = request.getParameter("Password");
		
		Source no = new Source();
		no.setId(0);
		no.setName(name);
		no.setEMail(email);
		no.setPassword(pass);
		
		QuickModel venue = new QuickModel();	
		
			boolean result = venue.save(no);
		
	
		response.sendRedirect("home.jsp");
	}

}
