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

@WebServlet("/save-notes")
public class SaveNotes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String dis = request.getParameter("dis");
		
		Notes no = new Notes();
		no.setSr(id);
		no.setTital(title);
		no.setDis(dis);
		
		QuickModel model = new QuickModel();
		
		boolean result = model.saveNotes(no);
		if(result){
			Notes no1 = new Notes();
			no1.setSr(id);
			request.setAttribute("no", no1);
			RequestDispatcher disp = request.getRequestDispatcher("view-notes");
			disp.forward(request, response);

		}else {
			response.sendRedirect("ViewNotes.jsp?code=102");
		}
	}

}
