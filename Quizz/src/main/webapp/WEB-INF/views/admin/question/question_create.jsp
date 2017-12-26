<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page session="false"%>
<%@ page isELIgnored="false"%>

<h1 class="heading-1 margin-bottom background"><span>Thêm mới câu hỏi</span></h1>

<div class="box-x-medium">
    <form id="form-create-question" action="javascript:void(0);">
        <section class="form-border box-shadow-radius mt-default">
            <h3 class="heading-3">Thông tin câu hỏi</h3>

            <div class="form-content first-child row">
                <div class="col-xs-9 col-sm-4 col-md-30p">
                    <div class="form-label">
                        <label>Nội dung câu hỏi</label>
                    </div>
                </div>

                <div class="col-xs-3 col-sm-1 col-md-5p clear-p-sm">
                    <div class="form-required form-required-sm">
                        <span class="required ">yc</span>
                    </div>
                </div>

                <div class="col-xs-12 col-sm-7 col-md-65p">
                    <textarea class="form-control mh90" id="strQuestionContentInformation" nullable="false" ></textarea>
                    <p class="message-error" id="strQuestionContentInformationErr"> </p>
                </div>
            </div>


            <div class="form-content last-child row">
                <div class="col-xs-9 col-sm-4 col-md-30p">
                    <div class="form-label">
                        <label>Độ khó câu hỏi</label>
                    </div>
                </div>

                <div class="col-xs-3 col-sm-1 col-md-5p clear-p-sm">
                    <div class="form-required form-required-sm">
                        <span class="required">yc</span>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-7 col-md-65p">
                    <select class="selectpicker" id="iQuestionInformationLevel">
                        <option value="1"  selected="selected" >Mức độ 1 (dễ)</option>
                        <option value="2">Mức độ 2 (trung bình)</option>
                        <option value="3">Mức độ 3 (khó)</option>
                        <option value="4">Mức độ 4 (cực khó)</option>
                    </select>
                </div>
            </div>

            <div class="form-content first-child row">
                <div class="col-xs-9 col-sm-4 col-md-30p">
                    <div class="form-label">
                        <label>Câu trả lời 1</label>
                    </div>
                </div>

                <div class="col-xs-3 col-sm-1 col-md-5p clear-p-sm">
                    <div class="form-required form-required-sm">
                        <span class="required ">yc</span>
                    </div>
                </div>

                <div class="col-xs-9 col-sm-5 col-md-60p">
                    <textarea class="form-control mh90" id="strAnswer1" nullable="false" ></textarea>
                    <p class="message-error" id="strAnswer1Err"> </p>
                </div>

                <div class="col-xs-3 col-sm-1 col-md-5p clear-p-sm">
                    <input type="radio" id="check-strAnswer1" name="checkTrue" checked="checked" value="1">
                </div>
            </div>


            <div class="form-content first-child row">
                <div class="col-xs-9 col-sm-4 col-md-30p">
                    <div class="form-label">
                        <label>Câu trả lời 2</label>
                    </div>
                </div>

                <div class="col-xs-3 col-sm-1 col-md-5p clear-p-sm">
                    <div class="form-required form-required-sm">
                        <span class="required ">yc</span>
                    </div>
                </div>

                <div class="col-xs-9 col-sm-5 col-md-60p">
                    <textarea class="form-control mh90" id="strAnswer2" nullable="false" ></textarea>
                    <p class="message-error" id="strAnswer2Err"> </p>
                </div>

                <div class="col-xs-3 col-sm-1 col-md-5p clear-p-sm">
                    <input type="radio" id="check-strAnswer2" name="checkTrue" value="2">
                </div>
            </div>

            <div class="form-content first-child row">
                <div class="col-xs-9 col-sm-4 col-md-30p">
                    <div class="form-label">
                        <label>Câu trả lời 3</label>
                    </div>
                </div>

                <div class="col-xs-3 col-sm-1 col-md-5p clear-p-sm">
                    <div class="form-required form-required-sm">
                        <span class="required ">yc</span>
                    </div>
                </div>

                <div class="col-xs-9 col-sm-5 col-md-60p">
                    <textarea class="form-control mh90" id="strAnswer3" nullable="false" ></textarea>
                    <p class="message-error" id="strAnswer3Err"> </p>
                </div>

                <div class="col-xs-3 col-sm-1 col-md-5p clear-p-sm">
                    <input type="radio" id="check-strAnswer3" name="checkTrue" value="3">
                </div>
            </div>


            <div class="form-content first-child row">
                <div class="col-xs-9 col-sm-4 col-md-30p">
                    <div class="form-label">
                        <label>Câu trả lời 4</label>
                    </div>
                </div>

                <div class="col-xs-3 col-sm-1 col-md-5p clear-p-sm">

                </div>

                <div class="col-xs-9 col-sm-5 col-md-60p">
                    <textarea class="form-control mh90" id="strAnswer4" ></textarea>
                    <p class="message-error" id="strAnswer4Err"> </p>
                </div>

                <div class="col-xs-3 col-sm-1 col-md-5p clear-p-sm">
                    <input type="radio" id="check-strAnswer4" name="checkTrue" value="4">
                </div>
            </div>

            <div class="form-content first-child row">
                <div class="col-xs-9 col-sm-4 col-md-30p">
                    <div class="form-label">
                        <label>Câu trả lời 5</label>
                    </div>
                </div>

                <div class="col-xs-3 col-sm-1 col-md-5p clear-p-sm">

                </div>

                <div class="col-xs-9 col-sm-5 col-md-60p">
                    <textarea class="form-control mh90" id="strAnswer5" ></textarea>
                    <p class="message-error" id="strAnswer5Err"> </p>
                </div>

                <div class="col-xs-3 col-sm-1 col-md-5p clear-p-sm">
                    <input type="radio" id="check-strAnswer5" name="checkTrue" value="5">
                </div>
            </div>
        </section>

        <section class="form-border box-shadow-radius mt-default">
            <h3 class="heading-3">Thông tin thêm</h3>

            <div class="form-content last-child row">
                <div class="col-xs-9 col-sm-4 col-md-30p">
                    <div class="form-label">
                        <label>Giáo viên</label>
                    </div>
                </div>

                <div class="col-xs-3 col-sm-1 col-md-5p clear-p-sm">
                    <div class="form-required form-required-sm">
                        <span class="required">yc</span>
                    </div>
                </div>

                <div class="col-xs-12 col-sm-7 col-md-65p">
                    <div class="row">
                        <div class="col-xs-8 col-sm-9 col-lg-80p">
                            <input class="form-control" id="strTeacherInformationName" nullable="false"
                                   type="text" readonly="readonly" />
                            <p class="message-error" id="strTeacherInformationNameErr"> </p>
                        </div>

                        <div class="col-xs-4 col-sm-3 col-lg-20p clear-p-l">
                            <button class="btn btn-green btn-form w100p"
                                   onclick="showTeacher();">Lựa chọn</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-content last-child row">
                <div class="col-xs-9 col-sm-4 col-md-30p">
                    <div class="form-label">
                        <label>Môn học</label>
                    </div>
                </div>

                <div class="col-xs-3 col-sm-1 col-md-5p clear-p-sm">
                    <div class="form-required form-required-sm">
                        <span class="required">yc</span>
                    </div>
                </div>

                <div class="col-xs-12 col-sm-7 col-md-65p">
                    <div class="row">
                        <div class="col-xs-8 col-sm-9 col-lg-80p">
                            <input class="form-control" type="text" readonly="readonly"
                                   nullable="false" id="strSubjectInformationName"/>
                            <p class="message-error" id="strSubjectInformationNameErr"> </p>
                        </div>

                        <div class="col-xs-4 col-sm-3 col-lg-20p clear-p-l">
                            <button class="btn btn-green btn-form w100p" onclick="showSubject();">Lựa chọn</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="layout main-btn txt-center mt30">
                <button class="btn btn-green btn-radius" id="btnConfirm">Xác nhận</button>
                <button class="btn btn-gray btn-radius mt-xs" onclick="redirectPage('admin','a104')">Trỏ về </button>
            </div>
        </section>
    </form>
