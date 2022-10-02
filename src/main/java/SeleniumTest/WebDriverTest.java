package SeleniumTest;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverTest extends BaseTest{
    WebDriver driver;
    private org.apache.logging.log4j.Logger logger = LogManager.getLogger(WebDriverTest.class);
//1. Авторизация
    private void auth() throws InterruptedException {               //пример
        String login = "fawodo3192@chikd73.com";
        String password = "Qazwsx123";
        String locator = "button.header2__auth.js-open-modal";
        driver.findElement(By.cssSelector(locator)).click();
        driver.findElement(By.cssSelector("div.new-input-line_slim:nth-child(3) > input:nth-child(1)")).sendKeys(login);
        driver.findElement(By.cssSelector(".js-psw-input")).sendKeys(password);
        driver.findElement(By.cssSelector("div.new-input-line_last:nth-child(5) > button:nth-child(1)")).submit();
        logger.info("Авторизация прошла успешно");
    }
//2. Переход в личный кабинет
    private void  enterLK() throws InterruptedException {
        Thread.sleep(1000);
        //String locator = ".ic-blog-default-avatar";
        //WebElement icon = driver.findElement(By.cssSelector(locator));
        //Actions actions = new Actions(driver);
        //actions.moveToElement(icon).build().perform();
        driver.get("https://duckduckgo.com");
        logger.info("Перешлла на главную страницу сайта");
    }

    @Test
    public void openPage() throws InterruptedException {
        //1. Открыть duckduckgo.com
        driver.get("https://duckduckgo.com");
        logger.info("Сайт открыт");
        //2. Ввести в поисковую строку ввести ОТУС

        //3. Проверить что в поисковой выдаче первый результат (текст - "Онлайн курсыдля профессионалов, дистанционное обучение

        //4. Открыть Chrome в режиме киоска

        //5. Перейти на https://demo.w3layouts.com/demos_new/ter10-2020/photolaflash-liberty


        // Авторизоваться на сайте
        auth();
        // Войти в личный кабинет
        enterLK();

        // Открыть https://otus.ru в “чистом браузере”
        driver.quit();
        driver = (WebDriver) new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logger.info("Драйвер поднят");
        driver.get("http://otus.ru");

        // Авторизоваться на сайте
        auth();
        // Войти в личный кабинет
        enterLK();

        //9. Проверить, что в разделе о себе отображаются указанные ранее данные (пример)
        Assertions.assertEquals("Nataliia", driver.findElement(By.id("id_fname_latin")).getAttribute("value"));
        Assertions.assertEquals("Софиеч", driver.findElement(By.id("id_lname")).getAttribute("value"));
        Assertions.assertEquals("Sofiech", driver.findElement(By.id("id_lname_latin")).getAttribute("value"));
        Assertions.assertEquals("08.02.1992", driver.findElement(By.cssSelector(".input-icon > input:nth-child(1)")).getAttribute("value"));
        Assertions.assertEquals("Россия", driver.findElement(By.cssSelector(".js-lk-cv-dependent-master > ......")).getText());
        Assertions.assertEquals("Тюмень", driver.findElement(By.cssSelector(".js-lk-cv-dependent-slave-city > .....")).getText());
        Assertions.assertEquals("Начальный уровень (Beginner)", driver.findElement(By.cssSelector("div.container__col_12:nth-child(3) > ....")).getText());
    }
}
