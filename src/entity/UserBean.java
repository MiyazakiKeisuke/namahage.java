package entity;

import java.io.Serializable;

public class UserBean implements Serializable {
	private String userId; //ユーザーID
	private String password; //パスワード

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
