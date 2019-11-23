package com.rj.rabbitmq.mq_fanout.controller;


import com.rj.rabbitmq.mq_fanout.fanout.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fanout")
public class FanoutController {
    @Autowired
    private Sender sender;

    @RequestMapping("/send")
    public String send(String msg) {
        for (int i = 100; i > 0; i--) {
            sender.sendMessage(msg+i);
        }
        return "fanout发送成功";
    }
}
