var editor;

KindEditor.ready(function(K) {
	editor = K.create('#content', {
		afterBlur: function () { this.sync(); },
		uploadJson : '/index.php?m=Home&c=Kindeditor&a=upload&type=desc',
		allowFileManager : false,
		langType: 'zh_CN',
		allowPreviewEmoticons : false,
		allowImageUpload : true,
		/*
        items : [
			'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
			'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
			'insertunorderedlist', '|', 'emoticons', 'image', 'link']
        */
	});
});

$(function(){
	var imgUploadBtn = document.getElementById("picbt1");
    new AjaxUpload(imgUploadBtn,{
        action:'/index.php?m=Home&c=Kindeditor&a=upload&type=image&dir=image&water=0',
        name:"imgFile",
        onSubmit:function(file,ext){
            if(ext && /^(jpg|jpeg|png|gif)$/.test(ext)){
                imgUploadBtn.innerHTML = " 正在上传… ";
                imgUploadBtn.disabled = "disabled";
            }else{
                showtip('不支持非图片格式！');
                return false;
            }
        },
        onComplete:function(file,response){
            imgUploadBtn.disabled = "";
            imgUploadBtn.innerHTML = " 重新上传 ";

            var obj = jQuery.parseJSON(response);
			console.log(obj);
            if(obj.error == 0){
                $('#idcardpic1').val(obj.url);
				$('#idcardpic1').parent().find('img').attr('src',obj.url).show();
			}else
                showtip(obj.message);
        }
    });
	
	var imgUploadBtn2 = document.getElementById("picbt2");
    new AjaxUpload(imgUploadBtn2,{
        action:'/index.php?m=Home&c=Kindeditor&a=upload&type=image&dir=image&water=0',
        name:"imgFile",
        onSubmit:function(file,ext){
            if(ext && /^(jpg|jpeg|png|gif)$/.test(ext)){
                imgUploadBtn2.innerHTML = " 正在上传… ";
                imgUploadBtn2.disabled = "disabled";
            }else{
                showtip('不支持非图片格式！');
                return false;
            }
        },
        onComplete:function(file,response){
            imgUploadBtn2.disabled = "";
            imgUploadBtn2.innerHTML = " 重新上传 ";

            var obj = jQuery.parseJSON(response);
			console.log(obj);
            if(obj.error == 0){
                $('#idcardpic2').val(obj.url);
				$('#idcardpic2').parent().find('img').attr('src',obj.url).show();
			}else
                showtip(obj.message);
        }
    });
	
	var imgUploadBtn3 = document.getElementById("picbt3");
    new AjaxUpload(imgUploadBtn3,{
        action:'/index.php?m=Home&c=Kindeditor&a=upload&type=image&dir=image&water=0',
        name:"imgFile",
        onSubmit:function(file,ext){
            if(ext && /^(jpg|jpeg|png|gif)$/.test(ext)){
                imgUploadBtn3.innerHTML = " 正在上传… ";
                imgUploadBtn3.disabled = "disabled";
            }else{
                showtip('不支持非图片格式！');
                return false;
            }
        },
        onComplete:function(file,response){
            imgUploadBtn3.disabled = "";
            imgUploadBtn3.innerHTML = " 重新上传 ";

            var obj = jQuery.parseJSON(response);
			console.log(obj);
            if(obj.error == 0){
                $('#vippic').val(obj.url);
				$('#vippic').parent().find('img:eq(0)').attr('src',obj.url).show();
			}else
                showtip(obj.message);
        }
    });
});

function delfile(obj){
	_file = $(obj).attr('rel');;
	$.ajax({
		data:{file:_file},
		type:"POST",
		url:"/index.php?m=Home&c=ajax&a=delbbsfile",
		dataType:"json",
		success:function(result){
			if(result.error == 0){
				$(obj).parent().remove();
			}else{
				showtip(result.message);
			}
		}
	});
}
