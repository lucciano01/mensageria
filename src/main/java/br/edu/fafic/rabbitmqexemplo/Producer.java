package br.edu.fafic.rabbitmqexemplo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {

    static Logger logger
            = LoggerFactory.getLogger(Producer.class);

    private final static String QUEUE_NAME = "queue-a";

    public  static void main(String[] argv)
            throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.2.238");
        factory.setUsername("luciano");
        factory.setPassword("luciano");
        factory.setPort(5672);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,
                true,
                false,
                false,
                null);
        String message = "Enviando de outro PC!";
        channel.basicPublish("",
                QUEUE_NAME,
                null,
                message.getBytes("UTF-8"));
        logger.debug("Mensagem enviada ao RabbitMQ '" + message + "'");
        channel.close();
        connection.close();
    }
}
