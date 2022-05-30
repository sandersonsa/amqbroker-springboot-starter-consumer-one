package xyz.sandersonsa.amqbrokerspringbootstarterconsumerone.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListenerConfigurer;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerEndpointRegistrar;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;
import javax.jms.Session;

@EnableJms
@Configuration
@SuppressWarnings("SpringJavaAutowiringInspection")
public class AmqConfig implements JmsListenerConfigurer {

    // public static final String ORDER_QUEUE = "order-queue";

    @Autowired
    private ConnectionFactory connectionFactory;

    @Override
    public void configureJmsListeners(JmsListenerEndpointRegistrar registrar) {
        registrar.setContainerFactory(containerFactory());
    }

    @Bean
    public JmsListenerContainerFactory<?> containerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setErrorHandler(new DefaultErrorHandler());
        factory.setMessageConverter(messageConverter());
        //Importante
        factory.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);
        factory.setSessionTransacted(true);
        return factory;
    }

    @Bean
    public MessageConverter messageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

}
