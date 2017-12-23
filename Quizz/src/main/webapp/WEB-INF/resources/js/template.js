//// Teacher ========================================
var pageX = {
    currentPage : 1,
    rowCount : 0,
    rowPerPage : rowPerPage,
    pageCount: 0
};
var listTeacher ;
urlCountTeacher = contextPath + "/teacher/count";
urlSearchTeacher= contextPath + "/teacher/search";

compilePopUpTeacher = Template7.compile($("#template-popup-teacher").html());
compileContenTableTeacher = Template7.compile($("#template-content-table-teacher").html());

function showTeacher() {
    countTeacher();
    $("#modal-list").modal("show");
    $("#modal-list").html(compilePopUpTeacher());

}
function countTeacher() {
    executeGetNew(urlCountTeacher,countSuccessX, countErrorX)
}
function countSuccessX(res) {
    if(res > 0){
        changePageX();
        pageX.rowCount = res;
        pageX.pageCount = Math.ceil(pageX.rowCount / pageX.rowPerPage);

    }else{
        clearDataX();
    }

}
function countErrorX(err) {
    $("#modal-list").modal("hide");
    display(err.responseText);
}
function clearDataX() {

    $("#table-content-teacher").empty();
    $("#table-content-teacher").html("<tr><td colspan='2'>"+noData+"</td></tr>");
    $("#txtPageCountX").empty();
    $("#txtPageNavigatorX").empty();
}
function changePageX(page){
    if(typeof page =="undefined"){
        pageX.currentPage = 1;
    }
    executeGetNew(urlSearchTeacher,searchSuccessX,searchErrorX);
}
function searchSuccessX(res) {
    listTeacher = res;
    $("#table-content-teacher").empty();
    let data = $.map(res, function (value) {
        return [value];
    });
    for (let i = 0; i < data.length; i++) {
        $("#table-content-teacher").append(compileContenTableTeacher(data[i]));
    }
    countIndexTeacher()
}
function countIndexTeacher() {
    countIndex(pageX.rowCount, pageX.rowPerPage, pageX.currentPage, 'txtPageCountX', 'txtPageNavigatorX',"changePageX");
}
function searchErrorX(err) {
    display(err.responseText);
}

function selectTeacher(iTeacherInformationPk){
    for (var i = 0; i < listTeacher.length; i++) {
        if (listTeacher[i].iTeacherInformationPk == iTeacherInformationPk) {
            $("#strTeacherInformationName").attr("iTeacherInformationPk", listTeacher[i].iTeacherInformationPk);
            $("#strTeacherInformationName").val(listTeacher[i].strTeacherInformationFirstName+" "+listTeacher[i].strTeacherInformationLastName);
            $("#strTeacherInformationNameErr").css("display", "none");
            $("#modal-list").modal("hide");
            return;
        }
    }
}

//end select teacher =================

// select subject

var pageY = {
    currentPage : 1,
    rowCount : 0,
    rowPerPage : rowPerPage,
    pageCount: 0
};
var listSubject ;
urlCountSubject = contextPath + "/subject/count";
urlSearchSubject= contextPath + "/subject/search";

compilePopUpSubject = Template7.compile($("#template-popup-subject").html());
compileContenTableSubject = Template7.compile($("#template-content-table-subject").html());

function showSubject() {

     $("#modal-list").modal("show");
     $("#modal-list").html(compilePopUpSubject());
     countSubject();
}
function countSubject() {
    executeGetNew(urlCountSubject,countSuccessY, countErrorY)
}
function countSuccessY(res) {
    if(res > 0){
        changePageY();
        pageY.rowCount = res;
        pageY.pageCount = Math.ceil(pageY.rowCount / pageY.rowPerPage);

    }else{
        clearDataY();
    }

}

function countErrorY(err) {
    $("#modal-list").modal("hide");
    display(err.responseText);
}
function clearDataY() {
    $("#table-content-subject").empty();
    $("#table-content-subject").html("<tr><td colspan='2'>"+noData+"</td></tr>");
    $("#txtPageCountY").empty();
    $("#txtPageNavigatorY").empty();
}
function changePageY(page){
    if(typeof page =="undefined"){
        pageY.currentPage = 1;
    }
    executeGetNew(urlSearchSubject,searchSuccessY,searchErrorY);
}
function searchSuccessY(res) {
    listTeacher = res;
    $("#table-content-subject").empty();
    let data = $.map(res, function (value) {
        return [value];
    });
    for (let i = 0; i < data.length; i++) {
        $("#table-content-subject").append(compileContenTableSubject(data[i]));
    }
    countIndexSubject()
}
function countIndexSubject() {
    countIndex(pageY.rowCount, pageY.rowPerPage, pageY.currentPage, 'txtPageCountY', 'txtPageNavigatorY',"changePageY");
}
function searchErrorY(err) {

    display(err.responseText);
}

function selectSubject(iSubjectInformationPk){
    for (var i = 0; i < listSubject.length; i++) {
        if (listSubject[i].iSubjectInformationPk == iSubjectInformationPk) {
            $("#strSubjectInformationName").attr("iTeacherInformationPk", listTeacher[i].iSubjectInformationPk);
            $("#strSubjectInformationName").val(listSubject[i].strSubjectInformationName);
            $("#strSubjectInformationNameErr").css("display", "none");
            $("#modal-list").modal("hide");
            return;
        }
    }
}


