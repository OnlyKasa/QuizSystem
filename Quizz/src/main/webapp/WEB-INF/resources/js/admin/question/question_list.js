var QuestionList = function () {


    let template7 = {
        compileList : Template7.compile($("#table-template-question-list").html()) ,
        compileModalDetail : Template7.compile($("#template-detail-question-list").html()),
        compileModalDelete : Template7.compile($("#template-delete-question-list").html())
    };
    let url = {
        countListURL : contextPath + "/question/count",
        searchListURL : contextPath + "/question/search",
        deleteURL : contextPath + "/question/delete/",
        detailURL : contextPath + "/question/find/ID"
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
        $("#sub_menu_question").addClass("sub-active");

        search() ;
        $("#btnSearch").click(function () {
            search() ;
        });


    }
    //==========================================================list==========
    function search() {
        inputSearch ={
            strQuestionContentInformation: $("#strQuestionContentInformation").val(),
            strSubjectInformationName :$("#strSubjectInformationName").val(),
            strTeacherInformationFirstName:$("#strTeacherInformationFirstName").val(),
            strTeacherInformationLastName:$("#strTeacherInformationLastName").val(),
            iQuestionInformationLevel:$("#iQuestionInformationLevel").val()
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
            if(data[i]["iQuestionInformationLevel"]==1){
                data[i]["vcQuestionInformationLevel"] = "Độ khó 1 (dễ)";
            }
            if(data[i]["iQuestionInformationLevel"]==2){
                data[i]["vcQuestionInformationLevel"] ="Độ khó 2 (trung bình )";
            }
            if(data[i]["iQuestionInformationLevel"]==3){
                data[i]["vcQuestionInformationLevel"] = "Độ khó 3 (khó)";
            }
            if(data[i]["iQuestionInformationLevel"]==4){
                data[i]["vcQuestionInformationLevel"] = "Độ khó 4 (cực khó)";
            }
            $("#table-content").append(template7.compileList(data[i]));
        }
        countIndexQuestion()
    }
    function searchError(err) {
        display(err.responseText)
    }
    function countIndexQuestion() {
        countIndex(page.rowCount, page.rowPerPage, page.currentPage, 'txtPageCount', 'txtPageNavigator',"QuestionList.changePage");
    }

    function deleteOne(iQuestionInformationPk) {
        executeDeleteNew(url.deleteURL + iQuestionInformationPk,deleteSuccess,deleteError);
    }

    function deleteSuccess() {
        displayDeleted("admin","a104");
    }
    function deleteError(err) {
        display(err.responseText);
    }

    //===========================================Show detail

    function showDetail(iQuestionInformationPk) {
        executeGetNew(url.detailURL + iQuestionInformationPk,getSuccessDetail, getError)
    }

    function getSuccessDetail(res) {
        $("#modal-detail").modal("show");
        if(res["iQuestionInformationLevel"]==1){
            res["vcQuestionInformationLevel"] = "Độ khó 1 (dễ)";
        }
        if(res["iQuestionInformationLevel"]==2){
            res["vcQuestionInformationLevel"] = "Độ khó 2 (trung bình )";
        }
        if(res["iQuestionInformationLevel"]==3){
            res["vcQuestionInformationLevel"] = "Độ khó 3 (khó)";
        }
        if(res["iQuestionInformationLevel"]==4){
            res["vcQuestionInformationLevel"] = "Độ khó 4 (cực khó)";
        }
        $("#modal-detail").html(template7.compileModalDetail(res))
    }
    function getError(err) {
        display(err.responseText);
    }


    function showDelete(iQuestionInformationPk) {
        executeGetNew(url.detailURL + iQuestionInformationPk,getSuccessDelete, getError)
    }
    function getSuccessDelete(res) {
        $("#modal-delete").modal("show");
        $("#modal-delete").html(template7.compileModalDelete(res));
    }
    return{
        init : init,
        deleteOne: deleteOne,
        showDetail: showDetail,
        showDelete: showDelete,
        changePage : changePage
    }
}();


$(document).ready(function () {
    QuestionList.init() ;
});

