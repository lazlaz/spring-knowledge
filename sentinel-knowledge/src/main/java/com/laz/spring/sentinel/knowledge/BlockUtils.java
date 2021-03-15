package com.laz.spring.sentinel.knowledge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class BlockUtils {
	private static Logger log = LoggerFactory.getLogger(BlockUtils.class);
    public static String testHelloSentinelV3BlockMethod(BlockException e){
        log.info("testHelloSentinelV3方法被流控了");
        return "testHelloSentinelV3方法被流控了";
    }
}
