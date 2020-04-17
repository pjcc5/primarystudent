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
<meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- css -->
<link href="/myprimarysystem/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="/myprimarysystem/css/style.css" type="text/css" media="all" />
<link href="/myprimarysystem/css/font-awesome.css" rel="stylesheet">		<!-- font-awesome icons -->
<style>
	input[type="text"]{
		padding:0px;
		margin:0px;
		border-width:0px;
		background: rgba(100,20,11,0.1);
		
	}
</style>
<!--// css -->
<!-- font -->
<link href="http://fonts.googleapis.com/css?family=Montserrat+Alternates:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Libre+Franklin:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
<!-- //font -->
<script src="/myprimarysystem/js/jquery-3.4.1.min.js"></script>
<script src="/myprimarysystem/js/bootstrap.js"></script>
	
	<!-- start-smooth-scrolling -->
			<script type="text/javascript" src="/myprimarysystem/js/move-top.js"></script>
			<script type="text/javascript" src="/myprimarysystem/js/easing.js"></script>
	<script type="text/javascript">
	//刷新验证码方法
	 function flush(obj) {
			obj.src = "/myprimarysystem/validate/getcode.do?id="+new Date().getTime();
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
				 <ul class="agile_forms" style="margin-right:80px;">
					<c:if test="${not empty acount }">
					<li style="font-size:15px;color:white;">你好:　</li>
					<li>
						<div class="dropdown" style="margin-right:10px;">
							  <button class="btn btn-success " type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							    ${acount.aname }
							  </button>
							  <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
							    <a class="dropdown-item" href="javascript:;">个人信息</a>
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
							<div style="width:200px;height:50px;text-align: center;margin:0 auto; margin-right:150px;color:#1ed88b;font-size:25px;float:left;" >个　人　中　心</div>
						</ul>
					</nav>

				</div>
			</nav>	
			
	<div class="clearfix"> </div> 
</div> 

													<div class="container"  >
														<nav navbar navbar-center>
															<p>
															  <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
															   个人信息查看和修改
															  </button>
															</p>	
														</nav>	
													</div>
													
													<div class="container">
														<div style="width:100%;height:50px;">
															
														</div>
													</div>
													
												<div class="collapse" id="collapseExample">
													<div class="container"  >
													<div class="row">
														<!-- 显示头像 -->
														<div style="width:100px;height:100px; margin:0 auto;border-radius:50% !important;  overflow: hidden;">
															<img src="${acount.aphoto }" id="img"  onclick="document.getElementById('photo').click()"  style="width:100%;height:100%;"  />
														</div>	
													</div>
													  <div class="div-left">
													  <!-- 信息查看表 -->
														<table class="table table-hover">
																<tr>
																	<th colspan="2" style="text-align: center;" >个人信息查看</th>
																</tr>
																<tr>
																	<td>用户名</td>
																	<td>${acount.aname }</td>
																</tr>
																<tr>
																	<td>手机号</td>
																	<td>${acount.aphone }</td>
																</tr>
																<tr>
																	<td>邮箱</td>
																	<td>${acount.amail }</td>
																</tr>
																<tr>
																	<td>性别</td>
																	<td>
																		<c:if test="${empty acount.asex }">
																			未设置
																		</c:if>
																		<c:if test="${not empty acount.asex }">
																			${acount.asex }
																		</c:if>
																	</td>
																</tr>
																<tr>
																	<td>个人简介</td>
																	<td>${acount.acontent }</td>
																</tr>
															</table>
													  </div>
													<div class="div-right">
													  <form id="usereditform" method="post"  enctype="multipart/form-data" action="/myprimarysystem/acount/edituser.do">
													  <!-- 上传图片表单 -->
													 	<input  type="file" id="photo" name="file" style="display:none;"  onchange="showphoto()"/>	
														<input type="hidden" value="${acount.aid }" name="aid"/>
														<!-- 信息修改表 -->
														<table class="table table-hover">
																<tr>
																	<th colspan="2" style="text-align: left;" >个人信息修改</th>
																</tr>
																<tr>
																	<td><input id="uname" type="text" placeholder="修改用户名"  name="aname" required="" value="${acount.aname }"/></td>
																</tr>
																<tr>
																	<td><input id="uphone" type="text"  placeholder="修改手机号" name="aphone" required="" value="${acount.aphone }" /> </td>
																</tr>
																<tr>
																
																</tr>
																<tr>
																	<td><input id="uemail" type="text" name="amail" placeholder="修改邮箱" required="" value="${acount.amail }"></td>
																</tr>
																<tr>
																	<td>
																		<c:if test="${empty acount.asex }">
																			男<input type="radio" name="asex"  value="男"/>
																			女<input type="radio" name="asex"  value="女"/>
																		</c:if>
																		<c:if test="${acount.asex == '男' }">
																			男<input type="radio" name="asex" checked="checked"  value="男"/>
																			女<input type="radio" name="asex" value="女"/>
																		</c:if>
																		<c:if test="${acount.asex == '女' }">
																			男<input type="radio" name="asex"  value="男"/>
																			女<input type="radio" name="asex" checked="checked"  value="女"/>
																		</c:if>
																	</td>
																</tr>
																<tr>
																	<td><input id="ucontent" type="text" name="acontent" placeholder="修改简介" required="" value="${acount.acontent }"></td>
																</tr>
															</table>
															
													  </form>
													</div>
													<input  type="button" style="margin-left:49%" class="btn btn-success" onclick="edituser()" value="确认修改"/>
												</div>
												</div>
												
												
												
												
												
												
												
												<div class="container">
													<div style="width:100%;height:300px;"></div>
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

	<!-- 万能弹出框 -->
	
<div class="modal fade" id="delcfmModel">
    <div class="modal-dialog">
        <div class="modal-content message_align">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">×</span></button>
                <h4 class="modal-title">确认信息</h4>
            </div>
            <div class="modal-body">
                <p id="delcfmMsg">您确认修改吗？</p>
            </div>
            <div class="modal-footer">
                <input type="hidden" id="submitUrl"/>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <a id="commit" style="display:none;" class="btn btn-success" data-dismiss="modal" >确定</a>
                <button calss="btn btn-success" style="color: #333; background-color: #26b278;border-color: #8c8c8c;display: inline-block;padding: 6px 12px;  margin-bottom: 0;font-size: 14px; font-weight: normal;line-height: 1.42857143;text-align: center;white-space: nowrap;vertical-align: middle;-ms-touch-action: manipulation; touch-action: manipulation;cursor: pointer; -webkit-user-select: none;-moz-user-select: none;-ms-user-select: none; user-select: none; background-image: none;border: 1px solid transparent;border-radius: 4px;" onclick="yes()" >确认</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
	

<!-- footer -->
			<div class="copy-right">
				<!-- <p>Copyright &copy; 2017.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p> -->
			</div>
			
<!-- //footer -->
			<!--  countdown-js -->  
	<script type="text/javascript" src=" /myprimarysystem/js/moment.js"></script>
	<script type="text/javascript" src=" /myprimarysystem/js/moment-timezone-with-data.js"></script>
	<script type="text/javascript" src="/myprimarysystem/js/timer.js"></script>
	<!-- //countdown-js -->   
									
	<!--light-box-files -->
<script src="/myprimarysystem/js/jquery.chocolat.js"></script>
<link rel="stylesheet" href="/myprimarysystem/css/chocolat.css" type="text/css" media="screen">
<!--//light-box-files -->
		<script type="text/javascript">
		$(function() {
			$('.gallery a').Chocolat();
		});
		</script>
<!-- //js -->
<script type="text/javascript" src="/myprimarysystem/js/numscroller-1.0.js"></script>
<script src="/myprimarysystem/js/particles.js"></script>

<!-- text-effect -->
		<script type="text/javascript" src="/myprimarysystem/js/jquery.transit.js"></script> 
		<script type="text/javascript" src="/myprimarysystem/js/jquery.textFx.js"></script> 
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
<script src="/myprimarysystem/js/SmoothScroll.min.js"></script>
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
		$('#collapseExample').collapse('show');
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
	</script>
	<a href="#home" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!-- //smooth scrolling -->
	
	
	
	
</body>
</html>
