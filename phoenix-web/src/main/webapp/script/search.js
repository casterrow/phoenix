
$(function() {
	
	//监听文本框内容变化，输入内容没按回车前，下方出现相似关键词给用户选择
	$("#search").on('input', function() {
		alert("亲，您输入的内容变化了哟!");
	});
	
	
	//监听文本框回车事件，和点击搜索的功能完全一样
	$("#search").keyup(function() {
		alert("欢迎搜索!");
	});
	
	//点击搜索功能
	$("#click").click(function() {
		//获取文本框的值
		var words = $("#search").attr("value"); 
		if (words == '') {
			alert("亲，您输入的内容为空哟！");
			return;
		}
		$.ajax({ //去服务端取数据
			method : POST
		});
		
	});
	
});