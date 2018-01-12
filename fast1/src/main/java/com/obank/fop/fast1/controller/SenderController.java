package com.obank.fop.fast1.controller;

import com.obank.fop.fast1.mq.HelloSender1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SenderController {
    @Autowired
    private HelloSender1 helloSender1;

    @RequestMapping(method = RequestMethod.GET, value = "/send")
    public Object send() {
        helloSender1.send();
        return true;
    }

}
