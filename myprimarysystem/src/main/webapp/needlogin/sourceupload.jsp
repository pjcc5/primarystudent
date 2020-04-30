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
<!-- //font -->
<script src="/myprimarysystem/js/jquery-3.4.1.min.js"></script>
<script src="/myprimarysystem/js/userinfo.js"></script>
<script src="/myprimarysystem/js/bootstrap.js"></script>
	
	<!-- start-smooth-scrolling -->
			<script type="text/javascript" src="/myprimarysystem/js/move-top.js"></script>
			<script type="text/javascript" src="/myprimarysystem/js/easing.js"></script>
			<script type="text/javascript" src="/myprimarysystem/js/examindex.js"></script>
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
				<h1><a class="navbar-brand" href="/myprimarysystem/"><i class="glyphicon glyphicon-knight" aria-hidden="true"></i><span>国马教育</span></a></h1>

				</div>
				 <ul class="agile_forms" style="margin-right:80px;    margin-top: 0px;">
					<c:if test="${not empty acount }">
					<li style="font-size:15px;color:white;">你好:　</li>
					<li >
						<div style="width:45px;height:45px;border:1px solid red;border-radius:50%;overflow:hidden;position:relative;top:20px;">
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
						<button class="btn btn-success " type="button" style="margin-left:10px;" onclick="history.go(-1)">
							   		 返回
							    </button>
					
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
							<div style="width:200px;height:50px;text-align: center;margin:0 auto; margin-right:150px;color:#1ed88b;font-size:25px;float:left;" >资　源　中　心</div>
						</ul>
					</nav>

				</div>
			</nav>	
			
	<div class="clearfix"> </div> 
</div> 
	<div class="container" style="height:20px"></div>
	<!-- 装入搜索框 -->
	<div class="container">
		<div class="col-lg-8 col-lg-offset-2">
		<form method="post" id="sourceform" enctype="multipart/form-data" action="/myprimarysystem/source/savesource.do">
			<table class="table table-hover">
				<tr>
					<td>资源名称</td>
						<td><input type="text" id="sname" name="sname" required="" placeholder="请输入资源名称" style="width:100%;"/></td>
				</tr>
				<tr>
					<td>资源类型</td>
					<td>
						<select class="form-control" name="stype" id="filetype">
						  <option value="1">mp4视频</option>
						  <option value="2">doc文档</option>
						  <option value="3">txt文本</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>资源发布人</td>
						<td><input type="text" id="spublisher" name="spublisher" required="" value="${acount.aname }" placeholder="请输入资源发布人" style="width:100%;"/></td>
				</tr>
				
				<tr>
					<td>资源备注</td>
					<td><textarea id="remark"  name="remark" style="width:100%;height:100px;resize:none;overflow-x:visible;"></textarea></td>
				</tr>
				<tr>
					<td>资源文件</td>
					<td><input type="file" id="file" name="file" required=""  style="width:100%;"/></td>
				</tr>
				
			</table>
			<div class="col-lg-2 col-lg-offset-5">
				<a href="javascript:;" class="btn btn-success" style="width:100%" onclick="uploadsource(this)">
					上传
				</a>
			</div>
		</form>
		</div>
	</div>
		
		
	
	<!-- 装入搜索结果 -->
	<div class="container">
		<table class="table table-table-hover" id="table1" style="text-align:center;">
			
			
		</table>
	</div>
	
	<div class="container">
		<div style="width:100%;height:300px;"></div>
	</div>
	

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
		$().UItoTop({ easingType: 'easeOutQuart' });
		$('#collapseExample').collapse('show');
		console.log($("[data-toggle='collapse']"));
		$("[data-toggle='collapse']").each(function(index,ele){
			$(this).click(function(){
				var aaa = $(this).siblings();
				$(aaa).each(function(){$(this.click())});
				
			});
				
				
			});
		
		
		
		
		});
		
		function uploadsource(obj)
		{	
			if($("#sname").val() == null || $("#sname").val() == "")
				{
					showMessage("资源名称不能为空");
					return;
				}
			if($("#spublisher").val() == null || $("#spublisher").val() == "")
				{
					showMessage("发布人不能为空");
					return;
				}
			if($("#remark").html() == null || $("#remark").html() == "")
				{
					$("#remark").html("无");
				}
			console.log($("#remark").html());
			
			var file = document.getElementById("file");
			//获得后缀名
			var str=$(file).val(); 
	        var index=str.lastIndexOf('.'); 
	        var strtype=str.substr(index,4); 
	        
	        var typenum = 0;
	        strtype=strtype.toLowerCase(); 
	        console.log("后缀名为:"+strtype);
	        if(strtype == ".mp4")
	        	{
	        		typenum = '1';
	        	}
	        if(strtype == ".doc")
        	{
        		typenum = '2';
        	}
			
	        if(strtype == ".txt")
        	{
        		typenum = '3';
        	}
			
	        var fr = new FileReader();
			var f = file.files[0];
			fr.readAsDataURL(f);
			fr.onload = function(e){
				content = e.target.result;
				var filemin = 0;
				var filemax = 1024*300;//限定为300m
				var filesize  = f.size/1024;
				if(filesize > filemax )
					{
						alert("文件过大<0-100M>");
						$("#submit").attr("disabled","disabled");
					}
				
				//判断类型
				//获得用户选中的类型
				var filetype=$("#filetype option:selected").val();
				console.log("选中的类型为"+filetype);
				
				if(filetype != typenum)
					{
						showMessage("上传的文件类型不符");
						return;
					}
				
				//都ok之后进行上传
				$("#sourceform").submit();
				
				
			}
			
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
	</script>
	<a href="#home" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!-- //smooth scrolling -->
	
	
	
	
</body>
</html>
