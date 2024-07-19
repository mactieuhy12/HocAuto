package testcases;

import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_4 extends BaseTest {
    WebDriver driver;
    Select select;
    @BeforeClass
    public void beforeClass(){
        driver = getBrowserDriver("chrome");
    }

    @AfterClass
    public void afterClass(){
        //quitBrowser(driver);
    }
    @Test
    public void Testcase(){
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2Fregister");
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        Assert.assertFalse(driver.findElement(By.xpath("//input[@id=\"gender-male\"]")).isSelected(), "Sai");
        driver.findElement(By.xpath("//input[@id=\"gender-male\"]")).click();
    }
}
