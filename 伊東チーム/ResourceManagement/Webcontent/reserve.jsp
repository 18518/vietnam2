<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>リソース選択画面</title>
</head>
<body>

	<h2>リソース選択画面</h2>

	<br>貸出日時：${selectedReserveTearmDTO.lendDate}
	返却日時：${selectedReserveTearmDTO.returnDate}
	<br>
	<br>
	<form method="post" action="/ResourceManagement/ControllerServlet">
		<table border="1">
			<tr>
				<td></td>
				<th>リソース名</th>
			</tr>
			<c:forEach var="resource" items="availableResourceDTO">
				<tr>
					<td><input type="checkbox" name=${resource.resourceId }></td>
					<td>${resource.resourceName}></td>
				</tr>
			</c:forEach>
		</table>
		<br> <input type="submit" name="RESERVE" value="確認">
		     <input type="hidden" name="COMMAND" value="RESERVE">
	</form>
	<form method="post" action="/ResourceManagement/ControllerServlet">
		<input type="submit" name="AVAILABLERESOURCES" value="戻る">
		<input type="hidden" name="COMMAND" value="AVAILABLERESOURCES">
	</form>
	<form>
		method="post" action="/ResourceManagement/ControllerServlet">
		<input type="submit" name="MENU" value="メニュー">
		<input type="hidden"name="COMMAND" value="MENU"><br>
	</form>

</body>
</html>