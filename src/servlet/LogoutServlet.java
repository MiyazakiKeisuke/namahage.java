package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// リクエストオブジェクトのエンコーディング方式の指定
		request.setCharacterEncoding("UTF-8");

		// リクエストからのパラメーター取り出し
		String action = request.getParameter("action");


		// 委譲する先のjspを格納する変数url
		String url = "login.jsp";

		// 委譲先の指定
		url = "login.jsp";
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		if(userId != null) {

			// formからの値が「ログアウト」なら移譲先に「logout.jsp」を指定
			if ("ログアウト".equals(action)) {
				session.removeAttribute("userId");
				System.out.println(userId);
				url = "logout.jsp";
			}
		}

		// リクエストの委譲
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}