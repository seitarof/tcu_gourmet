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

import DAO.PostDAO;
import model.Post;
import model.User;

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
		
		// POSTデータベースから投稿を読み込む
		PostDAO postDAO = new PostDAO();
		List<Post> postList = postDAO.findAll();
		
		// セッションスコープに保存されたユーザ情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		
		if(loginUser == null) { // ログインしていない場合
			// リダイレクト
			response.sendRedirect("index.html");
		} else { // ログイン済みの場合
			RequestDispatcher dispatcher = request.getRequestDispatcher("webapp/Web-INF/mainpage.html");
			dispatcher.forward(request,response);
		}
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
		dispatcher.forward(request,response);
	}

}
