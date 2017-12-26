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
    <li id="menu_teacher"  class="first-child">
        <a href="${pageContext.request.contextPath}/admin/a106">Quản lý giáo viên</a>
    </li>
    <li  id="menu_student" class="normal">
        <a href="${pageContext.request.contextPath}/admin/a107">Quản lý sinh viên</a>
    </li>
    <li  id="menu_examination" class="normal">
        <a>Quản lý kỳ thi</a>
        <div class="sub-menu">
        <ul class="flex-box">
            <li  id="sub_menu_examination"  ><a href="${pageContext.request.contextPath}/admin/a101"><span>Quản lý kỳ thi</span></a></li>
            <li id="sub_menu_difficulty" ><a   href="${pageContext.request.contextPath}/admin/a102"><span>Quản lý độ khó</span></a></li>
            <li id="sub_menu_tests"><a   href="${pageContext.request.contextPath}/admin/a103"><span>Danh sách bài thi</span></a></li>
            <li id="sub_menu_question" ><a  href="${pageContext.request.contextPath}/admin/a104"><span>Quản lý câu hỏi</span></a></li>
            <li id="sub_menu_subject"><a href="${pageContext.request.contextPath}/admin/a105"><span> Quản lý môn học</span></a></li>
        </ul>
        </div>
    </li>
    <li  id="menu_room" class="normal">
        <a href="${pageContext.request.contextPath}/admin/a108">Quản lý phòng thi</a>
    </li>
    <li  id="menu_faculty" class="last-child">
        <a href="${pageContext.request.contextPath}/admin/a109">Quản lý khoa</a>
    </li>
</script>
<script id="templateMenuStudent" type="text/template7">
    <li id="sub_menu_examintion"  class="first-child">
        <a>Danh sách kỳ thi</a>
    </li>
    <li  id="sub_menu_tests" class="last-child">
        <a>Danh sách bài thi</a>
    </li>
</script>
<script id="templateMenuTeacher" type="text/template7">
    <li  id="menu_student" class="normal">
        <a href="${pageContext.request.contextPath}/admin/a107">Quản lý sinh viên</a>
    </li>
    <li  id="menu_examination" class="normal">
        <a>Quản lý kỳ thi</a>
        <div class="sub-menu">
            <ul class="flex-box">
                <li  id="sub_menu_examination"  ><a href="${pageContext.request.contextPath}/admin/a101"><span>Quản lý kỳ thi</span></a></li>
                <li id="sub_menu_difficulty" ><a   href="${pageContext.request.contextPath}/admin/a102"><span>Quản lý độ khó</span></a></li>
                <li id="sub_menu_tests"><a   href="${pageContext.request.contextPath}/admin/a103"><span>Danh sách bài thi</span></a></li>
                <li id="sub_menu_question" ><a  href="${pageContext.request.contextPath}/admin/a104"><span>Quản lý câu hỏi</span></a></li>
                <li id="sub_menu_subject"><a href="${pageContext.request.contextPath}/admin/a105"><span> Quản lý môn học</span></a></li>
            </ul>
        </div>
    </li>
    <li  id="menu_room" class="normal">
        <a href="${pageContext.request.contextPath}/admin/a108">Quản lý phòng thi</a>
    </li>
</script>
<script>
    var screenCode = "${screenCode}" ;
    console.log(screenCode);
</script>
<script src="${pageContext.request.contextPath}/js/auth/menu.js"></script>
