package xyz.sandersonsa.amqbrokerspringbootstarterconsumerone;

import javax.jms.JMSException;
import javax.management.JMException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import xyz.sandersonsa.amqbrokerspringbootstarterconsumerone.config.JmsProcessingException;

import org.springframework.beans.factory.annotation.Value;

@EnableJms
@SpringBootApplication
@Slf4j
public class AmqBrokerSpringbootStarterConsumerOneApplication implements CommandLineRunner {
    
    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${app.springboot.queue}")
    private String destination;

	@Value("${app.springboot.consumer.number}")
    private String consumerNumber;

    public static void main(String[] args) {
        SpringApplication.run(AmqBrokerSpringbootStarterConsumerOneApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        sendMessage("Hello World - Consumer One ... ");
    }

    public void sendMessage(String text) {
        log.info(String.format(" ## Sending '%s'", text));
        this.jmsTemplate.convertAndSend(destination, text);
    }

    @JmsListener(destination = "${app.springboot.queue}")
    public void receiveMessage(String text) throws Exception {
        log.info(String.format(" ## Received Consumer - %s :: '%s'", consumerNumber, text));
        // Lançar ERROR
        // throw new JmsProcessingException("problem occurred while processing message.");
    }
}

