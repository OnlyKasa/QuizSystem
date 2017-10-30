<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><tiles:getAsString name="title" /></title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap-select.css"
          rel="stylesheet">
    <link
            href="${pageContext.request.contextPath}/css/bootstrap-datepicker3.css"
            rel="stylesheet">
    <link
            href="${pageContext.request.contextPath}/css/jquery.datetimepicker.css"
            rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css"
          rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/config.js"></script>
    <script src="${pageContext.request.contextPath}/js/lib/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/lib/template7.min.js"></script>
</head>

<body>
    <section class="page-wrap">
        <header class="header">
            <tiles:insertAttribute name="header" />
            <tiles:insertAttribute name="menu" />
        </header>
        <section class="container">
            <tiles:insertAttribute name="body" />
        </section>
    </section>
<tiles:insertAttribute name="footer" />
<script>

</script>
</body>
</html>