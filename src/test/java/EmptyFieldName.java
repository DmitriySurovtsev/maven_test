import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmptyFieldName {

    @Test
    public void testEmptyField(){

        String enterName = "Володя";

        System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module01/");
        //driver.findElement(By.name("name")).sendKeys(enterName);
        driver.findElement(By.className("button")).click();
        var actualRes = driver.findElement(By.className("start-screen__res")).getText();
        var expectedRes = "Привет, " + enterName + "!";
        Assertions.assertEquals(expectedRes,actualRes);
        driver.quit();

    }
}
