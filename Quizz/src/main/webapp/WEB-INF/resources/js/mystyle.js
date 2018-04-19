/* menu hover */
$(document).ready(function(){
    checkSize();
    boxToggle();
    slideToggle();
    slideToggleDouble();
    changeText();
    updateAll();
    deleteAll();
    modalDeleteShow();
    modalApprovalShow();
    messageSuccess();
    messageApprovalSuccess();
    /*showMenuList();*/
    slideDown();
    slideShow();
    messageConfirmSuccess();
    searchChangeDate();
    checkDay();
    backModalfromDelete();
    backModalfromApproval();

});
function openNav() {
    document.getElementById("mySidenav").style.width = "auto";
    document.getElementById("mainContainer").style.marginLeft = "auto";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("mainContainer").style.marginLeft= "auto";
}
/*function showMenuList(event){
     $('.table-calendar .ordered .sub-ordered').hide();
    var orderTarget = event.currentTarget;

    $('.table-calendar .ordered').mouseover(function(){
         $('.table-calendar .ordered .sub-ordered').show();
    })
}*/

function modalApprovalShow(){
    $('.btn-detail-approval').click(function(e){
        e.preventDefault();

        $('#modal-detail')
            .modal('hide')
            .on('hidden.bs.modal', function (e) {
                $('#modal-approval').modal('show');

                $(this).off('hidden.bs.modal'); // Remove the 'on' event binding
            });
    });
}

function messageApprovalSuccess(){
    $(".btn-confirm-approval").click(function(){

         $('#modal-approval')
            .modal('hide')
            .on('hidden.bs.modal', function (e) {
                $('#modal-approval-success').modal({backdrop: "static"});

                $(this).off('hidden.bs.modal'); // Remove the 'on' event binding
            });

        /*$(".modal-success").modal("show");*/
        $("#modal-approval-success").on('shown.bs.modal', function () {
            setTimeout(function() { $('#modal-approval-success').modal("hide"); }, 3000);
        });
    });
}
function modalDeleteShow(){
    $('.btn-detail-delete').click(function(e){
        e.preventDefault();

        $('#modal-detail')
            .modal('hide')
            .on('hidden.bs.modal', function (e) {
                $('#modal-delete').modal('show');

                $(this).off('hidden.bs.modal'); // Remove the 'on' event binding
            });
    });
}
function backModalfromDelete(){
    $('.btn-back-modal').click(function(e){
        e.preventDefault();

        $('#modal-delete')
            .modal('hide')
            .on('hidden.bs.modal', function (e) {
                $('#modal-detail').modal('show');

                $(this).off('hidden.bs.modal'); // Remove the 'on' event binding
            });
    });
}
/*function modalDeleteShow(){
    $('.btn-detail-delete').click(function(e){
        e.preventDefault();
        $('#modal-delete').modal('show');
        var open = $("#modal-detail").data('bs.modal').isShown ;    // Bootstrap <= 3;
        $("#modal-detail").modal('hide');

        $('.btn-back-modal').click(function(e){
            e.preventDefault();
            $('#modal-delete').modal('hide');
            if (open){
                $('#modal-detail').modal('show');
                $(this).off('hidden.bs.modal');
            }
         });
        $(this).off('hidden.bs.modal');

        // $('#modal-detail')
        //     // .modal('hide')
        //     .on('hidden.bs.modal', function (e) {
        //         $('#modal-delete').modal('show');

        //         $(this).off('hidden.bs.modal'); // Remove the 'on' event binding
        //     });
    });
}*/

// function backModalfromDelete(){
//     $('.btn-back-modal').click(function(e){
//         e.preventDefault();
//         $('#modal-delete')
//              .modal('hide');
// $('#modal-detail').modal('show');
//         // $('#modal-delete')
//         //     .modal('hide')
//         //     .on('hidden.bs.modal', function (e) {
//         //         // $('#modal-detail').modal('show');

