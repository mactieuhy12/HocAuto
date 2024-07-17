package testcases;

import commons.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Textbox_Textarea extends BaseTest {
    WebDriver driver;
    private WebDriverWait explicitWait;
    private JavascriptExecutor jsExecutor;

    private JavascriptExecutor javascriptExecutor;
    protected void waitToAlertPresence(WebDriver driver) {
        explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    @BeforeClass
    public void beforeClass(){
        driver = getBrowserDriver("chorme");
    }
    @AfterClass
    public  void afterClass(){
        quitBrowser(driver);
    }
    @Test
    public void TC_1(){
        driver.get("http://live.techpanda.org/");
        By parentLocator = By.xpath("//span[@class = 'label' and text()= \"Account\"]");
        By childLocator = By.xpath("//div[@id = \"header-account\"]/div/ul/li");


    }
   protected void selectItemInCustomDropDown(String parentLocator, String childLocator, String expectedItem){
        //1- Click vào thẻ (cha) để xổ ra tất cả các item con
        driver.findElement(By.xpath(parentLocator)).click();

        // 2. Chờ cho tất cả cái item con được xổ ra
        explicitWait = new WebDriverWait(driver, 20);
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childLocator)));

        //3- Đưa tất cả các item trong Dropdown vào 1 list để kiểm tra
        List<WebElement> allItems = driver.findElements(By.xpath(childLocator));
         //4 - Chạy qua tất cả các giá trị đang có trong list
        for(WebElement item : allItems){
            //5 - Kiểm tra xem text của các giá trị có item nào bằng với text mong muốn không
            if(item.getText().equals(expectedItem)){
                //6- Scroll xuống đúng Item này
                javascriptExecutor = (JavascriptExecutor) driver;
                javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", item);

                //7 - Click vào item này
                item.click();
                //8- Thoát vòng lặp
                break;
            }
        }
    }




}
