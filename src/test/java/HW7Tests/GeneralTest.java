package HW7Tests;

import HW7.CommonUtils;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import pages.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GeneralTest extends AbstractTest {
    JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
    // процедура логирования логов браузера для этого класса
    void saveBrowserLogs() {
        LogEntries browserLogs = getWebDriver().manage().logs().get(LogType.BROWSER);
        List<LogEntry> allLogRows = browserLogs.getAll();
        // здесь сохраняется лог тогда и только тогда, когда есть что сохранять (набор логов непустой))
        if (allLogRows.size() > 0) {
            allLogRows.forEach(logEntry -> {
                logger.debug("BROWSERLOGS: "+logEntry.getMessage());
            });
        }
    }
    @Test
    @DisplayName("Тест-кейс №1: Авторизация ")
    @Description("Тест-кейс №1: Авторизация ")
    @Link("https://context.reverso.net/%D0%BF%D0%B5%D1%80%D0%B5%D0%B2%D0%BE%D0%B4/")
    @Severity(SeverityLevel.BLOCKER)
    @Epic("Тестирование интерфейса сайта")
    @Feature("Авторизация на сайте")
    @Story("Вход на сайт по email пользователя и паролю")
    public void testCase1() {
        // тестовые действия
        getWebDriver().get("https://account.reverso.net/Account/Login?returnUrl=https%3A%2F%2Fcontext.reverso.net%2F&lang=ru");
        new MainPage(getWebDriver()).pressLoginBtt();
        new LoginPage(getWebDriver())
                .setLogin("nagornaya.teacher@gmail.com")
                .setPassword("Nevermore13")
                .pressInBtt();
        assertTrue(new MainPage(getWebDriver()).checkUser("nagornayateacher"));
        // сохранение логов браузера
        saveBrowserLogs();
        // сохранение скриншота с именем пользователя
        String fileName =  "test-case1-" + System.currentTimeMillis() + ".png";
        CommonUtils.makeScreenshot(getWebDriver(),fileName);
        // создался скриншот без вложения в отчет
        //результат теста
        logger.info("Тест-кейс №1 пройден");   // выведется только если тест не упадет и условия удовлетворят assert
    }
    @Test
    @DisplayName("Тест-кейс №2: Поисковая строка")
    @Description("Тест-кейс №2: Поисковая строка")
    @Link("https://context.reverso.net/%D0%BF%D0%B5%D1%80%D0%B5%D0%B2%D0%BE%D0%B4/")
    @Severity(SeverityLevel.BLOCKER)
    @Epic("Тестирование интерфейса сайта")
    @Feature("Поиск")
    @Story("Поиск перевода пользователем ")
    public void testCase2() throws InterruptedException {
        new SearchPage(getWebDriver())
                .pressSearchField()
                .setSearchW("I am enjoining the meal")
                .pressSearchBut();
        assertTrue(new SearchPage(getWebDriver()).getSameText().equals("I am enjoining the meal"));
        saveBrowserLogs();

        //результат теста
        logger.info("Тест-кейс №2 пройден");    //выведется только если тест не упадет и условия удовлетворят assert

    }
    @Test
    @DisplayName("Тест-кейс №3: Корректор грамматики")
    // Аннотации allure
    @Description("Тест-кейс №3: Корректор грамматики")
    @Link("https://context.reverso.net/%D0%BF%D0%B5%D1%80%D0%B5%D0%B2%D0%BE%D0%B4/")
    @Severity(SeverityLevel.TRIVIAL)
    @Epic("Тестирование интерфейса сайта")
    @Feature("Корректор")
    @Story("Проверка корректора грамматики пользователем")
    public void testCase3() throws InterruptedException {
        new MainPage(getWebDriver()).pressCabinetBtt();
        new MenuPage(getWebDriver())
                .pressSpellerField()
                .setSpWords("I is student")
                .pressSpBut();
        assertTrue(new MenuPage(getWebDriver()).getCorrectText().equals("I am a student"));
        saveBrowserLogs();
        //результат теста
        logger.info("Тест-кейс №3 пройден");      // выведется только если тест не упадет и условия удовлетворят
    }
    @Test
    @DisplayName("Тест-кейс №4: Удаление из избранного всех записей")
    // Аннотации allure
    @Description("Тест-кейс №4: Удаление из избранного всех записей")
    @Link("https://context.reverso.net/%D0%BF%D0%B5%D1%80%D0%B5%D0%B2%D0%BE%D0%B4/")
    @Severity(SeverityLevel.TRIVIAL)
    @Epic("Тестирование интерфейса сайта")
    @Feature("Удаление")
    @Story("Проверка удаления из избранного")
    public void testCase4() throws InterruptedException {
        new BacketPage(getWebDriver())
                .pressDelIt();
        assertTrue(new BacketPage(getWebDriver()).getText().equals("Будьте внимательны! Все Ваши примеры будут удалены."));
        String s = new BacketPage(getWebDriver())
                .pressDelIt()
                .pressAcAll()
                .getText();
        assertTrue(s.equals("0 "));
        saveBrowserLogs();
        //результат теста
        logger.info("Тест-кейс №4 пройден");      // выведется только если тест не упадет и условия удовлетворят
    }
}
