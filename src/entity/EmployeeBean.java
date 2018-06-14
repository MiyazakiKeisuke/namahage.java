package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/* データベース管理クラス
*
* @author emBex Education
* @version 1.00
*/
public class EmployeeBean implements Serializable {

	private int empCode; // 従業員コード
	private String lName; // 氏
	private String fName; // 氏（フリガナ）
	private String lKanaName; // 名
	private String fKanaName; // 名（フリガナ）
	private Boolean sex; // 性別
	private String birthDay; // 生年月日
	private String empDate; // 入社日
	private String sectionCode; // 所属コード
	private String sectionName; // 所属部署名

	public int getEmpCode() {
		return empCode;
	}

	public void setEmpCode(int empCode) {
		this.empCode = empCode;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlKanaName() {
		return lKanaName;
	}

	public void setlKanaName(String lKanaName) {
		this.lKanaName = lKanaName;
	}

	public String getfKanaName() {
		return fKanaName;
	}

	public void setfKanaName(String fKanaName) {
		this.fKanaName = fKanaName;
	}

	public int getSex() {
		int gender;
		if (this.sex) {
			gender = 0;
		} else {
			gender = 1;
		}
		return gender;
	}

	public void setSex(int gender) {
		if (gender == 0) {
			this.sex = true;
		} else {
			this.sex = false;
		}
	}

	public String getStrSex() {
		String gender;
		if (this.sex) {
			gender = "男性";
		} else {
			gender = "女性";
		}
		return gender;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getEmpDate() {
		return empDate;
	}

	public void setEmpDate(String empDate) {
		this.empDate = empDate;
	}

	public String getSectionCode() {
		return sectionCode;
	}

	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public void setStrBirthDay(Date birthDay) {
		this.birthDay = new SimpleDateFormat("yyyy年MM年dd日").format(birthDay);
	}

	public void setStrEmpDate(Date empDate) {
		this.empDate = new SimpleDateFormat("yyyy年MM年dd日").format(empDate);
	}
}