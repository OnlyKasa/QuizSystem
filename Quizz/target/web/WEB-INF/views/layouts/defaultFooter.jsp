<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<footer class="footer" style="margin-top: 62px;">
    <div class="footer__header">
        <div class="container">
            <p><a href="${pageContext.request.contextPath}/auth/C105"><spring:message code='C105.LINK' /></a></p>
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
<style>
.header-2 .navbar-right li.username .text-overflow {
    line-height: 60px !important;
}
</style>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/js/lib/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/lib/bootstrap-confirmation.js"></script>
<script src="${pageContext.request.contextPath}/js/lib/bootstrap-select.js"></script>
<script src="${pageContext.request.contextPath}/js/lib/bootstrap-datepicker.js"></script>
<script src="${pageContext.request.contextPath}/js/lib/jquery.datetimepicker.full.min.js"></script>
<script src="${pageContext.request.contextPath}/js/lib/bootstrap-datepicker.ja.js" charset="UTF-8"></script>
<script src="${pageContext.request.contextPath}/js/lib/custom-file-input.js"></script>
<script src="${pageContext.request.contextPath}/js/jscustom.js"></script>
<script src="${pageContext.request.contextPath}/js/mystyle.js"></script>
<script src="${pageContext.request.contextPath}/js/lib/datatables.min.js"></script>