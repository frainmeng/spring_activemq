/**
 * 
 */
package com.kalven.service.mq.sender.imp;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jms.core.support.JmsGatewaySupport;

import com.kalven.service.mq.sender.MessageSender;

/**
 * activeMqÏûÏ¢·¢ËÍÆ÷
 * 
 * @author kalven.meng
 *
 */
public class MessageSenderImp extends JmsGatewaySupport implements
		MessageSender {
	private static final String PUB_SUB_DOMAIN_CONST_PRIFIX = "TP_PUB_SUB";
	
	@Override
	public void send(String destinationName, Serializable messageObj) {
		// TODO Auto-generated method stub
		if (StringUtils.isNotEmpty(destinationName)) {
			if (destinationName.startsWith(PUB_SUB_DOMAIN_CONST_PRIFIX)) 
				 getJmsTemplate().setPubSubDomain(true);
			else 
				getJmsTemplate().setPubSubDomain(false);
			getJmsTemplate().send(destinationName, session -> session.createObjectMessage(messageObj));
		}
		
	}

	@Override
	public void send(String destinationName, String message) {
		// TODO Auto-generated method stub
		if (StringUtils.isNotEmpty(destinationName)) {
			if (destinationName.startsWith(PUB_SUB_DOMAIN_CONST_PRIFIX)) 
				 getJmsTemplate().setPubSubDomain(true);
			else 
				getJmsTemplate().setPubSubDomain(false);
			getJmsTemplate().send(destinationName, session -> session.createTextMessage(message));
		}
	}

}
