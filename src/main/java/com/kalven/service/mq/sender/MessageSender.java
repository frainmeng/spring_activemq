/**
 * 
 */
package com.kalven.service.mq.sender;

import java.io.Serializable;

/**
 * @author kalven.meng
 *
 */
public interface MessageSender {
	/**
	 * 发送java对象消息
	 * @param destinationName
	 * @param messageObj
	 */
	void send(String destinationName, Serializable messageObj);
	/**
	 * 发送字符串下消息
	 * @param destinationName
	 * @param message
	 */
	void send(String destinationName, String message);
}
