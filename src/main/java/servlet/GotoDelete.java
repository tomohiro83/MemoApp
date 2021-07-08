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

import dao.Edit;
import dao.Record;
import model.Fragments;

/**
 * Servlet implementation class GotoDelete
 */
@WebServlet("/GotoDelete")
public class GotoDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String check = request.getParameter("check");
		HttpSession session = request.getSession();
		
//	断片の削除要請なら
		if(check.equals("frag")) {
			
			Edit.frag_Delete(id);
			
//			リストを更新
			List<Fragments> list = Record.get(title);
			
//		リストが空でなければfragment.jspへ
			if(!list.isEmpty()) {
				
				session.setAttribute("fragment", list);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/fragment.jsp");
				dispatcher.forward(request, response);
				
			}else {
				
//		リストが空ならt1からタイトルを削除してindex.jspへ
				Edit.title_Delete(title);
				
				List<Fragments> title_list = Record.getTitle();
				session.setAttribute("titles", title_list);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			
			}
			
//タイトル以下全削除なら			
		}else {
			
			Edit.all_Delete(title);
			Edit.title_Delete(title);
			
			List<Fragments> title_list = Record.getTitle();
			session.setAttribute("titles", title_list);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			
		}
	}

}
