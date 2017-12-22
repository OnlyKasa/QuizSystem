var ExaminationList = function () {


    let template7 = {
        compileList : Template7.compile($("#table-template-examination-list").html()) ,
        compileModalDetail : Template7.compile($("#template-detail-examination-list").html()),
        compileModalDelete : Template7.compile($("#template-delete-examination-list").html())
    };
    let url = {
        countListURL : contextPath + "/examination/count",
        searchListURL : contextPath + "/examination/search",
        deleteURL : contextPath + "/examination/delete/",
        detailURL : contextPath + "/examination/find/ID"
    };

    let page = {
        currentPage : 1,
        rowCount : 0,
        rowPerPage : rowPerPage,
        pageCount: 0
    };

    let sort ={
        ascending : true,
        sortedBy :""
    };
    let  inputSearch;

    function init() {
        inputSearch="";
        $("#menu_examination").addClass("active");
        $("#sub_menu_examination").addClass("sub-active");

        search() ;
        $("#btnSeach").click(function () {
            search() ;
        });


    }
    //==========================================================list==========
    function search() {
        inputSearch ={
            strExaminationInformationCode: $("#strExaminationInformationCode").val(),
            strRateDifficultyName: $("#strRateDifficultyName").val(),
            strExaminationRoomName : $("#strExaminationRoomName").val(),
            strSubjectInformationName :$("#strSubjectInformationName").val(),
            strTeacherInformationFirstName:$("#strTeacherInformationFirstName").val(),
            strTeacherInformationLastName:$("#strTeacherInformationLastName").val()
        };
        if($("#dtExaminationDay").val() != ""){
          inputSearch["dtExaminationDay"] = formatNormalDateTime($("#dtExaminationDay").val());
        }
        count(inputSearch);
    }
    function count(inputSearch){
        executeGetNew(url.countListURL +"?"+ paramEncode(inputSearch),countSuccess,display);
    };
    function countSuccess(res){
        if(res >0 ){
            changePage();
            page.rowCount = res;
            page.pageCount = Math.ceil(page.rowCount / page.rowPerPage);
        }else{
            cleanTable();
        }

    }
    function cleanTable(){
        $("#table_content").html("<tr><td colspan='2'>"+noData+"</td></tr>");
        $("#txtPageCount").empty();
        $("#txtPageNavigator").empty();
    }

    function changePage(pg) {
        if(typeof pg =="undefined"){
            page.currentPage = 1;
        }
        inputSearch["page"] = page.currentPage ;
        inputSearch["rowPerPage"] = page.rowPerPage ;
        executeGetNew(url.searchListURL +"?"+ paramEncode(inputSearch),searchSuccess,searchError);
    }

    function searchSuccess(res) {
        $("#table_content").empty();
        let data = $.map(res, function (value) {
            return [value];
        });
        for (let i = 0; i < data.length; i++) {
            data[i]["index"] = (((page.currentPage - 1) * page.rowPerPage) + i + 1).toString();
            $("#table_content").append(template7.compileList(data[i]));
        }
        countIndexExamination()
    }
    function searchError(err) {
        display(err.responseText)
    }
    function countIndexExamination() {
        countIndex(page.rowCount, page.rowPerPage, page.currentPage, 'txtPageCount', 'txtPageNavigator',"ExaminationList.changePage");
    }

    function deleteOne(iExaminationInformationPk) {
        executeDeleteNew(url.deleteURL + iExaminationInformationPk,deleteSuccess,deleteError);
    }

    function deleteSuccess() {
        displayDeleted("admin","a101");
    }
    function deleteError(err) {
        display(err.responseText);
    }

    //===========================================Show detail

    function showDetail() {
        console.log("asdasd");
        let iExaminationInformationPk = $("#iExaminationInformationPk").html();
        executeGetNew(url.detailURL + iExaminationInformationPk,getSuccessDetail, getError)
    }

    function getSuccessDetail(res) {
        $("#modal-detail").modal("show");
        $("#modal-detail").html(template7.compileModalDetail(res))
    }
    function getError(err) {
        display(err.responseText);
    }


    function showDelete() {
        let iExaminationInformationPk = $("#iExaminationInformationPk").html();
        executeGetNew(url.detailURL + iExaminationInformationPk,getSuccessDelete, getError)
    }
    function getSuccessDelete(res) {
        $("#modal-delete").modal("show");
        $("#modal-delete").html(template7.compileModalDelete(res));
    }
    return{
        init : init,
        deleteOne: deleteOne,
        showDetail: showDetail,
        showDelete: showDelete
    }
}();


$(document).ready(function () {
    ExaminationList.init() ;
});

