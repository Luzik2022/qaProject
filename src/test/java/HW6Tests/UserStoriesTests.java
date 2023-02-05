package HW6Tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import pages.BacketPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserStoriesTests extends AbstractTest{
    JavascriptExecutor js = (JavascriptExecutor) getWebDriver();

    @Test
    @DisplayName("Тест-кейс №4: Удаление из избранного всех записей")
    public void testCase4() throws InterruptedException {
        new BacketPage(getWebDriver())
                .pressDelIt();
        assertTrue(new BacketPage(getWebDriver()).getText().equals("Trout Master Ridge Sbiro (12g Floating)"));
        String s = new BacketPage(getWebDriver())
                .pressDelIt()
                .pressAcAll()
                .getText();
        assertTrue(s.equals("0 "));

        //результат теста
        logger.info("Тест-кейс №4 пройден");      // выведется только если тест не упадет и условия удовлетворят
    }

}
