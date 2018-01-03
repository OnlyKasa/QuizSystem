<%@ page pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<br/>
<h1 class="heading-1 margin-bottom background"><span><spring:message code="ERROR_PAGE.label.Page_Not_Found" /></span></h1>
<div class="text-error-403">
    <center>
        <img src="${pageContext.request.contextPath}/img/icon-403.png" alt="error-403">
    </center>
    <c:if test="${error==null}">
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
    <br />
    <div class="btn-modal">
        <a class="btn btn-green" href="${pageContext.request.contextPath}/#">
            <spring:message code="ERROR_PAGE.label.Go_Back_Home" />
        </a>
        <%--<button class="btn btn-disable">更新</button>--%>
    </div>
</div>
<!--/wrap-->