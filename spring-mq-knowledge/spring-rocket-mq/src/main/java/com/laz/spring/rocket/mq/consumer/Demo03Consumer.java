package com.laz.spring.rocket.mq.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.laz.spring.rocket.mq.message.Demo03Message;

@Component
@RocketMQMessageListener(
        topic = Demo03Message.TOPIC,
        consumerGroup = "demo03-consumer-group-" + Demo03Message.TOPIC
)
public class Demo03Consumer implements RocketMQListener<Demo03Message> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onMessage(Demo03Message message) {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }

}