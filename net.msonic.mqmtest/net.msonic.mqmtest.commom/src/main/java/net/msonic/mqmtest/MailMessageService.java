package net.msonic.mqmtest;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Transactional(propagation=Propagation.REQUIRES_NEW)
public class MailMessageService implements javax.jms.MessageListener {

	final Logger logger = Logger.getLogger(MailMessageService.class);

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
				
				//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			} catch (JMSException e) {
				logger.error("", e);
			}

		}
	}

}
