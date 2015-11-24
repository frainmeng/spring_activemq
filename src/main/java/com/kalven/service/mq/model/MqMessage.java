/**
 * 
 */
package com.kalven.service.mq.model;

/**
 * @author kalven.meng
 *
 */
public class MqMessage<T> {
	
	public static final String MSG_TYPE_STR = "00";
	public static final String MSG_TYPE_OBJ = "01";
	
	public MqMessage(String msgType, T messageObj) {
		this.msgType = msgType;
		this.messageObj = messageObj;
	}
	public MqMessage(){}
	/**
	 * 消息类型:
	 * 字符串:00
	 * 序列化:01
	 */
	private String msgType;
	/**
	 * 消息内容
	 */
	private T messageObj;
	/**
	 * @return the msgType
	 */
	public String getMsgType() {
		return msgType;
	}
	/**
	 * @param msgType the msgType to set
	 */
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	/**
	 * @return the messageObj
	 */
	public T getMessageObj() {
		return messageObj;
	}
	/**
	 * @param messageObj the messageObj to set
	 */
	public void setMessageObj(T messageObj) {
		this.messageObj = messageObj;
	}
	
}
