
import Helpers.HelperSleep;
import Pages.PageLogin;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Tests {
    
    WebDriver driver;
    HelperSleep sleep;
    
    @Before
    public void testBefore() {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://localhost:8080/login");  
        sleep = new HelperSleep();
    }
    @After
    public void tearDown(){        
      driver.close(); //Cierra Ventana
      driver.quit();  //Cierra Sesion

    }
    
    @Test
    public void test_01() throws InterruptedException {        
        PageLogin login = new PageLogin(driver);
        login.IngresarLogin("invalido", "12345");
        sleep.SleepSeconds(5);       
        Assert.assertTrue(driver.findElement(By.cssSelector("body > header > div")).getText().contains("Error: Contraseña o usuario incorrecto"));
    }
    
    @Test
    public void test_02() throws InterruptedException {        
        PageLogin login = new PageLogin(driver);
        login.IngresarLogin("admin", "123456789");
        sleep.SleepSeconds(5);       
        Assert.assertTrue(driver.findElement(By.cssSelector("body > header > div")).getText().contains("Error: Contraseña o usuario incorrecto"));
    }
    
    @Test
    public void test_03() throws InterruptedException {        
        PageLogin login = new PageLogin(driver);
        login.IngresarLogin("admin", "12345");
        sleep.SleepSeconds(5);       
        Assert.assertTrue(driver.findElement(By.id("dropdownMenuLink")).getText().contains("admin"));
    }
    
}
