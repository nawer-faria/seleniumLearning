package testNg.withoutpriority;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParaBankWithoutPriorityTest extends BaseParaBankWithoutPriorityTest {

    @Test
    public void verifyPageTitleShouldSucceed(){
        System.out.println("The Page Title is: " + driver.getTitle());
        Assert.assertEquals(driver.getTitle().trim(), "ParaBank | Welcome | Online Banking");
        System.out.println("The Pge URL is: " + driver.getCurrentUrl());
    }

    @Test
    public void verifyLoginPageShouldSucceed(){
        String loginText=driver.findElement(By.cssSelector("#leftPanel h2")).getText().trim();
        System.out.println("The Text is: "+ loginText);
        Assert.assertEquals(loginText, "Customer Login");
    }

    @Test
    public void loginShouldSucceed() {

        WebElement usernameEl= driver.findElement(By.name("username"));
        usernameEl.clear();
        usernameEl.sendKeys("Demo User");

        WebElement passwordEl= driver.findElement(By.name("password"));
        passwordEl.clear();
        passwordEl.sendKeys("abc");

        driver.findElement(By.cssSelector("input.button")).click();

        String logoutLinkText=driver.findElement(By.linkText("Log Out")).getText().trim();
        System.out.println("The Text is : " + logoutLinkText);
        Assert.assertEquals(logoutLinkText, "Log Out");
    }

}
