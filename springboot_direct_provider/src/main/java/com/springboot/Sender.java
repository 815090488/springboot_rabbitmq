package com.springboot;



import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    private  AmqpTemplate rabbitAmqpTemplate;

    @Value("${mq.config.exchange}")
    private  String  exchange;
    @Value("${mq.config.queue.error.routing.key}")
    private  String routingkey;

    public  void send(String msg){

        this.rabbitAmqpTemplate.convertAndSend(this.exchange,this.routingkey,msg);
    }
}
