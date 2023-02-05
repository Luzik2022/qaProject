package HW6Tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends AbstractTest{
    @Test
    @DisplayName("Тест-кейс №1: Авторизация")
    public void testCase1() {
        // тестовые действия
        getWebDriver().get("https://account.reverso.net/Account/Login?returnUrl=https%3A%2F%2Fcontext.reverso.net%2F&lang=ru");
        new MainPage(getWebDriver()).pressLoginBtt();
        new LoginPage(getWebDriver())
                .setLogin("nagornaya.teacher@gmail.com")
                .setPassword("Nevermore13")
                .pressInBtt();
        assertTrue(new MainPage(getWebDriver()).checkUser("nagornayateacher"));

        //результат теста
        logger.info("Тест-кейс №1 пройден");   // выведется только если тест не упадет и условия удовлетворят assert
    }

}



