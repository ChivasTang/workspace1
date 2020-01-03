<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Login | FlyingStone</title>
</head>
<body>
<h1>Login | FlyingStone</h1>
<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
    <p style="color: #ff0000">
        Your login attempt was not successful due to <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
    </p>
</c:if>
<form name='loginForm' action="<c:url value='/login' />" method='POST'>
    Username <input type="text" name="username" title="" /><br />
    Password <input type="password" name="password" title="" /><br />
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /><br />
    <input type="submit" value="Submit">
</form>
</body>
</html>