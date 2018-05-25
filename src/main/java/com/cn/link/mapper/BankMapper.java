package com.cn.link.mapper;

import java.util.List;

import com.cn.link.model.Bank;
import com.cn.link.model.BankBranch;
import com.cn.link.model.BankRemain;

public interface BankMapper {
	public int deleteByPrimaryKey(Integer id);

	public int insert(Bank record);

	public int insertSelective(Bank record);

	public Bank selectByPrimaryKey(Integer id);

	public int updateByPrimaryKeySelective(Bank record);

	public int updateByPrimaryKey(Bank record);
	
	public List<String> queryBank();
	
	public List<String> queryBankBranch(String bank);
	
	public List<String> queryBankBranches();
	
	public List<String> queryBankAccount(String bankBranch);
	
	public int insertBankRemain(BankRemain bankRemain);
	
	public List<BankRemain> queryTodayBankRemain(String today);
	
	public List<BankRemain> queryBankRemainCurrency(String currency);
	
	public List<BankRemain> queryBankRemainForeignCurrency(String currency);
	
	public List<BankBranch> queryBankbranch();
	
	public int insertBankRemainList(List<BankRemain> list);
}