// package xyz.sandersonsa.amqbrokerspringbootstarterconsumerone.config;

// import javax.jms.ConnectionFactory;
// import javax.jms.Session;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
// import org.springframework.jms.config.JmsListenerContainerFactory;

// @Configuration
// public class Config {
    
//     @Bean
//     public JmsListenerContainerFactory<?> jmsContainerFactory(ConnectionFactory connectionFactory) {
//         DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//         factory.setPubSubDomain(false);
//         factory.setConnectionFactory(connectionFactory);
//         factory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
//         //factory.setSubscriptionDurable(true);
//         // factory.setClientId(env.getProperty("jms.client.id:thinkbig.feedmgr"));
//         // factory.setConcurrency("1-1");
//         factory.setConnectionFactory(connectionFactory);
//         // factory.setMessageConverter(new SimpleMessageConverter());
//         factory.setSessionTransacted(true);
//         return factory;
//     }
// }