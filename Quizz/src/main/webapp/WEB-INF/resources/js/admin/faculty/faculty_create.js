var FacultyCreate = function () {

    let template7 ={
        confirmAdd : Template7.compile($("#templateConfirm").html())
    };

    let url = {
      urlAdd : contextPath + "/faculty/create"
    };
    function init() {
        $("#btnConfirm").click(function () {
            validUtil.autoValidation("form-create-faculty","submit");
        });

    }


    function submit() {
        let newdata = {
            strFacultyInformationShortName:$("#strFacultyInformationShortName").val().trim() ,
            strFacultyInformationFullName:  $("#strFacultyInformationFullName").val().trim()
        };

        $("#modal-confirm").modal("show");
        $("#modal-confirm").html(template7.confirmAdd(newdata));

        $("#btnAdd").click(function () {
            let data = JSON.stringify(newdata);

            executePostNew(url.urlAdd,data,addSuccess, addError);

        });
    }


    function addSuccess() {
        displayCreated("admin","a109");
    }

    function addError(err) {
        display(err.responseText);
    }

    return{
        init : init
    }
}();

$(document).ready(function () {

    FacultyCreate.init();
});