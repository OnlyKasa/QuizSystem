
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page session="false"%>
<%@ page isELIgnored="false"%>

<script type="text/template7" id="template-popup-teacher">
    <div class="modal-dialog box-medium">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title heading-1">Thông tin gíao viên</h4>
            </div>

            <div class="modal-body">
                <p id="txtPageCountX" class="txt-small txt-right"></p>
                <div class="box-shadow-radius overflow-h mt10">
                    <div class="scrollx-xs">
                        <table class="table-border-1 table-center table-xs th-nomarl">
                            <colgroup>
                                <col width="8%" />
                                <col width="35%" />
                            </colgroup>

                            <thead>
                            <tr>
                                <th>Chọn</th>
                                <th><a>Tên giáo viên </a></th>
                                <th><a>Số điện thoại</a></th>
                            </tr>
                            </thead>

                            <tbody id="table-content-teacher">

                            </tbody>

                        </table>
                    </div><!-- /.scroll -->
                </div><!-- /.box-shadow-radius -->
                <nav aria-label="Page navigation">
                    <ul id="txtPageNavigatorX" class="pagination float-r"></ul>
                    <div class="clearfix"></div>
                </nav>

            </div><!-- /.modal-body -->

            <div class="modal-footer">
                <button type="button" class="btn btn-gray" data-dismiss="modal">Trở lại</button>
            </div>
        </div>
    </div>
</script>

<script type="text/template7" id="template-content-table-teacher">
    <tr>
        <td class="txt-center">
            <a class="txt-green border" href="#" onclick="selectTeacher('{{iTeacherInformationPk}}')">Chọn</a>
        </td>
        <td>{{strTeacherInformationFirstName}} {{strTeacherInformationLastName}}</td>
        <td>{{strTeacherInformationPhone}}</td>
    </tr>
</script>

<script type="text/template7" id="template-popup-subject">
    <div class="modal-dialog box-medium">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title heading-1">Thông tin môn học</h4>
            </div>

            <div class="modal-body">
                <p id="txtPageCountY" class="txt-small txt-right"></p>
                <div class="box-shadow-radius overflow-h mt10">
                    <div class="scrollx-xs">
                        <table class="table-border-1 table-center table-xs th-nomarl">
                            <colgroup>
                                <col width="8%" />
                                <col width="35%" />
                            </colgroup>

                            <thead>
                            <tr>
                                <th>Chọn</th>
                                <th><a>Mã môn học</a></th>
                                <th><a>Tên môn học</a></th>
                                <th><a>số tín chỉ</a></th>
                            </tr>
                            </thead>

                            <tbody id="table-content-subject">

                            </tbody>

                        </table>
                    </div><!-- /.scroll -->
                </div><!-- /.box-shadow-radius -->
                <nav aria-label="Page navigation">
                    <ul id="txtPageNavigatorY" class="pagination float-r"></ul>
                    <div class="clearfix"></div>
                </nav>

            </div><!-- /.modal-body -->

            <div class="modal-footer">
                <button type="button" class="btn btn-gray" data-dismiss="modal">Trở lại</button>
            </div>
        </div>
    </div>
</script>
<script type="text/template7" id="template-content-table-subject">
    <tr>
        <td class="txt-center">
            <a class="txt-green border" href="#" onclick="selectSubject('{{iSubjectInformationPk}}')">Chọn</a>
        </td>
        <td>{{iSubjectInformationPk}}</td>
        <td>{{strSubjectInformationName}}</td>
        <td>{{iSubjectInformationCreditsNum}}</td>
    </tr>
</script>



<script type="text/template7" id="template-popup-difficulty">
    <div class="modal-dialog box-medium">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title heading-1">Thông tin độ khó</h4>
            </div>

            <div class="modal-body">
                <p id="txtPageCountZ" class="txt-small txt-right"></p>
                <div class="box-shadow-radius overflow-h mt10">
                    <div class="scrollx-xs">
                        <table class="table-border-1 table-center table-xs th-nomarl">
                            <colgroup>
                                <col width="8%" />
                                <col width="35%" />
                            </colgroup>

                            <thead>
                            <tr>
                                <th rowspan="2">Chọn</th>
                                <th rowspan="2"><a>Tên độ khó</a></th>
                                <th><a>Số câu hỏi mức độ 1(dễ)</a></th>
                                <th><a>Số câu hỏi mức độ 2(trung bình)</a></th>
                            </tr>
                            <tr>
                                <th><a>Số câu hỏi mức độ 3(khó)</a></th>
                                <th><a>Số câu hỏi mức độ 4(cực khó)</a></th>
                            </tr>
                            </thead>

                            <tbody id="table-content-difficulty">

                            </tbody>
                        </table>
                    </div><!-- /.scroll -->
                </div><!-- /.bõ-shadow-radius -->
                <nav aria-label="Page navigation">
                    <ul id="txtPageNavigatorZ" class="pagination float-r"></ul>
                    <div class="clearfix"></div>
                </nav>

            </div><!-- /.modal-body -->

            <div class="modal-footer">
                <button type="button" class="btn btn-gray" data-dismiss="modal">Trở lại</button>
            </div>
        </div>
    </div>
</script>
<script type="text/template7" id="template-content-table-difficulty">
    <tr>
        <td class="txt-center" rowspan="2">
            <a class="txt-green border" href="#"
               onclick="selectDifficulty('{{iRateOfDifficultyPk}}')">Chọn</a>
        </td>
        <td rowspan="2">{{strRateDifficultyName}}</td>
        <td>{{iNumQuestionLevel1}}</td>
        <td>{{iNumQuestionLevel2}}</td>
    </tr>
    <tr>
        <td>{{iNumQuestionLevel3}}</td>
        <td>{{iNumQuestionLevel4}}</td>
    </tr>
</script>


<script type="text/template7" id="template-popup-room">
    <div class="modal-dialog box-medium">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title heading-1">Phòng thi</h4>
            </div>

            <div class="modal-body">

                <p id="txtPageCountR" class="txt-small txt-right"></p>
                <div class="box-shadow-radius overflow-h mt10">
                    <div class="scrollx-xs">
                        <table class="table-border-1 table-center table-xs th-nomarl">
                            <colgroup>
                                <col width="8%" />
                            </colgroup>

                            <thead>
                                <tr>
                                    <th>Chọn</th>
                                    <th ><a>Mã phòng thi</a></th>
                                    <th><a>Tên phòng thi</a></th>
                                </tr>
                            </thead>

                            <tbody id="table-content-room"></tbody>
                        </table>
                    </div><!-- /.scroll -->
                </div><!-- /.bõ-shadow-radius -->
                <nav aria-label="Page navigation">
                    <ul id="txtPageNavigatorR" class="pagination float-r"></ul>
                    <div class="clearfix"></div>
                </nav>

            </div><!-- /.modal-body -->

            <div class="modal-footer">
                <button type="button" class="btn btn-gray" data-dismiss="modal">Trở lại</button>
            </div>
        </div>
    </div>
</script>
<script type="text/template7" id="template-content-table-room">
    <tr>
        <td class="txt-center">
            <a class="txt-green border" href="#"
               onclick="selectRoom('{{iExaminationRoomPk}}')">Chọn</a>
        </td>
        <td>{{iExaminationRoomPk}}</td>
        <td>{{strExaminationRoomName}}</td>
    </tr>
</script>

<script src="${pageContext.request.contextPath}/js/template.js"></script>
