<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page session="false"%>
<%@ page isELIgnored="false"%>

<h1 class="heading-1 margin-bottom background">
    <span><spring:message code="MENU.TEACHER.EXAMINATION.LIST" />
    </span>
</h1>
<section class="form-search form-style">
    <div class="btn-box-toggle">
        <i class="fa fa-chevron-circle-right" aria-hidden="true"></i>
        <div class="caption">
            <spring:message code="COMMON.label.search"/>
        </div>
    </div>
    <div class="box-toggle row">
        <div class="col-xs-12 col-sm-10 col-input clear-padding">
            <div class="col-xs-12 col-sm-4">
                <label><spring:message code="SEARCH.label.InformationCode"/></label>
                <input class="form-control" id="iExaminationInformationCode" type="text" />
            </div>

            <div class="col-xs-12 col-sm-4 mt-xs">
                <label><spring:message code="SEARCH.label.SubjectName"/> </label>
                <input class="form-control" id="strSubjectInformationName" type="text" />
            </div>

            <div class="col-xs-12 col-sm-4 mt-xs">
                <label><spring:message code="SEARCH.label.ExaminationDay"/> </label>
                <input class="form-control bootstrap-calendar-1 " id="dtExaminationDay" type="text"/>
            </div>
        </div>

        <div class="col-xs-12 col-sm-2 col-button border-sm float-r mt-xs">
            <button class="btn btn-search btn-green w100p btn-fa">
                <i class="fa fa-search" aria-hidden="true"></i>
                <spring:message code="COMMON.button.search"/>
        </button>
        </div>
    </div>

</section>