package com.cn.link.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.link.model.BankBranch;
import com.cn.link.model.BankRemain;
import com.cn.link.service.BankService;

@Controller
public class BankController {

	private static Logger logger = Logger.getLogger(BankController.class);

	@Autowired
	private BankService bankService;

	@RequestMapping(value = "queryBank", method = RequestMethod.GET)
	public @ResponseBody List<String> queryBank() {
		logger.info("获取银行：" + JSON.toJSONString(bankService.queryBank()));
		return bankService.queryBank();
	}
	
	@RequestMapping(value="queryBankBranch", method=RequestMethod.POST)
	public @ResponseBody List<String> queryBankBranch(@RequestParam("bank") String bank){
		List<String> bankBranches = bankService.queryBankBranch(bank);
		logger.info("获取分行：" + JSON.toJSONString(bankBranches));
		if(!bankBranches.isEmpty()){
			return bankBranches;
		}else{
			bankBranches = bankService.queryBankBranch();
			logger.info("获取分行：" + JSON.toJSONString(bankBranches));
			return bankBranches;
		}
	}
	
	@RequestMapping(value="queryBankAccount", method = RequestMethod.POST)
	public @ResponseBody List<String> queryBankAccount(@RequestParam("bankBranch") String bankBranch){
		List<String> bankAccount = bankService.queryBankAccount(bankBranch);
		logger.info("获取账户" + JSON.toJSONString(bankAccount));
		return bankAccount;
	}
	
	@RequestMapping(value="insertBankRemain", method = RequestMethod.POST)
	public @ResponseBody boolean insertBankRemain(@RequestParam("bank") String bank, @RequestParam("branch") String branch, 
			@RequestParam("account") String account, @RequestParam("currency") String currency,
			@RequestParam("remain") double remain, HttpServletResponse response){
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String date = sdf.format(today);
		BankRemain bankRemain = new BankRemain(bank, branch, account, currency, remain, date);
		int times = bankService.insertBankRemain(bankRemain);
		logger.info("增加了" + times +"条数据");
		if(times >= 1) return true;
		else return false;
	}
	
	@RequestMapping(value="insertBankRemainList", method=RequestMethod.POST)
	public @ResponseBody boolean insertBankRemainList(@RequestBody List<JSONObject> selections){
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String date = sdf.format(today);
		List<BankRemain> list = new ArrayList<>();
		for(int i = 0; i < selections.size(); i++){
			JSONObject selection = selections.get(i);
			BankRemain bankRemain = new BankRemain(selection.getString("bank"), selection.getString("bankName"),
					selection.getString("account"), selection.getString("currency"), selection.getDoubleValue("remain"),
					date);
			list.add(bankRemain);
		}
		int times = bankService.insertBankRemainList(list);
		logger.info("增加了" + times + "条数据");
		if(times >= 1) return true;
		else return false;
	}
	
	@RequestMapping(value="queryTodayBankRemain")
	public @ResponseBody List<BankRemain> queryTodayBankRemain(){
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String date = sdf.format(today);
		List<BankRemain> list = bankService.queryTodayBankRemain(date);
		logger.info("当天的银行余额记录：" + JSON.toJSONString(list));
		return list;
	}
	
	@RequestMapping(value="queryRMBRemain")
	public @ResponseBody List<BankRemain> queryRMBRemain(){
		String currency = "人民币CNY";
		List<BankRemain> list = bankService.queryCurrencyRemain(currency);
		logger.info("查询人民币银行余额"+ JSON.toJSONString(list));
		return list;
	}
	
	@RequestMapping(value="queryForeignRemain")
	public @ResponseBody List<BankRemain> queryForeignRemain(){
		String currency = "人民币CNY";
		List<BankRemain> list = bankService.queryForeignCurrencyRemain(currency);
		logger.info("查询外币银行余额"+ JSON.toJSONString(list));
		return list;
	}
	
	@RequestMapping(value="getBankBranches")
	public @ResponseBody List<BankBranch> getBankBranches(){
		List<BankBranch> bankBranches = bankService.queryBankBranches();
		logger.info("银行账户" + JSON.toJSONString(bankBranches));
		return bankBranches;
	}
	
	@RequestMapping(value="insertBankBranch", method=RequestMethod.POST)
	public @ResponseBody boolean insertBankBranch(@RequestParam("bank") String bank,
			@RequestParam("bankName") String bankName, @RequestParam("currency") String currency,
			@RequestParam("account") String account){
		BankBranch bankBranch = new BankBranch(bank, bankName, currency, account);
		int times = bankService.insertBankBranch(bankBranch);
		if(times >= 1){
			return true;
		}else{
			return false;
		}
	}
	
	@RequestMapping(value="delBankBranch", method=RequestMethod.POST)
	public @ResponseBody boolean delBankBranch(String[] accounts){
		System.out.println(Arrays.toString(accounts));
		int times = bankService.delBankBranch(accounts);
		logger.info("删除了" + times +"条支行记录");
		if(times >= 1){
			return true;
		}else{
			return false;
		}
	}
}
