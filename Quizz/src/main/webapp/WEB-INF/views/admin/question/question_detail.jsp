<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page session="false"%>
<%@ page isELIgnored="false"%>

<h1 class="heading-1 margin-bottom background"><span>Chi tiết kỳ thi</span></h1>

<section class="form-border box-shadow-radius mt-default">
    <h3 class="heading-3">Thông tin kỳ thi</h3>
    <div class="form-content first-child row">
        <div class="col-xs-9 col-sm-4 col-md-30p">
            <div class="form-label">
                <label>Mã kỳ thi</label>
            </div>
        </div>

        <div class="col-xs-3 col-sm-1 col-md-5p clear-p-sm">
        </div>

        <div class="col-xs-12 col-sm-7 col-md-65p">
            <input class="form-control" type="text" readonly="readonly" id="strExaminationInformationCode"/>
            <p class="message-error" id="strExaminationInformationCodeErr"> </p>
        </div>
    </div>

    <div class="form-content first-child row">
        <div class="col-xs-9 col-sm-4 col-md-30p">
            <div class="form-label">
                <label>Ngày thi</label>
            </div>
        </div>

        <div class="col-xs-3 col-sm-1 col-md-5p clear-p-sm">
        </div>

        <div class="col-xs-12 col-sm-7 col-md-65p">
            <input id="dtExaminationDay" readonly="readonly" class="form-control" type="text" nullable="false"/>
            <p class="message-error" id="dtExaminationDayErr"> </p>
        </div>
    </div>
</section><!-- /.form-border -->

<div class="row row-small layout mt20">
    <div class="col-xs-12 col-sm-inline padding-small">
        <button class="btn btn-blue btn-reponsive btn-medium float-l" id="btnAddStudent">Thêm sinh viên vào danh sách</button>
        <p class="message-error" id="preventAddStudent"></p>
    </div>
    <p id="txtPageCount" class="float-r txt-small mt15 mr5"></p>
    <div class="clearfix"></div>
</div>
<h3 class="heading-3">Danh sách sinh viên</h3>
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

                <th class="last-child"></th>
            </tr>

            <tbody id="table-student-content">

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


<script id="template-table-student" type="text/template7">
    <tr>
        <td class="txt-center">1</td>
        <td>
            {{strStudentInformationCode}}
        </td>
        <td>{{strStudentInformationFirstName}} {{strStudentInformationLastName}}</td>
        <td>{{strFacultyInformationFullName}}</td>
        <td class="txt-center">
            <button class="btn btn-update btn-small">Xem đề thi</button><br/>
            <button class="btn btn-delete btn-small mt5" data-toggle="modal" data-target="#modal-delete">Xóa</button>
        </td>
    </tr>
</script>


<div class="row row-small layout mt20">
    <p id="txtPageCountX" class="float-r txt-small mt15 mr5"></p>
    <div class="clearfix"></div>
</div>
<h3 class="heading-3">Danh sách câu hỏi</h3>
<section class="box-list box-shadow-radius">
    <div class="scrollx-md">
        <table class="table-border table-center table-lg">
            <colgroup>
                <col class="col-number" />
                <col />
                <col />
                <col />
                <col />
                <col class="col-button" />
            </colgroup>
            <tr>
                <th class="first-child">STT</th>
                <th><a>Nội dung câu hỏi </a></th>
                <th><a>Họ và tên giáo viên</a></th>
                <th><a>Môn học</a></th>
                <th><a>Độ khó</a></th>
                <th class="last-child"></th>
            </tr>

            <tbody id="table-question"></tbody>
        </table>
    </div><!-- /.scroll -->
</section><!-- /.list-search -->

<nav aria-label="Page navigation">
    <ul id="txtPageNavigatorX" class="pagination float-r"></ul>
    <div class="clearfix"></div>
</nav>

<script type="text/template7" id="template-table-question">
    <tr>
        <td class="txt-center">1</td>
        <td>
            <a class="txt-green border" data-toggle="modal" data-target="#modal-detail">
               {{strQuestionContentInformation}}
            </a>
        </td>
        <td>{{strTeacherInformationFirstName}}{{strTeacherInformationLastName}}</td>
        <td>{{strSubjectInformationName}}</td>
        <td>{{iQuestionInformationLevel}}</td>
        <td class="txt-center">
            <button class="btn btn-update btn-small">Sửa</button><br/>
            <button class="btn btn-delete btn-small mt5" data-toggle="modal" data-target="#modal-delete">Xóa</button>
        </td>
    </tr>
