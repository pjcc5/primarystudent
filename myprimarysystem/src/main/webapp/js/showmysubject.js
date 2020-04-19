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


