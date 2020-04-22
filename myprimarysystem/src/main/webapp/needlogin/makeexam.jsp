<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!DOCTYPE html>
<html lang="cn">
<head>
<title>套题生成</title>
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
	/*消除上下箭头*/
	input::-webkit-outer-spin-button,
	input::-webkit-inner-spin-button {
	    -webkit-appearance: none;
	}
	 
	input[type="number"] {
	    -moz-appearance: textfield;
	}
</style>
<!-- //font -->
<script src="/myprimarysystem/js/jquery-3.4.1.min.js"></script>
<script src="/myprimarysystem/js/userinfo.js"></script>
<script src="/myprimarysystem/js/showmysubject.js"></script>
<script src="/myprimarysystem/js/bootstrap.js"></script>
	
	<!-- start-smooth-scrolling -->
			<script type="text/javascript" src="/myprimarysystem/js/move-top.js"></script>
			<script type="text/javascript" src="/myprimarysystem/js/easing.js"></script>
	<script type="text/javascript">
	
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
							<div style="width:200px;height:50px;text-align: center;margin:0 auto; margin-right:150px;color:#1ed88b;font-size:25px;float:left;" >套　卷　生　成</div>
						</ul>
					</nav>

				</div>
			</nav>	
			
	<div class="clearfix"> </div> 
</div> 

<div class="collapse" id="collapse1">
<form id="form1">
	<div class="container" style="text-align: center;">
		<h3>选择试题年级</h3>
		<div class="col-lg-8 col-lg-offset-2">
			<select class="form-control" name="qgrade" id="qgrade" >
			  <option value="一年级上学期">一年级上学期</option>
			  <option value="一年级下学期">一年级下学期</option>
			  <option value="一年级下学期">二年级上学期</option>
			  <option value="二年级下学期">二年级下学期</option>
			  <option value="三年级上学期">三年级上学期</option>
			  <option value="三年级下学期">三年级下学期</option>
			  <option value="四年级上学期">四年级上学期</option>
			  <option value="四年级下学期">四年级下学期</option>
			  <option value="五年级上学期">五年级上学期</option>
			  <option value="五年级下学期">五年级下学期</option>
			  <option value="六年级上学期">六年级上学期</option>
			  <option value="六年级下学期">六年级下学期</option>
			</select>
		</div>
	</div>
		
	<div class="container" style="text-align: center;">
		<h3>选择试题学科</h3>
		<div class="col-lg-8 col-lg-offset-2">
			<select class="form-control" name="qsubject" id="qsubject" >
			  <option value="语文">语文</option>
			  <option value="数学">数学</option>
			</select>
		</div>
	</div>
	
	<div class="container" style="text-align: center;">
		<h3>选择做题时间</h3>
		<div class="col-lg-8 col-lg-offset-2">
			<select class="form-control" name="exlimittime" >
			  <option value="600">10分钟</option>
			  <option value="1200">20分钟</option>
			  <option value="1800">30分钟</option>
			  <option value="2700">45分钟</option>
			  <option value="3600">1小时</option>
			  <option value="5400">1小时30分钟</option>
			  <option value="7200">2小时</option>
			</select>
		</div>
	</div>
</form>
	<div class="container" style="height: 20px;">
		
	</div>
	<div class="container" style="text-align: center;">
		<button class="bt btn-success" onclick="getdata()">下一步</button>		
	</div>
	<!-- 折叠框1结束 -->
