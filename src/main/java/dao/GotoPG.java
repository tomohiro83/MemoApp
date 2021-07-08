package dao;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Fragments;

/**
 * Servlet implementation class GotoPG
 */
@WebServlet("/GotoPG")
public class GotoPG extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		String word = request.getParameter("contents");
		String check = request.getParameter("check");
		
		HttpSession session = request.getSession();
		
		if(word.isEmpty()) {
			
			if(check.equals("0")) {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);
				
			}else {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/fragment.jsp");
				dispatcher.forward(request, response);
			}
			
			
		}else {
		
		if(!check.equals("0")) {
				
				//コンテンツを登録
				Record.frag_push(check, word);
				
				//リストを更新する				
				List<Fragments> list = Record.get(check);
				session.setAttribute("fragment", list);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/fragment.jsp");
				dispatcher.forward(request, response);

				
				
//				そうでないなら改行を含んでいるかの判定
				}else {
					
					Pattern p = Pattern.compile("\r\n|[\n\r\u2028\u2029\u0085]");
					Predicate<String> predicate = p.asPredicate();
					
					if(!predicate.test(word)) {
						
						Record.title_push(word);
						
						List<Fragments> title_list = Record.getTitle();
						session.setAttribute("titles", title_list);
					}
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
					dispatcher.forward(request, response);
					
				}
				
				
			}
		
	}
}
