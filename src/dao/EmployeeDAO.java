package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.EmployeeBean;

public class EmployeeDAO {
	/*
	 * Employeeテーブルのレコードを取得する
	 *
	 * @return EmployeeBeanのリスト
	 */
	public List<EmployeeBean> selectAll() {

		List<EmployeeBean> empList = new ArrayList<EmployeeBean>();

		try (Connection con = ConnectionManager.getConnection(); Statement stmt = con.createStatement()) {

			String sql = "SELECT ";
			sql = sql + "t2.emp_code,";
			sql = sql + "t2.l_name,";
			sql = sql + "t2.f_name,";
			sql = sql + "t2.l_kana_name,";
			sql = sql + "t2.f_kana_name,";
			sql = sql + "t2.sex,";
			sql = sql + "t2.birth_day,";
			sql = sql + "t1.section_name,";
			sql = sql + "t2.emp_date";
			sql = sql + " FROM ";
			sql = sql + "m_section t1 JOIN ";
			sql = sql + "m_employee t2 on ";
			sql = sql + "t1.section_code = t2.section_code";
			sql = sql + " ORDER BY t2.emp_code";


			ResultSet res = stmt.executeQuery(sql);

			System.out.println(sql);

			// 結果の操作
			while (res.next()) {

				EmployeeBean emp = new EmployeeBean();
				emp.setEmpCode(res.getInt("emp_code"));
				emp.setlName(res.getString("l_name"));
				emp.setfName(res.getString("f_name"));
				emp.setlKanaName(res.getString("l_kana_name"));
				emp.setfKanaName(res.getString("f_kana_name"));
				emp.setSex(res.getInt("sex"));
				emp.setStrBirthDay(res.getDate("birth_day"));
				emp.setSectionName(res.getString("section_name"));
				emp.setStrEmpDate(res.getDate("emp_date"));

				empList.add(emp);
			}

			// SQLに関する例外処理
		} catch (Exception e) {
			System.out.println("処理結果：異常が発生しました。");
			e.printStackTrace();
		}

		return empList;

	}

	private String getString(String string) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
