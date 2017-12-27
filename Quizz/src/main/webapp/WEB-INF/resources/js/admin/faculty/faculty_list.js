var FacultyList = function () {


    let template7 = {
        compileList : Template7.compile($("#table-template-faculty-list").html()) ,
        compileModalDelete : Template7.compile($("#template-delete-faculty-list").html())
    };
    let url = {
        countListURL : contextPath + "/faculty/count",
        searchListURL : contextPath + "/faculty/search",
        deleteURL : contextPath + "/faculty/delete/",
        detailURL: contextPath +"/faculty/find/ID"
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
        $("#menu_faculty").addClass("active");

        search() ;
        $("#btnSearch").click(function () {
            search() ;
        });

    }
    //==========================================================list==========
    function search() {
        inputSearch ={
            strFacultyInformationShortName: $("#strFacultyInformationShortName").val(),
            strFacultyInformationFullName:$("#strFacultyInformationFullName").val()
        };

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
        countIndexFaculty()
    }
    function searchError(err) {
        display(err.responseText)
    }
    function countIndexFaculty() {
        countIndex(page.rowCount, page.rowPerPage, page.currentPage, 'txtPageCount', 'txtPageNavigator',"FacultyList.changePage");
    }

    function deleteOne(iFacultyInformationPk) {
        executeDeleteNew(url.deleteURL + iFacultyInformationPk,deleteSuccess,deleteError);
    }

    function deleteSuccess() {
        displayDeleted("admin","a101");
    }
    function deleteError(err) {
        display(err.responseText);
    }


    function getError(err) {
        display(err.responseText);
    }


    function showDelete(iFacultyInformationPk) {
        executeGetNew(url.detailURL + iFacultyInformationPk,getSuccessDelete, getError)
    }
    function getSuccessDelete(res) {
        $("#modal-delete").modal("show");
        $("#modal-delete").html(template7.compileModalDelete(res));
    }
    return{
        init : init,
        deleteOne: deleteOne,
        showDelete: showDelete,
        changePage : changePage
    }
}();


$(document).ready(function () {
    FacultyList.init() ;
});

