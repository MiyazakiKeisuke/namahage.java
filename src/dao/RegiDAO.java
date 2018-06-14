package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entity.EmployeeBean;

public class RegiDAO {

	public boolean regiEmp(EmployeeBean employee) {
		// booleanのregflgを用意し、初期化する
		boolean regiFlg = false;

		// SQL文を変数に格納
		String sql = "INSERT INTO ";
		sql +=  "m_employee";
		sql += "(";
		sql += "l_name,";
		sql += "f_name,";
		sql += "l_kana_name,";
		sql += "f_kana_name,";
		sql += "sex,";
		sql += "birth_day,";
		sql += "section_code,";
		sql += "emp_date";
		sql += ")";
		sql += " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		System.out.println(sql);


		// PreparedStatementで値のやり取りをするので定義する。
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, employee.getlName());
			System.out.println(employee.getlName());

			pstmt.setString(2, employee.getfName());
			System.out.println(employee.getfName());

			pstmt.setString(3, employee.getlKanaName());
			System.out.println(employee.getlKanaName());

			pstmt.setString(4, employee.getfKanaName());
			System.out.println(employee.getfKanaName());

			pstmt.setInt(5, employee.getSex());
			System.out.println(employee.getSex());

			pstmt.setString(6, employee.getBirthDay());
			System.out.println(employee.getBirthDay());

			pstmt.setString(7, employee.getSectionCode());
			System.out.println(employee.getSectionCode());

			pstmt.setString(8, employee.getEmpDate());
			System.out.println(employee.getEmpDate());

			// 登録完了したら値を返してもらう
			int completeId = pstmt.executeUpdate();

			// もし返ってくる値が0以上なら条件をtrueにし値をサーブレットに返す
			if (completeId > 0) {
				regiFlg = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("処理結果:異常が発生しました。");
		}
		return regiFlg;
	}
}