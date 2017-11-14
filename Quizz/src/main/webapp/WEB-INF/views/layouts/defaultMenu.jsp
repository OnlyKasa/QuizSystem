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
												${fullName}
											</span>
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/auth/C108">
                                <i class="fa fa-sign-out" aria-hidden="true"></i> ログアウト
                            </a>
                        </li>
                    </ul>
                </div>
                <ul class="nav navbar-nav navbar-main">
                    <li class="normal first-child">
                        <a>Teacher Informtion</a>
                        <div class="sub-menu">
                            <ul class="flex-box container">
                                <li><a onclick="redirectPage('payment','M01')" href="#"><span><spring:message code='MENU.M01' /></span></a></li>
                                <li><a onclick="redirectPage('payment','M02')" href="#"><span><spring:message code='MENU.M02' /></span></a></li>
                                <li><a onclick="redirectPage('company','M03')" href="#"><span><spring:message code='MENU.M03' /></span></a></li>
                            </ul>
                        </div>
                    </li>

                    <li class="normal">
                        <a><spring:message code='MENU.M04.HEAD' /></a>
                        <div class="sub-menu">
                            <ul class="flex-box container">
                                <li><a onclick="redirectPage('billing','M04')" href="#"><span><spring:message code='MENU.M04' /></span></a></li>
                                <li><a onclick="redirectPage('billing','M05')" href="#"><span><spring:message code='MENU.M05' /></span></a></li>
                                <li><a onclick="redirectPage('billing','M06')"  href="#"><span><spring:message code='MENU.M06' /></span></a></li>
                                <li><a onclick="redirectPage('payment','M07')" href="#"><span><spring:message code='MENU.M07' /></span></a></li>
                                <li><a onclick="redirectPage('payment','M08')" href="#"><span><spring:message code='MENU.M08' /></span></a></li>
                            </ul>
                        </div>
                    </li>

                    <li class="normal">
                        <a><spring:message code='MENU.M09.HEAD' /></a>
                        <div class="sub-menu">
                            <ul class="flex-box container">
                                <li><a onclick="redirectPage('menu','M09')" href="#"><span><spring:message code='MENU.M09' /></span></a></li>
                                <li><a onclick="redirectPage('menu','M10')" href="#"><span><spring:message code='MENU.M10' /></span></a></li>
                                <li><a onclick="redirectPage('menu','M11')" href="#"><span><spring:message code='MENU.M11' /></span></a></li>
                                <li><a onclick="redirectPage('deliverymenu','M12')" href="#"><span><spring:message code='MENU.M12' /></span></a></li>
                                <li><a onclick="redirectPage('deliverymenu','M13')" href="#"><span><spring:message code='MENU.M13' /></span></a></li>
                            </ul>
                        </div>
                    </li>
                    <li class="normal">
                        <a><spring:message code='MENU.M14.HEAD' /></a>
                        <div class="sub-menu">
                            <ul class="flex-box container">
                                <li><a onclick="redirectPage('order','M14')" href="#"><span><spring:message code='MENU.M14' /></span></a></li>
                                <li><a onclick="redirectPage('order','M15')" href="#"><span><spring:message code='MENU.M15' /></span></a></li>
                                <li><a onclick="redirectPage('order','M16')" href="#"><span><spring:message code='MENU.M16' /></span></a></li>
                                <li><a href="#"><span><spring:message code='MENU.M17' /></span></a></li>
                                <li><a onclick="redirectPage('payment','M18')" href="#"><span><spring:message code='MENU.M18' /></span></a></li>
                            </ul>
                         </div>
                    </li>

                    <li class="normal">
                        <a><spring:message code='MENU.M19.HEAD' /></a>
                        <div class="sub-menu">
                            <ul class="flex-box">
                                <li><a onclick="redirectPage('company','M19')" href="#"><span><spring:message code='MENU.M19' /></span></a></li>
                                <li><a onclick="redirectPage('company','M20')" href="#"><span><spring:message code='MENU.M20' /></span></a></li>
                                <li><a onclick="redirectPage('company','M21')" href="#"><span><spring:message code='MENU.M21' /></span></a></li>
                                <li><a onclick="redirectPage('office','M22')" href="#"><span><spring:message code='MENU.M22' /></span></a></li>
                                <li><a onclick="redirectPage('office','M23')" href="#"><span><spring:message code='MENU.M23' /></span></a></li>
                                <li><a onclick="redirectPage('employee','M24')" href="#"><span><spring:message code='MENU.M24' /></span></a></li>
                                <li><a onclick="redirectPage('employee','M25')" href="#"><span><spring:message code='MENU.M25' /></span></a></li>
                            </ul>
                        </div>
                    </li>

                    <li class="normal">
                        <a><spring:message code='MENU.M26.HEAD' /></a>
                        <div class="sub-menu">
                            <ul class="flex-box">
                                <li><a onclick="redirectPage('foodcompany','M26')" href="#"><span><spring:message code='MENU.M26' /></span></a></li>
                                <li><a onclick="redirectPage('foodcompany','M27')" href="#"><span><spring:message code='MENU.M27' /></span></a></li>
                                <li><a onclick="redirectPage('store','M28')" href="#"><span><spring:message code='MENU.M28' /></span></a></li>
                                <li><a onclick="redirectPage('foodcompany','M29')" href="#"><span><spring:message code='MENU.M29' /></span></a></li>
                                <li><a onclick="redirectPage('order','M30')" href="#"><span><spring:message code='MENU.M30' /></span></a></li>
                                <li><a onclick="redirectPage('order','M31')" href="#"><span><spring:message code='MENU.M31' /></span></a></li>
                                <li><a onclick="redirectPage('foodcompany','M32')" href="#"><span><spring:message code='MENU.M32' /></span></a></li>
                                <li><a onclick="redirectPage('foodcompany','M33')" href="#"><span><spring:message code='MENU.M33' /></span></a></li>
                            </ul>
                        </div>
                    </li>

                    <li class="normal last-child">
                        <a><spring:message code='MENU.COMMON.HEAD' /></a>
                        <div class="sub-menu">
                            <ul class="flex-box">
                                <li><a onclick="redirectPage('system','M34')" href="#"><span><spring:message code='MENU.M34' /></span></a></li>
                                <li><a href="#"><span><spring:message code='MENU.M35' /></span></a></li>
                                <li><a href="#"><span><spring:message code='MENU.M36' /></span></a></li>
                                <li><a onclick="redirectPage('maintenance','M37')" href="#"><span><spring:message code='MENU.M37' /></span></a></li>
                                <li><a onclick="redirectPage('maintenance','M38')" href="#"><span><spring:message code='MENU.M38' /></span></a></li>
                                <li><a onclick="redirectPage('maintenance','M39')" href="#"><span><spring:message code='MENU.M39' /></span></a></li>
                                <li><a onclick="redirectPage('system','M40')" href="#"><span><spring:message code='MENU.M40' /></span></a></li>
                                <li><a onclick="redirectPage('system','M41')" href="#"><span><spring:message code='MENU.M41' /></span></a></li>
                                <li><a onclick="redirectPage('system','M42')" href="#"><span><spring:message code='MENU.M42' /></span></a></li>
                                <li><a onclick="redirectPage('system','M43')"><span><spring:message code='MENU.M43' /></span></a></li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
