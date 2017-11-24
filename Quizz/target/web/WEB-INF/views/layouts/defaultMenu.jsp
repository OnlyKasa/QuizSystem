<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page session="true" %>

<div class="header-2">
    <nav class="navbar navbar-default">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <i class="fa fa-bars" aria-hidden="true"></i>
                </button>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <div class="navbar-right">
                    <ul class="nav navbar-nav flex-box">
                        <li class="username">
                            <a href="#">
                                <span class="text-overflow">
                                    <i class="fa fa-user" aria-hidden="true"></i>
                                    ${fullname}
                                </span>
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/auth/logout">
                                <i class="fa fa-sign-out" aria-hidden="true"></i>
                                <spring:message code="COMMON.label.logout"/>
                            </a>
                        </li>
                    </ul>
                </div>
                <ul class="nav navbar-nav navbar-main" id="menuContent">
                </ul>
            </div>
        </div>
    </nav>
</div>

<script id="templateMenuAdmin" type="text/template7">
    <li class="normal first-child">
        <a>ADMIN</a>
        <%--<div class="sub-menu">--%>
            <%--<ul class="flexbox container">--%>
                <%--<li><a onclick="redirectPage('payment','M01')" href="#"><span><spring:message code='MENU.M01' /></span></a></li>--%>
                <%--<li><a onclick="redirectPage('payment','M02')" href="#"><span><spring:message code='MENU.M02' /></span></a></li>--%>
                <%--<li><a onclick="redirectPage('company','M03')" href="#"><span><spring:message code='MENU.M03' /></span></a></li>--%>
            <%--</ul>--%>
        <%--</div>--%>
    </li>
</script>
<script id="templateMenuStudent" type="text/template7">
    <li class="normal first-child">
        <a>Student</a>
        <%--<div class="sub-menu">--%>
        <%--<ul class="flexbox container">--%>
        <%--<li><a onclick="redirectPage('payment','M01')" href="#"><span><spring:message code='MENU.M01' /></span></a></li>--%>
        <%--<li><a onclick="redirectPage('payment','M02')" href="#"><span><spring:message code='MENU.M02' /></span></a></li>--%>
        <%--<li><a onclick="redirectPage('company','M03')" href="#"><span><spring:message code='MENU.M03' /></span></a></li>--%>
        <%--</ul>--%>
        <%--</div>--%>
    </li>
</script>
<script id="templateMenuTeacher" type="text/template7">
    <li class="normal first-child">
        <a>Teacher</a>
        <%--<div class="sub-menu">--%>
        <%--<ul class="flexbox container">--%>
        <%--<li><a onclick="redirectPage('payment','M01')" href="#"><span><spring:message code='MENU.M01' /></span></a></li>--%>
        <%--<li><a onclick="redirectPage('payment','M02')" href="#"><span><spring:message code='MENU.M02' /></span></a></li>--%>
        <%--<li><a onclick="redirectPage('company','M03')" href="#"><span><spring:message code='MENU.M03' /></span></a></li>--%>
        <%--</ul>--%>
        <%--</div>--%>
    </li>
</script>
<script>
    var screenCode = "${screenCode}" ;
</script>
<script src="${pageContext.request.contextPath}/js/auth/menu.js"></script>