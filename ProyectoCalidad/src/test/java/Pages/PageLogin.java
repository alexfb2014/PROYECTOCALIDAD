
package Pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageLogin {
    private WebDriver driver;
    private By userField;
    private By userPassword;
    private By loginButton;
    
    
    public PageLogin(WebDriver driver) {
        this.driver = driver;
        userField= By.cssSelector("#username");
        userPassword=By.cssSelector("#password");
        loginButton=By.cssSelector("body > div > div > div.card-body > form > div:nth-child(4) > input");
        
    }
    
    public void IngresarLogin(String user, String pass){
        
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.findElement(userField).sendKeys(user);
       driver.findElement(userPassword).sendKeys(pass);
       driver.findElement(loginButton).click();
      

    }
    
}

