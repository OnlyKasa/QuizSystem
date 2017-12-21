<%--
  Created by IntelliJ IDEA.
  User: ben
  Date: 02/11/2017
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page session="false"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap-select.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap-datepicker3.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/jquery.datetimepicker.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>
<section class="page-wrap-2">
    <section id="mainContainer" class="container">
        <div class="clearfix"></div>
        <section class="management-login container box-x2-small">
            <div class="management-login_logo">
                <img src="${pageContext.request.contextPath}/img/logo-2.png"/>
            </div>
            <p id="txtErrorInform" class="message-error semi-hidden" ></p>
            <div class="mt40 relative">
                <input maxlength="100" class="form-control-gray selectpicker" id="txtUsername"
                       placeholder="<spring:message code='LOGIN.label.name'/>" />
                <p id="txtUsernameErr" class="message-error semi-hidden" ></p>
            </div>
            <div class="mt20 relative">
                <input type="password" class="form-control-gray" id="txtPassword" maxlength="100"
                       placeholder="<spring:message code='LOGIN.label.password'/>" />
                <p id="txtPasswordErr" class="message-error semi-hidden" > </p>
            </div>

            <div class="management-login_button row">
                <div class="col-xs-7 clear-padding-r">
                    <button id="btnLogin" class="btn btn-green btn-login"><spring:message code='LOGIN.label.button.login' /></button>
                </div>

                <div class="col-xs-5">
                    <button type="reset" class="btn btn-gray btn-clear" id="btnReset"><spring:message code='LOGIN.label.button.reset' /></button>
                </div>
            </div>

            <div class="management-login_forget-pw">
                <a class="txt-link txt-blue" href="${pageContext.request.contextPath}/auth/forget"><spring:message code='LOGIN.label.link.forgotPassword' /></a>
            </div>

            <div class="mt30 txt-center">
                <a href="${pageContext.request.contextPath}/auth/recommend" class="txt-hover mr20"><spring:message code='LOGIN.label.link.env' /></a>
                <a href="https://www.facebook.com/quanghi.95" class="txt-hover"><spring:message code='LOGIN.label.link.contact' /></a>
            </div>
        </section>
        <!-- /.management-login -->
        <!-- /.page-wrap -->
    </section>
</section>
<footer class="footer">
    <div class="footer__body">
        <div class="container">
            <p class="text">
                <span class="display-xs">©2017 Ben Computers Inc.</span>
                All Rights Reserved
            </p>
        </div>
    </div>
</footer>
<script>
    var contextPath = "${pageContext.request.contextPath}";
</script>
<script src="${pageContext.request.contextPath}/js/lib/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/lib/jquery.i18n.js"></script>
<script src="${pageContext.request.contextPath}/js/lib/jquery.i18n.messagestore.js"></script>
<script src="${pageContext.request.contextPath}/js/lib/jquery.i18n.fallbacks.js"></script>
<script src="${pageContext.request.contextPath}/js/lib/jquery.i18n.parser.js"></script>
<script src="${pageContext.request.contextPath}/js/lib/jquery.i18n.emitter.js"></script>
<script src="${pageContext.request.contextPath}/js/lib/jquery.i18n.language.js"></script>
<script src="${pageContext.request.contextPath}/js/lib/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/lib/bootstrap-select.js"></script>
<script src="${pageContext.request.contextPath}/js/jscustom.js"></script>
<script src="${pageContext.request.contextPath}/js/lib/jquery.redirect.js"></script>
<script src="${pageContext.request.contextPath}/js/validationUtil.js"></script>
<script src="${pageContext.request.contextPath}/js/config.js"></script>
<script src="${pageContext.request.contextPath}/js/auth/login.js"></script>
</body>
</html>