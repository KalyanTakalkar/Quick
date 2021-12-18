package org.Intutech.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Intutech.Been.Notes;
import org.Intutech.Been.Source;
import org.Intutech.model.QuickModel;

@WebServlet("/user-auth")
public class UserAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String uname = request.getParameter("uname");
			String upass = request.getParameter("upass");
		
			Source so = new Source();
			so.setName(uname);
			so.setPassword(upass);
			
			QuickModel model = new QuickModel();
			
			boolean ans = model.auth(so);
			int id = model.id(so);
			
			if(ans) {
				Notes no = new Notes();
				no.setSr(id);
				request.setAttribute("no", no);
				RequestDispatcher dis = request.getRequestDispatcher("view-notes");
				dis.forward(request, response);

			}else {
				response.sendRedirect("home.jsp?code=404");
			}
	}

}
