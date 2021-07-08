package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Record;

/**
 * Servlet implementation class GotoAsk
 */
@WebServlet("/GotoAsk")
public class GotoAsk extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		String check = request.getParameter("check");
			request.setAttribute("check", check);
		
		String title = request.getParameter("title");
			request.setAttribute("title", title);
		
		if(check.equals("title")) {
			
			String ask = "タイトル：" + title;
			request.setAttribute("ask", ask);
			
			String ask2 = "全て削除しますか？";
			request.setAttribute("ask2", ask2);
			
			String id = "all_title";
			request.setAttribute("id", id);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ask.jsp");
			dispatcher.forward(request, response);
			
		}else if(check.equals("frag")) {
			
			String id = request.getParameter("id");
			request.setAttribute("id", id);
			
			String fragment = Record.change_id_fragment(id);
			String ask = "【メモ】" + fragment;
			request.setAttribute("ask", ask);
			
			String ask2 = "このメモを削除しますか？";
			request.setAttribute("ask2", ask2);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ask.jsp");
			dispatcher.forward(request, response);
		}
	}

}
