<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>MENU</title>
</head>
<body>
	<div id="menu" class="box">
		<div class="formbox">
			<h1>メニューを選んでください</h1>
			<div class="btnbox menubtn">
				<ul>
					<li>
						<form action="list" method="POST">
							<input type="submit" class="btn" value="従業員一覧" name="action">
						</form>
					</li>

					<li>
						<form action="section" method="POST">
							<input type="submit" class="btn" value="新規登録" name="action">
						</form>
					</li>

					<li>
						<form action="logout" method="POST">
							<input type="submit" class="btn" value="ログアウト" name="action">
						</form>
					</li>
				</ul>
			</div>
		</div>
	</div>

</body>
</html>