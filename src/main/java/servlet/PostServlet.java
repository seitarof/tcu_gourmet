package servlet;

import java.io.IOException;

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
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 値を取得
		request.setCharacterEncoding("UTF-8");

		String shopName = request.getParameter("shopName");
		String photo = request.getParameter("picture");
		String review = request.getParameter("review");
		
		// セッションスコープに保存されたユーザ情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		
		int userID = loginUser.getUserID();
		Post post = new Post(userID, shopName, review, photo);
		PostDAO pDAO = new PostDAO();
		pDAO.createPost(post);
		
		// この時点ではPOST_IDがインスタンスに含まれていないため、インスタンスに含まれるようにする
		post = pDAO.readLastPost();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mainpage.jsp");
		dispatcher.forward(request, response);
	}
}
