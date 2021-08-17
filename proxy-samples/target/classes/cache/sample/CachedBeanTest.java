package cache.sample;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"config-data-access.xml", "config-cache.xml"})
public class CachedBeanTest {
	
	private static Logger logger = Logger.getLogger(CachedBeanTest.class);
	
	@Autowired
	private AccountService accountService;
	
	
	@Test
	public void findAccountCached() {
		Account account1 = accountService.findAccountCached(1);
		Account account2 = accountService.findAccountCached(1);
		// since the bean is cached, we expect to have the same address
		Assert.assertEquals(account1.toString(), account2.toString());
	}
	
	
	@Test
	public void findAccountNotCached() {
		Account account1 = accountService.findAccountNotCached(1);
		Account account2 = accountService.findAccountNotCached(1);
		// since the bean is cached, we expect that the method is called twice (so the reference on the returned value is different)
		Assert.assertNotSame(account1.toString(), account2.toString());
	}
	
	/**
	 * checks that we are indeed using a Dynamic Proxy
	 */
	@Test
	public void checkAccountServiceClassName() {
		String accountServiceClassName = accountService.getClass().getName();
		logger.info("class name: " + accountServiceClassName);
		Assert.assertTrue(accountServiceClassName.contains("$Proxy"));
	}
	
	

}