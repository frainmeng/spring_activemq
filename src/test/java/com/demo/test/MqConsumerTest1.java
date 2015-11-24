/**
 * 
 */
package com.demo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kalven.service.mq.MqService;

/**
 * @author kalven.meng
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/applicationContext.xml",
								"classpath:/applicationContext_mq_consumer1.xml"})
public class MqConsumerTest1 extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private MqService service;
	
	@Test
	public void testMain () {
		try {
			Thread.currentThread().sleep(1000*10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 获取实例对象from spring's applicationContext
	 * @param type
	 * @return
	 */
	public <T> T getBean(Class<T> type) {
        return applicationContext.getBean(type);
    }
}
