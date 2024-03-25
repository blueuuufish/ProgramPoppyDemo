package com.programpoppy.programpoppyrabbitmq.test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class rabbitDEMO {
    public static void main(String[] args) throws IOException, TimeoutException {
    //1 创建连接工厂
    ConnectionFactory connectionFactory=new ConnectionFactory();
    //2 设置rabbitmq  ip地址
    connectionFactory.setHost("localhost");
    //3 创建连接对象   Conection对象
    Connection connection=connectionFactory.newConnection();
    //4 创建管道  Chanel
    Channel channel=connection.createChannel();
    //5 设置队列属性
    /*
     * 第一个参数:队列的名称
     * 第二个参数:队列是否要持久化
     * 第三个参数:是否排他性(是否在同一个Connection,如果设置为true,不同的Connection是获得不到消息的)
     * 第四个参数:是否自动删除消息
     * 第五个参数:是否要设置一些额外的参数
     */
    channel.queueDeclare("01-hello",false,false,false,null);
    //6 发送消息
    /*
     * 第一个参数:交换机名称 没有交换机就设置""
     * 第二个参数:路由key
     * 第三个参数:消息属性
     * 第四个参数:消息内容
     */
    channel.basicPublish("","01-hello",null, "hello-rabbitMQ".getBytes(StandardCharsets.UTF_8));
    //7 关闭消息
    //channel.close();
    connection.close();
}
}
