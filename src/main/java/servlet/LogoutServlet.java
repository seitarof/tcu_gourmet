package servlet;

import java.io.IOException;
<<<<<<< HEAD

import javax.servlet.RequestDispatcher;
=======
>>>>>>> 357fb3b1c74c131213e5496edb6b02ac15a276b7
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
import javax.servlet.http.HttpSession;
=======
>>>>>>> 357fb3b1c74c131213e5496edb6b02ac15a276b7

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		// セッションスコープを破棄
		HttpSession session = request.getSession();
		session.invalidate();
		
		// index.jspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/tcu_gourmet/index.jsp");
		dispatcher.forward(request, response);
=======
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
>>>>>>> 357fb3b1c74c131213e5496edb6b02ac15a276b7
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD

=======
		// TODO Auto-generated method stub
		doGet(request, response);
>>>>>>> 357fb3b1c74c131213e5496edb6b02ac15a276b7
	}

}
