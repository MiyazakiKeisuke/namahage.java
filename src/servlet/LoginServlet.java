package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストの委譲
		System.out.println("LoginServlet");
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストオブジェクトのエンコーディング方式の指定
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(); // Sessionを使用する宣言

		String url = "loginError.jsp"; // 委譲先

		String action = request.getParameter("action"); // ボタンを押下した際の処理を可能にする

		if ("ログイン".equals(action)) {
			// リクエストからのパラメータ取り出し
			String rcvUserId = request.getParameter("id");
			String rcvPassword = request.getParameter("password");

			LoginDAO loginDAO = new LoginDAO();

			String userId = loginDAO.loginName(rcvUserId, rcvPassword);

			if (userId != null) {
				url = "menu.jsp";
				// リクエストオブジェクトへの情報設定
				session.setAttribute("userId", userId);// Sessionを使用
			}
		} else if ("ログインに戻る".equals(action)) { // 押したボタンが「ログインに戻る」の場合の処理
			url = "login.jsp";
		}

		// リクエストの委譲
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
