var SubjectCreate = function () {

    let template7 ={
        confirmAdd : Template7.compile($("#templateConfirm").html())
    };

    let url = {
      urlAdd : contextPath + "/subject/create"
    };
    function init() {
        validUtil.autoValidation("form-create-subject",SubjectCreate.submit);
        $("#btnConfirm").click(function () {
            validUtil.autoValidation("form-create-subject",SubjectCreate.submit);
        });

    }


    function submit() {
        let newdata = {
            strStudentInformationName:$("#strStudentInformationName").val().trim() ,
            iSubjectInformationCreditsNum: $("#iSubjectInformationCreditsNum").val().trim()
        };

        $("#modal-confirm").modal("show");
        $("#modal-confirm").html(template7.confirmAdd(newdata));

        $("#btnAdd").click(function () {
            let data = JSON.stringify(newdata);

            executePostNew(url.urlAdd,data,addSuccess, addError);

        });
    }


    function addSuccess() {
        displayCreated("admin","a105");
    }

    function addError(err) {
        display(err.responseText);
    }

    return{
        init : init
    }
}();

$(document).ready(function () {

    SubjectCreate.init();
});