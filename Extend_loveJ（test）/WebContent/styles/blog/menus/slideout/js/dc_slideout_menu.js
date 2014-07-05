/* dCodes Framework: (c) TemplateAccess */
// <![CDATA[
  $(function() {
	  //graceful degradation
	  $('#dc_slideout').find('ul').css({'left':'-660px'}).siblings('.dc_slideout-right').css({'left':'200px'});
	  
	  var $arrow = $('#dc_slideout').find('.dc_slideout-right');
	  var $menu  = $('#dc_slideout').find('ul');
	  $arrow.bind('mouseenter',function(){
		  var $this = $(this);
		  $this.stop().animate({'left':'160px'},50);
		  $menu.stop().animate({'left':'202px'},500,function(){
			  $(this).find('a')
			  .unbind('mouseenter,mouseleave')
			  .bind('mouseenter',function(){$(this).addClass('hover');})
			  .bind('mouseleave',function(){$(this).removeClass('hover');});
		  });
	  });
	  $menu.bind('mouseleave',function(){
		  var $this = $(this);
		  $this.stop().animate({'left':'-660px'},500,function(){$arrow.stop().animate({'left':'200px'},500);});
	  });
  });

// ]]>