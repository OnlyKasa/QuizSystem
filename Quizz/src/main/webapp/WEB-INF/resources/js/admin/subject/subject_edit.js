var SubjectEdit = function () {

    let template7 ={
        confirmUpdate: Template7.compile($("#templateConfirm").html())
    };

    let url = {
      urlUpdate : contextPath + "/subject/update",
      urlFindOne : contextPath + "/subject/find/ID" + iSubjectInformationPk
    };
    function init() {
        validUtil.autoValidation("form-update-subject",SubjectEdit.submit);
        $("#btnConfirm").click(function () {
            validUtil.autoValidation("form-update-subject",SubjectEdit.submit);
        });

        loadOld();

    }

    function loadOld() {
        executeGetNew(url.urlFindOne,findSuccess, findError);
    }
    function findSuccess(res) {
        $("#strStudentInformationName").val(res.strSubjectInformationName);
        $("#iSubjectInformationCreditsNum").val(res.iSubjectInformationCreditsNum);
    }
    function findError(err) {
        display(err.responseText);
    }
    function submit() {
        let newdata = {
            strStudentInformationName:$("#strStudentInformationName").val().trim() ,
            iSubjectInformationCreditsNum: $("#iSubjectInformationCreditsNum").val().trim()
        };

        $("#modal-confirm").modal("show");
        $("#modal-confirm").html(template7.confirmUpdate(newdata));

        $("#btnAdd").click(function () {
            let data = JSON.stringify(newdata);
            executePostNew(url.urlUpdate,data,updateSuccess, updateError);
        });
    }


    function updateSuccess() {
        displayUpdated("admin","a105");
    }

    function updateError(err) {
        display(err.responseText);
    }

    return{
        init : init, submit:submit
    }
}();

$(document).ready(function () {
    SubjectEdit.init();
});