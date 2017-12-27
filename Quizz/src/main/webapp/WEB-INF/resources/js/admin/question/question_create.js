var QuestionCreate = function () {

    let template7 ={
        confirmAdd : Template7.compile($("#templateConfirm").html())
    };

    let url = {
      urlAdd : contextPath + "/question/create"
    };
    function init() {
        validUtil.autoValidation("form-create-question",QuestionCreate.submit);
        $("#btnConfirm").click(function () {
            validUtil.autoValidation("form-create-question",QuestionCreate.submit);
        });

    }


    function submit() {
        let check = $('input[name="checkTrue"]:checked').val();
        let newdata = {
            iQuestionInformationLevel:$("#iQuestionInformationLevel").val(),
            strQuestionContentInformation:  $("#strQuestionContentInformation").val().trim(),
            iSubjectInformationPk: $("#strSubjectInformationName").attr("iSubjectInformationPk").trim(),
            iTeacherInformationPk: $("#strTeacherInformationName").attr("iTeacherInformationPk").trim(),
            strAnswer1: $("#strAnswer1").val().trim(),
            strAnswer2: $("#strAnswer2").val().trim(),
            strAnswer3: $("#strAnswer3").val().trim(),
            strAnswer4: $("#strAnswer4").val().trim(),
            strAnswer5: $("#strAnswer5").val().trim(),
            strTrueAnswer: $("#strAnswer"+check).val().trim(),
            strSubjectInformationName:$("#strSubjectInformationName").val().trim(),
            strTeacherInformationName:$("#strTeacherInformationName").val().trim(),
            vcQuestionInformationLevel:$("#iQuestionInformationLevel :checked").text()
        };

        $("#modal-confirm").modal("show");
        $("#modal-confirm").html(template7.confirmAdd(newdata));

        $("#btnAdd").click(function () {
            let data = JSON.stringify(newdata);

            executePostNew(url.urlAdd,data,addSuccess, addError);

        });
    }


    function addSuccess() {
        displayCreated("admin","a104");
    }

    function addError(err) {
        display(err.responseText);
    }

    return{
        init : init, submit:submit
    }
}();

$(document).ready(function () {

    QuestionCreate.init();
});