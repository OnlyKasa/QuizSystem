var StudentEdit = function () {

    let template7 ={
        confirmUpdate: Template7.compile($("#templateConfirm").html())
    };

    let url = {
      urlUpdate : contextPath + "/student/update",
      urlFindOne : contextPath + "/student/find/ID" + iStudentInformationPk
    };
    function init() {
        validUtil.autoValidation("form-update-student",StudentEdit.submit);
        $("#btnConfirm").click(function () {
            validUtil.autoValidation("form-update-student",StudentEdit.submit);
        });

        loadOld();

    }

    function loadOld() {
        executeGetNew(url.urlFindOne,findSuccess, findError);
    }
    function findSuccess(res) {
        $("#iStudentInformationCode").val(res.iStudentInformationCode);
        $("#strStudentInformationLastName").val(res.strStudentInformationLastName);
        $("#strStudentInformationFirstName").val(res.strStudentInformationFirstName);
        $("#dtStudentInformationBirthday").val((res.dtStudentInformationBirthday));
        $("#strFacultyInformationFullName").val(res.strFacultyInformationFullName);
        $("#strFacultyInformationFullName").attr("iFacultyInformationPk",res.iFacultyInformationPk)

    }
    function findError(err) {
        display(err.responseText);
    }
    function submit() {
        if(checkPassword()){
            return
        }
        let newdata = {
            iStudentInformationPk:iStudentInformationPk,
            iStudentInformationCode:$("#iStudentInformationCode").val().trim() ,
            strStudentInformationLastName:  $("#strStudentInformationLastName").val(),
            strStudentInformationFirstName:$("#strStudentInformationFirstName").val(),
            dtStudentInformationBirthday:$("#dtStudentInformationBirthday").val(),
            iFacultyInformationPk: $("#strFacultyInformationFullName").attr("iFacultyInformationPk").trim(),
            strFacultyInformationFullName : $("#strFacultyInformationFullName").val(),
            password : $("#password").val()
        };

        $("#modal-confirm").modal("show");
        $("#modal-confirm").html(template7.confirmUpdate(newdata));

        $("#btnAdd").click(function () {
            let data = JSON.stringify(newdata);

            executePostNew(url.urlUpdate,data,updateSuccess, updateError);

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
    function updateSuccess() {
        displayUpdated("admin","a106");
    }

    function updateError(err) {
        display(err.responseText);
    }

    return{
        init : init,submit:submit
    }
}();

$(document).ready(function () {
    StudentEdit.init();
});