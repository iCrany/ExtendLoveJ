/* dCodes Framework: (c) TemplateAccess */
 $(function() {
  /* the menu */
  var $menu = $('#dc_metro_menu');
  
  /* for each list element, we show the submenu when hovering and expand the span element (title) to 510px */
  $menu.children('li').each(function(){
    var $this = $(this);
    var $span = $this.children('span');
    $span.data('width',$span.width());
    $this.bind('mouseenter',function(){
      $menu.find('.dc_metro_submenu').stop(true,true).hide();
      $span.stop().animate({'width':'408px'},300,function(){ $this.find('.dc_metro_submenu').slideDown(300); });
    }).bind('mouseleave',function(){
      $this.find('.dc_metro_submenu').stop(true,true).hide();
      $span.stop().animate({'width':$span.data('width')+'px'},300);
    });
  });
});