var SubjectList = function () {


    let template7 = {
        compileList : Template7.compile($("#table-template-subject-list").html()) ,
        compileModalDelete : Template7.compile($("#template-delete-subject-list").html())
    };
    let url = {
        countListURL : contextPath + "/subject/count",
        searchListURL : contextPath + "/subject/search",
        deleteURL : contextPath + "/subject/delete/",
        detailURL : contextPath + "/subject/find/ID"
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
        $("#sub_menu_subject").addClass("sub-active");

        search() ;
        $("#btnSearch").click(function () {
            search() ;
        });


    }
    //==========================================================list==========
    function search() {
        inputSearch = {
            iSubjectInformationPk: $("#iSubjectInformationPk").val(),
            strSubjectInformationName: $("#strSubjectInformationName").val(),
            iSubjectInformationCreditsNum: $("#iSubjectInformationCreditsNum").val(),
        }
        count(inputSearch);
    }
    function count(inputSearch){
        executeGetNew(url.countListURL +"?"+ paramEncode(inputSearch),countSuccess,display);
    }
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
        $("#table-content").html("<tr><td colspan='2'>"+noData+"</td></tr>");
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
        $("#table-content").empty();
        let data = $.map(res, function (value) {
            return [value];
        });
        for (let i = 0; i < data.length; i++) {
            data[i]["index"] = (((page.currentPage - 1) * page.rowPerPage) + i + 1).toString();
            $("#table-content").append(template7.compileList(data[i]));
        }
        countIndexSubject()
    }
    function searchError(err) {
        display(err.responseText)
    }
    function countIndexSubject() {
        countIndex(page.rowCount, page.rowPerPage, page.currentPage, 'txtPageCount', 'txtPageNavigator',"SubjectList.changePage");
    }

    function deleteOne(iSubjectInformationPk) {
        executeDeleteNew(url.deleteURL + iSubjectInformationPk,deleteSuccess,deleteError);
    }

    function deleteSuccess() {
        displayDeleted("admin","a105");
    }
    function deleteError(err) {
        display(err.responseText);
    }



    function showDelete() {
        let iSubjectInformationPk = $("#iSubjectInformationPk").html();
        executeGetNew(url.detailURL + iSubjectInformationPk,getSuccessDelete, getError)
    }
    function getSuccessDelete(res) {
        $("#modal-delete").modal("show");
        $("#modal-delete").html(template7.compileModalDelete(res));
    }
    function getError(err) {
        display(err.responseText);
    }

    return{
        init : init,
        deleteOne: deleteOne,
        showDelete: showDelete,
        changePage : changePage
    }
}();


$(document).ready(function () {
    SubjectList.init() ;
});

