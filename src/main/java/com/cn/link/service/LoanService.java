package com.cn.link.service;

import java.util.List;

import com.cn.link.model.DomesticCertification;
import com.cn.link.model.LiquidLoan;

public interface LoanService {
	public int insertLiquidLoan(LiquidLoan liquidLoan);
	
	public List<String> queryInterestWay();
	
	public List<String> queryLoanWay();
	
	public List<LiquidLoan> queryLiquidLoan(String today);
	
	public int insertDomesticCertificate(DomesticCertification dc);
	
	public List<DomesticCertification> queryDomesticCertificationByDate(String today);
	
	public List<LiquidLoan> queryAllLiquidLoanByDate(String today, String nextDate, String nextNextDate);
	
	public List<DomesticCertification> queryAllDomesticCertificateByDate(String today, String nextDate, String nextNextDate);
}
