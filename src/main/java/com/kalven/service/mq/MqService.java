/**
 * 
 */
package com.kalven.service.mq;


import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * @author kalven.meng
 *
 */
@Service
public class MqService {
	@Autowired
	private JmsTemplate jmsTemplate; 
	
	public void sendMsg(String msg){
		jmsTemplate.send(session -> {
			return session.createTextMessage(msg);
		});
	}
	
	public String recieveMsg(String msg){
		System.out.println("Recieve message:" + msg);
		return msg;
	}
	
	public String recieveAndResponse(String msg){
		System.out.println("收到消息：" + msg);
		try {
			String respMsg = InetAddress.getLocalHost().getHostAddress();
			jmsTemplate.send(session -> {
				return session.createTextMessage(respMsg + "has receieve msg");
			});
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return msg;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(InetAddress.getLocalHost().getHostAddress());
	}
	
}
