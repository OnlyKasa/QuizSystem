var ViewExamination = function () {

    let template7 = {
        compileList : Template7.compile($("#table-template-examination-list").html()) ,
        compileModalDetail : Template7.compile($("#template-detail-examination-list").html())
    };
    let url = {
        countListURL : contextPath + "/tests/count",
        searchListURL : contextPath + "/tests/search",
        detailURL : contextPath + "/tests/find/ID",
        startTestURL : contextPath +"/tests/beginTest/"
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
        let date = reFormatDate(new Date);
        $("#dtExaminationDay").val(date);
        console.log("a");
        search() ;
        $("#btnSearch").click(function () {
            search() ;
        });
    }
    //==========================================================list==========
    function search() {
        console.log(iStudentInformationPk);
        inputSearch ={
            strSubjectInformationName :$("#strSubjectInformationName").val(),
            iStudentInformationPk : iStudentInformationPk
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
            data[i]["dtExaminationDay"]= reFormatDateTime(data[i]["dtExaminationDay"]);

            $("#table-content").append(template7.compileList(data[i]));

            if(new Date(data[i]["dtExaminationDay"]) != new Date() || data[i]["fExaminationResultScore"] == 0.0){
                $(".btnGoTest").removeClass("btn-green");
                $(".btnGoTest").attr('disabled','disabled');
            }
        }
        countIndexExamination()
    }
    function searchError(err) {
        display(err.responseText)
    }
    function countIndexExamination() {
        countIndex(page.rowCount, page.rowPerPage, page.currentPage, 'txtPageCount', 'txtPageNavigator',"ViewExamination.changePage");
    }

    //===========================================Show detail

    function showDetail(iExaminationInformationPk) {
        executeGetNew(url.detailURL + iExaminationInformationPk,getSuccessDetail, getError)
    }

    function getSuccessDetail(res) {
        $("#modal-detail").modal("show");
        res["dtExaminationDay"]= reFormatDateTime(res["dtExaminationDay"]);
        $("#modal-detail").html(template7.compileModalDetail(res))
    }
    function getError(err) {
        display(err.responseText);
    }
    let iTestInformation = 0;
    function goToTests(iTestInformationPk) {
        iTestInformation = iTestInformationPk ;
        updateScore();
    }
    function updateScore() {

        executeGetNew(url.startTestURL +iTestInformation,updateSuccess, display);
    }
    function updateSuccess() {
        let date = reFormatDateTime(new Date());
        redirectPage('student','s101',{iTestInformationPk :iTestInformation,dateStartTest : date});
    }
    return{
        init : init,
        showDetail: showDetail,
        changePage : changePage,
        goToTests : goToTests
    }
}();

$(document).ready(function () {
   ViewExamination.init();
});