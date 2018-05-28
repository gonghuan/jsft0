$(function(){  	
    	$('#todayRemain').bootstrapTable({
    		url: 'queryTodayBankRemain.do',
    		method: 'get',
    		toolbar: '#toolbar1',
    		striped: true,
    		sidePagination: 'client',
    		pagination: true,
    		sortable: true,
    		cache: true,
    		pageNumber: 1,    		
    		pageSize: 50,
    		pageList: [10,15,25,50,100],
    		search: true,
    		showRefresh: true,
    		showToggle: true,
    		showColumns: true,
    		queryParams: 'queryParams',
    		clickToSelect: true,
    		columns: [{
    			
    		}]
    	});
    	$('#todayRemain').bootstrapTable('hideColumn', 'id');
    	
    	$('#RMBRemain').bootstrapTable({
    		url: 'queryRMBRemain.do',
    		method: 'get',
    		toolbar: '#toolbar2',
    		striped: true,
    		sidePagination: 'client',
    		pagination: true,
    		sortable: true,
    		cache: true,
    		pageNumber: 1,    		
    		pageSize: 50,
    		pageList: [10,15,25,50,100],
    		search: true,
    		showRefresh: true,
    		showToggle: true,
    		showColumns: true,
    		queryParams: 'queryParams',
    		clickToSelect: true,
    		columns: [{
    			
    		}]
    	});
    	$('#RMBRemain').bootstrapTable('hideColumn', 'id');
    	
    	$('#foreignRemain').bootstrapTable({
    		url: 'queryForeignRemain.do',
    		method: 'get',
    		toolbar: '#toolbar3',
    		striped: true,
    		sidePagination: 'client',
    		pagination: true,
    		sortable: true,
    		cache: true,
    		pageNumber: 1,    		
    		pageSize: 50,
    		pageList: [10,15,25,50,100],
    		search: true,
    		showRefresh: true,
    		showToggle: true,
    		showColumns: true,
    		queryParams: 'queryParams',
    		clickToSelect: true,
    		columns: [{
    			
    		}]
    	});
    	$('#foreignRemain').bootstrapTable('hideColumn', 'id');
});

function getSum1(){
	var selections = $('#todayRemain').bootstrapTable('getSelections');
	if(selections.length > 0){
		var sum = 0.0;
    	for(var i = 0; i < selections.length; i++){
    		sum += parseFloat(selections[i].remain);
    	}
    	$('#sumText1').val(sum.toFixed(2));
    	//$('#sumText').css({color: "black"});
	}else{
		$('#sumText1').val('');
		alert('请先选择需要求和的行');
		
	}
}

function getSum2(){
	var selections = $('#RMBRemain').bootstrapTable('getSelections');
	if(selections.length > 0){
		var sum = 0.0;
    	for(var i = 0; i < selections.length; i++){
    		sum += parseFloat(selections[i].remain);
    	}
    	$('#sumText2').val(sum.toFixed(2));
    	//$('#sumText').css({color: "black"});
	}else{
		$('#sumText2').val('');
		alert('请先选择需要求和的行');
		
	}
}

function getSum3(){
	var selections = $('#foreignRemain').bootstrapTable('getSelections');
	if(selections.length > 0){
		var sum = 0.0;
    	for(var i = 0; i < selections.length; i++){
    		sum += parseFloat(selections[i].remain);
    	}
    	$('#sumText3').val(sum.toFixed(2));
    	//$('#sumText').css({color: "black"});
	}else{
		$('#sumText3').val('');
		alert('请先选择需要求和的行');
		
	}
}