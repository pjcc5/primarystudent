function regist(){
			var reg_name = /^[\u4e00-\u9fa5a-zA-Z0-9_-]{3,20}$/;
			var reg_phone = /^1[3-5678]\d{9}$/;
			var reg_password =/(?!.*\s)(?!^[\u4e00-\u9fa5]+$)(?!^[0-9]+$)(?!^[A-z]+$)(?!^[^A-z0-9]+$)^.{6,20}$/ ;
			var reg_email = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
			var message = "";
			
			if(!reg_name.test($("#name").val()))
			{
				showMessage("请输入正确的用户名");
				return;
			}
			if(!reg_password.test($("#pass").val()))
			{
				showMessage("密码格式不对");
				return ;
			}
			if(!($("#pass").val() == $("#repass").val()))
			{
				showMessage("两次密码输入不一致");
				return ;
			}
			if(!reg_phone.test($("#phone").val()))
			{
				showMessage("手机格式不对");
				return ;
			}
			if(!reg_email.test($("#email").val()))
			{
				showMessage("邮箱格式不对");
				return ;
			}
			
			//向后台提交数据进行注册
			  $.ajax({
                url:"acount/uregist.do",
                type:"post",
                data:$("#registform").serialize(),
                success:function (result) {
                	console.log(result);
                    if(result.flag == true){
                    	$("#registclose").click();
                    	showMessage(result.message);
                    	setTimeout(function () { 
                    		
                    	}, 2000);
                    }
                    else
                    	{
                    	showMessage(result.message);
                    	}
                },
                error:function () {
                    alert("错误！")
                }
            })
			
            $('#registform')[0].reset();
		}
		
		//登录按钮方法
		function login(){
			console.log("ss");
			var log_name = /^[\u4e00-\u9fa5a-zA-Z0-9_-]{3,20}$/;
			var log_password =/(?!.*\s)(?!^[\u4e00-\u9fa5]+$)(?!^[0-9]+$)(?!^[A-z]+$)(?!^[^A-z0-9]+$)^.{6,20}$/ ;
			if(!log_name.test($("#logname").val()))
			{
				showMessage("请输入正确的用户名");
					return false;
			}
			if(!log_password.test($("#logpass").val()))
			{
				showMessage("密码格式不对");
				return false;
			}
			//向后台提交数据进行登录
			  $.ajax({
              url:"acount/ulogin.do",
              type:"post",
              data:$("#loginform").serialize(),
              success:function (result) {
              	if(result.flag == true) 
              		{
              			$("#loginclose").click();
              			showMessage(result.message);
						setTimeout(function () { 
							location.replace(location.href);
							//document.referrer前一个页面地址
                    	}, 1500);
              		}else{
              			showMessage(result.message);
              			return false;
              		}
              	
              },
              error:function () {
                  showMessage("错误！");
              }
              
              
          })
			
			$('#loginform')[0].reset();
			return false;
		}

		function showMessage(message)
		{
			$("#show").stop(true, true);
			var show=$("#show").html(message).fadeIn(700);
			
			$("#show").fadeOut(2700);
			
		}
		
		//注销的方法
		function quit(){
			//向后台提交数据进行注销
			  $.ajax({
            url:"/myprimarysystem/acount/quit.do",
            type:"post",
            success:function (result) {
            	console.log(result);
            	showMessage(result.message);
            	setTimeout(function () { 
					location.replace(location.href);
            	}, 1500);
            },
            error:function () {
                showMessage("错误！");
            }
		})
        
		}
		
		//图片预览方法
		function showphoto(){
				var obj = document.getElementById("photo");
					var fr = new FileReader();
					var f = obj.files[0];
					fr.readAsDataURL(f);
					fr.onload = function(e){
						content = e.target.result;
						var filemin = 0;
						var filemax = 1024*10;//限定为10m
						var filesize  = f.size/1024;
						document.getElementById("img").src=content;
						if(filesize > filemax )
							{
								alert("文件过大<0-10M>");
								$("#submit").attr("disabled","disabled");
							}
					}
				}		
		
		//修改用户
		
		function edituser(){
			 $('#delcfmModel').modal();
			 
		}
		//点击确认修改
		function yes(){
			$("#commit").click();
			//检测输入是否合格
			var reg_name = /^[\u4e00-\u9fa5a-zA-Z0-9_-]{3,20}$/;
			var reg_phone = /^1[3-5678]\d{9}$/;
			var reg_password =/(?!.*\s)(?!^[\u4e00-\u9fa5]+$)(?!^[0-9]+$)(?!^[A-z]+$)(?!^[^A-z0-9]+$)^.{6,20}$/ ;
			var reg_email = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
			var message = "";
			
			if(!reg_name.test($("#uname").val()))
			{
				showMessage("请输入正确的用户名");
				return;
			}
			if(!reg_phone.test($("#uphone").val()))
			{
				showMessage("手机格式不对");
				return ;
			}
			if(!reg_email.test($("#uemail").val()))
			{
				showMessage("邮箱格式不对");
				return ;
			}
			
			$("#usereditform").submit();
		}
		
		//申请老师的方法
		function doteacher(){
			//检查合法性
			var reg_idnumber = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/; 
			var reg_realname = /^[\u4e00-\u9fa5]{2,4}$/;  
			
			if(!reg_realname.test($("#atruename").val()))
				{
				showMessage("请填写正确姓名");
				return ;
				}
			if(!reg_idnumber.test($("#aidcardnumber").val()))
			{
				showMessage("请填写正确身份证号");
				return ;
			}
			 $.ajax({
		            url:"/myprimarysystem/acount/doteacher.do",
		            type:"post",
		            data:$("#teacherform").serialize(),
		            success:function (result) {
		            	console.log(result);
		            	showMessage(result.message);
		            	setTimeout(function () { 
							location.replace(location.href);
		            	}, 1500);
		            },
		            error:function () {
		                showMessage("错误！");
		            }
				})
			
		}