package com.training.ykb;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {


    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "notf_q", durable = "true", autoDelete = "false"),
                                             exchange = @Exchange(name = "noft_direct_exc",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "notf_req"))
    @SendTo("noft_direct_res_exc/notf_res")
    public String handleEventXYZ(final NotificationObj no) {
        System.out.println("incoming str : " + no);
        return "Incoming : " + no + "handled";
    }

}
