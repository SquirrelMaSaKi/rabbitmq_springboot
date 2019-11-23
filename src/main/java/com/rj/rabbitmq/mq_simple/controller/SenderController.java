package com.rj.rabbitmq.mq_simple.controller;


import com.rj.rabbitmq.mq_simple.simple.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sender")
public class SenderController {
    @Autowired
    private Sender sender;

    @RequestMapping("/simple")
    public String simple(String eatmsg, String drinkmsg) {
        sender.sendMessage(eatmsg, drinkmsg);
        return "发送成功";
    }
}
