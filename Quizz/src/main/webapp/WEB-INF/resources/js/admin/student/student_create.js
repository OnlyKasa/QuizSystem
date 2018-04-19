var StudentCreate = function () {

    let template7 ={
        confirmAdd : Template7.compile($("#templateConfirm").html())
    };

    let url = {
      urlAdd : contextPath + "/student/create"
    };
    function init() {
        validUtil.autoValidation("form-create-student",StudentCreate.submit);
        $("#btnConfirm").click(function () {
            validUtil.autoValidation("form-create-student",StudentCreate.submit);
        });
    }


    function submit() {

        let newdata = {
            strStudentInformationLastName:  $("#strStudentInformationLastName").val().trim(),
            iFacultyInformationPk: $("#strFacultyInformationName").attr("iFacultyInformationPk").trim(),
            strFacultyInformationName : $("#strFacultyInformationName").val().trim(),
            strStudentInformationFirstName: $("#strStudentInformationFirstName").val().trim(),
            dtStudentInformationBirthday:$("#dtStudentInformationBirthday").val()
        };

        $("#modal-confirm").modal("show");
        $("#modal-confirm").html(template7.confirmAdd(newdata));

        $("#btnAdd").click(function () {
            let data = JSON.stringify(newdata);
            executePostNew(url.urlAdd,data,addSuccess, addError);
        });
    }
    function addSuccess() {
        displayCreated("admin","a106");
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