</div><!-- /.box-x-medium -->


<div id="modal-list" class="modal modal-confirm modal-style-1 fade" role="dialog">

</div>

<div id="modal-confirm" class="modal modal-confirm modal-style-1 fade" role="dialog">
</div>

<script type="text/template7" id="templateConfirm">
    <div class="modal-dialog box-medium">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title heading-1">Bạn có chắc chắn muốn tạo câu hỏi？</h4>
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
                                <th>Tên gíao viên soạn</th>
                                <td> {{strTeacherInformationName}}</td>
                            </tr>

                            <tr>
                                <th>Môn học</th>
                                <td>{{strSubjectInformationName}}</td>
                            </tr>

                        </table>
                    </div><!-- /.scroll -->
                </div><!-- /.box-shadow-radius -->
            </div><!-- /.modal-body -->

            <div class="modal-footer">
                <div class="btn-modal">
                    <button class="btn btn-green btn-medium btn-confirm" id="btnAdd">Thêm mới</button>
                </div>
                <div class="btn-modal">
                    <button type="button" class="btn btn-gray btn-medium" data-dismiss="modal">Hủy bỏ</button>
                </div>
            </div>
        </div>
    </div>
</script>


<script src="${pageContext.request.contextPath}/js/admin/question/question_create.js"></script>



