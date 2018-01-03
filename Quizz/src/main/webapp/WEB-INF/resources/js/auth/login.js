var login = function () {
    var messErr = {
        loginFalse : "Username or password that you've entered doesn't match any account.",
        sessionTimeOut : "You must log in to continue."
    };
    var regex ={
        specialCheck :/[^0-9a-zA-Z._]/
    };
    function init() {
        btnResetForm() ;
        btnLoginForm() ;
    }

    function btnResetForm() {
        $("#btnReset").click(function () {
            clearFormData() ;
        })
    }
    function clearFormData() {
        $('#txtUsername').val('');
        $('#txtPassword').val('');
        $('#txtUsername').focus();
    }
    function btnLoginForm() {
        $("#btnLogin").click(function () {
            if(validBeforeSubmit()){
                var data = {
                    "userid": $('#txtUsername').val().trim(),
                    "password": $("#txtPassword").val().trim()
                };
                executePostNewNon(contextPath + "/user/login", JSON.stringify(data), isDtosConfirmNull, loginFail);
            }
        })
    }

    function isDtosConfirmNull(data) {
        if (typeof data == 'undefined' || data == null || data == '') {
            redirectPage('auth','C106',{"userid": $.trim($('#txtUsername').val())});
        }else{

            $.redirect(contextPath + "/", {});
        }
    }

    function loginFail() {
        $("#txtErrorInform").html(messErr.loginFalse);
        clearFormData();
    }
    
    function validBeforeSubmit() {
        var check  = true ;
        if($('#txtUsername').val() ==""){
            clearFormData();
            check = false ;
        }else {
            if(checkSpecialInput($('#txtUsername').val()))
                check =false;

        }


        if($('#txtPassword').val()==""){
            clearFormData();
            check = false ;
        }

        return check ;
    }
    function checkSpecialInput(input) {
        if(regex.specialCheck.test(input)){
            loginFail();
            return true ;
        }else
            return false
    }

    return{
        init : init
    }
}();

$(document).ready(function () {
    login.init() ;
});