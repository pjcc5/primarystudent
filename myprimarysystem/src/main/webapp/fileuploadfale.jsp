<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 	<base href="<%=basePath%>"> 
    
    <title>My JSP 'needlogin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		*{
			margin:0px;
			padding:0px;
		}
		.maindiv{
			width:100%;
			height:100vh;
			background:#cbf3e2;
			position:relative;
			
		}
		.div1{
			width:50%;
			height:50%;
			background: white;
			border-radius:20px;
			margin:0 auto;
			position:absolute;
			top:25%;
			left:25%;
			text-align: center;
			
		}
		.div3{
			font-family: "宋体";
			font-size:100px;
		}
	</style>
	
	
<script type="text/javascript">
	window.onload = function(){
		var time = 3;
		var secondEle = document.getElementById("second");
		var timer = setInterval(function(){
			secondEle.innerHTML = time;
			time--;
			if(time==0){
				clearInterval(timer);
				location.href = document.referrer;
			}
				
		},1000);
	}
</script>
  </head>
  
  <body>
    <div class="maindiv" >
    	<div class="div1">
    		<h1 style="color:red;">${message}</h1>
    		<hr>
    		<h2>正在准备之前的页面</h2>
    		<div class="div3" id="second">3</div>
    		
    	</div>
    </div>
  </body>
</html>