//         //         $(this).off('hidden.bs.modal'); // Remove the 'on' event binding
//         //     });
//     });
// }
function backModalfromApproval(){
    $('.btn-back-modal-2').click(function(e){
        e.preventDefault();

        $('#modal-approval')
            .modal('hide')
            .on('hidden.bs.modal', function (e) {
                $('#modal-detail').modal('show');

                $(this).off('hidden.bs.modal'); // Remove the 'on' event binding
            });
    });
}

function messageSuccess(){
    $(".btn-confirm").click(function(){

         $('.modal-confirm')
            .modal('hide')
            .on('hidden.bs.modal', function (e) {
                $('.modal-success').modal({backdrop: "static"});

                $(this).off('hidden.bs.modal'); // Remove the 'on' event binding
            });

        /*$(".modal-success").modal("show");*/
        $(".modal-success").on('shown.bs.modal', function () {
            setTimeout(function() { $('.modal-success').modal("hide"); }, 3000);
        });
    });
}

function updateAll(){
    $(".cb-update-all").change( function(){
       if($(this).is(':checked')){
            $(".cb-update").prop("checked", true);
            
            if($(".cb-delete-all").is(':checked') ){
                $(".cb-delete-all").prop("checked", false);
            }

            $(".cb-delete").prop("checked", false);
        }else{
            $(".cb-update").prop("checked", false);

            if(!$(".cb-delete-all").is(':checked')){
                $(".cb-delete-all").prop("checked", true);
            }

            $(".cb-delete").prop("checked", true);
        }
    });
    $(".cb-update-all").change( function(){
        if(!$(this).is(':checked')){
            $(this).parents(".check-table").find(".cb-delete-all").prop("checked", false);
            $(this).parents(".check-table").find(".cb-delete").prop("checked", false);
        }
    });

    $(".cb-update").change( function(){
        if(!$(this).is(':checked')){
            $(".cb-update-all").prop("checked", false);
        }
    });
    $(".cb-update").change( function(){
        if($(this).is(':checked')){
            $(this).parents(".checkparents").find(".cb-delete").prop("checked", false);
            $(this).parents(".check-table").find(".cb-delete-all").prop("checked", false);
        }
    });
}

function deleteAll(){
    $(".cb-delete-all").change( function(){
       if($(this).is(':checked')){
            $(".cb-delete").prop("checked", true);
            
            if($(".cb-update-all").is(':checked')){
                $(".cb-update-all").prop("checked", false);
            }

            $(".cb-update").prop("checked", false);
        }else{
            $(".cb-delete").prop("checked", false);

            if(!$(".cb-delete-all").is(':checked')){
                $(".cb-update-all").prop("checked", true);
            }

            $(".cb-update").prop("checked", true);
        }
    });

    $(".cb-delete-all").change( function(){
        if(!$(this).is(':checked')){
            $(this).parents(".check-table").find(".cb-update-all").prop("checked", false);
            $(this).parents(".check-table").find(".cb-update").prop("checked", false);
        }
    });

    $(".cb-delete").change( function(){
        if(!$(this).is(':checked')){
            $(".cb-delete-all").prop("checked", false);
        }
    });
    $(".cb-delete").change( function(){
        if($(this).is(':checked')){
            $(this).parents(".checkparents").find(".cb-update").prop("checked", false);
            $(this).parents(".check-table").find(".cb-update-all").prop("checked", false);
        }
    });
}

function boxToggle(){
    $(".box-toggle").hide();
    $(".box-toggle-2").hide();

    $(".btn-box-toggle").click( function(){
       $(".box-toggle").slideToggle();
       $(".btn-box-toggle .fa").toggleClass('fa-chevron-circle-down');
    });

    $(".btn-box-toggle-2").click( function(){
       $(".box-toggle-2").slideToggle();
       $(".btn-box-toggle-2 .fa").toggleClass('fa-chevron-circle-down');
    });
}