</script>

<div id="confirm-adding-student" class="modal modal-style-1 fade" role="dialog">

</div><!-- /.modal -->

<script type="text/template7" id="template-confirm-adding-student">
    <div class="modal-dialog box-medium">
        <!-- Modal content-->

        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title heading-1">Chi tiết thêm mới</h4>
            </div>

            <div class="modal-body">
                <h4 class="heading-4 txt-center mb15">Thông tin hiện tại</h4>

                <div class="box-shadow-radius overflow-h">

                    <div class="scrollx-xs">
                        <table class="table-border-2 table-short table-xs th-nomarl">
                            <colgroup>
                                <col class="col-xs-5 col-sm-4" />
                            </colgroup>

                            <tr>
                                <th>Số lượng câu hỏi dễ (mức độ 1) của cả kỳ thi </th>
                                <td>{{numQuestionLv1}}</td>
                            </tr>
                            <tr>
                                <th>Số lượng câu hỏi trung bình (mức độ 2) của cả kỳ thi</th>
                                <td>{{numQuestionLv2}}</td>
                            </tr>
                            <tr>
                                <th>Số lượng câu hỏi khó  (mức độ 3) của cả kỳ thi</th>
                                <td>{{numQuestionLv3}}</td>
                            </tr>
                            <tr>
                                <th>Số lượng câu hỏi cực khó  (mức độ 4) của cả kỳ thi</th>
                                <td>{{numQuestionLv4}}</td>
                            </tr>

                        </table>
                    </div>
                </div>
                <h4 class="heading-4 txt-center mb15 mt40">Thông tin thêm mới </h4>

                <div class="box-shadow-radius overflow-h">
                    <div class="scrollx-xs">
                        <form id="confirm-value" action="javascript:void(0);">
                        <table class="table-border-2 table-short table-xs th-nomarl">
                            <colgroup>
                                <col class="col-xs-5 col-sm-4" />
                            </colgroup>

                            <tr>
                                <th><label for="numberStudent" >Số lượng sinh viên thêm mới</label> </th>
                                <td><input id="numberStudent" type="text" valid-type="number" valid="true" value="0"/></td>
                            </tr>

                            <tr>
                                <th><label for="numberPercent" >Tỷ lệ trùng câu hỏi </label> </th>
                                <td><input id="numberPercent" type="text" valid-type="number" valid="true" min="0" max="100" value="50"></td>
                            </tr>

                            <tr>
                                <th>Số câu hỏi dễ (mức độ 1) cần cho sô sinh viên trên</th>
                                <td id="numQuestionLv1">0</td>
                            </tr>
                            <tr>
                                <th>Số câu hỏi trung bình (mức độ 2) cần cho sô sinh viên trên</th>
                                <td id="numQuestionLv2">0</td>
                            </tr>
                            <tr>
                                <th>Số câu hỏi khó  (mức độ 3) cần cho sô sinh viên trên</th>
                                <td id="numQuestionLv3">0</td>
                            </tr>
                            <tr>
                                <th>Số câu hỏi cực khó  (mức độ 4) cần cho sô sinh viên trên</th>
                                <td id="numQuestionLv4">0</td>
                            </tr>

                        </table>

                        </form>
                    </div><!-- /.scroll -->
                </div><!-- /.box-shadow-r -->

            </div><!-- /.modal-body -->
            <p id="messErorr" class="message-error"></p>
            <div class="modal-footer">
                <div class="btn-modal">
                    <button class="btn btn-green" id="btnRepageAddStudent">Đồng ý</button>
                </div>
                <div class="btn-modal">
                    <button type="button" class="btn btn-gray" data-dismiss="modal">Trở lại</button>
                </div>
            </div>
            </div>
        </div>
</script>
<script>
    var iExaminationInformationPk  = ${iExaminationInformationPk};
</script>
<script src="${pageContext.request.contextPath}/js/admin/examination_detail.js"></script>
