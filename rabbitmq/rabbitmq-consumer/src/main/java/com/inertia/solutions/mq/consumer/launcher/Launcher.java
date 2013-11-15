package com.inertia.solutions.mq.consumer.launcher;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownSignalException;

public class Launcher {

	private static final String QUEUE_NAME = "TEST_QUEUE";

	public static void main(String[] args) throws IOException, InterruptedException, ShutdownSignalException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection("localhost");
		
		Channel channel = connection.createChannel();
		channel.queueDeclare(1, QUEUE_NAME, false);
		
		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(1, QUEUE_NAME, consumer);
		
		System.out.println("listening for messages");
		while(true) {
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());
			System.out.println(" [x] Received '" + message + "'");
		}
		
	}
	
}   
