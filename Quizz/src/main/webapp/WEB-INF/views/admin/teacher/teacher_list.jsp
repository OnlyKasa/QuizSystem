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
            <div class="col-xs-12 col-sm-6 col-lg-4 mt-xs">
                <label>Họ /tên sinh viên</label>
                <div class="row">
                    <div class="col-xs-12 col-sm-6 par5-sm">
                        <input class="form-control" type="text" id="strTeacherInformationFirstName" />
                    </div>
                    <div class="col-xs-12 col-sm-6 pal5-sm mt-small-xs">
                        <input class="form-control" type="text" id="strTeacherInformationLastName"/>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-lg-4 mt-xs">
                <label>Khoa</label>

                <input class="form-control" type="text" id="strFacultyInformationFullName" />
            </div>
        </div>

        <div class="col-xs-12 col-sm-2 col-button float-r mt">
            <button class="btn btn-search btn-green w100p btn-fa" id="btnSearch"><i class="fa fa-search" aria-hidden="true"></i>Tìm kiếm</button>
        </div>
    </div>
</section><!-- /.form-search -->

<div class="row row-small layout mt20">
    <div class="col-xs-12 col-sm-inline padding-small">
        <button class="btn btn-blue btn-reponsive btn-medium float-l" onclick="redirectPage('admin','a107_2');">Thêm mới</button>
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
                <col />
                <col />
                <col class="col-button" />
            </colgroup>
            <tr>
                <th class="first-child">STT</th>
                <th><a>Mã giáo viên</a></th>
                <th><a>Họ và tên giáo viên</a></th>
                <th><a>Tên khoa</a></th>
                <th><a>Số điện thoại</a></th>
                <th><a>Tài khoản đăng nhập</a></th>
                <th><a>Mật khẩu</a></th>
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

<div id="modal-delete" class="modal-confirm modal modal-style-1 fade" role="dialog">
</div><!-- /.modal -->

<script type="text/template7" id="template-delete-teacher-list">
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
                <h4 class="heading-4 txt-center mb15">Thông tin sinh viên </h4>

                <div class="box-shadow-radius overflow-h">

                    <div class="scrollx-xs">
                        <table class="table-border-2 table-short table-xs th-nomarl">
                            <colgroup>
                                <col class="col-xs-5 col-sm-4" />
                            </colgroup>
                            <tr>
                                <th>Mã giáo viên</th>
                                <td>{{iTeacherInformationPk}}</td>
                            </tr>

                            <tr>
                                <th>Tên giáo viên </th>
                                <td>{{strTeacherInformationLastName}} {{strTeacherInformationFirstName}}</td>
                            </tr>
                            <tr>
                                <th>Tên khoa </th>
                                <td>{{strFacultyInformationFullName}}</td>
                            </tr>
                            <tr>
                                <th>Số điện thoại</th>
                                <td>{{strTeacherInformationPhone}}</td>
                            </tr>
                            <tr>
                                <th>Tài khoản</th>
                                <td>{{userId}}</td>
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
                                <th>Tên khoa</th>
                                <td>{{strFacultyInformationFullName}}</td>
                            </tr>
                        </table>
                    </div><!-- /.scroll -->
                </div><!-- /.box-shadow-r -->
            </div>

            <div class="modal-footer">
                <div class="btn-modal">
                    <button class="btn btn-delete btn-confirm btn-medium btn-fa" onclick="TeacherList.deleteOne('{{iTeacherInformationPk}}')" >
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


<script type="text/template7" id="table-template-teacher-list">
    <tr>
        <td class="txt-center">{{index}}</td>
        <td>{{iTeacherInformationPk}}
        </td>
        <td> {{strTeacherInformationLastName}} {{strTeacherInformationFirstName}} </td>
        <td>{{strFacultyInformationFullName}}</td>
        <td>{{strTeacherInformationPhone}}</td>
        <td>{{userId}}</td>
        <td>**********</td>
        <td class="txt-center">
            <button class="btn btn-update btn-small"
                    onclick="redirectPage('admin','a107_1','{{iTeacherInformationPk}}');" >Sửa</button><br/>
            <button class="btn btn-delete btn-small mt5" onclick="TeacherList.showDelete('{{iTeacherInformationPk}}');">Xóa</button>
        </td>
    </tr>
</script>

<script src="${pageContext.request.contextPath}/js/admin/teacher/teacher_list.js"></script>
