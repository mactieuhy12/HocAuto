package testcases;

import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC10_PageReady extends BaseTest {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = getBrowserDriver("chrome");
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public void afterClass(){
       // driver.quit();
    }

    @Test
    public void Testcase(){
        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        driver.findElement(By.xpath("//button[@class = 'button-1 login-button']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class = 'fas fa-cogs']")));
       driver.findElement(By.xpath("//a[@class = 'nav-link' and text() = \"Logout\"]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//strong")).getText(), "Welcome, please sign in!" );

    }



}
