import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.management.InvalidApplicationException;

public class EnterNameVersionTwo {


    // 1. Позитвный сценарий (все поля заполнены)
    @Test
    public void EnterAllInfo(){

        String enterFIO = "Иванов Володя Иванович";
        String enterEmail = "test@test.ru";
        String enterPhone = "79991010101";

        // Открыть сайт
        System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");

        // указать фио
        driver.findElement(By.name("name")).sendKeys(enterFIO);
        // указать почту
        driver.findElement(By.name("email")).sendKeys(enterEmail);
        // указать телефон
        driver.findElement(By.name("phone")).sendKeys(enterPhone);
        // Кликнут на кнопку "Ввод"
        driver.findElement(By.className("button")).click();

        //Сравнение результа
        var actualRes = driver.findElement(By.className("start-screen__res")).getText();
        var expectedRes = "Здравствуйте, " + enterFIO + ".\n" +
                "На вашу почту (" + enterEmail + ") отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: " + enterPhone + ".";
        Assertions.assertEquals(expectedRes,actualRes);

        //Закрыть браузер
        driver.quit();

    }

    // 2. Указал только ФИО и почту
    @Test
    public void EnterInvalidPhone(){

        String enterFIO = "Иванов Володя Иванович";
        String enterEmail = "test@test.ru";
        String enterPhone = "";

        //Открыть сайт
        System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");

        driver.findElement(By.name("name")).sendKeys(enterFIO);
        driver.findElement(By.name("email")).sendKeys(enterEmail);
        driver.findElement(By.name("phone")).sendKeys(enterPhone);

        //Сравнение результа
        var actualRes = driver.findElement(By.className("start-screen__res")).getText();
        var expectedRes = "Вы не указали номер телефона";
        Assertions.assertEquals(expectedRes,actualRes);

        //Закрыть браузер
        driver.quit();

    }

    // 3. Указал только имя и телефон
    @Test
    public void EnterNameAndPhone(){

        String enterFIO = "Иванов Володя Иванович";
        String enterEmail = "";
        String enterPhone = "79991010101";

        //Открыть сайт
        System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");

        driver.findElement(By.name("name")).sendKeys(enterFIO);
        driver.findElement(By.name("email")).sendKeys(enterEmail);
        driver.findElement(By.name("phone")).sendKeys(enterPhone);

        //Сравнение результа
        var actualRes = driver.findElement(By.className("start-screen__res")).getText();
        var expectedRes = "Вы не адрес электронной почты";
        Assertions.assertEquals(expectedRes,actualRes);

        //Закрыть браузер
        driver.quit();

    }


}
