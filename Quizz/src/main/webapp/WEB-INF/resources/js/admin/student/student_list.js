var StudentList = function () {


    let template7 = {
        compileList : Template7.compile($("#table-template-student-list").html()) ,
        compileModalDelete : Template7.compile($("#template-delete-student-list").html())
    };
    let url = {
        countListURL : contextPath + "/student/count",
        searchListURL : contextPath + "/student/search",
        deleteURL : contextPath + "/student/delete/",
        detailURL : contextPath + "/student/find/ID"
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
        $("#menu_student").addClass("active");

        search() ;
        $("#btnSearch").click(function () {
            search() ;
        });
    }
    //==========================================================list==========
    function search() {
        inputSearch ={
            iStudentInformationCode: $("#iStudentInformationCode").val(),
            strStudentInformationFirstName: $("#strStudentInformationFirstName").val(),
            strStudentInformationLastName : $("#strStudentInformationLastName").val()
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
        }else
            page.currentPage=pg;
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
        countIndexStudent()
    }
    function searchError(err) {
        display(err.responseText)
    }
    function countIndexStudent() {
        countIndex(page.rowCount, page.rowPerPage, page.currentPage, 'txtPageCount', 'txtPageNavigator',"StudentList.changePage");
    }

    function deleteOne(iStudentInforamtionPk) {
        executeDeleteNew(url.deleteURL + iStudentInforamtionPk,deleteSuccess,deleteError);
    }

    function deleteSuccess() {
        displayDeleted("admin","a106");
    }
    function deleteError(err) {
        display(err.responseText);
    }

    //===========================================Show detail


    function getError(err) {
        display(err.responseText);
    }


    function showDelete(iStudentInformationPk) {
        executeGetNew(url.detailURL + iStudentInformationPk,getSuccessDelete, getError)
    }
    function getSuccessDelete(res) {
        console.log(res);
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
    StudentList.init() ;
});

