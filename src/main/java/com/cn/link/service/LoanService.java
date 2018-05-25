package com.cn.link.service;

import java.util.List;

import com.cn.link.model.LiquidLoan;

public interface LoanService {
	public int insertLiquidLoan(LiquidLoan liquidLoan);
	
	public List<String> queryInterestWay();
	
	public List<String> queryLoanWay();
	
	public List<LiquidLoan> queryLiquidLoan(String today);
}
