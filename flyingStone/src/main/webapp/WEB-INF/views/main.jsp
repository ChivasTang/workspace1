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

    <title>Home | flyingStone</title>

    <link type="text/css" rel="stylesheet" href="<c:url value="/css/site.css" />" media="all"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/fontawesome-all.min.css" />" media="all"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/lib/bootstrap/dist/css/bootstrap.min.css" />" media="all"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/lib/kendo/dist/styles/kendo.common.min.css" />" media="all"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/themes/theme_kendo_ui_bootstrap_v4.min.css" />" media="all"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/common.css" />" media="all"/>

    <script type="text/javascript" src="<c:url value="/lib/kendo/dist/js/jquery.min.js" />" charset="UTF-8"></script>
    <script type="text/javascript" src="<c:url value="/lib/kendo/dist/js/kendo.all.min.js" />" charset="UTF-8"></script>
    <script type="text/javascript" src="<c:url value="/lib/bootstrap/dist/js/bootstrap.min.js" />" charset="UTF-8"></script>
    <script type="text/javascript" src="<c:url value="/js/main.js" />" charset="UTF-8"></script>

    <link href="<c:url value="/lib/ikki/dist/img/favicon.png" />" rel="icon" type="image/png">
</head>
<body>
<%-- open widgets --%>
<input id="navCkb" class="hidden" type="checkbox">
<input id="menuCkb" class="hidden" type="checkbox">
<label for="navCkb" class="hidden"><span id="mask"></span></label>
<%-- close widgets --%>

<%-- open left nav --%>
<aside id="aside" class="theme-m-bg">
    <h1>FlyingStone</h1>
    <nav id="nav">
        <ul id="navPanelBar" class="nav-panel-bar"></ul>
        <ul id="navMenu" class="nav-menu"></ul>
    </nav>
</aside>
<%-- close left nav --%>

<%-- open main --%>
<main id="main" class="main">
    <%-- open header --%>
    <header id="header" class="theme-m">
        <label id="nav-toggle" for="navCkb"><i class="k-icon k-i-menu"></i></label>
        <label for="menuCkb"><i class="fas fa-ellipsis-h"></i></label>
        <h1>FlyingStone</h1>
        <nav id="path"></nav>
        <menu id="menuH"></menu>
        <menu id="menuV"></menu>
    </header>
    <%-- close header --%>

    <%-- open section --%>
    <section id="section" class="section">
        <footer id="footer">Powered by FlyingStone &amp; Brothers &copy; <script>document.write((new Date().getFullYear()-1)+"-"+(new Date().getFullYear()))</script> Learning Center</footer>
        <div id="inProgress" class="progress">
            <div class="progress-bar progress-bar-striped theme-m-bg"></div>
        </div>
        <div id="loading" class="k-loading-image hidden"></div>
    </section>
    <%-- close section --%>
</main>
<%-- close main --%>
<template id="template" class="hidden"></template>
</body>
</html>