var pageZ= {
    currentPage : 1,
    rowCount : 0,
    rowPerPage : rowPerPage,
    pageCount: 0
};
var listDifficulty ;
urlCountDifficulty  = contextPath + "/difficulty/count";
urlSearchDifficulty = contextPath + "/difficulty/search";

compilePopUpDifficulty = Template7.compile($("#template-popup-difficulty").html());
compileContenTableDifficulty = Template7.compile($("#template-content-table-difficulty").html());

function showDifficulty() {
    countDifficulty();
     $("#modal-list").modal("show");
     $("#modal-list").html(compilePopUpDifficulty())
}
function countDifficulty() {
    executeGetNew(urlCountDifficulty,countSuccessZ, countErrorZ)
}
function countSuccessZ(res) {
    if(res > 0){
        changePageZ();
        pageY.rowCount = res;
        pageY.pageCount = Math.ceil(pageY.rowCount / pageY.rowPerPage);

    }else{
        clearDataZ();
    }

}
function countErrorZ(err) {
    $("#modal-list").modal("hide");
    display(err.responseText);
}
function clearDataZ() {
    $("#table-content-difficulty").empty();
    $("#table-content-difficulty").html("<tr><td colspan='2'>"+noData+"</td></tr>");
    $("#txtPageCountZ").empty();
    $("#txtPageNavigatorZ").empty();
}
function changePageZ(page){
    if(typeof page =="undefined"){
        pageY.currentPage = 1;
    }
    executeGetNew(urlSearchDifficulty,searchSuccessZ,searchErrorZ);
}
function searchSuccessZ(res) {
    listDifficulty = res;
    $("#table-content-difficulty").empty();
    let data = $.map(res, function (value) {
        return [value];
    });
    for (let i = 0; i < data.length; i++) {
        $("#table-content-difficulty").append(compileContenTableDifficulty(data[i]));
    }
    countIndexDifficulty()
}
function countIndexDifficulty() {
    countIndex(pageZ.rowCount, pageZ.rowPerPage, pageZ.currentPage, 'txtPageCountZ', 'txtPageNavigatorZ',"changePageZ");
}
function searchErrorZ(err) {
    display(err.responseText);
}

function selectDifficulty(iRateOfDifficultyPk){
    for (var i = 0; i < listDifficulty.length; i++) {
        if (listDifficulty[i].iRateOfDifficultyPk == iRateOfDifficultyPk) {
            $("#strRateDifficultyName").attr("iRateOfDifficultyPk", listDifficulty[i].iRateOfDifficultyPk);
            $("#strRateDifficultyName").val(listDifficulty[i].strRateDifficultyName);
            $("#strRateDifficultyNameErr").css("display", "none");
            $("#modal-list").modal("hide");
            return;
        }
    }
}



var pageR= {
    currentPage : 1,
    rowCount : 0,
    rowPerPage : rowPerPage,
    pageCount: 0
};
var listRoom ;
var urlCountRoom= contextPath + "/room/count";
var urlSearchRoom = contextPath + "/room/search";
var compilePopUpRoom = Template7.compile($("#template-popup-room").html());
var compileContentTableRoom = Template7.compile($("#template-content-table-room").html());

function showRoom() {
    $("#modal-list").modal("show");
    $("#modal-list").html(Template7.compile(compilePopUpRoom()));
    countRoom();
}
function countRoom() {

    executeGetNew(urlCountRoom,countSuccessR, countErrorR)
}
function countSuccessR(res) {
        changePageR();
        pageR.rowCount = res;
        pageR.pageCount = Math.ceil(pageR.rowCount / pageR.rowPerPage);
}
function countErrorR(err) {
    $("#modal-list").modal("hide");
    display(err.responseText);
}
function clearDataR() {
    $("#table-content-room").empty();
    $("#table-content-room").html("<tr><td colspan='2'>"+noData+"</td></tr>");
    $("#txtPageCountR").empty();
    $("#txtPageNavigatorR").empty();
}
function changePageR(page){
    if(typeof page =="undefined"){
        pageR.currentPage = 1;
    }
    executeGetNew(urlSearchRoom,searchSuccessR,searchErrorR);
}
function searchSuccessR(res) {
    if(res.length > 0){
        listRoom = res;
        $("#table-content-room").empty();
        let data = $.map(res, function (value) {
            return [value];
        });
        for (let i = 0; i < data.length; i++) {
            $("#table-content-room").append(compileContentTableRoom(data[i]));
        }
        countIndexRoom()
    }else
        clearDataR();
}
function countIndexRoom() {
    countIndex(pageR.rowCount, pageR.rowPerPage, pageR.currentPage, 'txtPageCountR', 'txtPageNavigatorR',"changePageR");
}
function searchErrorR(err) {
    $("#modal-list").modal("hide");
    display(err.responseText);
}

function selectRoom(iExaminationRoomPk){
    console.log(iExaminationRoomPk);
    for (var i = 0; i < listRoom.length; i++) {
        if (listRoom[i].iExaminationRoomPk == iExaminationRoomPk) {
            $("#strExaminationRoomName").attr("iExaminationRoomPk", listRoom[i].iExaminationRoomPk);
            $("#strExaminationRoomName").val(listRoom[i].strExaminationRoomName);
            $("#strExaminationRoomNameErr").css("display", "none");
            $("#modal-list").modal("hide");
            return;
        }
    }
}

