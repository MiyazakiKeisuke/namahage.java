package entity;

import java.io.Serializable;

public class SectionBean implements Serializable{

	private String sectionCode;
	private String sectionName;

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

}
