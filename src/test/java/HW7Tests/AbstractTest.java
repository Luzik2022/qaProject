package HW7Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class AbstractTest {
        static EventFiringWebDriver driver;
        Logger logger = LoggerFactory.getLogger("Test-Case's 1-4");
        @BeforeAll
        static void initClass() {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            //options.addArguments("--headless");
            options.addArguments("start-maximized");


            WebDriver driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

        }

        @BeforeEach
        void initTest() {
            // обработка предусловий
            driver.get("https://account.reverso.net/Account/Login");
        }

        @AfterAll
        static void finalClass() {
            // Закрытие драйвера
            driver.quit();
        }
        public WebDriver getWebDriver(){

            return this.driver;
        }
    }

