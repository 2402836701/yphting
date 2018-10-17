// JavaScript Document

//显示加载层
function showloading(){
	var index = layer.load(1, {
	  shade: [0.7,'#fff'] //0.1透明度的白色背景
	});
}
//关闭所有层
function closetip(){
	layer.closeAll();
}  
//显示提示
function showtip(msg){
	closetip();
	layer.msg(msg, {closeBtn:0});
	//layer.alert(msg, {closeBtn:1});
}

function showConfirm(_msg, _func){

	layer.confirm(_msg, {
		btn: ['确定','取消'] //按钮
	}, function(){

		closetip();
		eval(_func);
	
	}, function(){
		closetip();
	});
}

$(function(){
	//right nav
	$('.right_nav li').mouseover(function(){
		$(this).children('.over_show').fadeIn();
	
	}).mouseover(function(){
		$(this).children('.over_show').hide();
	
	});
	
	//导航四个黑方块$().
	$('.i_rover').click(function(){
		$('.pop_contact').fadeIn();
	});
	//关闭导航四个黑方块
	$('.close_pop_contact').click(function(){
		$('.pop_contact').fadeOut();
	});
	
	//普通会员tab
	$('.pt_per_tab_ul li').click(function(){
		var thisIndex = $('.pt_per_tab_ul li').index(this);
		$('.pt_per_tab_ul li').removeClass('cur');
		$(this).addClass('cur');
		$('.pt_tab_show').hide();
		$('.pt_tab_show:eq('+thisIndex+')').show();
	});
	
	//帮助中心
	$('.sv_dl_list dt').click(function(){
		var thiscur = $(this).hasClass('cur');
		if(thiscur){
			$(this).removeClass('cur');
			$(this).next('dd').slideUp();
		}else{
			$('.sv_dl_list dt').removeClass('cur');
			$(this).addClass('cur');
			$('.sv_dl_list dd').hide();
			$(this).next('dd').slideDown();
		}
	});	
	
	//发送站内信
	$('.send_site_email_btna').click(function(){
		$('#pop_bg').show();
		$('.site_email_pop').show();	
	});

	//填写发货单号
	$('.btn_send_sth').click(function(){
		$('#pop_bg').show();
		$('.site_ship_pop').show();	
	});
	
	//上传翻译稿
	$('#upload_fy_word').click(function(){
		$('#pop_bg').show();
		$('.site_upload_pop').show();	
	});
	
	
	//关闭站内信pop
	$('.close_pop_btn,.btna_acancel').click(function(){
		$('#pop_bg').hide();
		$('.site_email_pop,.pop_con2').hide();
		$('.site_ship_pop').hide();	
		$('.site_upload_pop').hide();
		$('#bfid').val(0);
	});
	
	//商家入驻申请资料认证
	$('.sel_business_users a').click(function(){
		var thisIndex = $('.sel_business_users a').index(this);
		$('#group_id').val($(this).attr('rel'));
		$('.sel_business_users a').removeClass('cur');
		$(this).addClass('cur');
		thisIndex++;
		$('.stype2,.stype1').hide();
		$('.stype'+thisIndex+'').show();
	});
	//选择服务类别
	$('.sel_sev_style a').click(function(){

		_id = $(this).attr('rel');
		var _len = $('.sel_sev_style .cur').length;
		if($(this).hasClass('cur')){
			$(this).removeClass('cur');
			if(_id == 4){
				$('.hospital').hide();
			}
		}else{
			if(_len<2){
				if(_id == 4){
					$('.hospital').show();
				}
				$(this).addClass('cur');
			}
		}
		_len = $('.sel_sev_style .cur').length;
		var _catids = '0';
		for(i=0; i< _len;i++){
			_catids += ','+$('.sel_sev_style .cur:eq('+i+')').attr('rel');
		}
		$('#catids').val(_catids);
		
	});
	
	//选择发布服务类别
	$('.sss_ul li').click(function(){
		$('.sss_ul li').removeClass('cur');
		$(this).addClass('cur');
	});
	
	//回应评价
	$('.btna_hy_a').click(function(){
		$(this).parent('.date_p').hide();
		$(this).parent().siblings('.my_hy_box').show();
	});
	
	//取消评价
	$('.btn_jy_a4').click(function(){
		$(this).parent().parent('.my_hy_box').hide();
		$(this).parent().parent().siblings('.date_p').show();
	});
	
	//举报
	$('.btna_a_jb').click(function(){
		$('#pop_bg').show();
		$('.pop_con').show();
	});	
	
	$('.close_pop').click(function(){
		$('#pop_bg').hide();
		$('.pop_con').hide();
		$('.pop_con2').hide();
		$('#bfid').val(0);
	});
	
	$('.xh_po_qx').click(function(){
		$('#pop_bg').hide();
		$('.pop_con2').hide();
	});
	
	//回应
	$('.btna_hy_a2').click(function(){
		$(this).parent('p').hide();
		$(this).parent().parent().siblings('.my_hy_box').show();
	});
	
	//取消回应
	$('.btn_jy_a4_2').click(function(){
		$(this).parent().parent('.my_hy_box').hide();
		$(this).parent().parent().siblings('.my_evaluation_text').children('.mt0').show();
	});
	
	//
	$('.business_detail_img_ulist li img').click(function(){
		$('.business_detail_img_ulist li').removeClass('cur');
		$(this).parent('li').addClass('cur');
		var thisSrc = $(this).attr("src");
		$('#business_detail_big_img').attr({"src":thisSrc});
	});
	
	//删除
	$('.del_btn_p').mouseover(function(){
		$(this).children('a').show();
	}).mouseover(function(){
		$(this).children('a').hide();
	});
	
	$('.del_btn_p a').click(function(){
		_id = $(this).attr('rel');
		_obj = $(this);
		if(_id){
			$.ajax({
				data: {ids: _id, act: 'del'},
				url: "/index.php?m=Home&c=Member&a=smsoption",
				type: "post",
				success:function(res){
					location.reload();
					$(_obj).parent().parent().parent().remove();
				}
			})
		}
	});
	
	$('.mslist_ul2 li').mouseover(function(){
		$(this).find('.talk_del_a').show();
	}).mouseover(function(){
		$(this).find('.talk_del_a').hide();
	});
	
	//删除信息
	$('.talk_del_a').click(function(){

		_id = $(this).attr('rel');
		_obj = $(this);
		if(_id){
			$.ajax({
				data: {ids: _id, act: 'del'},
				url: "/index.php?m=Home&c=Member&a=smsoption",
				type: "post",
				success:function(res){
					location.reload();
					$(_obj).parent().parent().parent().remove();
				}
			})
		}
	});
	
	$('.rn_top').click(function(){
		goto('botop');
	});
	
	//帖子详细页回应
	$('.response_btn').click(function(){
		$('.hy_box2').hide();
		$('.login_after_pl_box').show();
		goto('response_box');
	});
	
	//首页星级服务商家推荐切换
	$('.star_recommend_tab a').click(function(){
		var thisIndex = $('.star_recommend_tab a').index(this);
		$('.star_recommend_tab a').removeClass('cur');
		$(this).addClass('cur');
		$('.star_recommend_show').hide();
		$('.star_recommend_show:eq('+thisIndex+')').show();
	});
	
	
	footerPos()
	$(window).resize(function(){
		footerPos();
	});
	
	//删除收藏服务 
	$('.del_collection').click(function(){
 		_id = $(this).attr('rel');
       showConfirm('是否要删除此收藏？', "delservers("+_id+")");		
	});

	
	//删除收藏商家 
	$('.collection_btndel').click(function(){
		_id = $(this).attr('rel');
		showConfirm('是否要删除此收藏？', "delshops("+_id+")");        
	});
	
	//删除站内信
	$('.smsdel').click(function(){
		_ids = $('#formsms').serialize();
		showloading();
		$.ajax({
			data: _ids+"&act=del",
			type: "post",
			url: "/index.php?m=Home&c=Member&a=smsoption",
			success: function(res){
				showtip('删除成功');
				setTimeout("location.reload()",1000);
			}
		});
	});
	
	//设置站内信状态
	$('.smszt').click(function(){
		_ids = $('#formsms').serialize();
		showloading();
		$.ajax({
			data: _ids+"&act=smszt",
			type: "post",
			url: "/index.php?m=Home&c=Member&a=smsoption",
			success: function(res){
				showtip('设置成功');
				setTimeout("location.reload()",1000);
			}
		});
	});
	
	//商家回复评论
	$('.btn_reply').click(function(){
		_id = $('#replymsg').attr('rel');
		_msg = $('#replymsg').val();
		showloading();
		if(_id && _msg){
			$.ajax({
				url: "/index.php?m=Home&c=Seller&a=reply",
				data:{ id:_id, msg:_msg},
				type:"post",
				dataType: 'json',
				success: function(res){
					showtip(res.msg);
					if(res.state == 1){
						setTimeout("location.reload();",1000);
					}
				}
			})
		}else{
			showtip('请填写回复内容');
		}
	});
	
});

