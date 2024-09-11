package testcases;

import commons.BaseTest;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Tc6_ExplicitWait extends BaseTest {
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
    public void TestCase(){
        //Step 01: Truy cập vào trang
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

        //Step 02: Wait cho "Date Time" được hiển thị
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class= \"RadAjaxPanel inlinePanel\"]")));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class= \"RadAjaxPanel inlinePanel\"]")).isDisplayed());

        //Step 03: In ra ngày đã chọn
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id = \"ctl00_ContentPlaceholder1_Label1\"]")).getText(), "No Selected Dates to display");
        //Step04: Chọn ngày
        driver.findElement(By.xpath("//td[@title = \"Wednesday, September 11, 2024\"]")).click();

        //Step05: Wait
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='raDiv']")));
        Assert.assertFalse(driver.findElement(By.xpath("//div[@class='raDiv']")).isDisplayed());


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id= \"ctl00_ContentPlaceholder1_ctl00_ContentPlaceholder1_Label1Panel\"]")));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id= \"ctl00_ContentPlaceholder1_ctl00_ContentPlaceholder1_Label1Panel\"]")).isDisplayed(), "Wednesday, September 11, 2024");





    }

}
