import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class ExcelTest {
    public static WebDriver driver;
   public static Enter enter;
    @BeforeClass
    void setUp() throws IOException {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "\"D:\\chromedriver.exe\"");
        driver.manage().window().maximize();
      driver.get("https://uk-ua.facebook.com/" );
    }
    @BeforeMethod
    public void sestUp() {
        enter=new Enter(driver);
        driver.get("https://uk-ua.facebook.com/");
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(5000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test(dataProvider = "usersFromSheet1", dataProviderClass = ExcelDataProviders.class)
    public void readExcelSheetDefault(String param1,String param2,String param3) throws InterruptedException {
        enter.login(param1);
        enter.password(param2);
        enter.eye();
        enter.enterBtn();
        enter.checkError(param3);

    }
}