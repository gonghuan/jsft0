package com.cn.link.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class IndexController {
	@RequestMapping(value="searchBankRemain")
	public String searchBankRemain(){
		return "searchBankRemain";
	}
}
