package testcases;

import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropdownT extends BaseTest {
    //Khai báo
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
    public void TC_1(){
        //Truyền URL => Mở ra Page
        driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        Select select = new Select(driver.findElement(By.id("select-demo")));
        //Chọn 1 giá trị
        select.selectByVisibleText("Sunday");
        // Kiểm tra xem có p multi-select không
        Assert.assertFalse(select.isMultiple());
        // Kiểm tra có 5 giá trị không
        Assert.assertEquals(select.getOptions().size(), 8);
        // Kiểm tra giá trị trong dropdown có hiển thị thành công không
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Sunday");

    }
}
