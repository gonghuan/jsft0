package com.cn.link.model;

public class BankBranch {
	private int remain = 0;
	public int getRemain() {
		return remain;
	}

	public void setRemain(int remain) {
		this.remain = remain;
	}



	private String bank;
	private String bankName;
	private String currency;
	private String account;
	
	public BankBranch() {
		super();
	}

	public BankBranch(String bank, String bankName, String currency, String account) {
		super();
		this.bank = bank;
		this.bankName = bankName;
		this.currency = currency;
		this.account = account;
	}



	public String getBank() {
		return bank;
	}



	public void setBank(String bank) {
		this.bank = bank;
	}



	public String getBankName() {
		return bankName;
	}



	public void setBankName(String bankName) {
		this.bankName = bankName;
	}



	public String getCurrency() {
		return currency;
	}



	public void setCurrency(String currency) {
		this.currency = currency;
	}



	public String getAccount() {
		return account;
	}



	public void setAccount(String account) {
		this.account = account;
	}
	
	
	
}
