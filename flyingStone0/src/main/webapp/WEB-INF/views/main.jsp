<!DOCTYPE html>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html lang="ja">
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
	<title>Home | flyingStone</title>
	
</head>
<body>
<h1>これはホームページです。</h1>
<c:out value="${msg}"></c:out>
<table>
<tr>
<td>番号</td>
<td>氏名</td>
</tr>
<c:forEach items="${employees}" var="employee">
	<tr>
	<td><c:out value="${employee.empNo}"></c:out></td>
	<td><c:out value="${employee.name}"></c:out></td>
	</tr>
</c:forEach>
</table>

</body>
</html>