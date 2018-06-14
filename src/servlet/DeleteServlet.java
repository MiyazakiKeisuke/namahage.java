package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DeleteDAO;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストのオブジェクトのエンコーディング方式の指定
		request.setCharacterEncoding("UTF-8");

		// リクエストからのパラメータ取り出し
		int delete = Integer.parseInt(request.getParameter("delete"));
		String action = request.getParameter("action");

		// 委譲する先のjsp格納する変数
		String url = "login.jsp";
		HttpSession session = request.getSession();

		if (session.getAttribute("userId") != null) {

			System.out.println(session.getAttribute("userId"));

			// formからの値をDAOを介し取得し「0以上なら」deleteComp.jspへ
			// formからの値をDAOを介し取得し「0なら」deleteError.jsp
			if ("削除".equals(action)) {
				System.out.println(action);
				DeleteDAO dao = new DeleteDAO();

				if (dao.deleteById(delete)) {
					url = "deleteComp.jsp";
				} else {
					url = "deleteError.jsp";

				}
			}

		}
		// リクエストの委譲
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}
}
