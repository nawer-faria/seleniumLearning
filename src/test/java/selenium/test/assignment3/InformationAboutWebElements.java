package selenium.test.assignment3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class InformationAboutWebElements {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://smartmf-erp.brac.net/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // .getAttribute() --> Fetches the attribute value that is given in () of a reference element
        WebElement imageLink = driver.findElement(By.cssSelector("img[class$=img-responsive]"));
        System.out.println("The image link is: " + imageLink.getAttribute("src"));

        // .getText() --> Fetches the rendered text of the reference element
        WebElement copyRightText = driver.findElement(By.cssSelector(".copyright a[href*='javascript:']"));
        System.out.println("The test is: " + copyRightText.getText().trim());

        WebElement userName = driver.findElement(By.cssSelector("input[id*='username_']"));
        userName.clear();
        userName.sendKeys("00191549");

        WebElement password = driver.findElement(By.cssSelector("input[name^='j_pass']"));
        password.clear();
        password.sendKeys("abc123$");

        // .isDisplayed() --> Checks if reference element is displayed on the webpage
        System.out.println("Element is displayed: " + password.isDisplayed());

        // .isSelected() --> Checks if referenced Element is Selected or not
        System.out.println("Reference element is selected: " + password.isSelected());

        // .getTagName() --> Fetches the TagName of the referenced element
        System.out.println("The tag name is: " + password.getTagName());

        // .getRect() --> Size and position of reference element
        System.out.println("The position is: " + password.getRect().x + "   " + password.getRect().y);

        // .getCssValue() --> Get the value of specified style property of reference element
        System.out.println("The css value os color is: " + password.getCssValue("color").trim());

        driver.findElement(By.cssSelector("button[class$='btn-primary']")).click();

        Thread.sleep(3000);
        driver.quit();

    }
}
