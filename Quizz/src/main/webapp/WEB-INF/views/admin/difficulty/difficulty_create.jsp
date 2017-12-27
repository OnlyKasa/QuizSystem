<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page session="false"%>
<%@ page isELIgnored="false"%>

<h1 class="heading-1 margin-bottom background"><span>Thêm mới cài đặt độ khó </span></h1>

<div class="box-x-medium">
    <form id="form-create-difficulty" action="javascript:void(0);">
        <section class="form-border box-shadow-radius mt-default">
            <h3 class="heading-3">Cài đặt độ khó cho các kỳ thi</h3>
            <div class="form-content first-child row">
                <div class="col-xs-9 col-sm-4 col-md-30p">
                    <div class="form-label">
                        <label>Tên của cài đặt độ khó </label>
                    </div>
                </div>

                <div class="col-xs-3 col-sm-1 col-md-5p clear-p-sm">
                    <div class="form-required form-required-sm">
                        <span class="required ">yc</span>
                    </div>
                </div>

                <div class="col-xs-12 col-sm-7 col-md-65p">
                    <input class="form-control" type="text" nullable="false" id="strRateDifficultyName"/>
                    <p class="message-error" id="strRateDifficultyNameErr"> </p>
                </div>

            </div>

            <div class="form-content first-child row">
                <div class="col-xs-9 col-sm-4 col-md-30p">
                    <div class="form-label">
                        <label>Số lượng câu hỏi ở mức 1 (mức dễ)</label>
                    </div>
                </div>

                <div class="col-xs-3 col-sm-1 col-md-5p clear-p-sm">
                    <div class="form-required form-required-sm">
                        <span class="required ">yc</span>
                    </div>
                </div>

                <div class="col-xs-12 col-sm-7 col-md-65p">
                    <input id="iNumQuestionLevel1" class="form-control" type="text" input-type="number" valid="true" nullable="false" min="1" max="40"/>
                    <p class="message-error" id="iNumQuestionLevel1Err"> </p>
                </div>
            </div>
            <div class="form-content first-child row">
                <div class="col-xs-9 col-sm-4 col-md-30p">
                    <div class="form-label">
                        <label>Số lượng câu hỏi ở mức 2 (mức trung bình)</label>
                    </div>
                </div>

                <div class="col-xs-3 col-sm-1 col-md-5p clear-p-sm">
                    <div class="form-required form-required-sm">
                        <span class="required ">yc</span>
                    </div>
                </div>

                <div class="col-xs-12 col-sm-7 col-md-65p">
                    <input id="iNumQuestionLevel2" class="form-control" type="text" input-type="number" valid="true" nullable="false" min="1" max="40"/>
                    <p class="message-error" id="iNumQuestionLevel2Err"> </p>
                </div>
            </div>
            <div class="form-content first-child row">
                <div class="col-xs-9 col-sm-4 col-md-30p">
                    <div class="form-label">
                        <label>Số lượng câu hỏi ở mức 3 (mức khó)</label>
                    </div>
                </div>

                <div class="col-xs-3 col-sm-1 col-md-5p clear-p-sm">
                    <div class="form-required form-required-sm">
                        <span class="required ">yc</span>
                    </div>
                </div>

                <div class="col-xs-12 col-sm-7 col-md-65p">
                    <input id="iNumQuestionLevel3" class="form-control" type="text" input-type="number" valid="true" nullable="false" min="1" max="40"/>
                    <p class="message-error" id="iNumQuestionLevel3Err"> </p>
                </div>
            </div>
            <div class="form-content first-child row">
                <div class="col-xs-9 col-sm-4 col-md-30p">
                    <div class="form-label">
                        <label>Số lượng câu hỏi ở mức 4  (mức cực khó)</label>
                    </div>
                </div>

                <div class="col-xs-3 col-sm-1 col-md-5p clear-p-sm">
                    <div class="form-required form-required-sm">
                        <span class="required ">yc</span>
                    </div>
                </div>

                <div class="col-xs-12 col-sm-7 col-md-65p">
                    <input id="iNumQuestionLevel4" class="form-control" type="text" input-type="number" valid="true" nullable="false" min="1" max="40"/>
                    <p class="message-error" id="iNumQuestionLevel4Err"> </p>
                </div>
            </div>


            <div class="layout main-btn txt-center mt30">
                <button class="btn btn-green btn-radius" id="btnConfirm">Xác nhận</button>
                <button class="btn btn-gray btn-radius mt-xs" onclick="redirectPage('admin','a102')">Trỏ về </button>
            </div>
        </section><!-- /.form-border -->
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
                <h4 class="modal-title heading-1">Bạn có chắc chắn muốn tạo cài đặt độ khó？</h4>
            </div>

            <div class="modal-body">
                <h4 class="heading-4 txt-center mb15">Thông tin đã cài đặt </h4>

                <div class="box-shadow-radius overflow-h">
                    <div class="scrollx-xs">
                        <table class="table-border-2 table-short table-xs th-nomarl">
                            <colgroup>
                                <col class="col-xs-5 col-sm-4" />
                            </colgroup>

                            <tr>
                                <th>Tên cài đặt </th>
                                <td>{{strRateDifficultyName}}</td>
                            </tr>

                            <tr>
                                <th>Số câu hỏi mức 1 ( mức dễ ) </th>
                                <td>{{iNumQuestionLevel1}}</td>
                            </tr>
                            <tr>
                                <th>Số câu hỏi mức 2 ( mức trung bình) </th>
                                <td>{{iNumQuestionLevel2}}</td>
                            </tr>
                            <tr>
                                <th>Số câu hỏi mức 3 ( mức khó ) </th>
                                <td>{{iNumQuestionLevel3}}</td>
                            </tr>
                            <tr>
                                <th>Số câu hỏi mức 4 ( mức cực khó ) </th>
                                <td>{{iNumQuestionLevel4}}</td>
                            </tr>
                        </table>
                    </div>
                </div>
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


<script src="${pageContext.request.contextPath}/js/admin/difficulty/difficulty_create.js"></script>



