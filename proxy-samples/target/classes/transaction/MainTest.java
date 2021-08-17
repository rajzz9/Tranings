package transaction;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
    private static Logger logger = Logger.getLogger(MainTest.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("transaction/config-data-access.xml");
        AccountServiceNoImpl accountService = (AccountServiceNoImpl) applicationContext.getBean(AccountServiceNoImpl.class);
        logger.info(accountService.getClass().getName());
    }
}
