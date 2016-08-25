package net.msonic.mqmtest;

import static org.junit.Assert.*;



import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/test/resources/spring/applicationContext-test03.xml" })
public class Test03 {
	
	final static Logger logger = Logger.getLogger(Test03.class);
	


	@Before
	public void setUp() {
		BasicConfigurator.configure();
	}


	@Test
	public void consumirMessage() throws InterruptedException {
		
		//La prioeidad más alta seràn ubicados arriba de la cola por lo tanto se obtienen primero
		
		assertTrue("consumirMessage", true);
		Thread.sleep(1000 * 10);
	}
	
}
