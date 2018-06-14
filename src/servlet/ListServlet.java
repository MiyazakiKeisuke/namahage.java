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

import dao.EmployeeDAO;
import entity.EmployeeBean;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// GETリクエストはメニュー画面へ
		RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
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

		// リクエストからのパラメータ取り出し
		String action = request.getParameter("action");

		// 委譲する先のjspｗｐ格納する変数url
		String url = "login.jsp";

		HttpSession session = request.getSession();

		if (session.getAttribute("userId") != null) {

			System.out.println("userId");

			// formからの値が「従業員一覧」ならDAOを介しDBから取得しrequestスコープに格納
			// 委譲先に「listEmployee.jsp」を指定
			if ("従業員一覧".equals(action)) {

				// DAOをインスタンス化
				EmployeeDAO dao = new EmployeeDAO();

				// DAOからのreturnをBeanのLisrに格納
				List<EmployeeBean> employeeList = dao.selectAll();

				// リクエストオブジェクトへの情報設定
				request.setAttribute("empl", employeeList);

				// 委譲先の指定
				url = "listEmployee.jsp";

				// formからの値が「メニュー画面へ」なら委譲先に「menu.jsp」を指定
			} else if ("メニュー画面へ".equals(action)) {
				url = "menu.jsp";
			}
		}
		// リクエストの委譲
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}