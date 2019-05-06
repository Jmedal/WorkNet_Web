$(function(){
	$(".msg-box ul li").hover(function(){
		$(this).css("background-color","#d1eeee");
		$(this).find("span").show();
	},function(){
//		$(this).css("background-color","snow");
		$(this).css("background-color","white");
		$(this).find("span").hide();
	});
	$(".msg-box ul li span").click(function(){
		$(this).parent().remove();
	});
})