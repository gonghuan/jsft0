package com.cn.link.model;

import org.springframework.stereotype.Repository;

@Repository
public class CreditRemain {
	private String contractId;
	private double remain;
	public CreditRemain(){
		
	}
	public CreditRemain(String contractId, double remain) {
		super();
		this.contractId = contractId;
		this.remain = remain;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public double getRemain() {
		return remain;
	}
	public void setRemain(double remain) {
		this.remain = remain;
	}
	
	
}
