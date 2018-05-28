package com.cn.link.model;

public class DomesticCertification {
	private int id;
	private String certificateid;
	private String bank;
	private double price;
	private String interestdate;
	private double bond;
	private boolean isusecredit;
	private boolean isrepayed;
	private String str;
	public DomesticCertification(int id, String certificateid, String bank, double price, String interestdate,
			double bond, boolean isusecredit) {
		super();
		this.id = id;
		this.certificateid = certificateid;
		this.bank = bank;
		this.price = price;
		this.interestdate = interestdate;
		this.bond = bond;
		this.isusecredit = isusecredit;
	}
	public DomesticCertification() {
		super();
	}
	public DomesticCertification(String certificateid, String bank, double price, String interestdate, double bond,
			boolean isusecredit) {
		super();
		this.certificateid = certificateid;
		this.bank = bank;
		this.price = price;
		this.interestdate = interestdate;
		this.bond = bond;
		this.isusecredit = isusecredit;
	}
	
	
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public boolean getIsIsrepayed() {
		return isrepayed;
	}
	public void setIsrepayed(boolean isrepayed) {
		this.isrepayed = isrepayed;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCertificateid() {
		return certificateid;
	}
	public void setCertificateid(String certificateid) {
		this.certificateid = certificateid;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getInterestdate() {
		return interestdate;
	}
	public void setInterestdate(String interestdate) {
		this.interestdate = interestdate;
	}
	public double getBond() {
		return bond;
	}
	public void setBond(double bond) {
		this.bond = bond;
	}
	public boolean getIsIsusecredit() {
		return isusecredit;
	}
	public void setIsusecredit(boolean isusecredit) {
		this.isusecredit = isusecredit;
	}
	
	
}
