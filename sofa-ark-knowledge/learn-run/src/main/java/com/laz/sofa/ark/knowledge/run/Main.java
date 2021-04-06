package com.laz.sofa.ark.knowledge.run;

import java.net.URLClassLoader;

import com.alipay.sofa.ark.support.startup.SofaArkBootstrap;
import com.laz.sofa.ark.knowledge.ServiceOne;
import com.laz.sofa.ark.knowledge.ServiceTwo;

public class Main {
	static {
		System.out.println("---");
	}
	//打包运行java -jar learn-run-0.0.1-SNAPSHOT-executable-ark.jar看效果，能够加载两个版本的myjar,因为是不同的类加载器
	public static void main(String[] args) {
		System.out.println("Main classloader: " + Main.class.getClassLoader());
		SofaArkBootstrap.launch(args);
		System.out.println("---------------");
		System.out.println("Main classloader: " + Main.class.getClassLoader());
		System.out.println("---------------");
		
		new ServiceOne().say();
		new ServiceTwo().say();
	}
}
