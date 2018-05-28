$(function(){
	$('#inputDomesticCertificate').hide();
	$.ajax({
		url:'queryBank.do',
		success: function(data){
			$('#selectBank').append("<option value='0'>请选择银行</option>");
			for(var i in data){
				$('#selectBank').append("<option value='"+data[i]+"'>"+data[i]+"</option>");
			}
			$('#selectBank2').append("<option value='0'>请选择银行</option>");
			for(var i in data){
				$('#selectBank2').append("<option value='"+data[i]+"'>"+data[i]+"</option>");
			}
		},
		error: function(data, e, status){
			alert('发生未知错误，请重试！');
			console.log(data);
			console.log(e);
			console.log(status);
		}
	});
	$.ajax({
		url:'queryInterestWay.do',
		success: function(data){
			$('#selectInterestWay').append("<option value='0'>请选择计息方式</option>");
			for(var i in data){
				$('#selectInterestWay').append("<option value='"+data[i]+"'>"+data[i]+"</option>");
			}
		},
		error: function(data, e, status){
			alert('发生未知错误，请重试！');
			console.log(data);
			console.log(e);
			console.log(status);
		}
	});
	$.ajax({
		url:'queryLoanWay.do',
		success: function(data){
			$('#selectLoanWay').append("<option value='0'>请选择贷款方式</option>");
			for(var i in data){
				$('#selectLoanWay').append("<option value='"+data[i]+"'>"+data[i]+"</option>");
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

$('.btn-default').click(function(){
	location.reload();
});

$('#saveLiquidLoanBtn').click(function(){
	$.ajax({
		url: 'insertLiquidLoan.do',
		data: $('#inputLiquidLoan').serialize(),
		type: 'post',
		success: function(data){
			if(data == true){
				alert("添加成功！");
				location.reload();
			}else{
				alert("发生未知错误，请重试！");
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

$('#saveDomesticCertificateBtn').click(function(){
	$.ajax({
		url: 'insertDomesticCertificate.do',
		data: $('#inputDomesticCertificate').serialize(),
		type: 'post',
		success: function(data){
			if(data == true){
				alert("添加成功！");
				location.reload();
			}else{
				alert("发生未知错误，请重试！");
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

$('#loanApproach').change(function(){
	var value = $(this).val();
	if(value == 'liquidLoan'){
		$('#inputDomesticCertificate').hide();
		$('#inputLiquidLoan').show();
	}else if(value == 'domesticCertificate'){
		$('#inputLiquidLoan').hide();
		$('#inputDomesticCertificate').show();
	}
});