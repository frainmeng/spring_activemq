/**
 * 
 */
package com.kalven.service.imp;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

import com.kalven.service.MqService;
import com.kalven.service.mq.model.BaseMessage;
import com.kalven.service.mq.model.MqMessage;
import com.kalven.service.mq.sender.MessageSender;

/**
 * @author kalven.meng
 *
 */

public class MqServiceImp implements MqService {
	private static final int SERVICE_ID = Math.abs(new Random().nextInt());
	
	/**
	 * ��Ϣ������
	 */
	private MessageSender messageSender;
	/**
	 * �ύ��Ϣ��Ŀ��
	 */
	private String destination;
	/**
	 * ������Ϣ�󣬶�Ӧ����Ӧ��ϢĿ��
	 */
	private String respDestination;
	
	@Override
	public void send(MqMessage<? extends BaseMessage> mqMessage) {
		// TODO Auto-generated method stub
		if (null != mqMessage) {
			this.send(destination, mqMessage);
		} else {
			//��ϢΪ��
			
		}
	}

	@Override
	public void recieve(Object message) {
		// TODO Auto-generated method stub
		if (message instanceof String) {
			System.out.println("["+SERVICE_ID+"]�յ���Ϣ��"+ message.toString());
		} else if (message instanceof BaseMessage) {
			System.out.println("["+SERVICE_ID+"]�յ���Ϣ��"+ ((BaseMessage)message).getMessageContent());
		}
	}

	@Override
	public void recieveAndResponse(Object message) {
		// TODO Auto-generated method stub
		recieveAndResponse(message, generateResponseMsg());
	}

	/**
	 * �ύ��Ϣ
	 * @param destination
	 * @param mqMessage
	 */
	private void send(String destination, MqMessage<? extends BaseMessage> mqMessage) {
		if (mqMessage.getMsgType().equals(MqMessage.MSG_TYPE_STR)) {
			messageSender.send(destination, mqMessage.getMessageObj().getMessageContent() );
		} else {
			messageSender.send(destination, mqMessage.getMessageObj());
		} 
	}
	
	/**
	 * ���ղ�������Ӧ
	 * @param message
	 * @param respMessageObj
	 */
	private void recieveAndResponse(Object message,MqMessage<? extends BaseMessage> respMessageObj) {
		// TODO Auto-generated method stub
		if (message instanceof String) {
			System.out.println("["+SERVICE_ID+"]�յ���Ϣ��"+ message.toString());
		} else if (message instanceof BaseMessage) {
			System.out.println("["+SERVICE_ID+"]�յ���Ϣ��"+ ((BaseMessage)message).getMessageContent());
		}
		this.send(respDestination, respMessageObj);
	}
	
	/**
	 * ������Ӧ��Ϣ
	 * @return
	 */
	private MqMessage<? extends BaseMessage> generateResponseMsg(){
		StringBuilder respMsgContesnt = new StringBuilder();
		respMsgContesnt.append("[");
		respMsgContesnt.append(SERVICE_ID);
		respMsgContesnt.append("](");
		try {
			respMsgContesnt.append(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		respMsgContesnt.append("] had recieved response message");
		MqMessage<BaseMessage> mqMsg = new MqMessage<BaseMessage>(MqMessage.MSG_TYPE_STR, 
				new BaseMessage(respMsgContesnt.toString()));
		return mqMsg;
	}
	
	/**
	 * @return the messageSender
	 */
	public MessageSender getMessageSender() {
		return messageSender;
	}

	/**
	 * @param messageSender the messageSender to set
	 */
	public void setMessageSender(MessageSender messageSender) {
		this.messageSender = messageSender;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the respDestination
	 */
	public String getRespDestination() {
		return respDestination;
	}

	/**
	 * @param respDestination the respDestination to set
	 */
	public void setRespDestination(String respDestination) {
		this.respDestination = respDestination;
	}



}
