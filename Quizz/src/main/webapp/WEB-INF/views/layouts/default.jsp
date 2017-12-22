<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="${pageContext.request.contextPath}/img/favicon.ico" rel="icon" type="image/x-icon" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><tiles:getAsString name="title" /></title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap-select.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap-datepicker3.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/jquery.datetimepicker.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/custom.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/lib/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/config.js"></script>
    <script src="${pageContext.request.contextPath}/js/lib/template7.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/lib/jquery.formatCurrency-1.4.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/lib/jquery.formatCurrency.ja.js"></script>
    <script src="${pageContext.request.contextPath}/js/lib/encoding.js"></script>
    <script src="${pageContext.request.contextPath}/js/lib/encoding-indexes.js"></script>
</head>

<body>
<div id="errorModalGlobal" class="modal fade" role="dialog" style="z-index: 9999;">
    <div class="modal-dialog modal-sm">
        <!-- Modal alert-->
        <div class="modal-content alert alert-danger" id="mdlContentGlobal">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 id="txtModalHeaderGlobal" class="modal-title">Có lỗi xảy ra. Xin thử lại.</h4>
            </div>
            <div class="modal-body" id="txtMsgErrorGlobal"></div>
        </div>
    </div>
</div>
<div id="modal-delete-success" class="modal-success modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-body alert alert-success">
               Xóa thành công bản ghi.
            </div><!-- /.modal-body -->
        </div>
    </div>
</div><!-- /.modal -->
<div id="modal-update-success" class="modal-success modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-body alert alert-success">
               Cập nhật thành công.
            </div><!-- /.modal-body -->
        </div>
    </div>
</div><!-- /.modal -->
<div id="modal-create-success" class="modal-success modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-body alert alert-success">
               Tạo mới thành công.
            </div><!-- /.modal-body -->
        </div>
    </div>
</div><!-- /.modal -->
<script>
    //Config Url
    var contextPath = "${pageContext.request.contextPath}";
</script>
    <section class="page-wrap-2">
        <tiles:insertAttribute name="template"/>
        <header class="header">
            <tiles:insertAttribute name="header" />
            <tiles:insertAttribute name="menu" />
        </header>
        <section id="mainContainer" class="container">
            <tiles:insertAttribute name="body" />
        </section>
    </section>
    <div id="spinner" class="spinner" style="display:none;" class="modal fade" role="dialog">
        <img id="img-spinner" src="${pageContext.request.contextPath}/img/loading.gif"/>
    </div>
	<tiles:insertAttribute name="footer" />
<script>

</script>

</body>
</html>