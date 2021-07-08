package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UpdateRecord;

/**
 * Servlet implementation class GotoEdit
 */
@WebServlet("/GotoEdit")
public class GotoEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
		
		
	String old_title = request.getParameter("title");
	String check = request.getParameter("check");
	
	if(check.equals("title")) {
		
		request.setAttribute("edit_contents", old_title);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit_title.jsp");
		dispatcher.forward(request, response);
		
	}else {
		
//		idから断片を取得
		String fragment = UpdateRecord.get(id);
		
		request.setAttribute("edit_contents",fragment );
		request.setAttribute("edit_id",id );
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit_fragment.jsp");
		dispatcher.forward(request, response);
	}
	
	}

}
