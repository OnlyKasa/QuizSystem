var ExaminationEdit= function () {

    let template7 ={
        confirmUpdate: Template7.compile($("#templateConfirm").html())
    };

    let url = {
      urlUpdate : contextPath + "/examination/update",
      urlFindOne : contextPath + "/examination/find/ID" + iExaminationInformationPk
    };
    function init() {
        console.log("inint");
        validUtil.autoValidation("form-update-teacher",ExaminationEdit.submit);
        $("#btnConfirm").click(function () {
            validUtil.autoValidation("form-update-teacher",ExaminationEdit.submit);
        });

        loadOld();

    }

    function loadOld() {
        executeGetNew(url.urlFindOne,findSuccess, findError);
    }
    function findSuccess(res) {
        $("#strExaminationInformationCode").val(res.strExaminationInformationCode);
        $("#strExaminationRoomName").val(res.strExaminationRoomName);
        $("#strExaminationRoomName").attr("iExaminationRoomPk", res.iExaminationRoomPk);

        $("#strSubjectInformationName").val(res.strSubjectInformationName);
        $("#strSubjectInformationName").attr("iSubjectInformationPk", res.iTeacherInformationPk);

        if(res.strTeacherInformationFirstName != null || res.strTeacherInformationLastName != null)
            $("#strTeacherInformationName").val(res.strTeacherInformationFirstName +" "+ res.strTeacherInformationLastName);
        $("#strTeacherInformationName").attr("iTeacherInformationPk", res.iTeacherInformationPk);

        $("#dtExaminationDay").val(reFormatDateTime(res.dtExaminationDay));
        $("#strRateDifficultyName").val(res.strRateDifficultyName);
        $("#strRateDifficultyName").attr("iRateOfDifficultyPk", res.iRateOfDifficultyPk);
        $("#iTestInformationTime").val(res.iTestInformationTime);
    }
    function findError(err) {
        display(err.responseText);
    }
    function submit() {
        let newdata = {
            strExaminationInformationCode:$("#strExaminationInformationCode").val().trim() ,
            iExaminationRoomPk:  $("#strExaminationRoomName").attr("iExaminationRoomPk").trim(),
            iSubjectInformationPk: $("#strSubjectInformationName").attr("iSubjectInformationPk").trim(),
            iTeacherInformationPk: $("#strTeacherInformationName").attr("iTeacherInformationPk").trim(),
            dtExaminationDay:formatNormalDateTime($("#dtExaminationDay").val()),
            iRateOfDifficultyPk: $("#strRateDifficultyName").attr("iRateOfDifficultyPk").trim(),
            iTestInformationTime: $("#iTestInformationTime").val().trim(),

            strExaminationRoomName: $("#strExaminationRoomName").val().trim(),
            strSubjectInformationName:$("#strSubjectInformationName").val().trim(),
            strRateDifficultyName:$("#strRateDifficultyName").val().trim(),
            strTeacherInformationName:$("#strTeacherInformationName").val().trim()

        };

        $("#modal-confirm").modal("show");
        $("#modal-confirm").html(template7.confirmUpdate(newdata));

        $("#btnAdd").click(function () {
            let data = JSON.stringify(newdata);

            executePostNew(url.urlUpdate,data,updateSuccess, updateError);

        });
    }


    function updateSuccess() {
        displayUpdated("admin","a101");
    }

    function updateError(err) {
        display(err.responseText);
    }

    return{
        init : init, submit:submit
    }
}();

$(document).ready(function () {
    ExaminationEdit.init();
});