package selenium.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ParaBankLogin {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("customer.firstName")).sendKeys("SQA");
        driver.findElement(By.id("customer.lastName")).sendKeys("Learning");
        driver.findElement(By.id("customer.address.street")).sendKeys("BRAC IT Services");
        driver.findElement(By.id("customer.address.city")).sendKeys("Manhaton");
        driver.findElement(By.id("customer.address.state")).sendKeys("Newyork City");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("10005");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("+1 201-432-345");
        driver.findElement(By.id("customer.ssn")).sendKeys("107-09-6780");

        driver.findElement(By.id("customer.username")).sendKeys("Demo User");
        driver.findElement(By.id("customer.password")).sendKeys("sqa");
        driver.findElement(By.id("repeatedPassword")).sendKeys("sqa");
        driver.findElement(By.cssSelector("input[value='Register']")).click();




        Thread.sleep(3000);
        driver.quit();
    }
}
