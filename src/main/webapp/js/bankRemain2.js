$('#saveBtn').click(function(){
	var selections = $('#table').bootstrapTable('getSelections');
	if(selections == null || selections == undefined || selections == ''){
		alert('请先选择数据！');
	}else{
		var isQualified = true;
		for(var i = 0; i < selections.length; i++){
			var selection = selections[i];
			if(isNaN(selection.remain)){
				isQualified = false;
				alert('余额必须是数字！');
				break;
			}
		}
		if(isQualified){
			$.ajax({
				url: 'insertBankRemainList.do',
				type: 'post',
				contentType: 'application/json',
				data: JSON.stringify(selections),
				success: function(data){
					if(data == true){
						alert('添加成功');
						window.location.href='#/searchBankRemain';
					}else{
						alert("添加失败，请重试");
					}
				},
				error: function(data, e, status){
					alert('发生未知错误，请重试');
					console.log(data);
					console.log(e);
					console.log(status);
				}
			});
		}
	}
});