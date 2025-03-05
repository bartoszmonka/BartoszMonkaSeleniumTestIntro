package utils.testng.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private static final int MAX_NUMBER_OF_RETRIES = 2;
    private int count = 0;
    private Logger logger = LogManager.getLogger(RetryAnalyzer.class);

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {                      //Sprawdza czy test zakończył się porażką.
            if (count < MAX_NUMBER_OF_RETRIES) {             //Sprawdzamy czy test został powtórzony. Jeśli tak to nie powtarzamy go ponownie
                count++;
                logger.info("Retrying test method {}!", iTestResult.getName());
                return true;
            }
        }
        logger.info("Test method {} will be not retried!", iTestResult.getName());
        return false;
    }
}