package servlet;

import java.io.IOException;
import java.util.Collections;
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
 * Servlet implementation class GotoReverse
 */
@WebServlet("/GotoReverse")
public class GotoReverse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	request.setCharacterEncoding("UTF-8");
	String check = request.getParameter("check");
	HttpSession session = request.getSession();
	
	if(check.equals("all_titles")) {
		
//		リストを取得
		List<Fragments> list = (List<Fragments>)session.getAttribute("titles");
		
		if(list == null) {
			
//		タイトルがまだ一つもない場合
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			
		}else {
			
//			逆順にする
			Collections.reverse(list);

//			更新
			session.setAttribute("titles", list);
			
//			index.jspで変更後のリストを使うための小細工
			request.setAttribute("reverse", "yes");
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}

		
		
	}else {

		List<Fragments> list = (List<Fragments>)session.getAttribute("fragment");

//		逆順にする
		Collections.reverse(list);

		session.setAttribute("fragment", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/fragment.jsp");
		dispatcher.forward(request, response);
	}
	

	
	}

}
