package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.SectionBean;


public class SectionDAO {
	public List<SectionBean> selectAll() {
		//List<ItemBean> インスタンス化
		List<SectionBean> sectionList = new ArrayList<SectionBean>();
		//try catch構文
		try (Connection con = ConnectionManager.getConnection(); Statement stmt = con.createStatement()) {
			String sql = "SELECT section_code, section_name FROM m_section;";

			//結果の操作(参照系)
			ResultSet res = stmt.executeQuery(sql);

			while (res.next()) {
				SectionBean section = new SectionBean();
				section.setSectionCode(res.getString("section_code"));
				section.setSectionName(res.getString("section_name"));


				sectionList.add(section);
			}
		//SQLに関する例外処理
		} catch (Exception e) {
			System.out.println("処理結果：異常が発生しました。");
			e.printStackTrace();
		}
		return sectionList;

	}

}
