package selenium.test.assignment4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class JavaScriptAlertsTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Alert --> a custom message, and a single button
        WebElement simpleAlert = driver.findElement(By.cssSelector("button[id*='alertButton']"));
        simpleAlert.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        // Confirm Alert --> a custom message, and two buttons
        driver.findElement(By.cssSelector("button[id*='confirmButton']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);

        // Prompt Alert --> a text input field, a custom message, and two buttons
        driver.findElement(By.cssSelector("button[id*='promtButton']")).click();
        Thread.sleep(2000);
        Alert alert= driver.switchTo().alert();
        alert.sendKeys("IT IS OK TO HIT OK");
        Thread.sleep(2000);
        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(3000);
        driver.quit();

    }
}
