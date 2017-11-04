//This is for validate and make error
//Constant
var validTag = "valid";
var tagValidType = "valid-type";
var tagNullValidType = "null-valid-type";
var tagNullMessage = "null-message";
var tagInvalidMessage = "invalid-message";
var tagNullable = "nullable";
var validTypeOnSubmit = "submit";
var validTypeOnPress = "press";
var validTypeNoInput = "noinput";
//Input type
var inputTypeText = "text";
var inputTypeNumber = "number";
var inputTypeDatetime = "date";
var inputTypeMask = "mask";
var inputTypeCombobox = "selection";
//Valid func
var lstValidFunc = [];
var formIsOK = false;
//Library
var validUtil = {
    autoValidation: function (formId, submitFunc){
        //For null validation
        $("#"+formId+" input["+tagNullable+"='false']").each(function(){
            var nullValidType = validUtil.getNullValidTypeAttr($(this));
            var id = this.id;
            switch(nullValidType) {
                case validTypeOnPress:
                    break;
                default:
                    lstValidFunc.push(function(){
                        if(validUtil.isValueIsEmpty($('#'+id).val())){
                            validUtil.disposeTooltip(validUtil.getNullMessage($('#'+id))
                                , validUtil.getToolTipAttr($('#'+id)));
                            formIsOK = false;
                            $('#'+id).focus();
                        }
                    });
            }
        });
        //For min-max validation
        $("#"+formId+" input[min]").each(function(){
            var validType = validUtil.getValidTypeAttr($(this));
            var id = this.id;
            var min = validUtil.getMinAttr($(this));
            var max = validUtil.getMaxAttr($(this));
            switch(validType) {
                case validTypeOnPress:
                    validUtil.makeValidationOnPress($(this));
                    break;
                default:
                    lstValidFunc.push(function(){
                        var value = '';
                        if(!validUtil.isValueIsEmpty($('#'+id).val())){
                            value = $('#' + id).val().trim();
                        }
                        if(value.length < min || value.length > max){
                            validUtil.disposeTooltip(validUtil.getInvalidMessage($('#'+id))
                                , validUtil.getToolTipAttr($('#'+id)));
                            formIsOK = false;
                            $('#'+id).focus();
                        }
                    });
            }
        });
        //And for other
        $( "#"+formId).submit(function() {
            formIsOK = true;
            for(var i = lstValidFunc.length - 1 ; i >= 0;i--){
                lstValidFunc[i]();
            }
            event.preventDefault();
            if(formIsOK){
                submitFunc();
            }
        });
        $("#"+formId+" input["+validTag+"='true']").each(function(){
            var validType = validUtil.getValidTypeAttr($(this));
            switch(validType) {
                case validTypeNoInput:
                    validUtil.makeValidationNoInput($(this));
                    break;
                case validTypeOnPress:
                    validUtil.makeValidationOnPress($(this));
                    break;
                default:
                    validUtil.makeValidationOnSubmit($(this),formId);
            }
        });
    },
    makeValidationOnSubmit: function (input) {
        switch(validUtil.getInputTypeAttr(input)) {
            case inputTypeCombobox:
                validUtil.preValidInputSelecionValidation(input);
                break;
            case inputTypeMask:
                validUtil.preValidInputMaskValidation(input);
                break;
            case inputTypeDatetime:
                validUtil.preValidInputDateValidation(input);
                break;
            case inputTypeNumber:
                validUtil.preValidInputNumberValidation(input);
                break;
            default:
                validUtil.preValidInputTextValidation(input);
        }
    },
    makeValidationOnPress: function (input) {
        switch(validUtil.getInputTypeAttr(input)) {
            case inputTypeCombobox:
                validUtil.notifyInputSelecionValidation(input);
                break;
            case inputTypeMask:
                validUtil.notifyInputMaskValidation(input);
                break;
            case inputTypeDatetime:
                validUtil.notifyInputDateValidation(input);
                break;
            case inputTypeNumber:
                validUtil.notifyInputNumberValidation(input);
                break;
            default:
                validUtil.notifyInputTextValidation(input);
        }
    },
    notifyInputSelecionValidation: function (input) {
        var strRegex = validUtil.getRegexAttr(input);
        if(validUtil.isRegExNotEmpty(strRegex)){
            validUtil.notifyRegExInput(input, strRegex);
        }
    },
    notifyInputMaskValidation: function (input) {
        var strRegex = validUtil.getRegexAttr(input);
        if(validUtil.isRegExNotEmpty(strRegex)){
            validUtil.notifyRegExInput(input, strRegex);
        }
    },
    notifyInputDateValidation: function (input) {
        var strRegex = validUtil.getRegexAttr(input);
        if(validUtil.isRegExNotEmpty(strRegex)){
            validUtil.notifyRegExInput(input, strRegex);
        }else{
            validUtil.notifyRegExInput(input, /^(((0[1-9]|[12]\d|3[01])\/(0[13578]|1[02])\/((19|[2-9]\d)\d{2}))|((0[1-9]|[12]\d|30)\/(0[13456789]|1[012])\/((19|[2-9]\d)\d{2}))|((0[1-9]|1\d|2[0-8])\/02\/((19|[2-9]\d)\d{2}))|(29\/02\/((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$/g);
        }
    },
    notifyInputNumberValidation: function (input) {
        var strRegex = validUtil.getRegexAttr(input);
        if(validUtil.isRegExNotEmpty(strRegex)){
            validUtil.notifyRegExInput(input, strRegex);
        }else{
            validUtil.notifyRegExInput(input, "^[0-9]+$");
        }
    },
    notifyInputTextValidation: function (input) {
        var strRegex = validUtil.getRegexAttr(input);
        if(validUtil.isRegExNotEmpty(strRegex)){
            validUtil.notifyRegExInput(input, strRegex);
        }
    },
    notifyRegExInput: function (input, strRegex){
        $(input).on('keypress', function (event) {
            if (!strRegex.test(input)) {
                event.preventDefault();
                return false;
            }
        });
    },
    makeValidationNoInput: function (input) {
        switch(validUtil.getInputTypeAttr(input)) {
            case inputTypeCombobox:
                validUtil.preventInputSelecionValidation(input);
                break;
            case inputTypeMask:
                validUtil.preventInputMaskValidation(input);
                break;
            case inputTypeDatetime:
                validUtil.preventInputDateValidation(input);
                break;
            case inputTypeNumber:
                validUtil.preventInputNumberValidation(input);
                break;
            default:
                validUtil.preventInputTextValidation(input);
        }
    },
    preventInputSelecionValidation: function (input) {
        var strRegex = validUtil.getRegexAttr(input);
        if(validUtil.isRegExNotEmpty(strRegex)){
            validUtil.preventRegExInput(input, strRegex);
        }
    },
    preventInputMaskValidation: function (input) {
        var strRegex = validUtil.getRegexAttr(input);
        if(validUtil.isRegExNotEmpty(strRegex)){
            validUtil.preventRegExInput(input, strRegex);
        }
    },
    preventInputDateValidation: function (input) {
        var strRegex = validUtil.getRegexAttr(input);
        if(validUtil.isRegExNotEmpty(strRegex)){
            validUtil.preventRegExInput(input, strRegex);
        }else{
            validUtil.preventRegExInput(input, /^(((0[1-9]|[12]\d|3[01])\/(0[13578]|1[02])\/((19|[2-9]\d)\d{2}))|((0[1-9]|[12]\d|30)\/(0[13456789]|1[012])\/((19|[2-9]\d)\d{2}))|((0[1-9]|1\d|2[0-8])\/02\/((19|[2-9]\d)\d{2}))|(29\/02\/((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$/g);
        }
    },
    preventInputNumberValidation: function (input) {
        var strRegex = validUtil.getRegexAttr(input);
        if(validUtil.isRegExNotEmpty(strRegex)){
            validUtil.preventRegExInput(input, strRegex);
        }else{
            validUtil.preventRegExInput(input, "^[0-9]+$");
        }
    },
    preventInputTextValidation: function (input) {
        var strRegex = validUtil.getRegexAttr(input);
        if(validUtil.isRegExNotEmpty(strRegex)){
            validUtil.preventRegExInput(input, strRegex);
        }
    },
    preventRegExInput: function (input, strRegex){
        $(input).on('keypress', function (event) {
            if (!validUtil.makeRegex(strRegex).test(event.key)) {
                event.preventDefault();
                return false;
            }
        });
    }
    ,
    getIdAttr: function (input){
        return input.attr("id");
    },
    getToolTipAttr: function(input){
        if(typeof input.attr("tool-tip") == 'undefined' || input.attr("tool-tip") == ''){
            return input.attr("id") + "Tooltip";
        }
        return input.attr("tool-tip");
    },
    getRegexAttr: function(input){
        return new RegExp(input.attr("regex"));
    },
    getValidTypeAttr: function(input){
        return input.attr(tagValidType);
    }
    ,
    getInputTypeAttr: function (input){
        return input.attr("input-type");
    },
    getNullMessage: function (input){
        return input.attr(tagNullMessage);
    },
    getInvalidMessage: function (input){
        return input.attr(tagInvalidMessage);
    },
    getMinAttr: function (input){
        return input.attr("min");
    },
    getMaxAttr: function (input){
        return input.attr("max");
    },
    getNullValidTypeAttr: function (input){
        return input.attr(tagNullValidType);
    }
    ,
    isRegExNotEmpty: function(inputRegex){
        return typeof inputRegex == 'undefined' || inputRegex == '/(?:)/' ? false : true;
    },
    isValueIsEmpty: function(inputValue){
        return typeof inputValue == 'undefined' || inputValue == 'undefined' || inputValue ==null || inputValue=='' || inputValue.trim()=='' ? true : false;
    },
    makeRegex: function (regEx){
        return new RegExp(regEx);
    },
    disposeTooltip: function(strMessage, tooltipId){
        $('#'+tooltipId).css("display", "block");
        $('#'+tooltipId).attr("data-original-title", strMessage);
    },
    makeRed: function (inputID) {
        $('#txt'+inputID).keydown(function() {
            $('#txt'+inputID).removeClass("is-not-valid");
            $('#tot'+inputID).css('display','none');
        });
        $('#txt'+inputID).change(function() {
            $('#txt'+inputID).removeClass("is-not-valid");
            $('#tot'+inputID).css('display','none');
        });
        $('#txt'+inputID).addClass("is-not-valid");
    },
    makeRedTootip: function (inputID, message) {
        $('#txt'+inputID).keydown(function() {
            $('#txt'+inputID).removeClass("is-not-valid");
            $('#tot'+inputID).css('display','none');
        });
        $('#txt'+inputID).change(function() {
            $('#txt'+inputID).removeClass("is-not-valid");
            $('#tot'+inputID).css('display','none');
        });
        $('#txt'+inputID).addClass("is-not-valid");
        $('#tot'+inputID).html(message);
        $('#tot'+inputID).css('display','block');
        return false;
    },
    validInput: function (inputID, messageCode) {
        if(validUtil.isValueIsEmpty($('#txt'+inputID).val())){
            validUtil.disposeTooltip(getMessage(messageCode), 'tot'+inputID);
            $('#tot'+inputID).parent().addClass('relative');
            validUtil.makeRed(inputID);
            return '#txt'+inputID;
        }else{
            return null;
        }
    },
    isNormalInteger: function (str) {
        var n = Math.floor(Number(str));
        return (String(n) === str || ('0'+String(n)) === str) && n >= 0;
    },
    isYYYYMM: function (inputDate) {
        if(validUtil.isValueIsEmpty(inputDate)){
            return false;
        }else{
            if(inputDate.length!=7){
                return false;
            }else if(inputDate.indexOf('-') == -1 || inputDate.split('-').length != 2){
                return false;
            }else if(inputDate.split('-')[0].length != 4 || inputDate.split('-')[1].length != 2){
                return false;
            }else if(!validUtil.isNormalInteger(inputDate.split('-')[0])){
                return false;
            }else if(!validUtil.isNormalInteger(inputDate.split('-')[1])) {
                return false;
            }else if(inputDate.split('-')[0] > 2999 || inputDate.split('-')[1] < 1){
                return false;
            }else if(inputDate.split('-')[1] > 12 || inputDate.split('-')[1] < 1){
                return false;
            }else{
                return true;
            }
        }
    }
};