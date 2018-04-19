var QuestionEdit = function () {

    let template7 ={
        confirmUpdate: Template7.compile($("#templateConfirm").html())
    };

    let url = {
      urlUpdate : contextPath + "/question/update",
      urlFindOne : contextPath + "/question/find/ID" + iQuestionInformationPk
    };
    function init() {
        console.log("inint");
        validUtil.autoValidation("form-update-question",QuestionEdit.submit);
        $("#btnConfirm").click(function () {
            validUtil.autoValidation("form-update-question",QuestionEdit.submit);
        });

        loadOld();

    }

    function loadOld() {
        executeGetNew(url.urlFindOne,findSuccess, findError);
    }
    function findSuccess(res) {

        $("#iQuestionInformationLevel").val(res.iQuestionInformationLevel);

        $("#strQuestionContentInformation").val(res.strQuestionContentInformation);

        $("#strAnswer1").val(res.strAnswer1);
        $("#strAnswer2").val(res.strAnswer2);
        $("#strAnswer3").val(res.strAnswer3);
        $("#strAnswer4").val(res.strAnswer4);
        $("#strAnswer5").val(res.strAnswer5);

        if(res.strTrueAnswer == res.strAnswer1){
            $("#check-strAnswer1").prop("checked", true);
        }
        if(res.strTrueAnswer == res.strAnswer2){
            $("#check-strAnswer2").prop("checked", true);
        }if(res.strTrueAnswer == res.strAnswer3){
            $("#check-strAnswer3").prop("checked", true);
        }
        if(res.strTrueAnswer == res.strAnswer4){
            $("#check-strAnswer4").prop("checked", true);
        }
        if(res.strTrueAnswer == res.strAnswer5){
            $("#check-strAnswer5").prop("checked", true);
        }

        $("#strSubjectInformationName").val(res.strSubjectInformationName);
        $("#strSubjectInformationName").attr("iSubjectInformationPk", res.iSubjectInformationPk);

        if(res.strTeacherInformationFirstName != null || res.strTeacherInformationLastName != null)
            $("#strTeacherInformationName").val(res.strTeacherInformationFirstName +" "+ res.strTeacherInformationLastName);
        $("#strTeacherInformationName").attr("iTeacherInformationPk", res.iTeacherInformationPk);

    }
    function findError(err) {
        display(err.responseText);
    }
    function submit() {
        let check = $('input[name="checkTrue"]:checked').val();
        let newdata = {
            iQuestionInformationPk: iQuestionInformationPk,
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
        $("#modal-confirm").html(template7.confirmUpdate(newdata));

        $("#btnAdd").click(function () {
            let data = JSON.stringify(newdata);

            executePostNew(url.urlUpdate,data,updateSuccess, updateError);

        });
    }


    function updateSuccess() {
        displayUpdated("admin","a104");
    }

    function updateError(err) {
        display(err.responseText);
    }

    return{
        init : init, submit:submit
    }
}();

$(document).ready(function () {
    QuestionEdit.init();
});