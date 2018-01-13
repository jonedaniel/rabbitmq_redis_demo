package com.obank.fop.fast1.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Date;

@Component
public class HelloSender1 implements RabbitTemplate.ConfirmCallback {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private JedisPool      jedisPool;

    public void send() {
        Jedis   resource = jedisPool.getResource();
        Integer reminder = Integer.valueOf(resource.get("reminder"));
        String  sendMsg  = "hello1 " + new Date().toLocaleString() + ",goods code:" + reminder;
        System.out.println("Sender1 : " + sendMsg);
        rabbitTemplate.convertAndSend("helloQueue", sendMsg);
    }


    /**
     * 回调
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println(" 回调id:" + correlationData);
        if (ack) {
            System.out.println("消息成功消费");
        } else {
            System.out.println("消息消费失败:" + cause);
        }
    }
}
