package org.Intutech.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Intutech.Been.Notes;
import org.Intutech.Been.Source;
import org.Intutech.model.QuickModel;


@WebServlet("/view-notes")
public class ViewNotes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Notes no =  (Notes) request.getAttribute("no");
		System.out.println("ID in view notes controller"+no);
		
		QuickModel model = new QuickModel();
		List<Notes> list = model.getAll(no);
		List<Source> user = model.get(no);
		
		request.setAttribute("contactList", list);
		request.setAttribute("user", user);
		RequestDispatcher dis = request.getRequestDispatcher("ViewNotes.jsp");
		dis.forward(request, response);
		
	}

}
