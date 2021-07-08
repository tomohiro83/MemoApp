package dao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Fragments;

/**
 * Servlet implementation class UpdatePG
 */
@WebServlet("/UpdatePG")
public class UpdatePG extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		String check = request.getParameter("check");
		String new_contents = request.getParameter("contents");
		
//		title変更用
		String old_title = request.getParameter("title");
		
//		contents変更用
		String s_id = request.getParameter("id");
		String f_title = request.getParameter("f_title");
		
		if(check.equals("title")) {
			
			UpdateRecord.Title(old_title, new_contents);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			
		}else {
			
			UpdateRecord.fragment(s_id, new_contents);
			
			List<Fragments> list = Record.get(f_title);
			
			HttpSession session = request.getSession();
			session.setAttribute("fragment", list);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/fragment.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
