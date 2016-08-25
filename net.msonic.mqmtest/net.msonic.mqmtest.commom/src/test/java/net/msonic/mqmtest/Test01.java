package net.msonic.mqmtest;

import static org.junit.Assert.*;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/test/resources/spring/applicationContext-test01.xml" })
public class Test01 {
	
	final static Logger logger = Logger.getLogger(Test01.class);
	
	@Autowired
	@Qualifier("jmsQueueTemplate1")
	JmsTemplate jmsTemplate1;

	@Autowired
	@Qualifier("jmsQueueTemplate2")
	JmsTemplate jmsTemplate2;

	@Value("${queue_reply}")
	public String queue_reply;

	@Before
	public void setUp() {
		BasicConfigurator.configure();
	}

	@Test
	public void sanity() {
		assertNotNull(jmsTemplate1);
	}

	@Test
	@Ignore
	public void sendMessageSimple() {
		
		
		
		jmsTemplate1.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				TextMessage message = session.createTextMessage(String.format("Message01"));
				return message;
			}
		});

		assertTrue("sendMessageSimple", true);
	}

	@Test
	@Ignore
	public void sendMessageReplyToQ() {

		jmsTemplate1.send(new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {

				TextMessage message = session.createTextMessage(String.format("Message02"));

				Queue queue = session.createQueue(queue_reply);
				message.setJMSReplyTo(queue);

				return message;
			}
		});
		assertTrue("sendMessageReplyToQ", true);
	}

	@Test
	public void sendMessageCorrelationId() throws JMSException {
			
		final String currentCorrId = createCorrelationId("T");
		
		jmsTemplate2.send(new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {

				// TODO Auto-generated method stub
				
				TextMessage message = session.createTextMessage(String.format("Message03"));
				Queue queue = session.createQueue(queue_reply);
				message.setJMSReplyTo(queue);
				message.setJMSCorrelationID(currentCorrId);

				return message;
			}
		});
		
		
		Message m1 = jmsTemplate2.receiveSelected("JMSCorrelationID='" + currentCorrId + "'");
		String message1 = ((TextMessage) m1).getText();
		logger.info("=====");
		logger.info(message1);
		logger.info("=====");
		
		assertTrue("sendMessageCorrelationId", true);
	}

	private static final char[] CORRELATTION_ID_PADDING = { '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0',
			'0', '0', '0' };

	public String createCorrelationId(final String prefix) {
		String index = Long.toHexString(System.currentTimeMillis());
		StringBuilder id = new StringBuilder(prefix);
		id.append(CORRELATTION_ID_PADDING, 0, 16 - index.length());
		id.append(index);
		return id.toString();
	}
}
