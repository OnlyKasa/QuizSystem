<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page session="false"%>
<%@ page isELIgnored="false"%>

<h1 class="heading-1 margin-bottom background"><span>Danh sách sinh viên</span></h1>

<section class="form-search form-style">
    <p class="caption btn-box-toggle">
        <i class="fa fa-chevron-circle-right" aria-hidden="true"></i>
        Nhập để tìm kiếm
    </p>

    <div class="box-toggle row">
        <div class="col-xs-12 clear-padding">
            <div class="col-xs-12 col-sm-6 col-lg-4 mt-xs">
                <label>Mã sinh viên</label>
                <input class="form-control" id="strStudentInformationCode" type="text" />
            </div>

            <div class="col-xs-12 col-sm-6 col-lg-4 mt-xs">
                <label>Họ tên sinh viên</label>
                <input class="form-control" id="strStudentInformationName" type="text" />
            </div>

            <div class="col-xs-12 col-sm-6 col-lg-4 mt-xs">
                <label>Tên khoa </label>
                <input class="form-control" type="text" id="strFacultyInformationFullName"/>
            </div>
        </div>

        <div class="col-xs-12 col-sm-2 col-button float-r mt">
            <button class="btn btn-search btn-green w100p btn-fa" id="btnSearch"><i class="fa fa-search" aria-hidden="true"></i>Tìm kiếm</button>
        </div>
    </div>
</section><!-- /.form-search -->

<div class="row row-small layout mt20">
    <div class="col-xs-12 col-sm-inline padding-small">
        <button class="btn btn-blue btn-reponsive btn-medium float-l" id="add-list">Thêm vào danh sách</button>
    </div>

    <p id="txtPageCount" class="float-r txt-small mt15 mr5"></p>
    <div class="clearfix"></div>
</div>

<section class="box-list box-shadow-radius">
    <div class="scrollx-md">
        <table class="table-border table-center table-lg">
            <colgroup>
                <col class="col-number" />
                <col />
                <col />
                <col />
                <col class="col-button" />
            </colgroup>
            <tr>
                <th class="first-child">STT</th>
                <th><a>Mã sinh viên </a></th>
                <th><a>Họ và tên sinh viên</a></th>
                <th><a>Tên khoa</a></th>

                <th class="last-child">
                    <input id="checkbox-all" name="radio" type="checkbox">
                </th>
            </tr>

            <tbody id="table-content">

            </tbody>

        </table>
    </div><!-- /.scroll -->
</section><!-- /.list-search -->

<nav aria-label="Page navigation">
    <ul id="txtPageNavigator" class="pagination float-r"></ul>
    <div class="clearfix"></div>
</nav>


<div id="modal-detail" class="modal modal-style-1 fade" role="dialog">
</div>


<script id="template-student-content" type="text/template7">
    <tr>
        <td class="txt-center">1</td>
        <td>
            <a class="txt-green border" data-toggle="modal" data-target="#modal-detail" id="showDetail('{{iStudentInformationPk}}');">
                {{strStudentInformationCode}}
            </a>
        </td>
        <td>{{strStudentInformationFirstName}} {{strStudentInformationLastName}}</td>
        <td>{{strFacultyInformationFullName}}</td>
        <td class="txt-center">
            <input class="my-checkbox" id="checkbox-{{iStudentInformationPk}}" name="radio" type="checkbox">
        </td>
    </tr>
</script>


<script>
    var iExaminationInformationPk  = ${iExaminationInformationPk};
    var numberStudent = ${numberStudent};
    var percentMatch = ${percentMatch};
</script>
<script src="${pageContext.request.contextPath}/js/admin/examination_detail.js"></script>