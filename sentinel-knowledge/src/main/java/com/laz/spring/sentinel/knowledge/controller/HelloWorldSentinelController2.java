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
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.laz.spring.sentinel.knowledge.service.BusiServiceImpl;
@RestController
public class HelloWorldSentinelController2 {
	private Logger log = LoggerFactory.getLogger(HelloWorldSentinelController2.class);
    @Autowired
    private BusiServiceImpl busiService;
    
    public HelloWorldSentinelController2() {
	
	}

    /**
     * 初始化流控规则
     */
    @PostConstruct
    public void init() {

        List<FlowRule> flowRules = new ArrayList<>();

        /**
         * 定义 helloSentinelV2 受保护的资源的规则
         */
        //创建流控规则对象
        FlowRule flowRule2 = new FlowRule();
        //设置流控规则 QPS
        flowRule2.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //设置受保护的资源
        flowRule2.setResource("helloSentinelV2");
        //设置受保护的资源的阈值
        flowRule2.setCount(1);

        flowRules.add(flowRule2);
    }

    /**
     * 频繁请求接口 http://localhost:8080/helloSentinelV2
     * 优点: 需要配置aspectj的切面SentinelResourceAspect ,添加注解@SentinelResource
     *     解决了v1版本中 sentinel的业务侵入代码问题,通过blockHandler指定被流控后调用的方法.
     * 缺点: 若我们的controller中的方法逐步变多,那么受保护的方法也越来越多，会导致一个问题
     * blockHandler的方法也会越来越多   引起方法急剧膨胀 怎么解决
     *
     * 注意点:
     *   blockHandler 对应处理 BlockException 的函数名称，
     *   可选项。blockHandler 函数访问范围需要是 public，返回类型需要与原方法相匹配，
     *   参数类型需要和原方法相匹配并且最后加一个额外的参数，
     *   类型为 BlockException。blockHandler 函数默认需要和原方法在同一个类中
     * @return
     */
    @RequestMapping("/helloSentinelV2")
    @SentinelResource(value = "helloSentinelV2",blockHandler ="testHelloSentinelV2BlockMethod")
    public String testHelloSentinelV2() {
    	System.out.println(this);
        busiService.doBusi();
        return "OK";
    }

    public String testHelloSentinelV2BlockMethod(BlockException e) {
        log.info("testRt流控");
        return "testRt降级 流控...."+e;
    }

}
