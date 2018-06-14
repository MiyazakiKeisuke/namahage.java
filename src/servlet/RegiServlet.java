package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegiDAO;
import entity.EmployeeBean;

/**
 * Servlet implementation class Regi
 */
@WebServlet("/regi")
public class RegiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegiServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// protected void doGet(HttpServletRequest request, HttpServletResponse
	// response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	// response.getWriter().append("Served at: ").append(request.getContextPath());
	// }

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
		System.out.println(action);

		// 委譲する先のjspを格納する変数url
		String url = "login.jsp";

		HttpSession session = request.getSession();

		if (session.getAttribute("userId") != null) {

			System.out.println(session.getAttribute("userId"));

			// regi.jspからの値が記入されたならDAOを介しDBから取得しrequestスコープに格納
			// 委譲先に「regi.jsp」を指定
			if ("登録する".equals(action)) {

				EmployeeBean employeeBean = new EmployeeBean();

				employeeBean.setlName(request.getParameter("l_name"));
				employeeBean.setfName(request.getParameter("f_name"));
				employeeBean.setlKanaName(request.getParameter("l_kana_name"));
				employeeBean.setfKanaName(request.getParameter("f_kana_name"));
				System.out.println(request.getParameter("sex"));
				employeeBean.setSex(Integer.parseInt(request.getParameter("sex")));
				employeeBean.setBirthDay(request.getParameter("birth_day"));
				employeeBean.setSectionCode(request.getParameter("section_code"));
				employeeBean.setEmpDate(request.getParameter("emp_date"));

				// DAOをインスタンス化
				RegiDAO dao = new RegiDAO();
				// DAOからのreturnをBeanのListに格納
				if (dao.regiEmp(employeeBean)) {

					// 委譲先の指定
					url = "regiComp.jsp";
				}

				// formからの値が「メニュー画面へ戻る」なら委譲先に「menu.jsp」を指定
			} else if ("メニュー画面へ戻る".equals(action)) {
				url = "menu.jsp";

			} else {
				url = "regiError.jsp";
			}
		}
		// リクエストの委譲
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