function footerPos(){
	var winH = $(window).height();
	var pageH = $(document).height();
	console.log(winH+"_"+pageH);
	if(pageH<=winH){
		$('.footer').addClass('footerpos');
	}else{
		$('.footer').removeClass('footerpos');
	}
}

function goto(id) {
	$("#" + id).ScrollTo(500);
}

var has_top = false;

function scrollFunc(){

	var scrollTop = 0;

	console.log(has_top);

	if(has_top){
		scrollTop = document.body.scrollTop;
	}



	//if(typeof document.body.scrollTop=='')

	var sh = document.documentElement.scrollTop ? document.documentElement.scrollTop:scrollTop;
	//var bodyH = document.body.scrollHeight;
	var wH = $(window).height();
	if(sh>(wH/2)){
		$('.rn_top').fadeIn().css({"display":"block"});
	}else{
		$('.rn_top').fadeOut();
	}

	has_top = true;
	
}
scrollFunc();

if(window.attachEvent){
	 window.attachEvent('onmousewheel',scrollFunc);
	 window.attachEvent('onscroll',scrollFunc);
}else if (window.addEventListener) {	
	window.addEventListener("scroll", scrollFunc, false); 
	window.addEventListener('mousewheel',scrollFunc, false);  
}

//获取下级地区数据
function setarea(_pid,oname){
	
	$.ajax({
		url : '/index.php?m=Home&c=Ajax&a=getcity',
		type: 'post',
		dataType: 'json',
		data:{pid:_pid},
		success: function(res){
			
			var obj = document.getElementById(oname);
			obj.length=1;
			for(var i=0, l=res.length; i<l; i++){
				obj.add(new Option(res[i].areaname,res[i].areaid));

			}
       
		}
	})
}

