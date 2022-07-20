import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Enter {
    public WebDriver driver;
    public Enter(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }
    public void login(String param1) throws InterruptedException {
        WebElement enterLogin =driver.findElement(By.xpath("//*[@id=\"email\"]"));
        enterLogin.sendKeys(param1);
    }
    public void password(String param2) throws InterruptedException {
        WebElement enterPassword = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
        enterPassword.sendKeys(param2);
    }
    public void eye(){
        WebElement seePassword=driver.findElement(By.xpath("//div[@class=\"_9lsa\"]"));
        seePassword.click();
    }
    public void enterBtn() throws InterruptedException {
        WebElement enterKeys = driver.findElement(By.xpath("//button[@data-testid=\"royal_login_button\"]"));
        enterKeys.click();
    }
    public void checkError(String param3) throws InterruptedException {
        WebElement checkErr = driver.findElement(By.xpath(param3));
        checkErr.isDisplayed();
    }
}
