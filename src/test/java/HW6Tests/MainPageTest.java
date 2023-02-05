package HW6Tests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import pages.MainPage;
import pages.MenuPage;
import pages.SearchPage;
import static org.junit.jupiter.api.Assertions.*;

public class MainPageTest extends AbstractTest {
    JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
    @Test
    @DisplayName("Тест-кейс №2: Поисковая строка")
    public void testCase2() throws InterruptedException {
      new SearchPage(getWebDriver())
                    .pressSearchField()
                            .setSearchW("I am enjoining the meal")
              .pressSearchBut();
        assertTrue(new SearchPage(getWebDriver()).getSameText().equals("I am enjoining the meal"));

        //результат теста
        logger.info("Тест-кейс №2 пройден");    //выведется только если тест не упадет и условия удовлетворят assert

    }

    @Test
    @DisplayName("Тест-кейс №3: Корректор грамматики ")
    public void testCase3() throws InterruptedException {
        new MainPage(getWebDriver()).pressCabinetBtt();
        new MenuPage(getWebDriver())
                .pressSpellerField()
                .setSpWords("I is student")
                        .pressSpBut();
        assertTrue(new MenuPage(getWebDriver()).getCorrectText().equals("I am a student"));



        //результат теста
        logger.info("Тест-кейс №3 пройден");      // выведется только если тест не упадет и условия удовлетворят

    }

}
