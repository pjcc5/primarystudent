<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!DOCTYPE html>
<html lang="cn">
<head>
<title>国马教育</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- css -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<link href="css/font-awesome.css" rel="stylesheet">		<!-- font-awesome icons -->
<style type="text/css">
		
		body>img{
			animation:haha1 2s linear infinite;
		}
		@-webkit-keyframes haha1{ from{transform:rotate(0)} to{transform:rotate(360deg)} 
				
	</style>
<!-- //font -->

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>

	
	<!-- start-smooth-scrolling -->
			<script type="text/javascript" src="js/move-top.js"></script>
			<script type="text/javascript" src="js/easing.js"></script>
			<!--
				<script type="text/javascript">
					jQuery(document).ready(function($) {
						$(".scroll").click(function(event){		
						event.preventDefault();
						$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
					});
				});
				</script>
			-->
	<!-- //start-smoth-scrolling -->
		<!-- here stars scrolling icon -->
	<script type="text/javascript">
	//刷新验证码方法
	 function flush(obj) {
			obj.src = "validate/getcode.do?id="+new Date().getTime();
		}
		$(document).ready(function() {
								
			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
	</script>
</head>
<body>
<div id="show" >
	登录成功
</div>
<div class="w3-banner-edu">
	
   <div class="agileits_w3layouts_banner_nav">
			<nav class="navbar navbar-default">
				<div class="navbar-header navbar-left">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
				<h1><a class="navbar-brand" href="index.jsp"><i class="glyphicon glyphicon-knight" aria-hidden="true"></i><span>国马教育</span></a></h1>

				</div>
				 <ul class="agile_forms" style="margin-right:80px;margin-top: 0px;">
					<c:if test="${not empty acount }">
					<li style="font-size:15px;color:white;">你好:　</li>
					<li >
						<div style="width:40px;height:40px;border:1px solid red;border-radius:50%;overflow:hidden;position:relative;top:15px;">
								<img src="${acount.aphoto }" style="width:100%;height:100%;" />
						</div>
					</li>
					<li>
						<div class="dropdown" style="margin-right:10px;">
							  <button class="btn btn-success " type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							    ${acount.aname }
							  </button>
							  <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
							    <a class="dropdown-item" href="/myprimarysystem/needlogin/userinfo.jsp">个人信息</a>
							    <a  class="dropdown-item" href="#" data-toggle="modal" data-target="#myModal4" >修改密码</a>
							    <a class="dropdown-item" href="javascript:;" onclick="quit()">退出登录</a>
							  </div>
							 <!--  <img src="images/userdefault.jpg" style="width:20px;height:20px;" /> -->
						</div>
						</li>
						<c:if test="${acount.arole == 0}">
							<li style="font-size:15px;color:white;">同学</li>
						</c:if>
						<c:if test="${acount.arole == 1}">
							<li style="font-size:15px;color:white;">老师</li>
						</c:if>
						
					
					</c:if>
					<c:if test="${ empty acount }">
					<li><a class="active" href="#" data-toggle="modal" data-target="#myModal2" ><i class="fa fa-sign-in" aria-hidden="true"></i> 登录</a> </li>
					<li><a href="#" data-toggle="modal" data-target="#myModal3" ><i class="fa fa-pencil-square-o" aria-hidden="true"></i>注册</a> </li>
					</c:if>
				</ul>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
					<nav>
						<ul class="nav navbar-nav">
							<li class="active"><a href="index.jsp" class="hvr-underline-from-center">主页</a></li>
							<li><a href="/myprimarysystem/needlogin/examindex.jsp" class="hvr-underline-from-center" >考试中心</a></li>
							<li><a href="/myprimarysystem/needlogin/sourceindex.jsp"  class="hvr-underline-from-center">资源中心</a></li>
							<li><a href="http://www.4399.com" class="hvr-underline-from-center">娱乐中心</a></li>
							<c:if test="${acount.arole == 3 }">
								<li><a href="/myprimarysystem/needlogin/adminindex.jsp" class="hvr-underline-from-center" >系统管理</a></li>
							</c:if>		
													
						</ul>
					</nav>

				</div>
			</nav>	
			
	<div class="clearfix"> </div> 
</div> 
<!-- Modal1 -->
		<div class="modal fade" id="myModal2" tabindex="-1" role="dialog">
				<div class="modal-dialog">
				<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" id="loginclose" data-dismiss="modal">&times;</button>
							
							<div class="signin-form profile">
							<h3 class="agileinfo_sign">登录</h3>	
									<div class="login-form">
										<form action="#" id="loginform" method="post" onsubmit="return login()">
											<input type="text" id="logname" name="aname" placeholder="用户名" required="">
											<input type="password" id="logpass" name="apass" placeholder="密码" required="">
											
											<div class="tp">
												<input type="submit" value="登录" >
											</div>
										</form>
									</div>
									<p><a onclick="showfindpasspanel()">忘记密码?</a></p>
								</div>
						</div>
					</div>
				</div>
			</div>
			<!-- //Modal1 -->	
	<!-- Modal2 -->
	<div class="modal fade" id="myModal3" tabindex="-1" role="dialog">
		<div class="modal-dialog">
		<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" id="registclose" data-dismiss="modal">&times;</button>
					
					<div class="signin-form profile">
					<h3 class="agileinfo_sign">注册</h3>	
							<div class="login-form">
								<form action="#" method="post" id="registform">
								   	<input id="name" type="text" name="aname" placeholder="用户名(3-20位数字,字母和有效字符组成)" required="">
									<input id="pass" type="password" name="apass" placeholder="密码(6-20位不能为纯数字和字母以及特殊字符)" required="">
									<input id="repass" type="password"  placeholder="确认密码" required="" >
									<input id="phone" type="text" name="aphone" placeholder="手机号" required="">
									<input id="email" type="text" name="amail" placeholder="邮箱(用于找回密码)" required="">
									<input id="valicode" type="text" name="valicode" placeholder="验证码" required="">
									<img src="validate/getcode.do" style=" width: 100px;height: 40px;border-radius:0%;	"onclick="flush(this)">
									<input type="button" value="注册" onclick="regist()" >
									
								</form>
							</div>
							<p><a href="#">没有努力,哪儿来的利益?</a></p>
						</div>
				</div>
			</div>
		</div>
	</div>
	<!-- //Modal2 -->	

	<!-- Modal3 修改密码-->
		<div class="modal fade" id="myModal4" tabindex="-1" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" id="registclose" data-dismiss="modal">&times;</button>
						
						<div class="signin-form profile">
						<h3 class="agileinfo_sign">修改密码</h3>	
								<div class="login-form">
									<form action="#" method="post" id="registform">
									   	<input id="oldpass" type="password"  name="oldpass" placeholder="原密码" required="">
										<input id="newpass" type="password" name="newpass" placeholder="新密码(6-20位不能为纯数字和字母以及特殊字符)" required="">
										<input id="re_newpass" type="password"  placeholder="确认密码" required="" >
										<input type="button" value="修改" onclick="editpass()" >
									</form>
								</div>
								<p><a href="#">没有努力,哪儿来的利益?</a></p>
							</div>
					</div>
				</div>
			</div>
		</div>
		<!-- //Modal3 -->		
		
	<!-- Modal5 找回密码-->
		<div class="modal fade" id="myModal5" tabindex="-1" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" id="registclose" data-dismiss="modal">&times;</button>
						
						<div class="signin-form profile">
						<h3 class="agileinfo_sign">找回密码</h3>	
								<div class="findpass_form">
									<form action="#" method="post" id="findpassform">
									   	<input id="findpassuname" type="text"  name="findpassuname" placeholder="请输入账户名" required="">
										<input id="findpassemail" type="text" name="findpassemail" placeholder="请输入账户邮箱" required="">
										<input id="findpassvalicode" type="text"  placeholder="请输入邮箱验证码" required="" >
										<button class="btn btn-success" id="code"  type="button" onclick="getcode()">获取验证码</button>
										<br/>
										<br/>
										<button  type="button" class="btn btn-primary" onclick="findpasss()" >找回</button>
									</form>
								</div>
								<p><a href="#">没有努力,哪儿来的利益?</a></p>
							</div>
					</div>
				</div>
			</div>
		</div>
		<!-- //Modal5 -->		
						
						
		<!-- Modal6 找回密码后修改-->
		<div class="modal fade" id="myModal6" tabindex="-1" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" id="registclose" data-dismiss="modal">&times;</button>
						
						<div class="signin-form profile">
						<h3 class="agileinfo_sign">修改密码</h3>	
								<div class="findpass_form">
									<form action="#" method="post" id="findpassform">
									   	<input id="passs" type="password"  name="passs" placeholder="请输入新密码" required="">
										<input id="repasss" type="password" name="repasss" placeholder="请重复新密码" required="">
										<button  type="button" class="btn btn-primary" onclick="editpasss()" >修改</button>
									</form>
								</div>
								<p><a href="#">没有努力,哪儿来的利益?</a></p>
							</div>
					</div>
				</div>
			</div>
		</div>
		<!-- //Modal5 -->				
																
	<div class="banner">
		<h3>免费的小学生辅导网站</h3>
		<h2 class="test"><span>欢迎您的到来 </span>让我们一起加油</h2>
		<p>一切都是为了学习</p>
		
		
	</div>
</div>

	<!-- map  -->
	<!---<div class="w3-agile-map1">
<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2481.2508055091607!2d-0.07901828417095903!3d51.54529987964132!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x48761c91f36ba6cb%3A0xa3353c086b61a5e4!2s14+Tottenham+Rd%2C+London+N1+4EP%2C+UK!5e0!3m2!1sen!2sin!4v1484802856551" ></iframe>
</div>--->
<!-- map -->
<!-- coureses online -->	
	<!-- footer-top -->	
	<div class="footer-top">
		<div class="container">
		<div class="w3-edu-footer-grids foot-left1">
			<div class="col-md-4 foot-left">
				<h3>About Us</h3>
			
				<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard.</p>
			</div>
			<div class="col-md-4 foot-left">
					<h3>Get In Touch</h3>
					<p>Lorem Ipsum is simply dummy text of the printing and typesetting.</p>
				
						<div class="contact-btm">
							<i class="fa fa-map-marker" aria-hidden="true"></i> 
							<p>90 Street, City, State 34789.</p>
							
							
						</div>
						<div class="contact-btm">
							<i class="fa fa-phone" aria-hidden="true"></i>
							<p>+456 123 7890</p>
						<div class="contact-btm">
						</div>
							<span class="fa fa-envelope-o" aria-hidden="true"></span>
							<p><a href="mailto:example@email.com">info@example.com</a></p>
						</div>
						<div class="clearfix"></div>

			</div>
			<div class="col-md-4 foot-left">
			<h3>Subscribe</h3>
			<p>Lorem Ipsum is simply dummy text of the printing and Lorem Ipsum has </p>
			<form action="#" method="post">	
					<input type="email" Name="Enter Your Email" placeholder="Enter Your Email" required="">
				<input type="submit" value="Subscribe">
			</form>
			</div>
				<div class="clearfix"></div>
		</div>

		</div>
	</div>
<!-- /footer-top -->							

<!-- footer -->
			<div class="copy-right">
				<!-- <p>Copyright &copy; 2017.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p> -->
			</div>
			
<!-- //footer -->
			<!--  countdown-js -->  
	<script type="text/javascript" src=" js/moment.js"></script>
	<script type="text/javascript" src=" js/moment-timezone-with-data.js"></script>
	<script type="text/javascript" src="js/timer.js"></script>
	<!-- //countdown-js -->   
									
	<!--light-box-files -->
<script src="js/jquery.chocolat.js"></script>
<link rel="stylesheet" href="css/chocolat.css" type="text/css" media="screen">
<!--//light-box-files -->
		<script type="text/javascript">
		$(function() {
			$('.gallery a').Chocolat();
		});
		</script>
<!-- //js -->
<script type="text/javascript" src="js/numscroller-1.0.js"></script>
<script src="js/particles.js"></script>

<!-- text-effect -->
		<script type="text/javascript" src="js/jquery.transit.js"></script> 
		<script type="text/javascript" src="js/jquery.textFx.js"></script> 
		<script type="text/javascript">
			$(document).ready(function() {
					$('.test').textFx({
						type: 'fadeIn',
						iChar: 100,
						iAnim: 1000
					});
			});
		</script>
<!-- //text-effect -->
<script src="js/SmoothScroll.min.js"></script>
	<script type="text/javascript">
		/* init Jarallax */
		$('.jarallax').jarallax({
			speed: 0.5,
			imgWidth: 1366,
			imgHeight: 768
		})
	</script>
<script type="text/javascript">
					jQuery(document).ready(function($) {
						$(".scroll").click(function(event){		
							event.preventDefault();
							$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
						});
					});
				</script>

<!-- smooth scrolling -->
	<script type="text/javascript">
		$(document).ready(function() {
		/*
			var defaults = {
			containerID: 'toTop', // fading element id
			containerHoverID: 'toTopHover', // fading element hover id
			scrollSpeed: 1200,
			easingType: 'linear' 
			};
		*/								
		$().UItoTop({ easingType: 'easeOutQuart' });
		});
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
		function editpass()
		{
			var reg_password =/(?!.*\s)(?!^[\u4e00-\u9fa5]+$)(?!^[0-9]+$)(?!^[A-z]+$)(?!^[^A-z0-9]+$)^.{6,20}$/ ;
			var oldpass = $("#oldpass").val();
			var newpass = $("#newpass").val();
			var re_newpass = $("#re_newpass").val();
			
			if(oldpass == undefined ||oldpass == null ||oldpass.trim() =="" )			
				{
				showMessage("原密码不能为空");
				return ;
				}
			if(newpass == undefined ||newpass == null ||newpass.trim() =="" )			
				{
				showMessage("新密码不能为空");
				return ;
				}
			if(re_newpass == undefined ||re_newpass == null ||re_newpass.trim() =="" )			
				{
				showMessage("重复密码不能为空");
				return ;
				}
			
			if(!($("#newpass").val() == $("#re_newpass").val()))
				{
					showMessage("两次密码不一致");
					return;
				}
			if(!reg_password.test($("#oldpass").val())||!reg_password.test($("#newpass").val())||!reg_password.test($("#re_newpass").val()))
			{
				showMessage("密码格式不对");
				return ;
			}
			  $.ajax({
		            url:"/myprimarysystem/acount/modifypass.do",
		            type:"post",
		            data:{"oldpass":oldpass,"newpass":newpass},
		            success:function (result) {
		            	showMessage(result.message);
		            	
		            	setTimeout(function () { 
		            		if(result.flag ==true)
		            		{
		            			quit();
		            		}
							location.replace(location.href);
		            	}, 1500);
		            },
		            error:function () {
		                showMessage("错误！");
		            }
				})
			
		}
		
		function showfindpasspanel()
		{
			$("#myModal2").modal('hide');
			$("#myModal5").modal('show');
			
		}
		
		function getcode(){
			var findpassuname = $("#findpassuname").val();
			var findpassemail = $("#findpassemail").val();
			
			if(findpassuname == undefined ||findpassuname == null ||findpassuname.trim() =="" )			
			{
				showMessage("用户名不能为空");
				return ;
			}
			if(findpassemail == undefined ||findpassemail == null ||findpassemail.trim() =="" )			
			{
				showMessage("邮箱不能为空");
				return ;
			}
			
			$.ajax({
	            url:"/myprimarysystem/acount/findpassgetcode.do",
	            type:"post",
	            data:{"findpassuname":findpassuname,"findpassemail":findpassemail},
	            success:function (result) {
	            	showMessage(result.message);
	            	if(result.flag == true)
	            		{	
	            			
		            		$("#code").attr({"disabled":"disabled"});
		            		var time = 60;
		            		var interval=setInterval(function () { 
		            			time = time -1;
		            			$("#code").html(time+"秒后重试");
		            			if(time == 4)
		            				{
			            				$("#code").html("取验证码");
			            				$("#code").removeAttr("disabled");
			            				clearInterval(interval);
		            				}
		                	}, 1000);
		        			
	            		}
	            	
	            },
	            
			})
		}
		//findpasss方法提交验证码
		function findpasss()
		{
			var code = $("#findpassvalicode").val();
			var aname = $("#findpassuname").val();
			var amail = $("#findpassemail").val();
			if(aname == undefined ||aname == null ||aname.trim() =="" )			
			{
				showMessage("用户名不能为空");
				return ;
			}
			if(amail == undefined ||amail == null ||amail.trim() =="" )			
			{
				showMessage("邮箱不能为空");
				return ;
			}
			
			if(code == undefined ||code == null ||code.trim() =="")			
			{
				showMessage("验证码不能为空");
				return ;
			}
			if( code.length != 4)			
			{
				showMessage("验证码格式不正确");
				return ;
			}
			$.ajax({
	            url:"/myprimarysystem/acount/validatethecode.do",
	            type:"post",
	            data:{"aname":aname,"amail":amail,"code":code},
	            success:function (result) {
	            	showMessage(result.message);
	            	if(result.flag == true)
	            	{
	            		//说明验证马正确
	            		$("#myModal5").modal('hide');
	        			$("#myModal6").modal('show');
	            	}
	            	
	            },
	            error:function () {
	                showMessage("错误！");
	            }
			})
			
			
		}
		
		
		function editpasss()
		{
			var passs = $("#passs").val();
			var repasss = $("#repasss").val();
			var log_password =/(?!.*\s)(?!^[\u4e00-\u9fa5]+$)(?!^[0-9]+$)(?!^[A-z]+$)(?!^[^A-z0-9]+$)^.{6,20}$/ ;
			var findpassuname = $("#findpassuname").val();
			var findpassemail = $("#findpassemail").val();
			
			if(passs == null || passs == "")
				{
				showMessage("密码不能为空");
				return ;
				}
			if(repasss == null || repasss == "")
				{
				showMessage("重复密码不能为空");
				return ;
				}
			if(!log_password.test(passs))
			{
				showMessage("密码格式不对");
				return ;
			}
			if(passs != repasss)
			{
				showMessage("两次密码不一致");
				return;
			}
			
			 $.ajax({
		            url:"/myprimarysystem/acount/editpasss.do",
		            type:"post",
		            data:{"aname":findpassuname,"amail":findpassemail,"pass":passs},
		            success:function (result) {
		            	showMessage(result.message);
		            	if(result.flag == true)
	            		{
	            		
		            		setTimeout(function () { 
		            			$("#myModal6").modal('hide');
			            	}, 1000);
	            		}
		            	
		            },
		            error:function () {
		                showMessage("错误！");
		            }
				})
			
			
			
			
		}
		
	</script>
	<a href="#home" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!-- //smooth scrolling -->
	
	
<script src="js/jquery.singlePageNav.min.js"></script>
	<script src="js/jquery-transform_2d.js"></script>
	<!-- 看板娘哦 -->
			<script src="https://eqcn.ajz.miesnfu.com/wp-content/plugins/wp-3d-pony/live2dw/lib/L2Dwidget.min.js"></script>
			$("#myModal5").modal('hide');
        		setTimeout(function () { 
        			$("#myModal6").modal('show');tion.replace(location.href);
            	}, 1000);
	            error:function () {
	                showMessage("错误！");
	            }
			  <script>
			      L2Dwidget.init({
			          "model": {
			              jsonPath: "https://unpkg.com/live2d-widget-model-hijiki/assets/hijiki.model.json",<!--这里改模型，前面后面都要改-->
			              "scale": 1
			          },
			          "display": {
			              "position": "left",<!--设置看板娘的上下左右位置-->
			              "width": 100,
			              "height": 200,
			              "hOffset": 30,
			              "vOffset": 0
			          },
			          "mobile": {
			              "show": true,
			              "scale": 0.5
			          },
			          "react": {
			              "opacityDefault": 0.7,<!--设置透明度-->
			              "opacityOnHover": 0.2
			          }
			      });
			  window.onload = function(){
			       $("#live2dcanvas").attr("style","position: fixed; opacity: 0.7; left: 20px; bottom: 0px; z-index: 1; pointer-events: none;")
			  }
			  
			  var arr=new Array();
			  	arr[0]="/myprimarysystem/images/雪花1.png";
				arr[1]="/myprimarysystem/images/雪花2.png";
				arr[2]="/myprimarysystem/images/雪花3.png";
				arr[3]="/myprimarysystem/images/雪花4.png";
				$(function(){//启动雪花
					setInterval(function(){
						  new SnowFlower();
						}, 1000);
				})
				
			  //雪花
function SnowFlower(){
 		
 		this.oflower=null;
 		this.windowH = document.documentElement.clientHeight;
 		this.windowW = document.documentElement.clientWidth;
 		this.top = -100;
 		this.left=parseInt(Math.random() * (this.windowW-500));
 		this.timer =null;
 		this.step=10;
 		this.init = function(){
 		      //创建元素添加到页面
 		      this.oflower = document.createElement('img');
 		     
 		      this.oflower.className = 'flower';
 		      //设置左右随机位置
 		     this.oflower.style.position="fixed";
 		      this.oflower.style.left = this.left + 'px';
// 		      this.oflower.style.top = this.top+"px";
 		     this.oflower.style.top = this.top+"px";
 		    this.oflower.style.width = 70+"px";
 		   this.oflower.style.height = 70+"px";
 		     this.oflower.src = arr[Math.floor(Math.random()*4)];
 		     $(this.oflower).animate({top:this.windowH+'px',left:this.left+this.windowH+"px"},10000);
 		     var that = this;
 		    $(this.oflower).mouseenter(function(){
 		    	
 		    	setTimeout(function(){
 		    		that.die();
 		    	},100);
 		    });
 		      //添加到页面
 		      document.body.appendChild(this.oflower);
 		    };
 		    
 		    this.go = function(){
 		    	var that = this;
 		    	
 		    	this.timer = setInterval(function(){
 		    		$(that).animate({top:that.windowH+'px',left:this.left+that.windowH+"px"},10000);
 		    		if(that.top > 800 )  
 		    			{
 		    				that.die();
 		    			}
 		    		if(that.left > 1000)
 		    			{
 		    			that.die();
 		    			}
 		    	},600)
 		    }
 		    
 		    this.die = function(){
 		    	clearInterval(this.timer);
 		    	document.body.removeChild(this.oflower);
 		    }
 		   //调用初始化方法
 		    this.init();
 		    //调用行走方法
 		    this.go();
 	}
			  
			  </script>
		<div id="live2d-widget"><canvas id="live2dcanvas" width="200" height="400" style="position: fixed; opacity: 0.7; left: 20px; bottom: 0px; z-index: 1; pointer-events: none;"></canvas></div>
		
</body>
</html>