function slideToggle(){
    $(".slide-toggle").hide();

    if($("#slide-down").is(':checked')){
        $(".slide-toggle").show();
    }

    $("#slide-down").change( function(){
       if($(this).is(':checked')){
            $(".slide-toggle").slideDown();
        }
    });

    $("#slide-up").change( function(){
       if($(this).is(':checked')){
            $(".slide-toggle").slideUp();
        }
    });

    $(".btn-slide-toggle").click(function(){
        $(".slide-toggle").slideToggle();
    });
}

function slideToggleDouble(){
    $(".slide-toggle-1").hide();
    $(".slide-toggle-2").hide();

    if($("#slide-1").is(':checked')){
        $(".slide-toggle-1").show();
    }

    $("#slide-1").change( function(){
       if($(this).is(':checked')){
            $(".slide-toggle-1").slideDown();
            $(".slide-toggle-2").slideUp();
        }
    });

    if($("#slide-2").is(':checked')){
        $(".slide-toggle-2").show();
    }

    $("#slide-2").change( function(){
       if($(this).is(':checked')){
            $(".slide-toggle-1").slideUp();
            $(".slide-toggle-2").slideDown();
        }
    });
}

function changeText(){
    if($("#radio-change-1").is(':checked')){
        $(".txt-change").text('補助比率(％) *2');
        $(".txt-change-2").attr("placeholder", "(最大50)").val("").focus().blur();
    }

    $("#radio-change-1").change( function(){
       if($(this).is(':checked')){
            $(".txt-change").text('補助比率(％) *2');
            $(".txt-change-2").attr("placeholder", "(最大50)").val("").focus().blur();
        }
    });

    $("#radio-change-2").change( function(){
       if($(this).is(':checked')){
             $(".txt-change").text('補助額(税込) *2');
             $(".txt-change-2").attr("placeholder", "(税込)").val("").focus().blur();
        }
    });
}

function checkSize(){
    if($(window).width() <= 1200){
        $(".header-2 .navbar-main li").click(function(){
            $(this).children(".sub-menu").slideToggle(300);
        });
    }
    else{
        /*$(".header-2 .navbar-main li.normal a").mouseover(function(){
            $(".header-2 .navbar-main li.active a").css("background", "none");
        });

        $(".header-2 .navbar-main li.normal .sub-menu").mouseover(function(){
            $(".header-2 .navbar-main li.active a").css("background", "none");
        });

        $(".header-2 .navbar-main li.normal a").mouseout(function(){
             $(".header-2 .navbar-main li.active a").css("background", "url(img/menu-active.png) no-repeat bottom center");
        });

        $(".header-2 .navbar-main li.normal .sub-menu").mouseout(function(){
             $(".header-2 .navbar-main li.active a").css("background", "url(img/menu-active.png) no-repeat bottom center");
        });*/
    } 
}

$('.bootstrap-calendar-1').datepicker({
    language :"vi",
    orientation: "bottom auto",
    toggleActive: true,
    format: "yyyy-mm-dd",
    autoclose: true,
    todayHighlight: true
});

$('.bootstrap-calendar-2').datepicker({
    language: "en",
    orientation: "bottom auto",
    toggleActive: true,
    format: "yyyy-mm",
    startView: 1,
    minViewMode: 1,
    maxViewMode: 2,
    autoclose: true,
    todayHighlight: true
});

$('.bootstrap-calendar-3').datetimepicker({
    format: 'Y-m-d H:i'
});

$('.form-current-date').datepicker('setDate', 'now');

function slideDown(){
    $(".box-toggle").hide();

    $(".btn-slide-down").click(function(){
        $(".box-toggle").slideDown();
    });
}

