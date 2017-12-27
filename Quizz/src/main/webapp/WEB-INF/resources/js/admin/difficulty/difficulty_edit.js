var DifficultyEdit = function () {

    let template7 ={
        confirmUpdate: Template7.compile($("#templateConfirm").html())
    };

    let url = {
      urlUpdate : contextPath + "/difficulty/update",
      urlFindOne : contextPath + "/difficulty/find/ID" + iRateOfDifficultyPk
    };
    function init() {
        console.log("inint");
        validUtil.autoValidation("form-update-difficulty",DifficultyEdit.submit);
        $("#btnConfirm").click(function () {
            validUtil.autoValidation("form-update-difficulty",DifficultyEdit.submit);
        });

        loadOld();

    }

    function loadOld() {
        executeGetNew(url.urlFindOne,findSuccess, findError);
    }
    function findSuccess(res) {
        $("#strRateDifficultyName").val(res.strRateDifficultyName);
        $("#iNumQuestionLevel1").val(res.iNumQuestionLevel1);
        $("#iNumQuestionLevel2").val(res.iNumQuestionLevel2);
        $("#iNumQuestionLevel3").val(res.iNumQuestionLevel3);
        $("#iNumQuestionLevel4").val(res.iNumQuestionLevel4);
    }
    function findError(err) {
        display(err.responseText);
    }
    function submit() {
        let newdata = {
            strRateDifficultyName:$("#strRateDifficultyName").val().trim(),
            iNumQuestionLevel1: $("#iNumQuestionLevel1").val().trim(),
            iNumQuestionLevel2:$("#iNumQuestionLevel2").val(),
            iNumQuestionLevel3:$("#iNumQuestionLevel3").val(),
            iNumQuestionLevel4:$("#iNumQuestionLevel4").val()
        };

        $("#modal-confirm").modal("show");
        $("#modal-confirm").html(template7.confirmUpdate(newdata));

        $("#btnAdd").click(function () {
            let data = JSON.stringify(newdata);

            executePostNew(url.urlUpdate,data,updateSuccess, updateError);

        });
    }


    function updateSuccess() {
        displayUpdated("admin","a102");
    }

    function updateError(err) {
        display(err.responseText);
    }

    return{
        init : init,
        submit:submit
    }
}();

$(document).ready(function () {
    DifficultyEdit.init();
});