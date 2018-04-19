<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page session="false"%>
<%@ page isELIgnored="false"%>

<div class="row">
    <div class="col-xs-12 col-sm-4 col-md-4 box-left">
        <div class="box-infor mb20">
            <h5 class="title-box">Thông tin cơ bản</h5>
            <div class="box-infor-common" id="common-content">

            </div>
        </div>

        <div class="box-infor box-infor-question">
            <h5 class="title-box">Danh sách câu hỏi</h5>
            <ul class="list-question list-inline" id="list-question-button">
            </ul>
        </div>
    </div>

    <div class="col-xs-12 col-sm-8 col-md-8 box-right">
        <div class="category-question" id="table-content">
        </div>
    </div>
</div>
<script id="template-question-content" type="text/template7">
    <div class="box-item-question" id="question-{{index}}">
        <div class="head-box">
            <span class="txt-bold">Câu {{index}}: </span>
            <span class="content-question">
                {{strQuestionContentInformation}}
            </span>
        </div>
        <div class="body-box">
            {{#js_if "this.strAnswer1 != ''  && this.strAnswer1 != null"}}
                <div class="answer">
                    <div class="radio">
                        <input id="radio-strAnswer1-{{index}}" name="radio-{{index}}" type="radio" value="1">
                        <label for="radio-strAnswer1-{{index}}" class="radio-label" id="strAnswer1-{{index}}">
                            {{strAnswer1}}
                        </label>
                    </div>
                </div>
            {{/js_if}}
            {{#js_if "this.strAnswer2 != ''  && this.strAnswer2 != null"}}
            <div class="answer">
                <div class="radio">
                    <input id="radio-strAnswer2-{{index}}" name="radio-{{index}}" type="radio" value="2">
                    <label for="radio-strAnswer2-{{index}}" class="radio-label" id="strAnswer2-{{index}}"> {{strAnswer2}}</label>
                </div>
            </div>
            {{/js_if}}
            {{#js_if "this.strAnswer3 != ''  && this.strAnswer3 != null"}}
            <div class="answer">
                <div class="radio">
                    <input id="radio-strAnswer3-{{index}}" name="radio-{{index}}" type="radio" value="3">
                    <label for="radio-strAnswer3-{{index}}" class="radio-label" id="strAnswer3-{{index}}"> {{strAnswer3}}</label>
                </div>
            </div>
            {{/js_if}}
            {{#js_if "this.strAnswer4 != ''  && this.strAnswer4 != null"}}
            <div class="answer">
                <div class="radio semi-hidden">
                    <input id="radio-strAnswer4-{{index}}" name="radio-{{index}}" type="radio" value="4">
                    <label for="radio-strAnswer4-{{index}}" class="radio-label" id="strAnswer4-{{index}}"> {{strAnswer4}}</label>
                </div>
            </div>
            {{/js_if}}
            {{#js_if "this.strAnswer5 != ''  && this.strAnswer5 != null"}}
                <div class="answer">
                    <div class="radio semi-hidden">
                        <input id="radio-strAnswer5-{{index}}" name="radio-{{index}}" type="radio" value="5">
                        <label for="radio-strAnswer4-{{index}}" class="radio-label" id="strAnswer5-{{index}}">{{strAnswer5}}</label>
                    </div>
                </div>
            {{/js_if}}
        </div>
    </div>
</script>
<script id="template-button-question" type="text/template7">
    <li>
        <button class="btn btn-number" id="button-{{index}}" onclick="Tests.goToPosition('{{index}}');" >{{index}}</button>
    </li>
</script>

<script id="template-common-content" type="text/template7">
    <div class="item-info">
        <div class="row">
            <div class="col-xs-5 clear-pr">
                <label>Tên môn thi:</label>
            </div>
            <div class="col-xs-7 clear-pl5">
                <span>{{strSubjectInformationName}}</span>
            </div>
        </div>
    </div>

    <div class="item-info">
        <div class="row">
            <div class="col-xs-5 clear-pr">
                <label>Ngày thi:</label>
            </div>
            <div class="col-xs-7 clear-pl5">
                <span>{{dtExaminationDay}}</span>
            </div>
        </div>
    </div>

    <div class="item-info">
        <div class="row">
            <div class="col-xs-5 clear-pr">
                <label>Thời gian làm bài:</label>
            </div>
            <div class="col-xs-7 clear-pl5">
                <span>{{iTestInformationTime}}</span>
            </div>
        </div>
    </div>

    <div class="item-info">
        <div class="row">
            <div class="col-xs-5 clear-pr">
                <label>Thời gian còn lại:</label>
            </div>
            <div class="col-xs-7 clear-pl5">
                <div class="range-time" >
                    <span class="num-hour" id="hour"></span>
                    <span>:</span>
                    <span class="num-min" id="minute"></span>
                </div>
            </div>
        </div>
    </div>
</script>
<script type="text/template7" id="templatehour">
    {{hour}}
</script>
<script type="text/template7" id="templateminute">
    {{minute}}
</script>
<script>
    var iTestInformationPk ="${iTestInformationPk}";
    var dateStartTest = "${dateStartTest}";
</script>
<script src="${pageContext.request.contextPath}/js/student/s101.js"></script>
