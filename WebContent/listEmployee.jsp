<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="entity.EmployeeBean"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>従業員一覧</title>
</head>
<body>
	<div id="saba" class="box">
		<div class="formbox">
			<h1>従業員一覧</h1>
			<form action="delete" method="POST">
				<table>
					<tr class="item">
						<td class="red">削除</td>
						<td>従業員コード</td>
						<td>氏名</td>
						<td>氏名（フリガナ）</td>
						<td>性別</td>
						<td>生年月日</td>
						<td>所属部署</td>
						<td>入社日</td>
					</tr>

					<%
						List<EmployeeBean> employeeList = (List<EmployeeBean>) request.getAttribute("empl");
						for (EmployeeBean emp : employeeList) {
					%>

					<tr>
						<td><input type="radio" name="delete" required
							value="<%=emp.getEmpCode()%>"></td>
						<td><%=emp.getEmpCode()%></td>
						<td><%=emp.getlName()%> <%=emp.getfName()%></td>
						<td><%=emp.getlKanaName()%> <%=emp.getfKanaName()%></td>
						<td><%=emp.getStrSex()%></td>
						<td><%=emp.getBirthDay()%></td>
						<td><%=emp.getSectionName()%></td>
						<td><%=emp.getEmpDate()%></td>
					</tr>

					<%
						}
					%>

				</table>
				<br>
				<div class="btnbox tbbox">
					<input type="submit" value="削除" name="action">
			</form>
			<form action="list" method="POST">
				<span class="lbtn"><input type="submit" value="メニュー画面へ"
					name="action"></span>
			</form>
		</div>
	</div>
</body>
</html>