package br.edu.fafic.rabbitmqexemplo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitMqExemploApplication {

    static Logger logger = LoggerFactory.getLogger(RabbitMqExemploApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqExemploApplication.class, args);
    }

}
