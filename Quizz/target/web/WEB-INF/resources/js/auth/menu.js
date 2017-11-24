/**
 * @author Ben
 */

var menu = function () {
    var template  = {
        compileMenuAdmin : Template7.compile($("#templateMenuAdmin").html()),
        compileMenuStudent : Template7.compile($("#templateMenuStudent").html()),
        compileMenuTeacher : Template7.compile($("#templateMenuTeacher").html())
    };
    function init() {
        if(screenCode == "ADM"){
            $("#menuContent").html(template.compileMenuAdmin());
        }
        if(screenCode=="STU"){
            $("#menuContent").html(template.compileMenuStudent());
        }
        if(screenCode=="TEA"){
            $("#menuContent").html(template.compileMenuTeacher());
        }

    }
    return{
        init: init
    }

}();

$(document).ready(function () {
        menu.init();
});