function slideShow(){
    $(".slide-show").hide();

    $(".btn-slide-show-box").click(function(){
        $(".slide-show").slideDown();
        $(this).parent().parent().css("background","#f5f5c7");
    });

}
function messageConfirmSuccess(){
    $(".btn-confirm-success").click(function(){

         $('#modal-approval')
            .modal('hide')
            .on('hidden.bs.modal', function (e) {
                $('.modal-success').modal({backdrop: "static"});

                $(this).off('hidden.bs.modal'); // Remove the 'on' event binding
            });

        /*$(".modal-success").modal("show");*/
        $(".modal-success").on('shown.bs.modal', function () {
            setTimeout(function() { $('.modal-success').modal("hide"); }, 3000);
        });
    });
}
function searchChangeDate(){
    $(".searchDate1").hide();
    $(".searchDate2").hide();

    if($("#radio-search1").is(':checked')){
        $(".searchDate1").show();
        $(".searchDate2").hide();
        $(".customcol2").addClass("customw100p");
        $(".customradio").addClass("col-md-6 col-lg-40p");
        $(".customcol1").addClass("custom-mt");
    }

    $("#radio-search1").change( function(){
       if($(this).is(':checked')){
            $(".searchDate1").show();
            $(".searchDate2").hide();
            $(".customcol2").addClass("customw100p");
            $(".customradio").addClass("col-md-6 col-lg-40p");
            $(".customcol1").addClass("custom-mt");
        }
    });

    if($("#radio-search2").is(':checked')){
        $(".searchDate2").show();
        $(".searchDate1").hide();
        $(".customcol2").removeClass("customw100p");
        $(".customradio").removeClass("col-md-6 col-lg-40p");
        $(".customcol1").removeClass("custom-mt");
    }

    $("#radio-search2").change( function(){
       if($(this).is(':checked')){
            $(".searchDate2").show();
            $(".searchDate1").hide();
            $(".customcol2").removeClass("customw100p");
            $(".customradio").removeClass("col-md-6 col-lg-40p");
            $(".customcol1").removeClass("custom-mt");
        }
    });
}
function checkDay() {
    var checkboxes;
    $('#checkbox-sun').click(function () {
        checkboxes = $("#calendar .checkbox:nth-child(7n - 6)").find('input:checkbox');
        checkboxes.prop('checked', this.checked);
        checkboxes.click(function () {
            if (!this.checked) {
                $('#checkbox-sun').prop('checked', false);
            }
        })
    });
    $('#checkbox-mon').click(function () {
        var checkboxes = $("#calendar .checkbox:nth-child(7n - 5)").find('input:checkbox');
        checkboxes.prop('checked', this.checked);
        checkboxes.click(function () {
            if (!this.checked) {
                $('#checkbox-mon').prop('checked', false);
            }
        })
    });
    $('#checkbox-tue').click(function () {
        var checkboxes = $("#calendar .checkbox:nth-child(7n - 4)").find('input:checkbox');
        checkboxes.prop('checked', this.checked);
        checkboxes.click(function () {
            if (!this.checked) {
                $('#checkbox-tue').prop('checked', false);
            }
        })
    });
    $('#checkbox-wes').click(function () {
        var checkboxes = $("#calendar .checkbox:nth-child(7n - 3)").find('input:checkbox');
        checkboxes.prop('checked', this.checked);
        checkboxes.click(function () {
            if (!this.checked) {
                $('#checkbox-wes').prop('checked', false);
            }
        })
    });
    $('#checkbox-thu').click(function () {
        var checkboxes = $("#calendar .checkbox:nth-child(7n - 2)").find('input:checkbox');
        checkboxes.prop('checked', this.checked);
        checkboxes.click(function () {
            if (!this.checked) {
                $('#checkbox-thu').prop('checked', false);
            }
        })
    });
    $('#checkbox-fri').click(function () {
        var checkboxes = $("#calendar .checkbox:nth-child(7n - 1)").find('input:checkbox');
        checkboxes.prop('checked', this.checked);
        checkboxes.click(function () {
            if (!this.checked) {
                $('#checkbox-fri').prop('checked', false);
            }
        })
    });
    $('#checkbox-sat').click(function () {
        var checkboxes = $("#calendar .checkbox:nth-child(7n)").find('input:checkbox');
        checkboxes.prop('checked', this.checked);
        checkboxes.click(function () {
            if (!this.checked) {
                $('#checkbox-sat').prop('checked', false);
            }
        })
    });
}

