package com.cn.link.model;

public class BankRemain {
	public int id;
	public String bank;
	public String branch;
	public String account;
	public String currency;
	public double remain;
	public String date;
	
	public BankRemain(){
		
	}
	
	public BankRemain(String bank, String branch, String account, String currency, double remain, String date) {
		super();
		this.bank = bank;
		this.branch = branch;
		this.account = account;
		this.currency = currency;
		this.remain = remain;
		this.date = date;
	}
	
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getRemain() {
		return remain;
	}

	public void setRemain(double remain) {
		this.remain = remain;
	}
	
	
}
