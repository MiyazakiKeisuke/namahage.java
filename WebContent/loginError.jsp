<!-- Izumi Shota -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">

<title>ログインに失敗しました</title>
</head>
<body>
	<div id="loginError" class="box">
		<div class="formbox">
			<h1>ログインに失敗しました</h1>
			<form action="login" method="post"> <!-- 送り先のサーブレットのマッピング名と送り方の指定 -->
				<div class="btnbox">
					<input type="submit" value="ログインに戻る" name="action">
				</div>
			</form>
		</div>
	</div>
</body>
</html>