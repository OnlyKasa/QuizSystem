<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page session="false"%>
<%@ page isELIgnored="false"%>

<h1 class="heading-1 margin-bottom background"><span>Danh sách câu hỏi</span></h1>
<section class="form-search form-style">
    <p class="caption btn-box-toggle">
        <i class="fa fa-chevron-circle-right" aria-hidden="true"></i>
        Nhập để tìm kiếm
    </p>

    <div class="box-toggle row">
        <div class="col-xs-12 clear-padding">
            <div class="col-xs-12 col-sm-6 col-lg-4 mt-xs">
                <label>Nội dung câu hỏi</label>
                <input class="form-control" type="text" id="strQuestionContentInformation"/>
            </div>

            <div class="col-xs-12 col-sm-6 col-lg-4 mt-xs">
                <label>Môn học </label>
                <input class="form-control" type="text" id="strSubjectInformationName"/>
            </div>

            <div class="col-xs-12 col-sm-6 col-lg-4 mt-xs">
                <label>Họ tên giáo viên</label>
                <div class="row">
                    <div class="col-xs-12 col-sm-6 par5-sm">
                        <input class="form-control" type="text" id="strTeacherInformationFirstName"/>
                    </div>
                    <div class="col-xs-12 col-sm-6 pal5-sm mt-small-xs">
                        <input class="form-control" type="text" id="strTeacherInformationLastName"/>
                    </div>
                </div>
            </div>

            <div  class="col-xs-12 col-sm-6 col-lg-4 mt-xs">
                <label>Độ khó </label>
                <select class="selectpicker" id="iQuestionInformationLevel">
                    <option value="99">（Chọn nội dung）</option>
                    <option value="1">Mức độ 1(dễ) </option>
                    <option value="2">Mức độ 2(trung bình)</option>
                    <option value="3">Mức độ 3(khó)</option>
                    <option value="4">Mức độ 4(cực khó)</option>
                </select>
            </div>
        </div>

        <div class="col-xs-12 col-sm-2 col-button float-r mt">
            <button class="btn btn-search btn-green w100p btn-fa" id="btnSearch"><i class="fa fa-search" aria-hidden="true"></i>Tìm kiếm</button>
        </div>
    </div>
</section><!-- /.form-search -->

<div class="row row-small layout mt20">
    <div class="col-xs-12 col-sm-inline padding-small">
        <button class="btn btn-blue btn-reponsive btn-medium float-l" onclick="redirectPage('admin','a104_2');">Thêm mới</button>
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

<script type="text/template7" id="template-detail-question-list">
    <div class="modal-dialog box-medium" >
        <!-- Modal content-->

        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title heading-1">Thông tin chi tiết câu h</h4>
            </div>

            <div class="modal-body">
                <h4 class="heading-4 txt-center mb15">Thông tin câu hỏi</h4>

                <div class="box-shadow-radius overflow-h">

                    <div class="scrollx-xs">
                        <table class="table-border-2 table-short table-xs th-nomarl">
                            <colgroup>
                                <col class="col-xs-5 col-sm-4" />
                            </colgroup>
                            <tr>
                                <th>Nội dung</th>
                                <td>{{strQuestionContentInformation}}</td>
                            </tr>

                            <tr>
                                <th>Độ khó</th>
                                <td>{{vcQuestionInformationLevel}}</td>
                            </tr>
                            <tr>
                                <th>Câu trả lời 1</th>
                                <td>{{strAnswer1}}</td>
                            </tr>
                            <tr>
                                <th>Câu trả lời 2</th>
                                <td> {{strAnswer2}}</td>
                            </tr>
                            <tr>
                                <th>Câu trả lời 3</th>
                                <td>{{strAnswer3}}</td>
                            </tr>
                            <tr>
                                <th>Câu trả lời 4</th>
                                <td>{{strAnswer4}}</td>
                            </tr>
                            <tr>
                                <th>Câu trả lời 5</th>
                                <td>{{strAnswer5}}</td>
                            </tr>
                            <tr>
                                <th>Câu trả lời đúng</th>
                                <td>{{strTrueAnswer}}</td>
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
                                <td>{{strTeacherInformationName}}</td>
                            </tr>

                            <tr>
                                <th>Môn học</th>
                                <td>{{strSubjectInformationName}}</td>
                            </tr>
                        </table>
                    </div><!-- /.scroll -->
                </div><!-- /.box-shadow-r -->

            </div><!-- /.modal-body -->

            <div class="modal-footer">
                <div class="btn-modal">
                    <button class="btn btn-green"
                            onclick="redirectPage('admin','a104_1','{{iQuestionInformationPk}}');">Sửa</button>
                </div>
                <div class="btn-modal">
                    <button type="button" class="btn btn-detail-delete btn-gray"
                            onclick="ExaminationList.showDelete();" >Xóa</button>
                </div>
                <div class="btn-modal">
                    <button type="button" class="btn btn-gray" data-dismiss="modal">Trở lại</button>
                </div>
            </div>
        </div>
    </div>
