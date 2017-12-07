/**
 * Configuration file
 */
//Timeout
const btnTimeout = 100000;
var rowPerPage = 20;
var rowPerPageModal = 20;
const popupTimeout = 3000;
var globalData = [];
var globalPrefuctureData = [];
var pageCount = 1;
var postalCodeApi = 'http://geoapi.heartrails.com/api/json?method=searchByPostal&postal=';


const defaultHeader = {
    'Authorization' : 'Basic T21pbmV4dDpPbWluZXh0MjAxNw==',
    'Content-Type' : 'application/json'
};

String.prototype.escapeSpecialChars = function() {
    return this.replace(/\\n/g, "\\n")
        .replace(/\\'/g, "\\'")
        .replace(/\\"/g, '\\"')
        .replace(/\\&/g, "\\&")
        .replace(/\\r/g, "\\r")
        .replace(/\\t/g, "\\t")
        .replace(/\\b/g, "\\b")
        .replace(/\\f/g, "\\f");
};

function redirectPage(categoryName ,pageName, data){
    //Old version
    var strData = "";
    if(typeof data != 'undefined'){
        strData = data;
    }
    showLoading();
    $.redirect(contextPath + "/" + categoryName + "/"
        + pageName, strData);
    //New version - not use yet, only use on spa (single page application)
    // $( "#mainContainer" ).load( contextPath + "/" + categoryName + "/" + pageName
    //     , data );
}
function countPage(rowCount, rowPerPage){
    return Math.ceil(rowCount / rowPerPage);
}
function countFrom(rowPerPage, currentPage){
    return (currentPage - 1) * rowPerPage;
}
var iLoading;
function showLoading(){
    iLoading = 1;
    setTimeout(function(){
        if(iLoading==1) {
            $('#spinner').modal('show');
        }
    }, 500);
}

function getLstInt(data, column){
    var lstRt = [];
    for(var i = 0 ; i < data.length ; i++){
        lstRt.push(data[i][column]);
    }
    return lstRt;
}
function hideLoading(){
    iLoading = 0;
    $('#spinner').modal('hide');
}

function executePostNew(strUrl, inputData, successFunc, errorFunc, doneFunc, validateFunc, async) {
    executeAjaxNew(strUrl, inputData, successFunc, errorFunc, doneFunc, "POST", validateFunc, async);
}
function executePostNewNon(strUrl, inputData, successFunc, errorFunc, doneFunc, validateFunc, async) {
    executeAjaxNewNoresponse(strUrl, inputData, successFunc, errorFunc, doneFunc, "POST", validateFunc, async);
}
function executePutNew(strUrl, inputData, successFunc, errorFunc, doneFunc, validateFunc, async) {
    executeAjaxNewNoresponse(strUrl, inputData, successFunc, errorFunc, doneFunc, "PUT", validateFunc, async);
}
// long nv
function executePut(strUrl, inputData, successFunc, errorFunc, doneFunc, validateFunc, async) {
    executeAjaxNew(strUrl, inputData, successFunc, errorFunc, doneFunc, "PUT", validateFunc, async);
}

function executeGetNew(strUrl, successFunc, errorFunc, doneFunc, validateFunc, async) {
    executeAjaxNew(strUrl, '', successFunc, errorFunc, doneFunc, "GET", validateFunc, async);
}
function executeDeleteNew(strUrl, successFunc, errorFunc, doneFunc, validateFunc) {
    executeAjaxNewNoresponse(strUrl, '', successFunc, errorFunc, doneFunc, "DELETE", validateFunc);
}

function executeAjaxNew(strUrl, inputData, successFunc, errorFunc, doneFunc, type, validateFunc, async) {
    showLoading();
    //Validate if needed
    if(typeof validateFunc != 'undefined' && !validateFunc(inputData)){
        return;
    }
    setTimeout(function(){
        $.ajax({
            type : type,
            headers: defaultHeader,
            contentType : "application/json;charset=utf-8",
            url : strUrl,
            data : inputData,
            dataType : 'json',
            timeout : btnTimeout,
            async: async,
            success : function(data) {
                console.log("SUCCESS: ", data);
                successFunc(data);
                console.log(strUrl);
                hideLoading();
            },
            error : function(jqXHR, textStatus, errorThrown) {
                if(typeof errorFunc != 'undefined') {
                    errorFunc(jqXHR, textStatus, errorThrown);
                    console.log(strUrl);
                }
                hideLoading();
            },
            done : function(e) {
                if(typeof doneFunc != 'undefined') {
                    doneFunc(e);
                }
                hideLoading();
                console.log("DONE");
            }
        });
    }, 1);
}

function executeAjaxNewNoresponse(strUrl, inputData, successFunc, errorFunc, doneFunc, type, validateFunc) {
    showLoading();
    //Validate if needed
    if(typeof validateFunc != 'undefined'){
        validateFunc(inputData);
        return;
    }
    setTimeout(function(){
        $.ajax({
            type : type,
            headers: defaultHeader,
            contentType : "application/json;charset=utf-8",
            url : strUrl,
            data : inputData,
            timeout : btnTimeout,
            success : function(data) {
                console.log("SUCCESS: ", data);
                successFunc(data);
                hideLoading();
            },
            error : function(jqXHR, textStatus, errorThrown) {
                if(typeof errorFunc != 'undefined') {
                    errorFunc(jqXHR, textStatus, errorThrown);
                }
                hideLoading();
            },
            done : function(e) {
                if(typeof doneFunc != 'undefined') {
                    doneFunc(e);
                }
                hideLoading();
                console.log("DONE");
            }
        });
    }, 1);
}

function executeAjaxUpload(strUrl, inputData, successFunc, errorFunc, doneFunc, validateFunc) {
    showLoading();

    //Validate if needed
    if(typeof validateFunc != 'undefined'){
        validateFunc(inputData);
        return;
    }

    $.ajax({
        type: "POST",
        data: inputData,
        enctype: 'multipart/form-data',
        processData: false, // tell jQuery not to process the data
        contentType: false, // tell jQuery not to set contentType
        cache: false,
        url: strUrl,
        dataType: 'json',
        timeout: btnTimeout,
        success : function(data) {
            console.log("SUCCESS: ", data);
            successFunc(data);
            hideLoading();
        },
        error : function(e) {
            if(typeof errorFunc != 'undefined'){
                errorFunc(e);
                hideLoading();
            }
            console.log("ERROR: ", e);
            display(e);
        },
        done : function(e) {
            if(typeof doneFunc != 'undefined') {
                doneFunc(e);
                hideLoading();
            }
            console.log("DONE");
        }
    });
}

function countIndex(rowCount, rowPerPage, currentPage, txtPageCount, txtPageNavigator, pageChangeFunction, pageCountExt) {
    if(typeof pageCountExt == "undefined" || pageCountExt ==null){
        pageCountExt = countPage(rowCount, rowPerPage);
    }
    if(typeof pageChangeFunction == "undefined" || pageChangeFunction ==null){
        pageChangeFunction = "changePage";
    }
    if (rowCount > 0 && rowCount > rowPerPage) {
        var to;
        var from = (currentPage - 1) * rowPerPage;
        if((rowPerPage * currentPage) <= rowCount) {
            to = rowPerPage * currentPage;
        }else{
            to = rowCount;
        }
        $('#'+txtPageCount).html((from + 1) + "-" + to + "page/" + rowCount+"pages");
        $('#'+txtPageNavigator).empty();
        if (currentPage != 1) {
            $('#'+txtPageNavigator).html("<li><a onclick=\""+pageChangeFunction+"('" + (parseInt(currentPage) - 1).toString() + "')\" href=\"#\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span>Previous</a></li>");
        }else{
            $('#'+txtPageNavigator).html("<li><a class='no-hover' aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span>Previous</a></li>");
        }
        if (pageCountExt !=1 && pageCountExt <= 6) {
            for (var i = 1; i <= pageCountExt; i++) {
                if (currentPage == i) {
                    $('#'+txtPageNavigator).append("<li><a style=\"background-color: #67b800; color: #FFF;\" onclick=\""+pageChangeFunction+"('" + i.toString() + "')\" href=\"#\">" + i.toString() + "</a></li>");
                } else {
                    $('#'+txtPageNavigator).append("<li><a onclick=\""+pageChangeFunction+"('" + i.toString() + "')\" href=\"#\">" + i.toString() + "</a></li>");
                }
            }
        } else if(pageCountExt !=1) {
            if(currentPage <= 3){
                for (var y = 1; y <= 4; y++) {
                    if (currentPage == y) {
                        $('#'+txtPageNavigator).append("<li><a style=\"background-color: #67b800; color: #FFF;\" onclick=\""+pageChangeFunction+"('" + y.toString() + "')\" href=\"#\">" + y.toString() + "</a></li>");
                    } else {
                        $('#'+txtPageNavigator).append("<li><a onclick=\""+pageChangeFunction+"('" + y.toString() + "')\" href=\"#\">" + y.toString() + "</a></li>");
                    }
                }
                $('#'+txtPageNavigator).append("<li><a class='no-hover'>...</a></li>");
                $('#'+txtPageNavigator).append("<li><a onclick=\""+pageChangeFunction+"('" + pageCountExt.toString() + "')\" href=\"#\">" + pageCountExt.toString() + "</a></li>");
            }else if(currentPage > (pageCountExt - 3)){
                $('#'+txtPageNavigator).append("<li><a onclick=\""+pageChangeFunction+"('1')\" href=\"#\">1</a></li>");
                $('#'+txtPageNavigator).append("<li><a class='no-hover'>...</a></li>");
                for (var z = (pageCountExt - 4); z <= pageCountExt; z++) {
                    if (currentPage == z) {
                        $('#'+txtPageNavigator).append("<li><a style=\"background-color: #67b800; color: #FFF;\" onclick=\""+pageChangeFunction+"('" + z.toString() + "')\" href=\"#\">" + z.toString() + "</a></li>");
                    } else {
                        $('#'+txtPageNavigator).append("<li><a onclick=\""+pageChangeFunction+"('" + z.toString() + "')\" href=\"#\">" + z.toString() + "</a></li>");
                    }
                }
            }else if(pageCountExt < 9){
                $('#'+txtPageNavigator).append("<li><a onclick=\""+pageChangeFunction+"('1')\" href=\"#\">1</a></li>");
                if(currentPage!=4){
                    $('#'+txtPageNavigator).append("<li><a>...</a></li>");
                }
                $('#'+txtPageNavigator).append("<li><a onclick=\""+pageChangeFunction+"('" + (parseInt(currentPage) - 1).toString()  + "')\" href=\"#\">" + (parseInt(currentPage) - 1).toString()  + "</a></li>");
                $('#'+txtPageNavigator).append("<li><a style=\"background-color: #67b800; color: #FFF;\"  href=\"#\">" + currentPage + "</a></li>");
                $('#'+txtPageNavigator).append("<li><a onclick=\""+pageChangeFunction+"('" + (parseInt(currentPage) + 1).toString()  + "')\" href=\"#\">" + (parseInt(currentPage) + 1).toString()  + "</a></li>");
                if(currentPage!=(pageCountExt-2)){
                    $('#'+txtPageNavigator).append("<li><a class='no-hover'>...</a></li>");
                }
                $('#'+txtPageNavigator).append("<li><a onclick=\""+pageChangeFunction+"('" + pageCountExt.toString() + "')\" href=\"#\">" + pageCountExt.toString() + "</a></li>");
            }else{
                $('#'+txtPageNavigator).append("<li><a onclick=\""+pageChangeFunction+"('1')\" href=\"#\">1</a></li>");
                if(currentPage!=4){
                    $('#'+txtPageNavigator).append("<li><a href=\"#\">...</a></li>");
                }
                $('#'+txtPageNavigator).append("<li><a onclick=\""+pageChangeFunction+"('" + (parseInt(currentPage) - 2).toString()  + "')\" href=\"#\">" + (parseInt(currentPage) - 2).toString()  + "</a></li>");
                $('#'+txtPageNavigator).append("<li><a onclick=\""+pageChangeFunction+"('" + (parseInt(currentPage) - 1).toString()  + "')\" href=\"#\">" + (parseInt(currentPage) - 1).toString()  + "</a></li>");
                $('#'+txtPageNavigator).append("<li><a style=\"background-color: #67b800; color: #FFF;\"  href=\"#\">" + currentPage + "</a></li>");
                $('#'+txtPageNavigator).append("<li><a onclick=\""+pageChangeFunction+"('" + (parseInt(currentPage) + 1).toString()  + "')\" href=\"#\">" + (parseInt(currentPage) + 1).toString()  + "</a></li>");
                $('#'+txtPageNavigator).append("<li><a onclick=\""+pageChangeFunction+"('" + (parseInt(currentPage) + 1).toString()  + "')\" href=\"#\">" + (parseInt(currentPage) + 2).toString()  + "</a></li>");
                if(currentPage!=(pageCountExt-3)){
                    $('#'+txtPageNavigator).append("<li><a class='no-hover'>...</a></li>");
                }
                $('#'+txtPageNavigator).append("<li><a onclick=\""+pageChangeFunction+"('" + pageCountExt.toString() + "')\" href=\"#\">" + pageCountExt.toString() + "</a></li>");
            }
        }
        if (currentPage != pageCountExt && pageCountExt != 1) {
            $('#'+txtPageNavigator).append("<li><a onclick=\""+pageChangeFunction+"('" + (parseInt(currentPage) + 1).toString() + "')\" href=\"#\" aria-label=\"Next\">Next<span aria-hidden=\"true\">&raquo;</span></a></li>");
        }else{
            $('#'+txtPageNavigator).append("<li><a class='no-hover' aria-label=\"Next\">Next<span aria-hidden=\"true\">&raquo;</span></a></li>");
        }
    }else if(rowCount > 0){
        $('#'+txtPageNavigator).html("<li><a class='no-hover' aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span>Previous</a></li>");
        $('#'+txtPageNavigator).append('<li><a style=\"background-color: #67b800; color: #FFF;\" href=\"#\">1</a></li>');
        $('#'+txtPageNavigator).append("<li><a class='no-hover' aria-label=\"Next\">Next<span aria-hidden=\"true\">&raquo;</span></a></li>");
        $('#'+txtPageCount).html("1-" + rowCount + "row/" + rowCount+"row");
    }else{
        $('#'+txtPageNavigator).empty();
        $('#'+txtPageCount).empty();
    }
}

//Display error modal
function display(msg) {
    $('#txtMsgError').html(msg);
    $('#txtMsgErrorGlobal').html(msg);
    $('#errorModalGlobal').modal('show');
}
function cleanModal(id){
    $('.modal').not($(id)).each(function () {
        $(this).modal('hide');
    });
}


function displayDeleted(categoryName ,pageName, data) {
    cleanModal('#modal-delete-success');
    $('#modal-delete-success').modal('show');
    setTimeout(function(){
        $('#modal-delete-success').modal('hide');
    },popupTimeout);
    if(typeof pageName != 'undefined'){
        setTimeout(function(){
            redirectPage(categoryName ,pageName, data)
        }, popupTimeout);
    }
}
function displayUpdated(categoryName ,pageName, data) {
    cleanModal('#modal-update-success');
    $('#modal-update-success').modal('show');
    // setTimeout(function(){
    //     $('#modal-update-success').modal('hide');
    // },popupTimeout);
    if(typeof pageName != 'undefined'){
        setTimeout(function(){
            redirectPage(categoryName ,pageName, data)
        }, popupTimeout);
    }
}
function displayCreated(categoryName ,pageName, data) {
    cleanModal('#modal-create-success');
    $('#modal-create-success').modal('show');
    setTimeout(function(){
        $('#modal-create-success').modal('hide');
    },popupTimeout);
    if(typeof pageName != 'undefined'){
        setTimeout(function(){
            redirectPage(categoryName ,pageName, data)
        }, popupTimeout);
    }
}

//This is for loading page
$(document).ready(function(){
    $("#spinner").bind("ajaxSend", function() {
        $(this).show();
    }).bind("ajaxStop", function() {
        $(this).hide();
    }).bind("ajaxError", function() {
        $(this).hide();
    });
});


function makeOnEnter(inputID, func){
    $(inputID).on('keyup', function (e) {
        if (e.keyCode == 13) {
            func();
        }
    });

}

function searchOnEnter(array, func) {
    for (var index = 0; index < array.length; ++index) {
        makeOnEnter('#' + array[index], func);
    }
}

function convertDate(inputDate, formatOutput, formatInput, languageInput, languageOutput) {
    var dpg = $.fn.datepicker.DPGlobal;
    languageInput = languageInput ? languageInput : 'vi';
    languageOutput = languageOutput ? languageOutput : 'en';
    var dpgDate;
    if (formatInput) {
        dpgDate = dpg.parseDate(inputDate, dpg.parseFormat(formatInput), languageInput);
        return dpg.formatDate(dpgDate, dpg.parseFormat(formatOutput), languageOutput);
    } else {
        dpgDate = dpg.parseDate(new Date(inputDate));
        return dpg.formatDate(dpgDate, dpg.parseFormat(formatOutput), 'en');
    }
}



function paramEncode(obj) {
    var str = "";
    for (var prop in obj) {
        str += prop + "=" + encodeURIComponent(obj[prop]) + "&";
    }
    return str.slice(0, -1);
}

function download(url) {
    window.location.href = url;
}
function formatNormalDate(date) {
    if(typeof date == 'undefined' || date == null){
        return '';
    }
    var day = date.getDate();
    var monthIndex = date.getMonth();
    var year = date.getFullYear();
    return year+'-'+(monthIndex+1)+'-'+day;
}

