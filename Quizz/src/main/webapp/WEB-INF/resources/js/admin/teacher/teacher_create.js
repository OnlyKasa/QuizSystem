var TeacherCreate = function () {

    let template7 ={
        confirmAdd : Template7.compile($("#templateConfirm").html())
    };

    let url = {
      urlAdd : contextPath + "/teacher/create"
    };
    function init() {
        validUtil.autoValidation("form-create-teacher",TeacherCreate.submit);
        $("#btnConfirm").click(function () {
            validUtil.autoValidation("form-create-teacher",TeacherCreate.submit);
        });


    }


    function submit() {

        if(checkPassword()){
            return
        }

        let newdata = {
            strTeacherInformationLastName:$("#strTeacherInformationLastName").val().trim(),
            strTeacherInformationFirstName: $("#strTeacherInformationFirstName").val().trim(),
            iFacultyInformationPk: $("#strFacultyInformationFullName").attr("iFacultyInformationPk").trim(),
            strFacultyInformationFullName: $("#strFacultyInformationFullName").val(),
            strTeacherInformationPhone:$("#strTeacherInformationPhone").val(),
            userId:$("#userId").val(),
            password:$("#password").val()
        };

        $("#modal-confirm").modal("show");
        $("#modal-confirm").html(template7.confirmAdd(newdata));

        $("#btnAdd").click(function () {
            let data = JSON.stringify(newdata);

            executePostNew(url.urlAdd,data,addSuccess, addError);

        });
    }

    function checkPassword(){
        let pass =  $("#password").val();
        let repass = $("#rePassword").val();

        $("#password").removeClass("input-error");
        $("#passwordErr").css("display", "none");
        if(pass == repass)
            return false;
        else{
            $("#password").addClass("input-error");
            $("#passwordErr").css("display", "block");
            $("#passwordErr").text("Mật khẩu nhập lại không khớp");
            return true;
        }

    }

    function addSuccess() {
        displayCreated("admin","a107");
    }

    function addError(err) {
        display(err.responseText);
    }

    return{
        init : init, submit:submit
    }
}();

$(document).ready(function () {

    TeacherCreate.init();
});