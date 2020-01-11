<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <title>Login | flyingStone</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/lib/bootstrap/dist/css/bootstrap.min.css" />" media="all"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/lib/kendo/dist/styles/kendo.common.min.css" />" media="all"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/lib/kendo/dist/styles/kendo.bootstrap-v4.min.css" />" media="all"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/common.css" />" media="all"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/site.css" />" media="all"/>
    <script type="text/javascript" src="<c:url value="/lib/kendo/dist/js/jquery.min.js" />" charset="UTF-8"></script>
    <script type="text/javascript" src="<c:url value="/lib/kendo/dist/js/kendo.all.min.js" />" charset="UTF-8"></script>
    <script type="text/javascript" src="<c:url value="/lib/bootstrap/dist/js/bootstrap.min.js" />" charset="UTF-8"></script>
</head>
<body>
<header>
    <div class="container">
        <h1 class="">FlyingStone</h1>
    </div>
</header>

<div class="container">
    <div class="content">
        <form id="loginForm" name="loginForm" class="form" method="post" action="${pageContext.request.contextPath}/login">
            <div class="k-header">
                <h1 class="k-title">ログインForm</h1>
            </div>

            <div class="error">
                <c:if test="${not empty error}">
                    <div class="error">${error}</div>
                </c:if>
                <c:if test="${not empty msg}">
                    <div class="msg">${msg}</div>
                </c:if>
            </div>
            <ul class="fieldlist">
                <li>
                    <label for="username">ユーザ名</label>
                    <input id="username" type="text" class="k-textbox" style="width: 40%;" />
                </li>
                <li>
                    <label for="password">パースワード</label>
                    <input id="password" type="password" class="k-textbox" style="width: 40%;" />
                </li>
                <li>
                    <button class="k-button k-primary" type="submit">ログイン</button>&nbsp;
                    <a class="k-button" role="button" href="${pageContext.request.contextPath}/admin/register">新規登録</a>
                </li>
            </ul>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>
</div>
</body>
</html>