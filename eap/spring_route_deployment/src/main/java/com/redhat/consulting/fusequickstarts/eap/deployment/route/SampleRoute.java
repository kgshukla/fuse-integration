package com.redhat.consulting.fusequickstarts.eap.deployment.route;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.springframework.stereotype.Component;

import com.redhat.consulting.fusequickstarts.eap.deployment.processor.RequestProcessor;
import com.redhat.consulting.fusequickstarts.eap.deployment.processor.XMLProcessor;

/*
 * The Annotations below are required for Spring to find and start the Camel Route.
 */
@Component
public class SampleRoute extends RouteBuilder {

	private final RequestProcessor requestProcessor = new RequestProcessor();
	private final XMLProcessor xmlProcessor = new XMLProcessor();
	
	/**
	@Resource(mappedName = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;
	*/
	
    @Override
    public void configure() throws Exception {
    	
    	/**
    	JmsComponent component = new JmsComponent();
    	component.setConnectionFactory(connectionFactory);
    	**/
    	
    	 from("timer://myEapTimer?fixedRate=true&period=10000")
         .process(requestProcessor)
         .to("cxfrs://bean://rsClient")
         .process(xmlProcessor)
         .log("Setting message to queue: ${body}");
    	 
    	 /**
         .to("jms:queue:eapJmsTestQueue?clientId=eapJmsProducerRoute");
    	 
    	 from("jms:queue:eapJmsTestQueue?clientId=eapJmsConsumerRoute")
    	 .routeId("eapJmsConsumer")
    	 .setBody().simple("Received Message: ${body}")
    	 .log("Getting message from queue: ${body}");
    	 **/
    	 

    }

}
