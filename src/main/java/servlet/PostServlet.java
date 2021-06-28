package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import DAO.*;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

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
		String userIDString = request.getParameter("userID");
		String shopName = request.getParameter("shopName");
		String photo = request.getParameter("picture");
		String review = request.getParameter("postText");
		int userID = Integer.parseInt(userIDString);
		Post post = new Post();
		post.setUserID(userID);
		post.setShopName(shopName);
		post.setPhotoPath(photo);
		post.setReview(review);
		PostDAO pDAO = new PostDAO();
		pDAO.createPost(post);
	}

}
