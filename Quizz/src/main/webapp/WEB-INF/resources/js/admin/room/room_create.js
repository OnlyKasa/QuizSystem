var RoomCreate = function () {

    let template7 ={
        confirmAdd : Template7.compile($("#templateConfirm").html())
    };

    let url = {
      urlAdd : contextPath + "/room/create"
    };
    function init() {
        validUtil.autoValidation("form-create-room",RoomCreate.submit);
        $("#btnConfirm").click(function () {
            validUtil.autoValidation("form-create-room",RoomCreate.submit);
        });

    }


    function submit() {
        let newdata = {
            strExaminationRoomName:$("#strExaminationRoomName").val().trim()
        };

        $("#modal-confirm").modal("show");
        $("#modal-confirm").html(template7.confirmAdd(newdata));

        $("#btnAdd").click(function () {
            let data = JSON.stringify(newdata);

            executePostNew(url.urlAdd,data,addSuccess, addError);

        });
    }


    function addSuccess() {
        displayCreated("admin","a108");
    }

    function addError(err) {
        display(err.responseText);
    }

    return{
        init : init, submit:submit
    }
}();

$(document).ready(function () {

    RoomCreate.init();
});