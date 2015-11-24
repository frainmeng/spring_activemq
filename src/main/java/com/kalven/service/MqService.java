/**
 * 
 */
package com.kalven.service;

import java.io.Serializable;

import com.kalven.service.mq.model.BaseMessage;
import com.kalven.service.mq.model.MqMessage;

/**
 * active消息服务
 * @author kalven.meng
 *
 */
public interface MqService {
	/**
	 * 提交消息
	 * @param destination 目标
	 * @param messageObj 消息
	 */
	void send (MqMessage<? extends BaseMessage> messageObj);
	/**
	 * 接收消息
	 * @param message 消息
	 */
	void recieve(Object message);
	
	/**
	 * 接收并返回响应
	 * @param message 消息
	 * @param destination 响应目标
	 */
	void recieveAndResponse(Object message);
}

