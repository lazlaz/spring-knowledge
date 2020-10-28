package com.laz.spring.rocket.mq.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.laz.spring.rocket.mq.message.Demo02Message;

@Component
@RocketMQMessageListener(
        topic = Demo02Message.TOPIC,
        consumerGroup = "demo02-consumer-group-" + Demo02Message.TOPIC
)
public class Demo02Consumer implements RocketMQListener<Demo02Message> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onMessage(Demo02Message message) {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }

}
