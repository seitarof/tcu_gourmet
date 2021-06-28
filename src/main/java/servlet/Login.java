package servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import model.LoginLogic;
import model.User;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
<<<<<<< HEAD
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// リクエストパラメーターの取得
	request.setCharacterEncoding("UTF-8");
	String inputemail = request.getParameter("email");
	String inputpass = request.getParameter("pass");
	// メールアドレスとパスワードが正規か判断
	boolean emailIsRegular = inputemail.matches("^[a-zA-Z0-9_+-]+(.[a-zA-Z0-9_+-]+)*@([a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]*\\.)+[a-zA-Z]{2,}$");
	boolean passIsRegular = false;
	if(inputpass.length() >= 8) {
		passIsRegular = true;
	}
	// おかしければログインページにリダイレクト
	if(emailIsRegular == false || passIsRegular == false) {
		
	}
	
	// DAOを使って情報を引っ張る
	String userName;
	int userID;
	String userEmail;
	String userHashedPass;
	boolean userAdmin;
	UserDAO uDAO = new UserDAO();
	User user = uDAO.readUser(inputemail);
	userName = user.getName();
	userID = user.getUserID();
	userEmail = user.getEmail();
	userHashedPass = user.getHashedPass();
	userAdmin = user.isAdmin();
	LoginLogic loginLogic = new LoginLogic();
	boolean isLogin = loginLogic.execute(userEmail, inputemail, userHashedPass, inputpass);
	// Userインスタンスの生成
	User loginUser = new User(userName, userID, userEmail, userHashedPass, userAdmin);
	// DBと一致すればメインページに遷移
	if(isLogin == true){
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", loginUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}else{
		HttpSession session = request.getSession();
		session.setAttribute("emailIsRegular", emailIsRegular);
		session.setAttribute("passIsRegular", passIsRegular);
		response.sendRedirect("/tcu_gourmet/index.jsp");
	}
}

=======
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // リクエストパラメーターの取得
    request.setCharacterEncoding("UTF-8");
    String inputemail = request.getParameter("email");
    String inputpass = request.getParameter("pass");
    // メールアドレスとパスワードが正規か判断
    boolean emailIsRegular = inputemail.matches("^[a-zA-Z0-9_+-]+(.[a-zA-Z0-9_+-]+)*@([a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]*\\.)+[a-zA-Z]{2,}$");
    boolean passIsRegular = false;
    if(inputpass.length() >= 8) {
        passIsRegular = true;
    }
    // おかしければログインページにリダイレクト
    if(emailIsRegular == false || passIsRegular == false) {
        
    }
    
    // DAOを使って情報を引っ張る
    String userName;
    int userID;
    String userEmail;
    String userHashedPass;
    boolean userAdmin;
    UserDAO uDAO = new UserDAO();
    User user = uDAO.readUser(inputemail);
    userName = user.getName();
    userID = user.getUserID();
    userEmail = user.getEmail();
    userHashedPass = user.getHashedPass();
    userAdmin = user.isAdmin();
    LoginLogic loginLogic = new LoginLogic();
    boolean isLogin = loginLogic.execute(userEmail, inputemail, userHashedPass, inputpass);
    // Userインスタンスの生成
    User loginUser = new User(userName, userID, userEmail, userHashedPass, userAdmin);
    // DBと一致すればメインページに遷移
    if(isLogin){
        HttpSession session = request.getSession();
        session.setAttribute("loginUser", loginUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
        dispatcher.forward(request, response);
    } else {
        HttpSession session = request.getSession();
        session.setAttribute("emailIsRegular", emailIsRegular);
        session.setAttribute("passIsRegular", passIsRegular);
        response.sendRedirect("/tcu_gourmet/index.jsp");
    }
>>>>>>> 357fb3b1c74c131213e5496edb6b02ac15a276b7
}
}