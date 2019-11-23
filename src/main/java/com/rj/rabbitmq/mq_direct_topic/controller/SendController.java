package com.rj.rabbitmq.mq_direct_topic.controller;

import com.rj.rabbitmq.mq_direct_topic.direct_topic.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dt")
public class SendController {
    @Autowired
    private Sender sender;

    @RequestMapping("/send")
    public String sendMessage(String msg) {
        for (int i = 100; i > 0; i--) {
            sender.send(msg+i);
        }
        return "direct发送完毕";
    }

    @RequestMapping("/send2/{rometingkey}/{msg}")
    public String sendMessage2(@PathVariable("rometingkey") String rometingkey, @PathVariable("msg") String msg) {
        for (int i = 100; i > 0; i--) {
            sender.send2(rometingkey,msg+i);
        }
        return "topic发送完毕";
    }
}
