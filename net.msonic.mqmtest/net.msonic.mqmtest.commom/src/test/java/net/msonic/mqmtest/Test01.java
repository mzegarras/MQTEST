package net.msonic.mqmtest;

import static org.junit.Assert.*;

import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/test/resources/spring/applicationContext-test01.xml" })
public class Test01 {

	
	@Autowired
	JmsTemplate jmsTemplate;
	
	
	@Before
	public void setUp() {
		BasicConfigurator.configure();
	}
	
	
	@Test
	public void sanity() {
		assertNotNull(jmsTemplate);
	}
	
	
	
}
