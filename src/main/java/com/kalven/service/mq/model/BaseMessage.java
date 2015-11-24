/**
 * 
 */
package com.kalven.service.mq.model;

import java.io.Serializable;

/**
 * @author kalven.meng
 *
 */
public class BaseMessage implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7234937305041742463L;
	
	public BaseMessage(String messageContent) {
		this.messageContent = messageContent;
	}
	public BaseMessage() {}

	private String messageContent;

	/**
	 * @return the messageContent
	 */
	public String getMessageContent() {
		return messageContent;
	}

	/**
	 * @param messageContent the messageContent to set
	 */
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	
}
