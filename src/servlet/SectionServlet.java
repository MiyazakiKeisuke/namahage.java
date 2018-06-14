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

import dao.SectionDAO;
import entity.SectionBean;

/**
 * Servlet implementation class Section
 */
@WebServlet("/section")
public class SectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SectionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
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

		// 委譲する先のjspを格納する変数url
		String url = "login.jsp";
		HttpSession session = request.getSession();

		if (session.getAttribute("userId") != null) {

			System.out.println(session.getAttribute("userId"));
			// menからの値が「商品一覧」ならDAOを介しDBから取得しrequestスコープに格納
			// 委譲先に「itemlist.jsp」を指定
			if ("新規登録".equals(action)) {

				// DAOをインスタンス化
				SectionDAO dao = new SectionDAO();
				// DAOからのreturnをBeanのListに格納
				List<SectionBean> sectionList = dao.selectAll();
				// リクエストオブジェクトへの情報設定

				session = request.getSession();

				session.setAttribute("section", sectionList);
				// 委譲先の指定
				url = "regi.jsp";
				// formからの値が「メニュー画面へ戻る」なら委譲先に「menu.jsp」を指定
			} else if ("メニュー画面へ戻る".equals(action)) {
				url = "menu.jsp";

			}
		}
		// リクエストの委譲
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
