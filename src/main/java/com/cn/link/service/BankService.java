package com.cn.link.service;

import java.util.List;

import com.cn.link.model.BankBranch;
import com.cn.link.model.BankRemain;

public interface BankService {

//	public int deleteByPrimaryKey(Integer id);
//
//	public int insert(Bank record);
//
//	public int insertSelective(Bank record);
//
//	public Bank selectByPrimaryKey(Integer id);
//
//	public int updateByPrimaryKeySelective(Bank record);
//
//	public int updateByPrimaryKey(Bank record);
	
	public List<String> queryBank();
	
	public List<String> queryBankBranch(String bank);
	
	public List<String> queryBankBranch();
	
	public List<String> queryBankAccount(String bankBranch);
	
	public int insertBankRemain(BankRemain bankRemain);
	
	public List<BankRemain> queryTodayBankRemain(String today);
	
	public List<BankRemain> queryCurrencyRemain(String currency);
	
	public List<BankRemain> queryForeignCurrencyRemain(String currency);
	
	public List<BankBranch> queryBankBranches();
	
	public int insertBankRemainList(List<BankRemain> list);
	
	public int insertBankBranch(BankBranch bankBranch);
	
	public int delBankBranch(String[] accounts);
}
