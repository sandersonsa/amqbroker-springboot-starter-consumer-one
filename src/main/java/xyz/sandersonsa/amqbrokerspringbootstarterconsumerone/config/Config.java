// package xyz.sandersonsa.amqbrokerspringbootstarterconsumerone.config;

// import javax.jms.ConnectionFactory;
// import javax.jms.Session;

// import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
// import org.springframework.jms.config.JmsListenerContainerFactory;
// import org.springframework.jms.connection.JmsTransactionManager;
// import org.springframework.transaction.PlatformTransactionManager;

// @Configuration
// public class Config {

//         @Bean
//     public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
//             DefaultJmsListenerContainerFactoryConfigurer configurer) {
//         DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
//         defaultJmsListenerContainerFactory.setTransactionManager(jmsTransactionManager(connectionFactory));
//         defaultJmsListenerContainerFactory.setSessionTransacted(true);
//         defaultJmsListenerContainerFactory.setSessionAcknowledgeMode(Session.SESSION_TRANSACTED);
//         configurer.configure(defaultJmsListenerContainerFactory, connectionFactory);
//         return defaultJmsListenerContainerFactory;
//     }

//     @Bean
//     public PlatformTransactionManager jmsTransactionManager(ConnectionFactory connectionFactory) {
//         return new JmsTransactionManager(connectionFactory);
//     }
    
// //     @Bean
// //     public JmsListenerContainerFactory<?> jmsContainerFactory(ConnectionFactory connectionFactory) {
// //         DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
// //         factory.setPubSubDomain(false);
// //         factory.setConnectionFactory(connectionFactory);
// //         factory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
// //         //factory.setSubscriptionDurable(true);
// //         // factory.setClientId(env.getProperty("jms.client.id:thinkbig.feedmgr"));
// //         // factory.setConcurrency("1-1");
// //         factory.setConnectionFactory(connectionFactory);
// //         // factory.setMessageConverter(new SimpleMessageConverter());
// //         factory.setSessionTransacted(true);
// //         return factory;


// //         factory.setConnectionFactory(this.connectionFactory);
// //         factory.setDestinationResolver(this.destinationResolver);
// //         factory.setMessageConverter(this.messageConverter);
// //         factory.setSessionTransacted(true);
// //         factory.setSessionAcknowledgeMode(Session.DUPS_OK_ACKNOWLEDGE);
// //         factory.setPubSubDomain(true);
// //         factory.setReplyPubSubDomain(true);
// //         factory.setReplyQosSettings(new QosSettings(1, 7, 5000));
// //         factory.setSubscriptionDurable(true);
// //         factory.setClientId("client-1234");
// //         factory.setAutoStartup(false);
// //     }
// }
