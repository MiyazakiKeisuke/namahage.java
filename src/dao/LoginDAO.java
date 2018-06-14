/*
 * namahage.java
 * EmployeeDAO.java
 */

package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDAO {

	public String loginName(String rcvUserId, String rcvPassword) {

		String userId = null;
		String sql = "SELECT * FROM m_user WHERE user_id = ? AND password = ?";

			try(Connection con  = ConnectionManager.getConnection();
					java.sql.PreparedStatement pstmt = con.prepareStatement(sql);) {

				pstmt.setString(1, rcvUserId);
				pstmt.setString(2, rcvPassword);

				ResultSet res = pstmt.executeQuery();

				while(res.next()) {
					userId = res.getString("user_id");
				}

			//SQLに関する例外処理
			} catch (SQLException | ClassNotFoundException e) {
				System.out.println("処理結果：異常が発生しました。");
				e.printStackTrace();
			}

			return userId;

	}

}
