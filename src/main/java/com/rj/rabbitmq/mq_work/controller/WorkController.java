package com.rj.rabbitmq.mq_work.controller;


import com.rj.rabbitmq.mq_work.work.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/work")
public class WorkController {
    @Autowired
    private Sender sender;

    @RequestMapping("/send")
    public String send(String msg) {
        sender.sendMessage(msg);
        return "ok";
    }
}
