package com.laz.spring.sentinel.knowledge;

import java.util.Properties;
import java.util.concurrent.Executor;

import org.junit.jupiter.api.Test;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

public class ConfigExample {
	@Test
	public void test2() throws Exception {
		String serverAddr = "localhost";
		String dataId = "badger-spring-cloud-alibaba-config-client";
		String group = "DEFAULT_GROUP";
		Properties properties = new Properties();
		properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
		properties.put(PropertyKeyConst.USERNAME, "nacos");
		properties.put(PropertyKeyConst.PASSWORD, "nacos");
		ConfigService configService = NacosFactory.createConfigService(properties);
		String content = configService.getConfig(dataId, group, 5000);
	}
	@Test
	public void test1() throws Exception {
		String serverAddr = "localhost";
		String dataId = "badger-spring-cloud-alibaba-config-client";
		String group = "DEFAULT_GROUP";
		Properties properties = new Properties();
		properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
		properties.put(PropertyKeyConst.USERNAME, "nacos");
		properties.put(PropertyKeyConst.PASSWORD, "nacos");
		ConfigService configService = NacosFactory.createConfigService(properties);
		String content = configService.getConfig(dataId, group, 5000);
		System.out.println(content);
		configService.addListener(dataId, group, new Listener() {
			@Override
			public void receiveConfigInfo(String configInfo) {
				System.out.println("recieve:" + configInfo);
			}

			@Override
			public Executor getExecutor() {
				return null;
			}
		});
		Thread.sleep(50000000);
//		boolean isPublishOk = configService.publishConfig(dataId, group, "content");
//		System.out.println(isPublishOk);
//
//		Thread.sleep(3000);
//		content = configService.getConfig(dataId, group, 5000);
//		System.out.println(content);
//
//		boolean isRemoveOk = configService.removeConfig(dataId, group);
//		System.out.println(isRemoveOk);
//		Thread.sleep(3000);
//
//		content = configService.getConfig(dataId, group, 5000);
//		System.out.println(content);
//		Thread.sleep(300000);
	}
}
