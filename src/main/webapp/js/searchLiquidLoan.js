$(function(){
	$('#liquidLoan').bootstrapTable({
		url: 'queryLiquidLoan.do',
		method: 'get',
		toolbar: '#toolbar',
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