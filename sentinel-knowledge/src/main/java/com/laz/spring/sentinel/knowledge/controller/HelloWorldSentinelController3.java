package com.laz.spring.sentinel.knowledge.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.laz.spring.sentinel.knowledge.BlockUtils;
import com.laz.spring.sentinel.knowledge.service.BusiServiceImpl;

@RestController
public class HelloWorldSentinelController3 {
	private Logger log = LoggerFactory.getLogger(HelloWorldSentinelController3.class);
	@Autowired
	private BusiServiceImpl busiService;

	public HelloWorldSentinelController3() {

	}


	/**
	 * 我们看到了v2中的缺点,我们通过blockHandlerClass 来指定处理被流控的类 通过testHelloSentinelV3BlockMethod
	 * 来指定blockHandlerClass 中的方法名称 ***这种方式 处理异常流控的方法必须要是static的 频繁请求接口
	 * http://localhost:8080/helloSentinelV3
	 * 
	 * @return
	 */
	@RequestMapping("/helloSentinelV3")
	@SentinelResource(value = "helloSentinelV3", blockHandler = "testHelloSentinelV3BlockMethod", blockHandlerClass = BlockUtils.class)
	public String testHelloSentinelV3() {
		busiService.doBusi();
		return "OK";
	}

}
