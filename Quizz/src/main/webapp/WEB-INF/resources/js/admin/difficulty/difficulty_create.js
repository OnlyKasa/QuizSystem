var DifficultyCreate = function () {

    let template7 ={
        confirmAdd : Template7.compile($("#templateConfirm").html())
    };

    let url = {
      urlAdd : contextPath + "/difficulty/create"
    };
    function init() {
        validUtil.autoValidation("form-create-difficulty",DifficultyCreate.submit);
        $("#btnConfirm").click(function () {
            validUtil.autoValidation("form-create-difficulty",DifficultyCreate.submit);
        });

    }


    function submit() {
        let newdata = {
            strRateDifficultyName:$("#strRateDifficultyName").val().trim() ,
            iNumQuestionLevel1:$("#iNumQuestionLevel1").val().trim(),
            iNumQuestionLevel2:$("#iNumQuestionLevel2").val().trim(),
            iNumQuestionLevel3:$("#iNumQuestionLevel3").val().trim(),
            iNumQuestionLevel4:$("#iNumQuestionLevel4").val().trim()
        };

        $("#modal-confirm").modal("show");
        $("#modal-confirm").html(template7.confirmAdd(newdata));

        $("#btnAdd").click(function () {
            let data = JSON.stringify(newdata);

            executePostNew(url.urlAdd,data,addSuccess, addError);

        });
    }


    function addSuccess() {
        displayCreated("admin","a102");
    }

    function addError(err) {
        display(err.responseText);
    }

    return{
        init : init,
        submit:submit
    }
}();

$(document).ready(function () {

    DifficultyCreate.init();
});