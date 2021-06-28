package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*----------------------------------------------------------*/
		/*				
		 * マイページを表示する											*/
		//フォワード-->マイページ
		//getRequestDispatcherメソッドの指定パスが正しいか要確認
		/*															*/
		/*----------------------------------------------------------*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("webapp/Web-INF/mainpage.html");
		dispatcher.forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*----------------------------------------------------------*/
		/*															*/
		//投稿の処理を呼び出す
		//フォワード-->投稿処理ページ
		//getRequestDispatcherメソッドの指定パスが正しいか要確認
		/*															*/
		/*----------------------------------------------------------*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("webapp/login.jsp");
		dispatcher.forward(request,response);
	}

}
