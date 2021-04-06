package com.laz.sofa.ark.knowledge;

public class ServiceTwo {
	public  void say() {
		MyDemo myDemo = new MyDemo();
		System.out.println("ServiceTwo classloader="+this.getClass().getClassLoader());
		myDemo.test();
	}
}
