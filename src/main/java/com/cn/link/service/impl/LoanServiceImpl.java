package com.cn.link.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.link.mapper.LoanMapper;
import com.cn.link.model.DomesticCertification;
import com.cn.link.model.LiquidLoan;
import com.cn.link.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanMapper loanMapper;
	
	@Override
	public int insertLiquidLoan(LiquidLoan liquidLoan) {
		// TODO Auto-generated method stub
		return loanMapper.insertLiquidLoan(liquidLoan);
	}

	@Override
	public List<String> queryInterestWay() {
		// TODO Auto-generated method stub
		return loanMapper.queryInterestWay();
	}

	@Override
	public List<String> queryLoanWay() {
		// TODO Auto-generated method stub
		return loanMapper.queryLoanWay();
	}

	@Override
	public List<LiquidLoan> queryLiquidLoan(String today) {
		// TODO Auto-generated method stub
		return loanMapper.queryLiquidLoanByDate(today);
	}

	@Override
	public int insertDomesticCertificate(DomesticCertification dc) {
		// TODO Auto-generated method stub
		return loanMapper.insertDomesticCertificate(dc);
	}

	@Override
	public List<DomesticCertification> queryDomesticCertificationByDate(String today) {
		// TODO Auto-generated method stub
		return loanMapper.queryDomesticCertificationByDate(today);
	}

	@Override
	public List<LiquidLoan> queryAllLiquidLoanByDate(String today, String nextDate, String nextNextDate) {
		// TODO Auto-generated method stub
		return loanMapper.queryAllLiquidLoanByDate(today, nextDate, nextNextDate);
	}

	@Override
	public List<DomesticCertification> queryAllDomesticCertificateByDate(String today, String nextDate,
			String nextNextDate) {
		// TODO Auto-generated method stub
		return loanMapper.queryAllDomesticCertificateByDate(today, nextDate, nextNextDate);
	}

}
