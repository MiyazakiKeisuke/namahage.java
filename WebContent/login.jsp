<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">

<title>ログイン</title>
</head>
<body>
	<div id="login" class="box">
		<div class="formbox">
			<h1>ログイン</h1>
			<div align="center">
				<form action="login" method="post">
					<p class="text">ユーザーIDとパスワードを入力してください。</p>
					<dl>
						<dt>ユーザID</dt>
						<dd>
							<input type="text" placeholder="" name="id">
						</dd>
					</dl>
					<dl>
						<dt>パスワード</dt>
						<dd>
							<input type="password" placeholder="" name="password">
						</dd>
					</dl>
					<div class="btnbox logbtn">
						<input type="submit" value="ログイン" name="action">
				</form>
				<input type="reset" value="取消">
			</div>

		</div>
	</div>
</body>
</html>

