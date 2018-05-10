package com.redhat.consulting.fusequickstarts.eap.deployment.processor;

import javax.ws.rs.core.Response;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.cxf.message.MessageContentsList;

public class XMLProcessor implements Processor {
	
	 public void process(Exchange exchange) throws Exception {
	        exchange.setPattern(ExchangePattern.InOut);
	        Message inMessage = exchange.getIn();
	        String xmlData = (String) inMessage.getBody();
	        
	        // TODO - massage the data
	        String transformedData = xmlData;
	        
	        // pass this message out
	        exchange.getOut().setBody(transformedData);
	 }
}
