package xyz.sandersonsa.amqbrokerspringbootstarterconsumerone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.beans.factory.annotation.Value;

@EnableJms
@SpringBootApplication
public class AmqBrokerSpringbootStarterConsumerOneApplication implements CommandLineRunner {
    
    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${app.springboot.queue}")
    private String destination;

    public static void main(String[] args) {
        SpringApplication.run(AmqBrokerSpringbootStarterConsumerOneApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        sendMessage("Hello World - Consumer One ... ");
    }

    public void sendMessage(String text) {
        System.out.println(String.format(" ## Sending '%s'", text));
        this.jmsTemplate.convertAndSend(destination, text);
    }

    @JmsListener(destination = "${app.springboot.queue}")
    public void receiveMessage(String text) {
        System.out.println(String.format(" ## Received Consumer One :: '%s'", text));
    }
}

