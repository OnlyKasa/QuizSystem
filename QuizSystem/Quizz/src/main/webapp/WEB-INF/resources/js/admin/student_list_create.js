var StudentListCreate= function () {
    let mess = "Số lượng sinh viên thêm đã quá số lượng";
    let listTestForStudent =[];
    let listStudentChecked=[];
    let iSubjectInformationPk = 0;
    let iRateOfDifficultyPk =0;
    let template7 ={
        compileList : Template7.compile($("#template-student-content").html())
    };

    let examination = {
        numQuestionLv1 : 0,
        numQuestionLv2 : 0,
        numQuestionLv3 : 0,
        numQuestionLv4 : 0
    };
    let url = {
        urlGetListQuestionForExamination : contextPath +"/question/findBySubjectID/" ,
        urlCountListQuestion : contextPath +"/question/countBySubjectID/",
        urlFindOneExamination : contextPath + "/examination/find/ID" + iExaminationInformationPk,
        urlListOldStudentInExamination : contextPath + "/findDetailExamination/"+ iExaminationInformationPk,
        urlCountStudent:contextPath+"/student/count",
        urlSearchStudent:contextPath +"/student/search"
    };

    let page = {
        currentPage : 1,
        rowCount : 0,
        rowPerPage : rowPerPage,
        pageCount: 0
    };
    let  inputSearch;

    function checkChecked(iExaminationInformationPk) {
        if(listStudentChecked.includes(iExaminationInformationPk))
            return true;
        else
            return false;
    }

    function init() {
        loadOldExamination();
        setTimeout(function () {
            loadDifficulty();
        },1000);
        setTimeout(function () {
            findQuestion();
        },3000);
        getListStudentOld();

        search() ;
        $("#btnSearch").click(function () {
            search() ;
        });
    }

    function search() {
        inputSearch ={
            strStudentInformationCode: $("#strStudentInformationCode").val(),
            strFacultyInformationName : $("#strFacultyInformationName").val(),
            strStudentInformationFirstName:$("#strStudentInformationName").val(),
            strStudentInformationLastName:$("#strStudentInformationName").val()
        };
        count(inputSearch);
    }

    function count(inputSearch){
        executeGetNew(url.urlCountStudent +"?"+ paramEncode(inputSearch),countSuccess,display);
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
        executeGetNew(url.urlSearchStudent +"?"+ paramEncode(inputSearch),searchSuccess,searchError);
    }

    
    let listStudent=[];
    function searchSuccess(res) {
        listStudent =res;
        $("#table-content").empty();
        let data = $.map(res, function (value) {
            return [value];
        });
        for (let i = 0; i < data.length; i++) {
            data[i]["index"] = (((page.currentPage - 1) * page.rowPerPage) + i + 1).toString();

            $("#table-content").append(template7.compileList(data[i]));
            if(checkChecked(data[i].iStudentInformationPk)){
                $("#checkbox-"+data[i].iStudentInformationPk).attr("checked","checked")
            }

            $("#checkbox-"+data[i].iStudentInformationPk).click(function () {
                if("#checkbox-"+data[i].iStudentInformationPk.is(':checked')){
                    if(!checkChecked(data[i].iStudentInformationPk)){
                        if(listStudentChecked.length > numberStudent){
                            display(mess);
                            return;
                        }
                        listStudentChecked.push(data[i].iStudentInformationPk);
                    }
                }else{
                    let index = listStudentChecked.indexOf(data[i].iStudentInformationPk);
                    if (index > -1) {
                        listStudentChecked.splice(index, 1);
                    }
                }
            })
        }

        $("#checkbox-all").click(function () {
            if($("#checkbox-all").is(':checked')){
                for (let i = 0; i < data.length; i++) {
                    if(!checkChecked(data[i].iStudentInformationPk)){
                        if(listStudentChecked.length > numberStudent){
                            display(mess);
                            return;
                        }
                        $("#checkbox-"+data[i].iStudentInformationPk)[0].checked = true;
                        listStudentChecked.push(data[i].iStudentInformationPk);
                    }
                }
            }
            else{
                for (let i = 0; i < data.length; i++) {
                    if(checkChecked(data[i].iStudentInformationPk)){
                        $("#checkbox-"+data[i].iStudentInformationPk)[0].checked = false;
                        var index = listStudentChecked.indexOf(data[i].iStudentInformationPk);
                        if (index > -1) {
                            listStudentChecked.splice(index,1);
                        }
                    }
                }
            }
        });
        countIndexExamination();
        $("#add-list").click(function () {
            AddStudentAndTests();
        })
    }
    
    function AddStudentAndTests() {
        listStudentChecked , listTestForStudent;
        for(let i =0 ;i< listTestForStudent.length;i++){

        }
    }
    
    function searchError(err) {
        display(err.responseText)
    }
    function countIndexExamination() {
        countIndex(page.rowCount, page.rowPerPage, page.currentPage, 'txtPageCount', 'txtPageNavigator',"StudentListCreate.changePage");
    }



    function getListStudentOld() {
        executeGetNew(url.urlListOldStudentInExamination,getSuccess, display);
    }

    function getSuccess(res) {
        for (let i= 0 ; i< res.length;i++){
            listStudentChecked.push(res[i].iStudentInformationPk);
        }

    }

    function loadDifficulty() {
        if(iRateOfDifficultyPk == null){
            display("Có lỗi xảy ra với dữ liệu của kỳ thi. Kiểm tra lại trường đánh giá độ khó.");
            return
        }

        executeGetNew(url.urlFindDifficulty +iRateOfDifficultyPk,findSuccessDifficulty,findErrorDifficulty);

    }
    function findSuccessDifficulty(res) {
        examination.numQuestionLv1 = res.iNumQuestionLevel1;
        examination.numQuestionLv2 = res.iNumQuestionLevel2;
        examination.numQuestionLv3 = res.iNumQuestionLevel3;
        examination.numQuestionLv4 = res.iNumQuestionLevel4;
    }

    function findErrorDifficulty(err) {
        display(err.responseText);
    }
    let listQuestionLv1 = [];
    let listQuestionLv2 = [];
    let listQuestionLv3 = [];
    let listQuestionLv4 = [];
    let listTestsLv1 = [];
    let listTestsLv2 =[];
    let listTestsLv3 =[];
    let listTestsLv4 =[];
    function findQuestion() {
        if(iSubjectInformationPk == null){
            return
        }
        executeGetNew(url.urlGetListQuestionForExamination + iSubjectInformationPk ,findQuestionSuccess,display);
    }

    function findQuestionSuccess(res) {
        for(let i=0 ;i< res.length;i++){
            if(res[i].iQuestionInformationLevel = 1){
                listQuestionLv1.push(res[i]);
            }
            if(res[i].iQuestionInformationLevel = 2){
                listQuestionLv2.push(res[i]);
            }
            if(res[i].iQuestionInformationLevel = 3){
                listQuestionLv3.push(res[i]);
            }
            if(res[i].iQuestionInformationLevel = 4){
                listQuestionLv4.push(res[i]);
            }
        }
        listTestsLv1 = getListQuestionForStudents(listQuestionLv1,examination.numQuestionLv1,percentMatch);
        listTestsLv2 = getListQuestionForStudents(listQuestionLv2,examination.numQuestionLv2,percentMatch);
        listTestsLv3 = getListQuestionForStudents(listQuestionLv3,examination.numQuestionLv3,percentMatch);
        listTestsLv4 = getListQuestionForStudents(listQuestionLv4,examination.numQuestionLv4,percentMatch);


        for(let i =0 ;i<listQuestionLv1.length;i++){
            let subList = [];
            copyElement(listQuestionLv1[i],subList);
            copyElement(listQuestionLv2[i],subList);
            copyElement(listQuestionLv3[i],subList);
            copyElement(listQuestionLv4[i],subList);
            listTestForStudent.push(subList);
        }
    }



    function loadOldExamination() {
        executeGetNew(url.urlFindOneExamination,findSuccess, findError);
    }


    function findSuccess(res) {
        iSubjectInformationPk =res.iSubjectInformationPk ;
        iRateOfDifficultyPk =res.iRateOfDifficultyPk;
    }
    
    function findError(err) {
        display(err.responseText);
    }

    return{
        init : init
    }
}();


$(document).ready(function () {
   StudentListCreate.init() ;
});