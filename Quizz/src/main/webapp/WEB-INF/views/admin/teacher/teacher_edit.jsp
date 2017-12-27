<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page session="false"%>
<%@ page isELIgnored="false"%>

<h1 class="heading-1 margin-bottom background"><span>Sửa đổi sinh viên</span></h1>

<div class="box-x-medium">
    <form id="form-update-teacher" action="javascript:void(0);">
        <section class="form-border box-shadow-radius mt-default">
            <h3 class="heading-3">Thông tin sinh viên</h3>
            <div class="form-content first-child row">
                <div class="col-xs-9 col-sm-4 col-md-30p">
                    <div class="form-label">
                        <label>Mã sinh viên</label>
                    </div>
                </div>

                <div class="col-xs-3 col-sm-1 col-md-5p clear-p-sm">
                    <div class="form-required form-required-sm">
                        <span class="required ">yc</span>
                    </div>
                </div>

                <div class="col-xs-12 col-sm-7 col-md-65p">
                    <input class="form-control" type="text" readonly="readonly" id="strStudentInformationCode"/>
                    <p class="message-error" id="strStudentInformationCodeErr"> </p>
                </div>
            </div>


            <div class="form-content first-child row">
                <div class="col-xs-9 col-sm-4 col-md-30p">
                    <div class="form-label">
                        <label>Họ sinh viên</label>
                    </div>
                </div>

                <div class="col-xs-3 col-sm-1 col-md-5p clear-p-sm">
                    <div class="form-required form-required-sm">
                        <span class="required ">yc</span>
                    </div>
                </div>

                <div class="col-xs-12 col-sm-7 col-md-65p">
                    <input class="form-control" type="text" id="strStudentInformationLastName" nullable="false"/>
                </div>
            </div>

            <div class="form-content first-child row">
                <div class="col-xs-9 col-sm-4 col-md-30p">
                    <div class="form-label">
                        <label>Tên sinh viên</label>
                    </div>
                </div>

                <div class="col-xs-3 col-sm-1 col-md-5p clear-p-sm">
                    <div class="form-required form-required-sm">
                        <span class="required ">yc</span>
                    </div>
                </div>

                <div class="col-xs-12 col-sm-7 col-md-65p">
                    <input class="form-control" type="text" id="strStudentInformationFirstName" nullable="false"/>
                </div>
            </div>

            <div class="form-content last-child row">
                <div class="col-xs-9 col-sm-4 col-md-30p">
                    <div class="form-label">
                        <label>Giới tính</label>
                    </div>
                </div>

                <div class="col-xs-3 col-sm-1 col-md-5p clear-p-sm">
                    <div class="form-required form-required-sm">
                        <span class="required">yc</span>
                    </div>
                </div>
            </div>

            <div class="form-content first-child row">
                <div class="col-xs-9 col-sm-4 col-md-30p">
                    <div class="form-label">
                        <label>Tài khoản đăng nhập</label>
                    </div>
                </div>

                <div class="col-xs-3 col-sm-1 col-md-5p clear-p-sm">
                    <div class="form-required form-required-sm">
                        <span class="required ">yc</span>
                    </div>
                </div>

                <div class="col-xs-12 col-sm-7 col-md-65p">
                    <input class="form-control" type="text" id="username"/>
                </div>
            </div>

            <div class="form-content first-child row">
                <div class="col-xs-9 col-sm-4 col-md-30p">
                    <div class="form-label">
                        <label>Mật khẩu</label>
                    </div>
                </div>

                <div class="col-xs-3 col-sm-1 col-md-5p clear-p-sm">
                    <div class="form-required form-required-sm">
                        <span class="required ">yc</span>
                    </div>
                </div>

                <div class="col-xs-12 col-sm-7 col-md-65p">
                    <input class="form-control" type="password" id="password"/>
                </div>


            </div>
            <div class="form-content first-child row">
                <div class="col-xs-9 col-sm-4 col-md-30p">
                    <div class="form-label">
                        <label>Nhập lại mật khẩu</label>
                    </div>
                </div>

                <div class="col-xs-3 col-sm-1 col-md-5p clear-p-sm">

                </div>

                <div class="col-xs-12 col-sm-7 col-md-65p">
                    <input class="form-control" type="password" id="rePassword"/>
                </div>

            </div>

        </section><!-- /.form-border -->
        <section class="form-border box-shadow-radius mt-default">
            <h3 class="heading-3">Thông tin thêm cho sinh viên </h3>

            <div class="form-content last-child row">
                <div class="col-xs-9 col-sm-4 col-md-30p">
                    <div class="form-label">
                        <label>Khoa</label>
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
                            <input  id="strFacultyInformationName" class="form-control" type="text" readonly="readonly" nullable="false" />
                            <p class="message-error" id="strFacultyInformationNameErr"> </p>
                        </div>

                        <div class="col-xs-4 col-sm-3 col-lg-20p clear-p-l">
                            <button class="btn btn-green btn-form w100p" type="button" onclick="showFaculty();">Lựa chọn</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="layout main-btn txt-center mt30">
                <button class="btn btn-green btn-radius" id="btnConfirm">Xác nhận</button>
                <button class="btn btn-gray btn-radius mt-xs" onclick="redirectPage('admin','a106')" type="button">Trở về </button>
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
                <h4 class="modal-title heading-1">Bạn có chắc chắn muốn sửa thông tin sinh viên？</h4>
            </div>

            <div class="modal-body">
                <h4 class="heading-4 txt-center mb15">Thông tin sinh viên</h4>

                <div class="box-shadow-radius overflow-h">
                    <div class="scrollx-xs">
                        <table class="table-border-2 table-short table-xs th-nomarl">
                            <colgroup>
                                <col class="col-xs-5 col-sm-4" />
                            </colgroup>

                            <tr>
                                <th>Mã sinh viên</th>
                                <td>{{strStudentInformationCode}}</td>
                            </tr>

                            <tr>
                                <th>Họ sinh viên </th>
                                <td>{{strStudentInformationLastName}}</td>
                            </tr>
                            <tr>
                                <th>Tên sinh viên </th>
                                <td>{{strStudentInformationFirstName}}</td>
                            </tr>
                            <tr>
                                <th>Tài khoản</th>
                                <td>{username}}</td>
                            </tr>
                            <tr>
                                <th>Mật khẩu  </th>
                                <td>**********</td>
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
                                <th>Khoa</th>
                                <td>{{strFacultyInformationName}}</td>
                            </tr>
                        </table>
                    </div><!-- /.scroll -->
                </div><!-- /.box-shadow-radius -->
            </div><!-- /.modal-body -->
            <div class="modal-footer">
                <div class="btn-modal">
                    <button class="btn btn-green btn-medium btn-confirm" id="btnAdd">Sửa đổi</button>
                </div>
                <div class="btn-modal">
                    <button type="button" class="btn btn-gray btn-medium" data-dismiss="modal">Hủy bỏ</button>
                </div>
            </div>
        </div>
    </div>
</script>

<script>
    var iStudentInformationPk  = ${iStudentInformationPk};
</script>
<script src="${pageContext.request.contextPath}/js/admin/student/student_edit.js"></script>



