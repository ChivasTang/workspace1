<!DOCTYPE html>
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

    <link type="text/css" rel="stylesheet" href="<c:url value="/lib/bootstrap/dist/css/bootstrap.min.css" />" media="all"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/lib/kendo/dist/styles/kendo.common.min.css" />" media="all"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/lib/kendo/dist/styles/kendo.bootstrap-v4.min.css" />" media="all"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="./lib/ikki/dist/css/fontawesome-all.min.css" />" media="all"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="./lib/ikki/dist/css/flag-icon.min.css" />" media="all"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="./lib/ikki/dist/css/weather-icons.min.css" />" media="all"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="./lib/ikki/dist/css/themes/theme_kendo_ui_bootstrap_v4.min.css" />" media="all"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="./lib/ikki/dist/css/amikoko.admin.css" />" media="all"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/common.css" />" media="all"/>

    <script type="text/javascript" src="<c:url value="/lib/kendo/dist/js/jquery.min.js" />" charset="UTF-8"></script>
    <script type="text/javascript" src="<c:url value="/lib/kendo/dist/js/kendo.all.min.js" />" charset="UTF-8"></script>
    <script type="text/javascript" src="<c:url value="/lib/bootstrap/dist/js/bootstrap.min.js" />" charset="UTF-8"></script>
    <script type="text/javascript" src="<c:url value="/js/main.js" />" charset="UTF-8"></script>
    
    <link href="<c:url value="/lib/ikki/dist/img/favicon.png" />" rel="icon" type="image/png">
</head>
<body>
<!-- 控件 -->
<input id="navCkb" type="checkbox">
<input id="menuCkb" type="checkbox">
<label for="navCkb"><span id="mask"></span></label>
<!-- 侧栏 -->
<aside class="theme-m-bg" id="aside">
    <h1>Kendo UI Admin by IKKI &amp; Amikoko</h1>
    <nav id="nav">
        <ul id="navPanelBar"></ul>
        <ul id="navMenu"></ul>
    </nav>
</aside>
<!-- 主体 -->
<main id="main">
    <!-- 头部 -->
    <header class="theme-m" id="header">
        <label for="navCkb"><i class="fas fa-bars"></i></label>
        <label for="menuCkb"><i class="fas fa-ellipsis-h"></i></label>
        <h1>Kendo UI Admin by IKKI &amp; Amikoko</h1>
        <nav id="path"></nav>
        <menu id="menuH"></menu>
        <menu id="menuV"></menu>
    </header>
    <!-- 内容 -->
    <section id="section">
        <!-- 脚部 -->
        <footer id="footer">Powered by FlyingStone &amp; learn &copy; <script>document.write((new Date().getFullYear()-1)+"-"+(new Date().getFullYear()))</script> UED Center</footer>
        <div class="progress" id="inProgress">
            <div class="progress-bar progress-bar-striped theme-m-bg"></div>
        </div>
        <div class="k-loading-image" id="loading"></div>
    </section>
</main>
<template id="template"></template>
</body>
</html>