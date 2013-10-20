package com.inertia.solutions.producer.launcher;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Launcher {

	private static final String QUEUE_NAME = "TEST_QUEUE";

	public static void main(String[] args) throws IOException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection("localhost");
		
		Channel channel = connection.createChannel();
		channel.queueDeclare(1, QUEUE_NAME, false);
		
		channel.basicPublish(1, "", QUEUE_NAME, null, "test message 3".getBytes());
		channel.close(1, QUEUE_NAME);
		connection.close(1, QUEUE_NAME);
	}
}
