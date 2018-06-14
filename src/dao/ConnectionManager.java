package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * データベース管理クラス
 *
 * @author emBex Education
 * @version 1.00
 */
public class ConnectionManager {

	private final static String URL = "jdbc:mysql://192.168.20.45:3306/namahagedb?useSSL=false";
	private final static String USER = "namahage";
	private final static String PASSWORD = "namahageP2018!";

	/**
	 * DBの接続
	 *
	 * @return コネクション
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException, ClassNotFoundException {

		// JDBCドライバクラスの初期化処理
		Class.forName("com.mysql.jdbc.Driver");

		// コネクションの取得
		return DriverManager.getConnection(URL, USER, PASSWORD);

	}
}
