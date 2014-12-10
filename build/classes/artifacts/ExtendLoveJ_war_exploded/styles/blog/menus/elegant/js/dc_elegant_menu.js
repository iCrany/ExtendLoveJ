/* dCodes Framework: (c) TemplateAccess */
// <![CDATA[

DD_roundies.addRule("#dc_elegant_menu", "5px");
DD_roundies.addRule("#dc_elegant_menu li", "5px");

$(function() {
  $nav_li=$("#dc_elegant_menu li");
  $nav_li_a=$("#dc_elegant_menu li a");
  var animSpeed=450; //fade speed
  var hoverTextColor="#000000"; //text color on mouse over
  var hoverBackgroundColor="#ffffff"; //background color on mouse over
  var textColor=$nav_li_a.css("color");
  var backgroundColor=$nav_li.css("background-color");
  //text color animation
  $nav_li_a.hover(function() {
	var $this=$(this);
	$this.stop().animate({ color: hoverTextColor }, animSpeed);
  },function() {
	var $this=$(this);
	$this.stop().animate({ color: textColor }, animSpeed);
  });
  //background color animation
  $nav_li.hover(function() {
	var $this=$(this);
	$this.stop().animate({ backgroundColor: hoverBackgroundColor }, animSpeed);
  },function() {
	var $this=$(this);
	$this.stop().animate({ backgroundColor: backgroundColor }, animSpeed);
  });
});

// ]]>