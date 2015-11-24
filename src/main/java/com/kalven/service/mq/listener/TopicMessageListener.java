/**
 * 
 */
package com.kalven.service.mq.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.listener.adapter.AbstractAdaptableMessageListener;

import com.kalven.service.MqService;





/**
 * @author kalven.meng
 *
 */
public class TopicMessageListener extends AbstractAdaptableMessageListener {
	
	
	private MqService mqService;
	
	@Override
	public void onMessage(Message message, Session session) throws JMSException {
		// TODO Auto-generated method stub
		try {
			if (message instanceof TextMessage) {
				mqService.recieveAndResponse(((TextMessage)message).getText());
			} else if (message instanceof ObjectMessage ) {
				mqService.recieveAndResponse(message);
			}
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the mqService
	 */
	public MqService getMqService() {
		return mqService;
	}

	/**
	 * @param mqService the mqService to set
	 */
	public void setMqService(MqService mqService) {
		this.mqService = mqService;
	}

}
