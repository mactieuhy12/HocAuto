package testcases;

import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Tc_6 extends BaseTest {
    WebDriver driver;
    private JavascriptExecutor javascriptExecutor;
    private WebDriverWait explicitWait;
    private  JavascriptExecutor jsExecutor;
    protected void waitToAlertPresence(WebDriver driver) {
        explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.alertIsPresent());
    }
    @BeforeClass
    public void beforeClass(){
        driver = getBrowserDriver("chrome");
    }

    @AfterClass
    public void afterClass(){
        quitBrowser(driver);

    }
    @Test
    public void TC_6(){
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        By parent = By.xpath("//span[@id ='speed-button']");
        By child = By.xpath("//li[@class ='ui-menu-item']");
        selectItemInCustomDropDown(parent, child, "Medium");


        Assert.assertEquals(driver.findElement(By.xpath("//span[@id = 'speed-button']//span[@class='ui-selectmenu-text']")).getText(), "Medium");


    }
    protected void selectItemInCustomDropDown(By parent, By child, String expectedItem){
        // 1. Click cha để sổ ra tìm con
        driver.findElement(parent).click();
        // 2. Đợi cho các item con xổ hết ra
        explicitWait  = new WebDriverWait(driver, 20);
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(child));

        //3. Đưa tất cả các item vào 1 list để kiểm tra
        List<WebElement> allItem = driver.findElements(child); //Khai báo list danh sách con
        // Vòng lặp for để duyệt danh sách
        for(WebElement item : allItem){
            // 5. Kiểm tra các giá trị xem có item nào bằng với giá trị mong muốn
            if(item.getText().equals(expectedItem)){
                //Trượt xuống đúng item đó
                javascriptExecutor = (JavascriptExecutor) driver;
                javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", item);

                //7. Click item này
                item.click();
                //Thoát
                break;
            }
        }


    }

}
