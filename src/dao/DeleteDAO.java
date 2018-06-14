/*
 * Java_
 * .java
 */

/**
 *
 * @author
 * @version 1.00
 */
package dao;

import java.sql.Connection;
import java.sql.Statement;

/**
 * DeleteDAOクラス
 *
 * @author Lisa Tanaka
 * @version 1.00
 */
public class DeleteDAO {

	public boolean deleteById(int delete) {

		boolean deleteFlg = false;
		try (Connection con = ConnectionManager.getConnection(); Statement stmt = con.createStatement();) {



			//SQLから情報を確認し、該当箇所を削除

			String sql = "Delete ";
			sql = sql + "FROM ";
			sql = sql + "m_employee ";
			sql = sql + "WHERE " ;
			sql=sql+"emp_code = ";
			sql = sql + delete;

			System.out.println(sql);

			int deleteId = stmt.executeUpdate(sql);

			if (deleteId > 0) {
				deleteFlg = true;

			}else {

			}

		} catch (Exception e) {
			System.out.println("処理結果:異常が見つかりました。");
		}

		return deleteFlg;
	}
}