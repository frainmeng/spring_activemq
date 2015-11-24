/**
 * 
 */
package com.kalven.service;

import java.io.Serializable;

import com.kalven.service.mq.model.BaseMessage;
import com.kalven.service.mq.model.MqMessage;

/**
 * active��Ϣ����
 * @author kalven.meng
 *
 */
public interface MqService {
	/**
	 * �ύ��Ϣ
	 * @param destination Ŀ��
	 * @param messageObj ��Ϣ
	 */
	void send (MqMessage<? extends BaseMessage> messageObj);
	/**
	 * ������Ϣ
	 * @param message ��Ϣ
	 */
	void recieve(Object message);
	
	/**
	 * ���ղ�������Ӧ
	 * @param message ��Ϣ
	 * @param destination ��ӦĿ��
	 */
	void recieveAndResponse(Object message);
}

