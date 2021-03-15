package com.laz.spring.sentinel.knowledge.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.laz.spring.sentinel.knowledge.service.BusiServiceImpl;
@RestController
public class HelloWorldSentinelController {
	private Logger log = LoggerFactory.getLogger(HelloWorldSentinelController.class);
    @Autowired
    private BusiServiceImpl busiService;

    /**
     * 初始化流控规则
     */
    @PostConstruct
    public void init() {

        List<FlowRule> flowRules = new ArrayList<>();

        /**
         * 定义 helloSentinelV1 受保护的资源的规则
         */
        //创建流控规则对象
        FlowRule flowRule = new FlowRule();
        //设置流控规则 QPS
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //设置受保护的资源
        flowRule.setResource("helloSentinelV1");
        //设置受保护的资源的阈值
        flowRule.setCount(1);

        flowRules.add(flowRule);

        //加载配置好的规则
        FlowRuleManager.loadRules(flowRules);
    }


    /**
     * 频繁请求接口 http://localhost:8080/helloSentinelV1
     * 这种做法的缺点:
     * 1)业务侵入性很大,需要在你的controoler中写入 非业务代码..
     * 2)配置不灵活 若需要添加新的受保护资源 需要手动添加 init方法来添加流控规则
     * @return
     */
    @RequestMapping("/helloSentinelV1")
    public String testHelloSentinelV1() {

        Entry entity =null;
        //关联受保护的资源
        try {
            entity = SphU.entry("helloSentinelV1");
            //开始执行 自己的业务方法
            busiService.doBusi();
            //结束执行自己的业务方法
        } catch (BlockException e) {
            log.info("testHelloSentinelV1方法被流控了");
            return "testHelloSentinelV1方法被流控了";
        }finally {
            if(entity!=null) {
                entity.exit();
            }
        }
        return "OK";
    }

}
