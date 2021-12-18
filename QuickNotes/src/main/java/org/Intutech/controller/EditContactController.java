package org.Intutech.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Intutech.Been.Notes;
import org.Intutech.model.QuickModel;


@WebServlet("/edit-contact")
public class EditContactController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			int id = Integer.parseInt(request.getParameter("id"));
			Notes no = new Notes();
			QuickModel model = new QuickModel();
			boolean contact = model.editById(id, no);
			
			request.setAttribute("contact", contact);
			RequestDispatcher dis = request.getRequestDispatcher("editcontact.jsp");
			dis.forward(request, response);
	}

}
