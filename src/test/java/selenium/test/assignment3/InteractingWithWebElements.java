package selenium.test.assignment3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class InteractingWithWebElements {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();

        // .get()
        driver.get("https://smartmf-erp.brac.net/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // .sendKeys()
        driver.findElement(By.cssSelector("input[id*='username_']")).sendKeys("00191549");

        // .clear()
        WebElement password=driver.findElement(By.cssSelector("input[name^='j_pass']"));
        password.clear();
        password.sendKeys("abc123$");

        // .submit() [Can use only if the tag is <form]
        driver.findElement(By.id("loginForm")).submit();

        // .click()
        driver.findElement(By.cssSelector("button[class$='btn-primary']")).click();

        Thread.sleep(3000);
        driver.quit();
    }
}
