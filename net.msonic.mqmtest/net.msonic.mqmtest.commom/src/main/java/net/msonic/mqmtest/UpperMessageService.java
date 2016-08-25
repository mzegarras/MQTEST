package net.msonic.mqmtest;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class UpperMessageService implements javax.jms.MessageListener {

	final Logger logger = Logger.getLogger(UpperMessageService.class);

	@Autowired
	@Qualifier("jmsQueueTemplate1")
	JmsTemplate jmsTemplate;

	@Override
	public void onMessage(Message msg) {

		if (msg instanceof TextMessage) {

			try {

				final String message = ((TextMessage) msg).getText().toUpperCase();
				final String correlationID = msg.getJMSCorrelationID();
				final String messageID = msg.getJMSMessageID();

				logger.info(message);
				logger.info(correlationID);
				logger.info(messageID);
				logger.info("====");

				jmsTemplate.send(msg.getJMSReplyTo(), new MessageCreator() {

					public Message createMessage(Session session) throws JMSException {
						// TODO Auto-generated method stub
						TextMessage textMessage = session.createTextMessage(message);
						textMessage.setJMSCorrelationID(correlationID);
						textMessage.setJMSMessageID(messageID);
						return textMessage;

					}
				});

			} catch (JMSException e) {
				logger.error("", e);
			}

		}
	}

}
