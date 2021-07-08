package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Goto
 */
@WebServlet("/Goto")
public class Goto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		String check = request.getParameter("check");

		switch (check) {

		case "write":
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/write.jsp");
			dispatcher.forward(request, response);

			break;
			
		case "return":
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/jsp/fragment.jsp");
			dispatcher2.forward(request, response);

			break;
			
		case "home":
			RequestDispatcher dispatcher3 = request.getRequestDispatcher("index.jsp");
			dispatcher3.forward(request, response);
			
			break;
			
		case "frag":
			RequestDispatcher dispatcher4 = request.getRequestDispatcher("/WEB-INF/jsp/fragment.jsp");
			dispatcher4.forward(request, response);
			
			break;
			
		case "title":
			RequestDispatcher dispatcher5 = request.getRequestDispatcher("/WEB-INF/jsp/fragment.jsp");
			dispatcher5.forward(request, response);
			
			break;
			
		
		}

	}

}