//发送站内信
function sendsms(){
	_uid = $('#smsuid').val();
	_msg = $('#smsmsg').val();
	_rid = $("#reid").val();
	if(_uid && _msg){
		showloading();
		$.ajax({
			data: {msg:_msg, uid:_uid, rid:_rid},
			type: "post",
			url: '/index.php?m=Home&c=Member&a=sendsms',
			dataType: 'json',
			success: function(res){
				closetip();
				showtip(res.msg);
				if(res.state == 1){
					$('.btna_acancel').click();
					setTimeout('location.reload()',1000);
				}
			}
		})
	}else{
		showtip('请填写信件内容！');
	}
}

//申请管理员介入
function disagree(_rid){
	if(_rid){
		showloading();
		$.ajax({
			data: {rid:_rid},
			type: "post",
			dataType: "json",
			url: "/index.php?m=Home&c=Member&a=refunddisagree",
			success: function(res){
				showtip(res.msg);
				if(res.state==1){
					setTimeout('location.reload()',1000);
				}
			}
			
		});
	}
}

//提交快递单号
function toship(){
	_hydh = $('#hydh1').val();
	_gs = $("#shipcompany").val();
	_lid = $('#hydh1').attr('rel');
	if(_hydh && _gs && _lid){
		showloading();
		$.ajax({
			data:{hydh:_hydh,company:_gs,lid:_lid},
			type:"post",
			dataType:"json",
			url:"/index.php?m=Home&c=Member&a=toshiphyd",
			success: function(res){
				showtip(res.msg);
				if(res.state==1){
					setTimeout('location.reload()',1000);
				}
			}
		})
	}else{
		showtip('请填写快递公司和快递单号');
	}
}

//物流设置为完成
function toshipsuccess(_lid){
	showloading();
	$.ajax({
		data:{lid:_lid},
		type:"post",
		dataType:"json",
		url:"/index.php?m=Home&c=Member&a=toshipsuccess",
		success: function(res){
			showtip(res.msg);
			if(res.state==1){
				setTimeout('location.reload()',1000);
			}
		}
	})
}

$(function(){
	$('.c_pop_close').click(function(){
		$('.com_pop_box').hide();
		$('#pop_bg').hide();
	});
});

function changechk(){
	$('#chkimg').attr('src','/index.php?m=Home&c=Index&a=verify&t='+(new Date().getTime()));
}

