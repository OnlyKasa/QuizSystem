<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page session="false"%>
<%@ page isELIgnored="false"%>

<h1 class="heading-1 margin-bottom background"><span>Danh sách kỳ thi</span></h1>
<section class="form-search form-style">
    <p class="caption btn-box-toggle">
        <i class="fa fa-chevron-circle-right" aria-hidden="true"></i>
        Nhập để tìm kiếm
    </p>

    <div class="box-toggle row">
        <div class="col-xs-12 clear-padding">

            <div class="col-xs-12 col-sm-8 col-lg-6 mt-xs">
                <label>Tên môn học </label>
                <input class="form-control" type="text" id="strSubjectInformationName" />
            </div>
            <div class="col-xs-12 col-sm-8 col-lg-6 mt-xs">
                <label>Ngày thi</label>
                <input class="form-control bootstrap-calendar-3" type="text" id="dtExaminationDay" />
            </div>
        </div>

        <div class="col-xs-12 col-sm-2 col-button float-r mt">
            <button class="btn btn-search btn-green w100p btn-fa" id="btnSearch"><i class="fa fa-search" aria-hidden="true"></i>Tìm kiếm</button>
        </div>
    </div>
</section><!-- /.form-search -->

<div class="row row-small layout mt20">
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
                <col />
                <col class="col-button" />
            </colgroup>
            <tr>
                <th class="first-child">STT</th>
                <th><a>Mã kỳ thi </a></th>
                <th><a>Tên môn học</a></th>
                <th><a>Ngày thi</a></th>
                <th><a>Phòng thi</a></th>
                <th class="last-child"></th>
            </tr>

            <tbody id="table-content" >

            </tbody>
        </table>
    </div><!-- /.scroll -->
</section><!-- /.list-search -->

<nav aria-label="Page navigation">
    <ul id="txtPageNavigator" class="pagination float-r"></ul>
    <div class="clearfix"></div>
</nav>

<div id="modal-detail" class="modal modal-style-1 fade" role="dialog">

</div><!-- /.modal -->

<script type="text/template7" id="template-detail-examination-list">
    <div class="modal-dialog box-medium" >
        <!-- Modal content-->

        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title heading-1">Thông tin chi tiết kỳ thi</h4>
            </div>

            <div class="modal-body">
                <h4 class="heading-4 txt-center mb15">Thông tin kỳ thi</h4>

                <div class="box-shadow-radius overflow-h">

                    <div class="scrollx-xs">
                        <table class="table-border-2 table-short table-xs th-nomarl">
                            <colgroup>
                                <col class="col-xs-5 col-sm-4" />
                            </colgroup>

                            <tr>
                                <th>Mã kỳ thi</th>
                                <td>{{strExaminationInformationCode}}</td>
                            </tr>

                            <tr>
                                <th>Ngày / giờ tổ chức thi</th>
                                <td>{{dtExaminationDay}}</td>
                            </tr>
                        </table>
                    </div>
                </div>
                <h4 class="heading-4 txt-center mb15 mt40">Thông tin thêm</h4>

                <div class="box-shadow-radius overflow-h">
                    <div class="scrollx-xs">
                        <table class="table-border-2 table-short table-xs th-nomarl">
                            <colgroup>
                                <col class="col-xs-5 col-sm-4" />
                            </colgroup>
                            <tr>
                                <th>Tên gíao viên tổ chức</th>
                                <td>{{strTeacherInformationFirstName}} {{strTeacherInformationLastName}}</td>
                            </tr>

                            <tr>
                                <th>Môn học</th>
                                <td>{{strSubjectInformationName}}</td>
                            </tr>

                            <tr>
                                <th>Tên độ khó</th>
                                <td>{{strRateDifficultyName}}</td>
                            </tr>

                            <tr>
                                <th>Tên phòng thi</th>
                                <td>{{strExaminationRoomName}}</td>
                            </tr>

                        </table>
                    </div><!-- /.scroll -->
                </div><!-- /.box-shadow-r -->

            </div><!-- /.modal-body -->

            <div class="modal-footer">

<%--TODO sửa chỗ này --%>
                <div class="btn-modal">
                    <button class="btn btn-green"
                            onclick="redirectPage('admin','s101','{{iTestInformationPk}}');">Bắt đầu làm bài</button>
                </div>

                <div class="btn-modal">
                    <button type="button" class="btn btn-gray" data-dismiss="modal">Trở lại</button>
                </div>
            </div>
        </div>
    </div>
</script>

<script type="text/template7" id="table-template-examination-list">
    <tr>
        <td class="txt-center">{{index}}</td>
        <td>
            <a class="txt-green border" onclick="ExaminationList.showDetail('{{iExaminationInformationPk}}');">
                {{strExaminationInformationCode}}
            </a>
            <a style="display:none" id="iExaminationInformationPk">{{iExaminationInformationPk}}</a>
        </td>
        <td>{{strSubjectInformationName}}</td>
        <td>{{dtExaminationDay}}</td>
        <td>{{strExaminationRoomName}}</td>
        <td class="txt-center">
            <button class="btn btn-green"
                    onclick="redirectPage('admin','s101','{{iTestInformationPk}}');">Bắt đầu làm bài
            </button>
        </td>
    </tr>
</script>
<script>
    var iStudentInformationPk = "${iStudentInformationPk}" ;
</script>
<script src="${pageContext.request.contextPath}/js/student/view_examination.js"></script>
