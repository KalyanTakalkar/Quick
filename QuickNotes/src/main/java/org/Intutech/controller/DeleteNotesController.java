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

@WebServlet("/delete-contact")
public class DeleteNotesController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			int id = Integer.parseInt(request.getParameter("id"));
			QuickModel model = new QuickModel();
			boolean result = model.delete(id);
			if(result) {
				request.setAttribute("code", "150");
			}else {
				request.setAttribute("code", "160");
			}
			Notes no = new Notes();
			no.setSr(id);
			request.setAttribute("no", no);
			RequestDispatcher dis = request.getRequestDispatcher("view-notes");
			dis.forward(request, response);

	}

}
