package com.cn.link.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.link.model.DomesticCertification;
import com.cn.link.model.LiquidLoan;

public interface LoanMapper {
	public int insertLiquidLoan(LiquidLoan liquidLoan);
	
	public List<String> queryInterestWay();
	
	public List<String> queryLoanWay();
	
	public List<LiquidLoan> queryLiquidLoanByDate(String today);
	
	public int insertDomesticCertificate(DomesticCertification dc);
	
	public List<DomesticCertification> queryDomesticCertificationByDate(String today);
	
	public List<LiquidLoan> queryAllLiquidLoanByDate(@Param("today") String today, @Param("nextDate") String nextDate,
			@Param("nextNextDate") String nextNextDate);
	
	public List<DomesticCertification> queryAllDomesticCertificateByDate(@Param("today") String today,
			@Param("nextDate") String nextDate,	@Param("nextNextDate") String nextNextDate);
	
}
