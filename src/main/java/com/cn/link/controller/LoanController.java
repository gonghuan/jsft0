package com.cn.link.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.cn.link.model.LiquidLoan;
import com.cn.link.service.LoanService;

@Controller
public class LoanController {
	
	private static Logger logger = Logger.getLogger(BankController.class);
	
	@Autowired
	private LoanService loanService;
	
	
	@RequestMapping(value="queryInterestWay")
	public @ResponseBody List<String> queryInterestWay(){
		List<String> list = loanService.queryInterestWay();
		logger.info("计息方式：" + JSON.toJSONString(list));
		return list;
	}
	
	@RequestMapping(value="queryLoanWay")
	public @ResponseBody List<String> queryLoanWay(){
		List<String> list = loanService.queryLoanWay();
		logger.info("贷款方式：" + JSON.toJSONString(list));
		return list;
	}
	
	@RequestMapping(value="insertLiquidLoan", method = RequestMethod.POST)
	public @ResponseBody boolean insertLiquidLoan(@RequestParam("bank") String bank, @RequestParam("money") double money,
			@RequestParam("loanDate") String loanDate, @RequestParam("repayDate") String repayDate, 
			@RequestParam("rate") String rate, @RequestParam("isUseCredit") String isUseCredit, 
			@RequestParam("interestWay") String interestWay, @RequestParam("loanWay") String loanWay){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String today = sdf.format(date);
		boolean isusecredit = false;
		if(isUseCredit.equals("1")){
			isusecredit = true;
		}
		LiquidLoan liquidLoan = new LiquidLoan(bank, money, loanDate, repayDate, rate, interestWay, loanWay, today,
				isusecredit);
		int times = loanService.insertLiquidLoan(liquidLoan);
		logger.info("添加了" + times + "条记录");
		if(times >= 1){
			return true;
		}else{
			return false;
		}
	}
	
	@RequestMapping(value="queryLiquidLoan")
	public @ResponseBody List<LiquidLoan> queryLiquidLoan(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String today = sdf.format(date);
		List<LiquidLoan> list = loanService.queryLiquidLoan(today);
		logger.info("未到期流贷如下：" + JSON.toJSONString(list));
		return list;
	}
}
