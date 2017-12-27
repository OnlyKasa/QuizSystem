var StudentCreate = function () {

    let template7 ={
        confirmAdd : Template7.compile($("#templateConfirm").html())
    };

    let url = {
      urlAdd : contextPath + "/examination/create"
    };
    function init() {
        validUtil.autoValidation("form-create-teacher",StudentCreate.submit);
        $("#btnConfirm").click(function () {
            validUtil.autoValidation("form-create-teacher",StudentCreate.submit);
        });

    }


    function submit() {
        let newdata = {
            strExaminationInformationCode:$("#strExaminationInformationCode").val().trim() ,
            iExaminationRoomPk:  $("#strExaminationRoomName").attr("iExaminationRoomPk").trim(),
            iSubjectInformationPk: $("#strSubjectInformationName").attr("iSubjectInformationPk").trim(),
            iTeacherInformationPk: $("#strTeacherInformationName").attr("iTeacherInformationPk").trim(),
            dtExaminationDay:formatNormalDateTime($("#dtExaminationDay").val()),
            iRateOfDifficultyPk: $("#strRateDifficultyName").attr("iRateOfDifficultyPk").trim(),
            iTestInformationTime: $("#iTestInformationTime").val().trim()
        };

        $("#modal-confirm").modal("show");
        $("#modal-confirm").html(template7.confirmAdd(newdata));

        $("#btnAdd").click(function () {
            let data = JSON.stringify(newdata);

            executePostNew(url.urlAdd,data,addSuccess, addError);

        });
    }


    function addSuccess() {
        displayCreated("admin","a101");
    }

    function addError(err) {
        display(err.responseText);
    }

    return{
        init : init, submit:submit
    }
}();

$(document).ready(function () {

    StudentCreate.init();
});