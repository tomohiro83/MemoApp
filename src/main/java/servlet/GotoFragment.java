package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Record;
import model.Fragments;

/**
 * Servlet implementation class GotoFragment
 */
@WebServlet("/GotoFragment")
public class GotoFragment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	request.setCharacterEncoding("UTF-8");
	String title = request.getParameter("title");

//	各々のコンテンツページにタイトルを表示するためだけのモノ
	Fragments f = new Fragments();
	f.setTitle(title);
	
	HttpSession session = request.getSession();
	session.setAttribute("title", f);
	
	
	List<Fragments> list = Record.get(title);
	session.setAttribute("fragment", list);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/fragment.jsp");
	dispatcher.forward(request, response);
	
	
	}

}
