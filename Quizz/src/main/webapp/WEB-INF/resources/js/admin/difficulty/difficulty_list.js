var DifficultyList = function () {


    let template7 = {
        compileList : Template7.compile($("#table-template-difficulty-list").html()) ,
        compileModalDelete : Template7.compile($("#template-delete-difficulty-list").html())
    };
    let url = {
        countListURL : contextPath + "/difficulty/count",
        searchListURL : contextPath + "/difficulty/search",
        deleteURL : contextPath + "/difficulty/delete/"
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
        $("#sub_menu_difficulty").addClass("sub-active");

        search() ;
        $("#btnSearch").click(function () {
            search() ;
        });


    }
    //==========================================================list==========
    function search() {
        inputSearch ={
            strRateDifficultyName: $("#strRateDifficultyName").val()
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
        countIndexDifficulty()
    }
    function searchError(err) {
        display(err.responseText)
    }
    function countIndexDifficulty() {
        countIndex(page.rowCount, page.rowPerPage, page.currentPage, 'txtPageCount', 'txtPageNavigator',"DifficultyList.changePage");
    }

    function deleteOne(iRateOfDifficultyPk) {
        executeDeleteNew(url.deleteURL + iRateOfDifficultyPk,deleteSuccess,deleteError);
    }

    function deleteSuccess() {
        displayDeleted("admin","a102");
    }
    function deleteError(err) {
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
    DifficultyList.init() ;
});

