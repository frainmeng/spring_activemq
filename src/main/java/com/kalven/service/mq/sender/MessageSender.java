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
	 * ����java������Ϣ
	 * @param destinationName
	 * @param messageObj
	 */
	void send(String destinationName, Serializable messageObj);
	/**
	 * �����ַ�������Ϣ
	 * @param destinationName
	 * @param message
	 */
	void send(String destinationName, String message);
}
