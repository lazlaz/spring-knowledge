package com.laz.spring.rocket.mq.message;

public class Demo02Message {
	public static final String TOPIC = "DEMO_02";

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
