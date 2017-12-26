var FacultyEdit = function () {

    let template7 ={
        confirmUpdate: Template7.compile($("#templateConfirm").html())
    };

    let url = {
      urlUpdate : contextPath + "/faculty/update",
      urlFindOne : contextPath + "/faculty/find/ID" + iFacultyInformationPk
    };
    function init() {
        console.log("inint");
        $("#btnConfirm").click(function () {
            validUtil.autoValidation("form-update-faculty","submit");
        });

        loadOld();

    }

    function loadOld() {
        executeGetNew(url.urlFindOne,findSuccess, findError);
    }
    function findSuccess(res) {
        $("#strFacultyInformationShortName").val(res.strFacultyInformationShortName);
        $("#strFacultyInformationFullName").val(res.strFacultyInformationFullName);
    }
    function findError(err) {
        display(err.responseText);
    }
    function submit() {
        let newdata = {
            strFacultyInformationShortName:$("#strFacultyInformationShortName").val().trim() ,
            strFacultyInformationFullName:  $("#strFacultyInformationFullName").val().trim(),
        };

        $("#modal-confirm").modal("show");
        $("#modal-confirm").html(template7.confirmUpdate(newdata));

        $("#btnAdd").click(function () {
            let data = JSON.stringify(newdata);

            executePostNew(url.urlUpdate,data,updateSuccess, updateError);

        });
    }


    function updateSuccess() {
        displayUpdated("admin","a109");
    }

    function updateError(err) {
        display(err.responseText);
    }

    return{
        init : init
    }
}();

$(document).ready(function () {
    FacultyEdit.init();
});