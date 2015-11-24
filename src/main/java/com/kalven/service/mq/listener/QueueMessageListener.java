/**
 * 
 */
package com.kalven.service.mq.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
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
public class QueueMessageListener implements MessageListener {
	
	private MqService mqService;

	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		
		try {
			if (message instanceof ObjectMessage ) {
				mqService.recieve(message);
			} else if (message instanceof TextMessage) {
				mqService.recieve(((TextMessage)message).getText());
				
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
