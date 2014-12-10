/* dCodes Framework: (c) TemplateAccess */
// <![CDATA[
$(function() {
  var $oe_menu = $('#dc_exp_menu');
  var $oe_menu_items = $oe_menu.children('li');
  var $oe_overlay = $('#dc_em_overlay');
  $oe_menu_items.bind('mouseenter',function(){
	var $this = $(this);
	$this.addClass('slided selected');
	$this.children('div').css('z-index','9999').stop(true,true).slideDown(200,function(){
	  $oe_menu_items.not('.slided').children('div').hide();
	  $this.removeClass('slided');
	});
  }).bind('mouseleave',function(){
	var $this = $(this);
	$this.removeClass('selected').children('div').css('z-index','1');
  });
  $oe_menu.bind('mouseenter',function(){
	var $this = $(this);
	$oe_overlay.css('display','block');
	$oe_overlay.stop(true,true).fadeTo(200, 0.6);
	$this.addClass('hovered');
  }).bind('mouseleave',function(){
	var $this = $(this);
	$this.removeClass('hovered');
	$oe_overlay.stop(true,true).fadeTo(200, 0);
	$oe_overlay.css('display','none');
	$oe_menu_items.children('div').hide();
  })
});

// ]]>