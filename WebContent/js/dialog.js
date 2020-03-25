jQuery(document).ready(function($) {
	//想读
	$('.want').click(function(){
		//$('.dialog-popover-mask').fadeIn(10);
		$('.dialog-want').slideDown(300);
	})
	$('.dialog-poptit .close').click(function(){
		//$('.dialog-popover-mask').fadeOut(10);
		$('.dialog-want').slideUp(300);
	})
    //正在读这本书
	$('.reading').click(function(){
		//$('.dialog-popover-mask').fadeIn(10);
		$('.dialog-reading').slideDown(300);
	})
	$('.dialog-poptit .close').click(function(){
		//$('.dialog-popover-mask').fadeOut(10);
		$('.dialog-reading').slideUp(300);
	})
	//读过
	$('.read').click(function(){
		//$('.dialog-popover-mask').fadeIn(10);
		$('.dialog-read').slideDown(300);
	})
	$('.dialog-poptit .close').click(function(){
		//$('.dialog-popover-mask').fadeOut(10);
		$('.dialog-read').slideUp(300);
	})
	//修改
	$('.read-edit').click(function(){
		//$('.dialog-popover-mask').fadeIn(10);
		$('.dialog-edit').slideDown(300);
	})
	$('.dialog-poptit .close').click(function(){
		//$('.dialog-popover-mask').fadeOut(10);
		$('.dialog-edit').slideUp(300);
	})
	//登录框
	$('.reglgdialog').click(function(){
		//$('.dialog-popover-mask').fadeIn(10);
		$('.dialog-login').slideDown(300);
	})
	$('.dialog-poptit .close').click(function(){
		//$('.dialog-popover-mask').fadeOut(10);
		$('.dialog-login').slideUp(300);
	})
})

