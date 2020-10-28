package com.laz.spring.rocket.mq.message;

public class Demo01Message {

	public static final String TOPIC = "DEMO_01";

	/**
	 * 编号
	 */
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}