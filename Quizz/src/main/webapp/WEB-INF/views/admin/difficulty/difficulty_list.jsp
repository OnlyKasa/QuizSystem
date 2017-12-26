<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page session="false"%>
<%@ page isELIgnored="false"%>

<h1 class="heading-1 margin-bottom background"><span>Danh sách cài đặt độ khó</span></h1>
<section class="form-search form-style">
    <p class="caption btn-box-toggle">
        <i class="fa fa-chevron-circle-right" aria-hidden="true"></i>
        Nhập để tìm kiếm
    </p>

    <div class="box-toggle row">
        <div class="col-xs-12 clear-padding">
            <div class="col-xs-12 col-sm-6 col-lg-4 mt-xs">
                <label>Tên của cài đặt độ khó</label>
                <input class="form-control" type="text" id="strRateDifficultyName"/>
            </div>
        </div>

        <div class="col-xs-12 col-sm-2 col-button float-r mt">
            <button class="btn btn-search btn-green w100p btn-fa" id="btnSearch"><i class="fa fa-search" aria-hidden="true"></i>Tìm kiếm</button>
        </div>
    </div>
</section><!-- /.form-search -->

<div class="row row-small layout mt20">
    <div class="col-xs-12 col-sm-inline padding-small">
        <button class="btn btn-blue btn-reponsive btn-medium float-l" onclick="redirectPage('admin','a102_2');">Thêm mới</button>
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
                <col class="col-button" />
            </colgroup>
            <tr>
                <th class="first-child">STT</th>
                <th><a>Tên cài đặt độ khó</a></th>
                <th><a>Số câu mức độ 1 (mức dễ) </a></th>
                <th><a>Số câu mức độ 2 (mức trung bình) </a></th>
                <th><a>Số câu mức độ 3 (mức khó) </a></th>
                <th><a>Số câu mức độ 4 (mức cực khó) </a></th>
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

<script type="text/template7" id="template-delete-difficulty-list">
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
                <h4 class="heading-4 txt-center mb15">Thông tin cài đặt độ khó</h4>

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
            </div>

            <div class="modal-footer">
                <div class="btn-modal">
                    <button class="btn btn-delete btn-confirm btn-medium btn-fa" onclick="DifficultyList.deleteOne('{{iRateOfDifficultyPk}}')" >
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


<script type="text/template7" id="table-template-difficulty-list">
    <tr>
        <td class="txt-center">{{index}}</td>
        <td>
            {{strRateDifficultyName}}
            <a style="display:none" id="iRateOfDifficultyPk">{{iRateOfDifficultyPk}}</a>
        </td>
        <td>{{iNumQuestionLevel1}}</td>
        <td>{{iNumQuestionLevel2}}</td>
        <td>{{iNumQuestionLevel3}}</td>
        <td>{{iNumQuestionLevel4}}</td>
        <td class="txt-center">
            <button class="btn btn-update btn-small"
                    onclick="redirectPage('admin','a102_1','{{iRateOfDifficultyPk}}');" >Sửa</button><br/>
            <button class="btn btn-delete btn-small mt5" onclick="DifficultyList.showDelete();">Xóa</button>
        </td>
    </tr>
</script>

<script src="${pageContext.request.contextPath}/js/admin/difficulty/difficulty_list.js"></script>
