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
	#optiontable tr {
		height:60px;
	}
	#optiontable tr td{
		margin-top:10px;
	}
	.aaa{
	background:red;
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
				 <ul class="agile_forms" style="margin-right:80px;">
					<c:if test="${not empty acount }">
					<li style="font-size:15px;color:white;">你好:　</li>
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
				<div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
					<nav>
						<ul class="nav navbar-nav">
							<div style="width:200px;height:50px;text-align: center;margin:0 auto; margin-right:150px;color:#1ed88b;font-size:25px;float:left;" >考　试　结　果</div>
						</ul>
					</nav>

				</div>
			</nav>	
			
	<div class="clearfix"> </div> 
</div> 
	
	<div class="container">
			<div style="width:100%;"class="parentdiv">
					<!-- <div class="col-lg-2 col-lg-offset-2">
					</div>	
					 -->
					 <input type="hidden" id="annumber" value=""/>
			   <table class="table table-hover">
			   	<tr>
			   		<td>出题人:${exam.exregister}</td>
			   		<td>年级:${examdetail.exdgrade}</td>
			   		<td>学科:${examdetail.exdsubject}</td>
			   		<td>用时:<b style="font-family: '宋体';"><span class='usetime'></span></b></td>
			   		<td><span style="font-size:25px;color:green;text-decoration:underline;line-height:25px">总　分:　${score}分</span></td>
			   	</tr>
			   	
			   	
			   </table>
			   <c:forEach items="${questionresultdtos }" var="question" varStatus="i">
			   		<div >
			   			<h3><span id="index">${i.index+1 }.</span>${question.qcontent }
			   				<c:if test="${question.isright == true }">
			   					<span class="glyphicon glyphicon-ok" style="color:green;margin-left:30px;"></span>
			   				</c:if>
			   				<c:if test="${question.isright != true }">
			   					<span  class="glyphicon glyphicon-remove"  style="color:red;margin-left:30px;"></span><span style="color:green;margin-left:30px;">正确答案:${question.qrightanswer }</span><span style="color:red;margin-left:30px;">你的答案:${question.useranswer }</span>
			   				</c:if>
			   				
			   			</h3><br/>
			   			<div class="options" style="width:100%;">
			   				<table class=" table table-hover option optiontable" id="optiontable" qid="${question.qid }">
			   					<c:if test="${not empty question.qanswera  }">
			   						<tr class="answertr"><td onclick="selectthis(this)"><input type="radio"
			   						<c:if test="${ question.useranswer == 'A' }">
			   						 checked="checked"
			   						</c:if>
			   						 name="${i.index+1 }" value="A"/><b>A:　</b>${question.qanswera }</td></tr>
			   					</c:if>
			   					<c:if test="${not empty question.qanswerb  }">
			   					<tr class="answertr"><td onclick="selectthis(this)"><input type="radio"
			   						<c:if test="${ question.useranswer == 'B' }">
			   						 checked="checked"
			   						</c:if>
			   					 name="${i.index+1 }" value="B"/><b>B:　</b>${question.qanswerb }</td></tr>
			   					</c:if>
			   					<c:if test="${not empty question.qanswerc  }">
			   					<tr class="answertr"><td onclick="selectthis(this)"><input type="radio" 
			   						<c:if test="${ question.useranswer == 'C' }">
			   						 checked="checked"
			   						</c:if>
			   					name="${i.index+1 }" value="C"/><b>C:　</b>${question.qanswerc }</td></tr>
			   					</c:if>
			   					<c:if test="${not empty question.qanswerd  }">
			   					<tr class="answertr"><td onclick="selectthis(this)"><input type="radio"
			   						<c:if test="${ question.useranswer == 'D' }">
			   						 checked="checked"
			   						</c:if>
			   					 name="${i.index+1 }" value="D"/><b>D:　</b>${question.qanswerd }</td></tr>
			   					</c:if>
			   					
			   				</table>
			   			
			   			</div>
			   		</div>
			   	</c:forEach>
			   
			</div>
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
			$(".usetime").html(formatSeconds("${usetime}"));
		$().UItoTop({ easingType: 'easeOutQuart' });
				
			});
		 function getdate() {
			  　　var now = new Date(),
			  　　y = now.getFullYear(),
			  　　m = now.getMonth() + 1,
			  　　d = now.getDate();
			  　　return y + "-" + (m < 10 ? "0" + m : m) + "-" + (d < 10 ? "0" + d : d) + " " + now.toTimeString().substr(0, 8);
			  }
		//选中td就选中input
		function selectthis(obj)
		{
			$(obj).find("input [type=radio]");
			$(obj).parent().css("background","rgba(10,100,20,0.3)");
			$(obj).parent().siblings().each(function(index,element){
				$(element).find("td input").eq(0).removeAttr("checked");
				$(element).css('background','white');
				
			});
			$(obj).find("input").eq(0).attr("checked",'checked');
		}
			
		function formatDate(now) { 
		     var year=now.getFullYear(); 
		     var month=now.getMonth()+1; 
		     var date=now.getDate(); 
		     var hour=now.getHours(); 
		     var minute=now.getMinutes(); 
		     var second=now.getSeconds(); 
		     return year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second; 
		} 
			function formatSeconds(value) { //将秒转化成时间
				 var theTime = parseInt(value);// 需要转换的时间秒 
				 var theTime1 = 0;// 分 
				 var theTime2 = 0;// 小时 
				 var theTime3 = 0;// 天
				 if(theTime > 60) { 
				  theTime1 = parseInt(theTime/60); 
				  theTime = parseInt(theTime%60); 
				  if(theTime1 > 60) { 
				   theTime2 = parseInt(theTime1/60); 
				   theTime1 = parseInt(theTime1%60); 
				   if(theTime2 > 24){
				    //大于24小时
				    theTime3 = parseInt(theTime2/24);
				    theTime2 = parseInt(theTime2%24);
				   }
				  } 
				 } 
				 var result = '';
				 if(theTime > 0){
				  result = ""+parseInt(theTime)+"秒";
				 }
				 if(theTime1 > 0) { 
				  result = ""+parseInt(theTime1)+"分钟"+result; 
				 } 
				 if(theTime2 > 0) { 
				  result = ""+parseInt(theTime2)+"小时"+result; 
				 } 
				 return result; 
				}
			
			
			function calcscore(annumber)
			{	
				if(commit == false && annumber != "aaa" )
				{		
					console.log("执行算分了啊");
					console.log($("#annumber").val());
					$.ajax({
			            url:"/myprimarysystem/answer/calcscore.do",
			            type:"post",
			            data:{"annumber":annumber},
			            success:function (result) {
			            	showMessage(result.message);
			            	 console.log(result);
			            	
			            },
			            error:function () {
			                showMessage("错误！");
			            }
					});
				}
			}
	</script>
	<a href="#home" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!-- //smooth scrolling -->
	
	
	
	
</body>
</html>
