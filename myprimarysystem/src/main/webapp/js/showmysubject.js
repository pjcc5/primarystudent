function jump(nextpage,aid)
{	
	var maxpage = parseInt($("#currpage").attr("value"));
	console.log(maxpage);
	if(nextpage == 0)
	{
		return;
	}
	if(nextpage > maxpage)
	{
		return;
	}
	location.href="/myprimarysystem/question/"+nextpage+"/showmysubject.do?ccc="+aid;
}

function subjectdetails(obj)
{
	var $eee = $(obj);
	var aaa =$eee.parent().siblings("input").val();
	location.href="/myprimarysystem/question/questiondetails.do?aaa="+aaa;
}
	
//删除试题的方法

function deletesubject(obj){
	var $eee = $(obj);
	var aaa =$eee.parent().siblings("input").val();
	if(aaa == null || "" == aaa)
	{return ;}
	alert(aaa);
	
	$.ajax({
        url:"/myprimarysystem/question/editsubject.do",
        type:"post",
        data:$("#subjectform").serialize(),
        success:function (result) {
        	showMessage(result.message);
        	if(result.flag == true) 
        		{
        			$('#subjectform')[0].reset();
        			setTimeout(function(){
        				location.reload(true);
        				
        			}, 2000);
        			
        		}
        	return; 
        	
        },
        error:function () {
            showMessage("错误！");
        }
	})
	
	
}	
	


