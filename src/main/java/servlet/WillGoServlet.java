package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;
import DAO.*;

/**
 * Servlet implementation class WillGoServlet
 */
@WebServlet("/WillGoServlet")
public class WillGoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WillGoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 値を取得
		request.setCharacterEncoding("UTF-8");

		String willGoDate = request.getParameter("date");
		String inputPostID = request.getParameter("postID");
		int postID = Integer.parseInt(inputPostID);

		// セッションスコープに保存されたユーザ情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		int userID = loginUser.getUserID();
		WillGo willGo = new WillGo(postID, userID, willGoDate);
		WillGoDAO wDAO = new WillGoDAO();
		wDAO.createWillGo(willGo);

		// この時点ではPOST_IDがインスタンスに含まれていないため、インスタンスに含まれるようにする
		willGo = wDAO.readLastPost();

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mainpage.jsp");
		dispatcher.forward(request, response);
	}

}
