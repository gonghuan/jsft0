package com.cn.link.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.link.mapper.BankMapper;
import com.cn.link.model.BankBranch;
import com.cn.link.model.BankRemain;
import com.cn.link.service.BankService;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	private BankMapper bankMapper;

	@Override
	public List<String> queryBank() {
		return bankMapper.queryBank();
	}

	@Override
	public List<String> queryBankBranch(String bank) {
		// TODO Auto-generated method stub
		return bankMapper.queryBankBranch(bank);
	}

	@Override
	public List<String> queryBankBranch() {
		// TODO Auto-generated method stub
		return bankMapper.queryBankBranches();
	}

	@Override
	public List<String> queryBankAccount(String bankBranch) {
		// TODO Auto-generated method stub
		return bankMapper.queryBankAccount(bankBranch);
	}
	
	public int insertBankRemain(BankRemain bankRemain){
		return bankMapper.insertBankRemain(bankRemain);
	}

	@Override
	public List<BankRemain> queryTodayBankRemain(String today) {
		// TODO Auto-generated method stub
		return bankMapper.queryTodayBankRemain(today);
	}

	@Override
	public List<BankRemain> queryCurrencyRemain(String currency) {
		// TODO Auto-generated method stub
		return bankMapper.queryBankRemainCurrency(currency);
	}

	@Override
	public List<BankRemain> queryForeignCurrencyRemain(String currency) {
		// TODO Auto-generated method stub
		return bankMapper.queryBankRemainForeignCurrency(currency);
	}

	@Override
	public List<BankBranch> queryBankBranches() {
		// TODO Auto-generated method stub
		return bankMapper.queryBankbranch();
	}

	@Override
	public int insertBankRemainList(List<BankRemain> list) {
		// TODO Auto-generated method stub
		return bankMapper.insertBankRemainList(list);
	}
}
