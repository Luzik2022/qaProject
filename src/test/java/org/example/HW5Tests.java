package org.example;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.jupiter.api.Assertions.*;


    public class HW5Tests {

        static WebDriver driver;
        Logger logger = LoggerFactory.getLogger("Test-Case's 1-4");
        JavascriptExecutor js = (JavascriptExecutor) driver;

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
            driver.get("https://context.reverso.net/%D0%BF%D0%B5%D1%80%D0%B5%D0%B2%D0%BE%D0%B4/");
        }

        @AfterAll
        static void finalClass() {
            // Закрытие драйвера
            driver.quit();
        }

        @Test
        @DisplayName("Тест-кейс №1: Авторизация")
        public void testCase1() {
            // тестовые действия
            driver.get("https://account.reverso.net/Account/Login?returnUrl=https%3A%2F%2Fcontext.reverso.net%2F&lang=ru");
            driver.findElement(By.xpath("//input[@id='Email']")).clear();
            driver.findElement(By.xpath("//input[@id='Password]")).clear();
            driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("nagornaya.teacher@gmail.com");
            driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Nevermore13");
            driver.findElement(By.xpath("//button[@class='btn btn-primary btn-submit']")).click();
            String s = driver.findElement(By.xpath("//[@class='form-control valid']")).getText();
            assertTrue(s.equals("nagornayateacher"));

            //результат теста
            logger.info("Тест-кейс №1 пройден");   // выведется только если тест не упадет и условия удовлетворят assert
        }

        @Test
        @DisplayName("Тест-кейс №2: Поисковая строка")
        public void testCase2() {
            // тестовые действия
            driver.get("https://account.reverso.net/Account/Login?returnUrl=https%3A%2F%2Fcontext.reverso.net%2F&lang=ru");
            driver.findElement(By.xpath("//input[@id='entry']")).sendKeys("I am enjoying the meal");
            driver.findElement(By.xpath("//button[@class='close']")).click();
            driver.findElement(By.xpath("//button[@id='search-button']")).click();
            String s = driver.findElement(By.xpath("//div[@class='src ltr']/class")).getText();
            assertTrue(s.equals("I am enjoying the meal"));

            //результат теста
            logger.info("Тест-кейс №2 пройден");    //выведется только если тест не упадет и условия удовлетворят assert

        }

        @Test
        @DisplayName("Тест-кейс №3: Корректор грамматики ")
        public void testCase3() {
            // тестовые действия
            driver.get("https://www.reverso.net/%D0%BF%D1%80%D0%BE%D0%B2%D0%B5%D1%80%D0%BA%D0%B0-%D0%BE%D1%80%D1%84%D0%BE%D0%B3%D1%80%D0%B0%D1%84%D0%B8%D0%B8/%D0%B0%D0%BD%D0%B3%D0%BB%D0%B8%D0%B9%D1%81%D0%BA%D0%B8%D0%B9/");
            driver.findElement(By.xpath("//input[@css='.speller-link > span']")).click();
            driver.findElement(By.xpath("//input[@ngx-speller-textarea ]")).sendKeys("I is student");
            driver.findElement(By.xpath("//button[@class='speller-actions-input_button correct-button']")).click();
            String s = driver.findElement(By.xpath("//div[@class='corrected-text_text-detail']")).getText();
            assertTrue(s.equals("I am a student"));

            //результат теста
            logger.info("Тест-кейс №3 пройден");      // выведется только если тест не упадет и условия удовлетворят

        }

        @Test
        @DisplayName("Тест-кейс №4: Удаление из избранного всех записей")
        public void testCase4()  {
            // тестовые действия
            driver.get("https://context.reverso.net/favourites");
            driver.findElement(By.xpath("//button[@class='icon delete']")).click();
            driver.findElement(By.xpath("//button[@class='accept all']")).click();
            String s1 = driver.findElement(By.xpath("//body[@class='user-profile favourities hide-dapp-promo empty']")).getText();
            assertTrue (s1.equals("0 "));


            //результат теста
            logger.info("Тест-кейс №4 пройден");      // выведется только если тест не упадет и условия удовлетворят
        }

    }
