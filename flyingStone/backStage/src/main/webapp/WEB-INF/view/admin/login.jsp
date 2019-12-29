<%--
  Created by FlyingStone.
  User: tsk
  Date: 2019/12/25
  Time: 19:39
--%>
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
    <meta name="renderer" content="webkit">
    <meta name="force-rendering" content="webkit">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="theme-color" content="#ffffff">
    <title>login | FlyingStone</title>
    <base href="https://www.flying-stone.com/" type="admin">

    <link type="text/css" rel="stylesheet" href="<c:url value="/lib/ikki2000/dist/css/fontawesome-all.min.css" />" media="all"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/lib/bootstrap/dist/css/bootstrap.min.css" />" media="all"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/lib/ikki2000/dist/css/themes/theme_default.min.css" />" media="all"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/lib/ikki2000/dist/css/amikoko.admin.css" />" media="all"/>

    <script type="text/javascript" src="<c:url value="/lib/jQuery/dist/js/jquery.min.js" />" charset="UTF-8"></script>
    <script type="text/javascript" src="<c:url value="/lib/kendo/dist/js/kendo.all.min.js" />" charset="UTF-8"></script>
    <script type="text/javascript" src="<c:url value="/lib/kendo/dist/js/cultures/kendo.culture.ja.min.js" />" charset="UTF-8"></script>
    <script type="text/javascript" src="<c:url value="/lib/ikki2000/dist/js/ikki.js" />" charset="UTF-8"></script>

    <script type="text/javascript" src="<c:url value="/js/admin/login.js" />" charset="UTF-8"></script>
    <link rel="icon" type="image/png" href="<c:url value="/lib/ikki2000/dist/img/favicon.png" />">
</head>
<body id="login">
<main>
    <h3>FlyingStone<small>社員管理システム</small></h3>
    <div id="toggle">
        <form class="position-absolute" id="signIn">
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-user"></i></span>
                    </div>
                    <input class="form-control form-control-lg" name="userName" type="text" placeholder="用户名：Admin" required data-required-msg="请输入用户名！" pattern="[A-Za-z0-9_\-\u4E00-\u9FA5]{2,20}" data-pattern-msg="请输入2-20个大小写字母、数字、下划线或汉字！" title="">
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-key"></i></span>
                    </div>
                    <input class="form-control form-control-lg" name="password" type="password" placeholder="密码：IKKI2000" required data-required-msg="请输入密码！" pattern="[A-Za-z0-9]{6,20}" data-pattern-msg="请输入6-20个大小写字母或数字！" title="">
                </div>
            </div>
            <div class="form-group">
                <div id="verify"></div>
            </div>
            <div class="form-group">
                <div class="custom-control custom-checkbox custom-control-inline">
                    <input class="custom-control-input" id="remember" type="checkbox">
                    <label class="custom-control-label" for="remember">记住密码</label>
                </div>
                <a class="float-right text-light" id="forgetPass" href="javascript:;">忘记密码</a>
            </div>
            <div class="form-row">
                <div class="col-6">
                    <button class="btn btn-primary btn-lg btn-block" type="button" disabled>登&emsp;录</button>
                </div>
                <div class="col-6">
                    <button class="btn btn-secondary btn-lg btn-block toggle" type="button"><small>注册</small></button>
                </div>
            </div>
        </form>
    </div>
</main>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</body>
</html>
