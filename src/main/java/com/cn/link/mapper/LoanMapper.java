package com.cn.link.mapper;

import java.util.List;

import com.cn.link.model.LiquidLoan;

public interface LoanMapper {
	public int insertLiquidLoan(LiquidLoan liquidLoan);
	
	public List<String> queryInterestWay();
	
	public List<String> queryLoanWay();
	
	public List<LiquidLoan> queryLiquidLoanByDate(String today);
	
}
