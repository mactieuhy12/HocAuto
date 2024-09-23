package testcases;

import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.internal.annotations.IBeforeClass;

public class TC07_ExplicitWait extends BaseTest {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver = getBrowserDriver("chrome");
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
    @Test
    public void testcase(){
        driver.get("https://gofile.io/welcome");
        driver.findElement(By.xpath("//button[@type=\"button\"]")).click();
    }


}
