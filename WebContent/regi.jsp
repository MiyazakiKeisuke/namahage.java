<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="entity.SectionBean"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>新規登録</title>
</head>
<body>

	<%
		List<SectionBean> sectionList = (List<SectionBean>) session.getAttribute("section");
	%>
	<div id="entry" class="box">
		<div class="formbox">
			<h1>新規登録</h1>

			<form action="regi" method="POST">

				<dl class="entrybox">
					<dt>
						氏名<span class="required">(必須)</span>
					</dt>
					<dd>
						<input type="text" name="l_name" placeholder="姓" pattern="[^\x20-\x7E]*" maxlength='16' required>
						<input type="text" name="f_name" placeholder="名" pattern="[^\x20-\x7E]*" maxlength='16'  required>
					</dd>

					<dt>
						フリガナ<span class="required" >(必須)</span>
					</dt>
					<dd>
						<input type="text" name="l_kana_name" pattern="[\u30A1-\u30FF]*" maxlength='16' required>
						<input type="text" name="f_kana_name" pattern="[\u30A1-\u30FF]*" maxlength='16' required>
					</dd>

					<dt>
						性別<span class="required">(必須)</span>
					</dt>
					<dd>
						<label class="sex"><input type="radio" name="sex"
							value="0" required>男性</label> <label class="sex"><input
							type="radio" name="sex" value="1" required>女性</label>
					</dd>

					<dt>生年月日<span class="required" >(必須)</span></dt>
					<dd>
						<input type="date" name="birth_day" placeholder="生年月日" max="2018-03-09" required>
					</dd>


					<dt>所属部署名<span class="required">(必須)</span></dt>
					<dd>
						<select name="section_code" required>
						<option value="">選択して下さい。</option>
							<%
								for (SectionBean section : sectionList) {
							%>
							<option value="<%=section.getSectionCode()%>"><%=section.getSectionName()%></option>
							<%
								}
							%>
						</select>
					</dd>

					<dt>入社日<span class="required" >(必須)</span></dt>
					<dd>
						<input type="date" name="emp_date" placeholder="入社日" required >
					</dd>
				</dl>

				<div class="btnbox">
					<div class="btnleft">
						<input type="submit" value="登録する" name="action">
					</div>
				</form>
			<div class="btnright">
				<form action="regi" method="POST">
					<input type="submit" value="メニュー画面へ戻る" name="action">
				</form>
			</div>
		</div>
	</div>
</body>
</html>