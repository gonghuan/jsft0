package com.cn.link.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import com.cn.link.model.DomesticCertification;
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
	
	@RequestMapping(value="insertDomesticCertificate", method=RequestMethod.POST)
	public @ResponseBody boolean insertDomesticCertificate(@RequestParam("bank") String bank,
			@RequestParam("certificateId") String certificateId, @RequestParam("price") double price, 
			@RequestParam("interestDate") String interestDate, @RequestParam("bond") double bond,
			@RequestParam("isUseCredit") String isUseCredit){
		boolean isusecredit = false;
		if(isUseCredit.equals("1")){
			isusecredit = true;
		}
		DomesticCertification dc = new DomesticCertification(certificateId, bank, price, interestDate, bond, isusecredit);
		int times = loanService.insertDomesticCertificate(dc);
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
		for(int i = 0; i < list.size(); i++){
			LiquidLoan ll = list.get(i);
			if(ll.isIsusecredit()){
				ll.setStr("是");
			}else{
				ll.setStr("否");
			}
		}
		return list;
	}
	
	@RequestMapping(value="queryDomesticCertification")
	public @ResponseBody List<DomesticCertification> queryDomesticCertification(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String today = sdf.format(date);
		List<DomesticCertification> list = loanService.queryDomesticCertificationByDate(today);
		logger.info("未到期国内证如下：" + JSON.toJSONString(list));
		for(int i = 0; i < list.size(); i++){
			DomesticCertification dc = list.get(i);
			if(dc.getIsIsrepayed()){
				dc.setStr("是");
			}else{
				dc.setStr("否");
			}
		}
		return list;
	}
	
	@RequestMapping(value="queryAllLiquidLoanByDate")
	public @ResponseBody List<LiquidLoan> queryAllLiquidLoanByDate(){
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
		String nowDate = sf.format(date);
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(sf.parse(nowDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String today = sf.format(calendar.getTime());
		calendar.add(Calendar.DAY_OF_YEAR, +1);
		String nextDate = sf.format(calendar.getTime());
		calendar.add(Calendar.DAY_OF_YEAR, +1);
		String nextNextDate = sf.format(calendar.getTime());
		List<LiquidLoan> list = loanService.queryAllLiquidLoanByDate(today, nextDate, nextNextDate);
		logger.info("流贷到期提醒：" + JSON.toJSONString(list));
		for(int i = 0; i < list.size(); i++){
			LiquidLoan ll = list.get(i);
			if(ll.isIsusecredit()){
				ll.setStr("是");
			}else{
				ll.setStr("否");
			}
		}
		return list;
	}
	
	@RequestMapping(value="queryAllDomesticCertificateByDate")
	public @ResponseBody List<DomesticCertification> queryAllDomesticCertificateByDate(){
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
		String nowDate = sf.format(date);
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(sf.parse(nowDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String today = sf.format(calendar.getTime());
		calendar.add(Calendar.DAY_OF_YEAR, +1);
		String nextDate = sf.format(calendar.getTime());
		calendar.add(Calendar.DAY_OF_YEAR, +1);
		String nextNextDate = sf.format(calendar.getTime());
		List<DomesticCertification> list = loanService.queryAllDomesticCertificateByDate(today, nextDate, nextNextDate);
		logger.info("国内证到期提醒：" + JSON.toJSONString(list));
		for(int i = 0; i < list.size(); i++){
			DomesticCertification dc = list.get(i);
			if(dc.getIsIsrepayed()){
				dc.setStr("是");
			}else{
				dc.setStr("否");
			}
		}
		return list;
	}
	
}
