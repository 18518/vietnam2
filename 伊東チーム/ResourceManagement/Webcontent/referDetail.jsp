<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="employee" scope="session" class="dto.EmployeeDTO" />
<jsp:useBean id="ｓelectedReserve" scope="session" class="dto.SelectedReserveDTO" />
<h2>予約明細画面</h2><br>
予約番号：<jsp:getProperty name="employee" property="reserveId"/><br>
社員名：<jsp:getProperty name="employee" property="name"/><br>
貸出日時：<jsp:getProperty name="selectedReserveTermDTO" property="lendDate"/><br>
返却日時：<jsp:getProperty name="selectedReserveTermDTO" property="returnDate"/><br>
<form method="post" action="/ResourceManagement/ControllerServlet">
<table>
<tr>
<td> </td>
<th>リソース名 </th>
</tr>
<c:forEach var="i" begin "1" end="${reserveDTOs.size()}" step="1">
<tr>
<td><input type="checkbox" name="種別" ></td>
<tr>${reserveDTO[i].resourceName}</tr>
</c:forEach>
</table>
<input type ="hidden" name="COMMAND" value="CANCEL" >
<input type ="submit"name="CANCEL" value="取り消し" >
</form>
<form method="get" action="/ResourceManagement/ControllerServlet">
<input type="hidden" name="COMMAND" value="REFER">
<input type ="submit" name="REFER" value="戻る" >
</form>
<hr>
<form method="get" action="/ResourceManagement/ControllerServlet">
<input type ="hidden"name="COMMAND" value="MENU">
<input type ="submit"name="MENU" value="メニュー" >
</form><br>
</body>
</html>