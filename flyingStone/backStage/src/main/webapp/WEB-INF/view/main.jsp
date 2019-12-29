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
    <title>Home | FlyingStone</title>

    <link type="text/css" rel="stylesheet" href="<c:url value="/lib/bootstrap/dist/css/bootstrap.min.css" />" media="all"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/lib/bootstrap/dist/css/bootstrap-theme.min.css" />" media="all"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/lib/kendo/dist/css/kendo.bootstrap.min.css" />" media="all"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/lib/kendo/dist/css/kendo.common-bootstrap.min.css" />" media="all"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/common.css" />" media="all"/>

    <script type="text/javascript" src="<c:url value="/lib/jQuery/dist/js/jquery.min.js" />" charset="UTF-8"></script>
    <script type="text/javascript" src="<c:url value="/lib/jQuery/dist/js/jquery.i18n.properties.min.js" />" charset="UTF-8"></script>
    <script type="text/javascript" src="<c:url value="/lib/bootstrap/dist/js/bootstrap.min.js" />" charset="UTF-8"></script>
    <script type="text/javascript" src="<c:url value="/lib/kendo/dist/js/kendo.all.min.js" />" charset="UTF-8"></script>
    <script type="text/javascript" src="<c:url value="/lib/kendo/dist/js/kendo.mobile.min.js" />" charset="UTF-8"></script>
    <script type="text/javascript" src="<c:url value="/js/common.js" />" charset="UTF-8"></script>
    <script type="text/javascript" src="<c:url value="/js/main.js" />" charset="UTF-8"></script>

    <link rel="icon" type="image/png" href="<c:url value="/lib/ikki2000/dist/img/favicon.png" />">
</head>
<body>
<div class="container-fluid">

    <div class="k-header">
        <div id="locale"></div>
    </div>
    <div class="k-content">
        <div id="imageViewerGrid"></div>
    </div>
    <div class="k-footer">This is Footer</div>
</div>
</body>
</html>