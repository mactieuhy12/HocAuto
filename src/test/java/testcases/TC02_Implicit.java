package testcases;

import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC02_Implicit extends BaseTest {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver = getBrowserDriver("chrome");
    }
    @AfterClass
    public void afterClass(){
        //driver.quit();
    }

@Test
    public void Testcase(){
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button")).click();
    Assert.assertEquals(driver.findElement(By.xpath("//h4")).getText(), "Hello World!");



}

}