</div>	
	
	<div class="collapse" id="collapse2">
	  <div class="container" >
	   <div class="col-lg-8 col-lg-offset-2">
		<table class="table table-table-hover" id="classifytable" style="text-align: center;">
			<tr>
				<th style="text-align: center;">题目类型</th>
				<th style="text-align: center;">总题数</th>
				<th style="text-align: center;">出题数量</th>
			</tr>
		</table>
	   </div>
	  </div>
	</div>
	
	<div class="container">
		<div style="width:100%;height:300px;"></div>
	</div>

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
			
			//上传题目方法
			function uploadsubject(obj){
				//检测是否合法
				if($("#qtype").val() == null || $("#qtype").val().trim() == "")
					{
					showMessage("题目类型不能为空");
					return ;
					}
				if($("#qregister").val() == null || $("#qregister").val().trim() == "")
				{
				showMessage("登记人不能为空");
				return ;
				}
				$(obj).text("请稍等");
				$(obj).attr("disabled", "disabled");
				setTimeout(function () { 
					$(obj).html("登记");
					$(obj).removeAttr("disabled"); 
            	}, 3000);
				//至少填写一个答案
				
				
				$.ajax({
		            url:"/myprimarysystem/question/uploadsubject.do",
		            type:"post",
		            data:$("#subjectform").serialize(),
		            success:function (result) {
		            	showMessage(result.message);
		            	if(result.flag == true) 
		            		{
		            			$('#subjectform')[0].reset();
		            		}
		            	return; 
		            	
		            },
		            error:function () {
		                showMessage("错误！");
		            }
				})
			}
			
			function getdata(){
				//开始查询
				$.ajax({
		            url:"/myprimarysystem/question/getexamdetails.do",
		            type:"post",
		            data:$("#form1").serialize(),
		            success:function (result) {
		            	var classifytable = $("#classifytable");
		            	if(result == null || result.length == 0)
		            		{
		            		var str ="";
							str+="<tr><td></td><td>对不起暂无相关题目</td><td></td></tr>"
							classifytable.append(str);
		            		}
		            	for (var  i = 0;  i< result.length; i++) {
							//console.log(result[i].classificationname);
							//console.log(result[i].classificationcount);
							
							
							//开始拼接tr和td让用户选择分类的出题数量
							var str ="";
							str+="<tr class='classifytr'><td>"+result[i].classificationname+"</td><td>"+result[i].classificationcount+"</td><td><input type='number' onblur='checknumber(this)' value='0' max='"+result[i].classificationcount+"' /></td></tr>"
							classifytable.append(str);
						}
		            	var btn = `<div class="container" style="text-align: center;">
		        		<button class="bt btn-success" onclick="prevstep()">上一步</button>		
		        		<button class="bt btn-success" onclick="submitexam()">生成</button>		
		        		</div>`;
		            	
		            	$("#collapse2").append(btn);
		            	$("#collapse1").collapse('hide');
		            	$("#collapse2").collapse('show');
		            	
		            },
		            error:function () {
		                showMessage("错误！");
		            }
				})
			}
			
			function checknumber(obj)
			{	
				var max = $(obj).parent().prev().text();
				var curr = $(obj).val();
				var maxnumber = 0;
				var currnumber = 0;
				try {
					maxnumber = Number(max);	
					currnumber = Number(curr);
					} catch(err) {
						showMessage("只允许输入数字");
						return;
					}
					if(currnumber < 0 )
					{
						showMessage("请输入正确数字");
						$(obj).val(0);
						return;
					}
					if(currnumber > maxnumber )
						{
							showMessage("不能超过最大题数");
							$(obj).val(0);
							return;
						}
				console.log(maxnumber);
			}
			
			//上一步
			function prevstep()
			{	
				
				$("#collapse2").empty();
				$("#collapse2").html(`<div class="container" >
				   <div class="col-lg-8 col-lg-offset-2">
					<table class="table table-table-hover" id="classifytable" style="text-align: center;">
						<tr>
							<th style="text-align: center;">题目类型</th>
							<th style="text-align: center;">总题数</th>
							<th style="text-align: center;">出题数量</th>
						</tr>
					</table>
				   </div>
				  </div>`);
				
				$("#collapse2").collapse('hide');
            	$("#collapse1").collapse('show');
			}
			
			//完成,提交套卷信息
			function submitexam()
			{
				//先生成套卷,在生成试题
				
				
				
				$.ajax({
		            url:"/myprimarysystem/exam/makeexam.do",
		            type:"post",
		            data:$("#form1").serialize(),
		            success:function (result) {
		            	showMessage(result.message);
		            	if(result.flag)
		            	{
		            		//开始上传
		            		var exdnumber = "${exdnumber}";
		            		var exdgrade =$("#qgrade option:selected").val();
		            		var exdsubject = $("#qsubject option:selected").val();
		            		var trs = $(".classifytr");
		    				for (var i = 0; i < trs.length; i++) {
		    					var tds = $(trs[i]);
		    					var exdtype = tds.children().eq(0).html();
		    					var exdamount = tds.children().find("input").val();
		    					if(exdtype == null || "" == exdtype.trim() || exdamount == null ||"" == exdamount.trim())
		    						{
		    							continue;
		    						}else
	    							{
		    							console.log(exdtype,exdamount);
		    							$.ajax({
		    					            url:"/myprimarysystem/exam/makeexamdetails.do",
		    					            type:"post",
		    					            data:{"exdnumber":exdnumber,"exdgrade":exdgrade,"exdtype":exdtype,"exdsubject":exdsubject,"exdamount":exdamount},
		    					            success:function (result) {
		    					            	showMessage(result.message);
		    					            	console.log(result);
		    					            	
		    					            },
		    					            error:function () {
		    					                showMessage("错误！");
		    					            }
		    							})
		    							
		    							
	    							}
		    					
		    				}
		            		if("true" == "${saveresult}")
		            			{
		            				showMessage("生成成功");
		            			}else{
		            				showMessage("生成失败");
		            			}
		            		
		            	}
		            		
		            	
		            },
		            error:function () {
		                showMessage("错误！");
		            }
				})
				
			}
			
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
		$('#collapse1').collapse('show');
		console.log($("[data-toggle='collapse']"));
		$("[data-toggle='collapse']").each(function(index,ele){
			$(this).click(function(){
				var aaa = $(this).siblings();
				$(aaa).each(function(){$(this.click())});
				
			});
				
				
			});
		});
		
	</script>
	<a href="#home" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!-- //smooth scrolling -->
	
	
	
	
</body>
</html>
