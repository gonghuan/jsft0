$(document).ready(function(){
	$.ajax({
		url:'queryBank.do',
		success: function(data){
			$('#selectBank').append("<option value='0'>请选择银行</option>");
			for(var i in data){
				$('#selectBank').append("<option value='"+data[i]+"'>"+data[i]+"</option>");
			}
		},
		error: function(data, e, status){
			alert('发生未知错误，请重试！');
			console.log(data);
			console.log(e);
			console.log(status);
		}
	});
});

$('#selectBank').change(function(){
	$('#selectBankBranch').empty();
	var bank = $(this).val();
	$.ajax({
		url:'queryBankBranch.do',
		data: {'bank': bank},
		type: 'post',
		success: function(data){
			$('#selectBankBranch').append("<option value='0'>请选择支行</option>");
			for(var i in data){
				$('#selectBankBranch').append("<option value='"+data[i]+"'>"+data[i]+"</option>");
			}
		},
		error: function(data){
			alert('发生未知错误，请重试！');
			console.log(data);
			console.log(e);
			console.log(status);
		}
	});
});

$('#selectBankBranch').change(function(){
	$('#selectAccount').empty();
	var bankBranch = $(this).val();
	$.ajax({
		url: 'queryBankAccount.do',
		data: {'bankBranch': bankBranch},
		type: 'post',
		success: function(data){
			$('#selectAccount').append("<option value='0'>请选择账户</option>");
			for(var i in data){
				$('#selectAccount').append("<option value='"+data[i]+"'>"+data[i]+"</option>");
			}
		},
		error:function(data, e, status){
			alert('发生未知错误，请重试！');
			console.log(data);
			console.log(e);
			console.log(status);
		}
	});
});

$('.btn-default').click(function(){
	$('#selectBank').find("option:contains('请选择银行')").attr("selected",true);
	$('#selectBankBranch').find("option:contains('请选择支行')").attr("selected",true);
	$('#selectAccount').find("option:contains('请选择账户')").attr("selected",true);
	$('#selectCurrency').find("option:contains('0')").attr("selected",true);
	$('#inputRemain').val('');
});

$('.btn-success').click(function(){
	$.ajax({
		type: 'post',
		url: 'insertBankRemain.do',
		data: $('#inputBankRemain').serialize(),
		success: function(data){
			alert('添加成功！');
			location.reload();
		},
		error: function(data, e, status){
			alert('发生未知错误，请重试！');
			console.log(data);
			console.log(e);
			console.log(status);
		}
	});
});