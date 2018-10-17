function scrollFunc_online(){
	var sh = document.documentElement.scrollTop ? document.documentElement.scrollTop:document.body.scrollTop;
	var bodyH = document.body.scrollHeight;
	var wH = $(window).height();
	var service_recs_title = $('#service_recs_title').offset().top;
	var business_detail_online_boxH = $('.business_detail_online_box').height();
	var business_dtail_bottom_boxH = $('.business_dtail_bottom_box').height();
	
	if(sh>197 && sh < (service_recs_title-business_detail_online_boxH)){
		$('.business_detail_online_box').removeClass('fixed_online2').addClass('fixed_online');
	}else if(sh>=(service_recs_title-business_detail_online_boxH)){
		$('.business_detail_online_box').removeClass('fixed_online').addClass('fixed_online2');
		$('.fixed_online2').css({"bottom":-(business_dtail_bottom_boxH+86),"height":business_detail_online_boxH});
	}else{
		$('.business_detail_online_box').removeClass('fixed_online').removeClass('fixed_online2');
	}
	
}
scrollFunc_online();

if(window.attachEvent){
	 window.attachEvent('onmousewheel',scrollFunc_online);
	 window.attachEvent('onscroll',scrollFunc_online);
}else if (window.addEventListener) {	
	window.addEventListener("scroll", scrollFunc_online, false); 
	window.addEventListener('mousewheel',scrollFunc_online, false);  
}