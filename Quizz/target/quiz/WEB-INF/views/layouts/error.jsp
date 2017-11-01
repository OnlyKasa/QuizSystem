<%@ page pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ERROR-404</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-select.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-datepicker3.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/jquery.datetimepicker.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/font-awesome.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">

<link href="${pageContext.request.contextPath}/css/import.css"
	rel="stylesheet"/>
<link href="${pageContext.request.contextPath}/css/fontawesome.css"
	rel="stylesheet"/>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet"/>
</head>
<body>
	<section class="page-wrap">
		<header class="header">
			<div class="header-1">
				<img class="logo" src="${pageContext.request.contextPath}/img/logo.png" />
			</div>
		</header>

			<section class="container">
				<div class="wrap clearfix">
					<div class="text-error-404">
						<center>
							<img src="${pageContext.request.contextPath}/img/icon-404.png" alt="error-404">
						</center>
						<c:if test="${error==null}">
						<h2 class="error-h2">
							<spring:message code="ERROR_PAGE.label.Page_Not_Found" />
						</h2>
						<p>
							<spring:message code="ERROR_PAGE.label.Sorry_Page_Not_Exist" />
						</p>
						</c:if>
						<c:if test="${error!=null}">
							<h2 class="error-h2">
								Error: ${error.errMsg}
							</h2>
							<p>
								Level: ${error.level}
							</p>
						</c:if>
						<p>
							<spring:message code="ERROR_PAGE.label.Return_Home_Page" />
						</p>
						<br /> <a class="btn btn-success btn-error"
							href="${pageContext.request.contextPath}/#"><spring:message
								code="ERROR_PAGE.label.Go_Back_Home" /></a>
					</div>
				</div>
				<!--/wrap-->
			</section>
	<footer class="footer">
		<div class="footer__header">
			<div class="container">
				<p>マニュアル</p>
			</div>
		</div>
		<div class="footer__body">
			<div class="container">
				<p class="text">
					<span class="display-xs">©2014-2017 Fanatic Computers Inc.</span>
					All Rights Reserved
				</p>
			</div>
		</div>
	</footer>
	</section>
</body>
</html>