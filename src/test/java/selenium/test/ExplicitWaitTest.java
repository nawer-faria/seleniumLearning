package selenium.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitTest {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Alert --> a custom message, and a single button
        WebElement simpleAlert = driver.findElement(By.cssSelector("button[id*='alertButton']"));
        explicitWait.until(ExpectedConditions.elementToBeClickable(simpleAlert));
        simpleAlert.click();
        explicitWait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();


        // Confirm Alert --> a custom message, and two buttons
        WebElement confirmAlert = driver.findElement(By.cssSelector("button[id*='confirmButton']"));
        explicitWait.until(ExpectedConditions.elementToBeClickable(simpleAlert));
        confirmAlert.click();
        explicitWait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();


        // Prompt Alert --> a text input field, a custom message, and two buttons
        WebElement promtAlert=driver.findElement(By.cssSelector("button[id*='promtButton']"));
        explicitWait.until(ExpectedConditions.elementToBeClickable(simpleAlert));
        promtAlert.click();

        Alert alert= driver.switchTo().alert();
        alert.sendKeys("IT IS OK TO HIT OK");

        System.out.println(alert.getText());
        alert.accept();

        driver.quit();
    }
}
