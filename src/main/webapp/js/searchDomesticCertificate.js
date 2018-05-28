$(function(){
	$('#domesticCertificate').bootstrapTable({
		url: 'queryDomesticCertification.do',
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
});

function getSum1(){
	var selections = $('#domesticCertificate').bootstrapTable('getSelections');
	if(selections.length > 0){
		var sum = 0.0;
    	for(var i = 0; i < selections.length; i++){
    		sum += parseFloat(selections[i].price);
    	}
    	$('#sumText1').val(sum.toFixed(2));
    	//$('#sumText').css({color: "black"});
	}else{
		$('#sumText1').val('');
		alert('请先选择需要求和的行');
		
	}
}