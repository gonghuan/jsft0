package com.cn.link.model;

public class LiquidLoan {
	private int id;
	private String bank;
	private double money;
	private String loandate;
	private String repaydate;
	private String rate;
	private String interestway;
	private String loanway;
	private String registerdate;
	private boolean isusecredit;
	private boolean isrepayed;
	private String str;
	
	
	public LiquidLoan() {
		super();
	}



	public LiquidLoan(String bank, double money, String loandate, String repaydate, String rate,
			String interestway, String loanway, String registerdate, boolean isusecredit) {
		super();
		this.bank = bank;
		this.money = money;
		this.loandate = loandate;
		this.repaydate = repaydate;
		this.rate = rate;
		this.interestway = interestway;
		this.loanway = loanway;
		this.registerdate = registerdate;
		this.isusecredit = isusecredit;
	}
	
	
	
	public LiquidLoan(int id, String bank, double money, String loandate, String repaydate, String rate,
			String interestway, String loanway, String registerdate, boolean isusecredit, boolean isrepayed) {
		super();
		this.id = id;
		this.bank = bank;
		this.money = money;
		this.loandate = loandate;
		this.repaydate = repaydate;
		this.rate = rate;
		this.interestway = interestway;
		this.loanway = loanway;
		this.registerdate = registerdate;
		this.isusecredit = isusecredit;
		this.isrepayed = isrepayed;
	}



	public boolean isIsrepayed() {
		return isrepayed;
	}



	public void setIsrepayed(boolean isrepayed) {
		this.isrepayed = isrepayed;
	}



	public boolean isIsusecredit() {
		return isusecredit;
	}



	public void setIsusecredit(boolean isusecredit) {
		this.isusecredit = isusecredit;
	}

	

	public String getStr() {
		return str;
	}



	public void setStr(String str) {
		this.str = str;
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

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getLoandate() {
		return loandate;
	}

	public void setLoandate(String loandate) {
		this.loandate = loandate;
	}

	public String getRepaydate() {
		return repaydate;
	}

	public void setRepaydate(String repaydate) {
		this.repaydate = repaydate;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getInterestway() {
		return interestway;
	}

	public void setInterestway(String interestway) {
		this.interestway = interestway;
	}

	public String getLoanway() {
		return loanway;
	}

	public void setLoanway(String loanway) {
		this.loanway = loanway;
	}

	public String getRegisterdate() {
		return registerdate;
	}

	public void setRegisterdate(String registerdate) {
		this.registerdate = registerdate;
	}
	
	
	
}
