package com.laz.spring.rocket.mq.test;

import java.util.concurrent.CountDownLatch;

import org.apache.rocketmq.client.producer.SendResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.laz.spring.rocket.mq.RocketMqApplication;
import com.laz.spring.rocket.mq.producer.Demo07Producer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RocketMqApplication.class)
public class Demo07ProducerTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Demo07Producer producer;

    @Test
    public void testSendMessageInTransaction() throws InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);
        SendResult result = producer.sendMessageInTransaction(id);
        logger.info("[testSendMessageInTransaction][发送编号：[{}] 发送结果：[{}]]", id, result);

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

}
