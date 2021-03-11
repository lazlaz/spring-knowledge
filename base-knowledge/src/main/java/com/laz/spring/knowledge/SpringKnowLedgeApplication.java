package com.laz.spring.knowledge;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.laz.spring.knowledge.config.ConfigBean;

@SpringBootApplication
@EnableTransactionManagement
public class SpringKnowLedgeApplication {


	public static void main(String[] args) throws Exception {
		// System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
		// "D:\\class");
		ConfigurableApplicationContext context = SpringApplication.run(SpringKnowLedgeApplication.class, args);
//		String[] beans = context.getBeanDefinitionNames();
//		for (String beanName : beans) {
//			Class<?> beanType = context.getType(beanName);
//			System.out.println("BeanName:" + beanName);
//			System.out.println("Bean的类型：" + beanType);
//			Mapper mapper = beanType.getAnnotation(Mapper.class);
//			if (mapper != null) {
//				System.out.println("FactoryBean：" + context.getBean("&" + beanName));
//			}
//			System.out.println("Bean所在的包：" + beanType.getPackage());
//			System.out.println("Bean：" + context.getBean(beanName));
//		}
		while (true) {
			ConfigBean config = context.getBean(ConfigBean.class);
			config.getConfig();
			Thread.sleep(1000);
		}
	}

}