</script>
<div id="modal-delete" class="modal-confirm modal modal-style-1 fade" role="dialog">
</div><!-- /.modal -->

<script type="text/template7" id="template-delete-question-list">
    <div class="modal-dialog box-medium">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title heading-1">
                    <i class="fa fa-trash mr10" aria-hidden="true"></i>Bạn có thực sự muốn xóa ?
                </h4>
            </div>

            <div class="modal-body">
                <h4 class="heading-4 txt-center mb15">Thông tin câu hỏi</h4>

                <div class="box-shadow-radius overflow-h">

                    <div class="scrollx-xs">
                        <table class="table-border-2 table-short table-xs th-nomarl">
                            <colgroup>
                                <col class="col-xs-5 col-sm-4" />
                            </colgroup>
                            <tr>
                                <th>Nội dung</th>
                                <td>{{strQuestionContentInformation}}</td>
                            </tr>

                            <tr>
                                <th>Độ khó</th>
                                <td>{{vcQuestionInformationLevel}}</td>
                            </tr>
                            <tr>
                                <th>Câu trả lời 1</th>
                                <td>{{strAnswer1}}</td>
                            </tr>
                            <tr>
                                <th>Câu trả lời 2</th>
                                <td> {{strAnswer2}}</td>
                            </tr>
                            <tr>
                                <th>Câu trả lời 3</th>
                                <td>{{strAnswer3}}</td>
                            </tr>
                            <tr>
                                <th>Câu trả lời 4</th>
                                <td>{{strAnswer4}}</td>
                            </tr>
                            <tr>
                                <th>Câu trả lời 5</th>
                                <td>{{strAnswer5}}</td>
                            </tr>
                            <tr>
                                <th>Câu trả lời đúng</th>
                                <td>{{strTrueAnswer}}</td>
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
                                <td>{{strTeacherInformationName}}</td>
                            </tr>

                            <tr>
                                <th>Môn học</th>
                                <td>{{strSubjectInformationName}}</td>
                            </tr>
                        </table>
                    </div><!-- /.scroll -->
                </div><!-- /.box-shadow-r -->

            </div><!-- /.modal-body -->

            <div class="modal-footer">
                <div class="btn-modal">
                    <button class="btn btn-delete btn-confirm btn-medium btn-fa" onclick="QuestionList.deleteOne('{{iQuestionInformationPK}}')" >
                        Xóa
                    </button>
                </div>
                <div class="btn-modal">
                    <button type="button" class="btn btn-gray btn-medium" data-dismiss="modal">Hủy bỏ</button>
                </div>
            </div>
        </div>
    </div>
</script>


<script type="text/template7" id="table-template-question-list">

    <tr>
        <td class="txt-center">2</td>
        <td>
            <a class="txt-green border" data-toggle="modal">
                {{strQuestionContentInformation}}

            </a>
            <a style="display:none" id="iQuestionInformationPk">{{iQuestionInformationPk}}</a>
        </td>
        <td>{{strTeacherInformationName}}</td>
        <td>{{strSubjectInformationName}}</td>
        <td>{{vcQuestionInformationLevel}}</td>

        <td class="txt-center">
            <button class="btn btn-update btn-small"
                    onclick="redirectPage('admin','a104_1','{{iQuestionInformationPk}}');" >Sửa</button><br/>
            <button class="btn btn-delete btn-small mt5" onclick="QuestionList.showDelete();">Xóa</button>
        </td>
    </tr>
</script>

<script src="${pageContext.request.contextPath}/js/admin/question/question_list.js"></script>
