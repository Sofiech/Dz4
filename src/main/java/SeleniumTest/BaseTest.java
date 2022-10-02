package SeleniumTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

/**
 * FileName:BaseTest
 * Author: aspid
 * Date: 23.09.2022 20:13
 * Description:
 */
public class BaseTest {

    private WebDriver driver;
    private final org.apache.logging.log4j.Logger logger = LogManager.getLogger(BaseTest.class);


    @BeforeEach
    public void StartUp() {
        WebDriverManager.edgedriver().setup();
        driver.quit();
        driver = new EdgeDriver();
        //1.Открыть Chrome  в режиме "headless" (для каждого браузера свои options)
        EdgeOptions options = new EdgeOptions();
        options.addArgument("headless");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logger.info("Драйвер поднят");
        driver.get("http://otus.ru");
    }

    @AfterEach
    public void End(){
        if (driver!=null)
            driver.quit();
    }


}
