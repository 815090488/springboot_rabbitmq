package com.springboot;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 消息接收者
 * @RabbitListener：bindings：绑定队列
 * @QueueBinding: value:绑定队列名称
 *                exchange：配置交换器
 *                key：路由键
 * @Queue ：value：配置队列名称
 *          autoDelete：是否是一个可删除的临时队列
 *
 * @Exchange：  value：交换器起个名字
 *             type：指定具体的交换器类型
 */
@Component
@RabbitListener(
      bindings = @QueueBinding(
              value = @Queue(value = "${mq.config.queue.error}",autoDelete = "true"),
              exchange = @Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.DIRECT),
              key = "${mq.config.queue.error.routing.key}"
      )
)
public class ErrorReceive {

    @RabbitHandler
    public  void process(String msg){
        System.out.println("error.....Receive"+msg);

    }
}
