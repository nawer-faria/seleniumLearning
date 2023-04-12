package selenium.test.assignment6;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionApisTest{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/menu");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement menuItem1 = driver.findElement(By.cssSelector("#nav > li:nth-child(1) > a:nth-child(1)"));
        WebElement menuItem2 = driver.findElement(By.cssSelector("#nav > li:nth-child(2) > a:nth-child(1)"));
        WebElement menuItem2SubList = driver.findElement(By.cssSelector("#nav > li:nth-child(2) > ul:nth-child(2) > li:nth-child(3) > a:nth-child(1)"));
        WebElement menuItem2SubListSub1 = driver.findElement(By.cssSelector("#nav > li:nth-child(2) > ul:nth-child(2) > li:nth-child(3) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)"));
        WebElement menuItem3 = driver.findElement(By.cssSelector("#nav > li:nth-child(3) > a:nth-child(1)"));

        Actions actions =new Actions(driver);
        //.doubleClick()--> will double click on web element
        actions.doubleClick(menuItem1).perform();
        explicitWait.until(ExpectedConditions.elementToBeClickable(menuItem1));
        //.contextClick()--> will right click on web element
        actions.contextClick(menuItem1).perform();
        //.click()--> will click and release the web element
        actions.click(menuItem1).perform();

        //.moveToElement--> will move the cursor to the web element
        actions.moveToElement(menuItem2).moveToElement(menuItem2SubList).perform();
        actions.click(menuItem2SubListSub1).perform();

        //.clickAndHold()--> will click and hold click on web element
        actions.clickAndHold(menuItem3).perform();

        driver.navigate().to("https://demoqa.com/droppable");
        explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".main-header"))));
        System.out.println(driver.findElement(By.cssSelector(".main-header")).getText());
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        //.dragAndDrop()--> will drag an element to droppable
        actions.dragAndDrop(draggable, droppable).perform();

        Thread.sleep(3000);
        driver.quit();

    }

}

