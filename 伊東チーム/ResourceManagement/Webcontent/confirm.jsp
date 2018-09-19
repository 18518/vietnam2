<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>予約確認</title>
</head>
<body>
<jsp:useBean id="employee" scope="session" class:"dto.EmployeeDTO" />
<h2>予約確認画面</h2><br><br>
社員名：<jsp:getProperty name="employee" property="name"/>
<br>
貸出日時：<jsp:getProperty name="selectedReserveTermDTO" property="lendDate"/><br>
返却日時：<jsp:getProperty name="selectedReserveTermDTO" property="ReturnDate"/><br>
<table>
<tr>
<td> </td>
<td>リソース名</td>
</tr>
<c:forEach var="i" begin="1" end="${resourceDTO.size() }"step="1">
	<tr>

</table>
<form method="post" action="/ResourceManagement/ControllerServlet">
<input type ="hidden”name="COMMAND” value="COMPLETE" >
<input type ="submit”name="RESERVE” value="予約" >
</form><br>
<form method="get" action="/ResourceManagement/ControllerServlet">
<input type="hidden" name="COMMAND" value="RESERVE">
<br><input type ="submit"name="RESERVE" value="戻る" >
<input type ="submit"name="BACK" value="戻る" style="width: 58px; ">
</form><br>
<hr>
<form method="get" action="/ResourceManagement/ControllerServlet">
<input type ="hidden"name="COMMAND" value="MENU" >
<input type ="submit"name="MENU" value="メニュー" >
</form><br>
</body>
</html>