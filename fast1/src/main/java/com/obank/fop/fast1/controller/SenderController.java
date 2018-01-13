package com.obank.fop.fast1.controller;

import com.obank.fop.fast1.mq.HelloSender1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RestController
public class SenderController {
    @Autowired
    private HelloSender1 helloSender1;

    @RequestMapping(method = RequestMethod.GET, value = "/send")
    public Object send() {
        helloSender1.send();
        return "success";
    }

}
