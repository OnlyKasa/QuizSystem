/*
 * common.js
 *
 *  version --- 3.6
 *  updated --- 2011/09/06
 */
/* !stack ------------------------------------------------------------------- */

jQuery(document).ready(function($) {
	addCss();
});
$(function(){
	var a = true;
	$(".btn-menu").click(function(){
		if(a){
			$(".overlay").show(0).re;
			$(".SM-page .navibar").show();
			a = false;
		}
		else {
			$(".overlay").hide(0);
			$(".SM-page .navibar").hide();
			a = true;
		}
	});
	$(".overlay").click(function(){
		$(".overlay").hide(0);
		$(".SM-page .navibar").hide();
		a = true;
	});
	$(window).resize(function(){
		var h_wd = $(window).height();
		
		if($(window).width() > 768 ){
			$(".SM-page .navibar").show();
		}
		else {
			
			$(".overlay").hide(0);
			$(".SM-page .navibar").hide();
			a = true;
		}
	});
	
	$(".accoding ul").slideUp(0);
	$('.accoding .ico-root').on('click',function(){
		$(this).toggleClass('active');
		$(this).parent().siblings('ul').slideToggle(500);	
		$(this).siblings('ul').slideToggle(500);
	})
	$(".accoding ul li.folder_open ul").show();

	$(".alert-success").click(function(){
		
		setTimeout(function(){
			$(".modal-success").modal("show");
		}, 500);
		setTimeout(function(){
			$(".modal-success").modal("hide");
		}, 1700);
	});
	$('[data-toggle="tooltip"]').tooltip();
});



/* !Addition Fitst & Last --------------------------------------------------- */
var addCss = (function(){
	$('.section:first-child:not(:last-child)').addClass('first');
	$('.section:last-child').addClass('last');
	$('li:first-child:not(:last-child)').addClass('first');
	$('li:last-child').addClass('last');
});
