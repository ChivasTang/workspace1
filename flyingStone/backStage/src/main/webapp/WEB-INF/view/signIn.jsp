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
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>login | FlyingStone</title>
    <script type="text/javascript" src=".../js/signIn.js" charset="UTF-8"></script>
    <link rel="icon" type="image/png" href="<c:url value="/WEB-INF/static/lib/ikki2000/dist/img/favicon.png" />">
</head>
<body>
<main>
    <h3>FlyingStone<small>社員管理システム</small></h3>
    <div>
        <form class="position-absolute" id="signIn">
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-user"></i></span>
                    </div>
                    <input class="form-control form-control-lg" name="username" type="text" placeholder="ユーザ名" required data-required-msg="ユーザ名を指定ください！" pattern="[A-Za-z0-9_\-\u4E00-\u9FA5]{6,20}" data-pattern-msg="アルファベット大文字、小文字、数字を長さ6-20を指定ください" title="">
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-key"></i></span>
                    </div>
                    <input class="form-control form-control-lg" name="password" type="password" placeholder="パスワード" required data-required-msg="パスワードを指定ください！" pattern="[A-Za-z0-9]{6,20}" data-pattern-msg="アルファベット大文字、小文字、数字を長さ6-20を指定ください" title="">
                </div>
            </div>
            <div class="form-group">
                <div id="verify"></div>
            </div>
            <div class="form-group">
                <div class="custom-control custom-checkbox custom-control-inline">
                    <input class="custom-control-input" id="remember" type="checkbox">
                    <label class="custom-control-label" for="remember">記憶する。</label>
                </div>
                <a class="float-right text-light" id="forgetPass" href="javascript:;">パスワードをリセット</a>
            </div>
            <div class="form-row">
                <div class="col-6">
                    <button class="btn btn-primary btn-lg btn-block" type="submit">ログイン</button>
                </div>
                <div class="col-6">
                    <button class="btn btn-secondary btn-lg btn-block toggle" type="button"><small>新規登録</small></button>
                </div>
            </div>
        </form>
    </div>
</main>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</body>
</html>
