package com.obank.fop.fast1.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
@RabbitListener(queues = "helloQueue")
public class HelloReceiver1 {
    @Autowired
    private JedisPool jedisPool;
    @RabbitHandler
    public void process(String hello) {
        Jedis   resource = jedisPool.getResource();
        Integer reminder = Integer.valueOf(resource.get("reminder"));
        if (0 == reminder) {
            System.out.println("there is no more goods!");
        } else {
            Integer i = reminder - 1;
            resource.set("reminder",i.toString());
        }
        System.out.println("Receiver1 : "+hello);
        resource.close();
    }
}
