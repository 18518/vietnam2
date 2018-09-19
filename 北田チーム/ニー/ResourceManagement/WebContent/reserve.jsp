<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>リソース選択画面</title>
</head>
<style>
table, tr, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 15px;
}
</style>

</head>
<jsp:useBean id="lendDate" class="dto.ReserveTermDTO" scope="session" />
<jsp:useBean id="returnDate" class="dto.ReserveTermDTO" scope="session" />
<body>
	<div class="dropdown">
		<form method="post" action="/ResourceManagement/ControllerServlet">
			<h2>リソース選択画面</h2>

			貸出日時：
			<jsp:getProperty name="lendDate" property="year"/>年
			<jsp:getProperty name="lendDate" property="month" />月
			<jsp:getProperty name="lendDate" property="day" />日
			<jsp:getProperty name="lendDate" property="hour" />時
			<jsp:getProperty name="lendDate" property="minute" />分<br> <br>
			返却日時：
			${returnDate.year}年
			${returnDate.month}月
			${returnDate.day}日
			${returnDate.hour}時
			${returnDate.minute}分<br> <br>
			<table>
				<tr>
					<td bgcolor="grey"></td>
					<td text="black" bgcolor="grey">リソース名</td>
				</tr>
				<tr>
					<td><input type="checkbox"></td>
					<td>プロジェクター０２</td>
				</tr>
				<tr>
					<td><input type="checkbox"></td>
					<td>レーザーポインター０１</td>
				</tr>
				<tr>
					<td><input type="checkbox"></td>
					<td>レーサーポインター０３</td>
				</tr>
			</table>
			<br> <br>

			<button value="確認" class="dropbtn">確認</button>
			<input type="hidden" name="COMMAND" value="RESERVE">

		</form>
	</div>

	<form method="post" action="/ResourceManagement/ControllerServlet">

		<button value="戻る" class="dropbtn">戻る</button>
		<input type="hidden" name="COMMAND" value="AVAILABLERESOURCES">
	</form>

	<hr width="30%" align="left" />

	<div class="dropdown">
		<form method="post" action="/ResourceManagement/ControllerServlet">
			<button value="メニュー" class="dropbtn">メニュー</button>
			<input type="hidden" name="COMMAND" value="MENU">
		</form>
	</div>

</body>
</html>