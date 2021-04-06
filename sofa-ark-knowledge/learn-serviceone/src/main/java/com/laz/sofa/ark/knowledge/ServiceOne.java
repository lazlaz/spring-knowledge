package com.laz.sofa.ark.knowledge;

public class ServiceOne {
	public  void say() {
		MyDemo myDemo = new MyDemo();
		System.out.println("ServiceOne classloader="+this.getClass().getClassLoader());
		myDemo.test();
	}
}
