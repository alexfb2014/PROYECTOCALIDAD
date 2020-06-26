
import Helpers.HelperSleep;
import Pages.PageCliente;
import Pages.PageLogin;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClienteTests {

    WebDriver driver;
    HelperSleep sleep;

    @Before
    public void testBefore() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://localhost:8080/login");
        sleep = new HelperSleep();
        PageLogin login = new PageLogin(driver);
        login.IngresarLogin("admin", "12345");
        sleep.SleepSeconds(5);
    }

    @After
    public void tearDown() {
        driver.close(); //Cierra Ventana
        //driver.quit();  //Cierra Sesion

    }

    @Test
    public void test_04() throws InterruptedException {
//        PageLogin login = new PageLogin(driver);
//        login.IngresarLogin("admin", "12345");
//        sleep.SleepSeconds(5);
        PageCliente cliente = new PageCliente(driver);
        cliente.registrarClienteVacio();
        sleep.SleepSeconds(5);
        Assert.assertTrue(driver.findElement(By.cssSelector("body > div > div > div.card-body > form > div:nth-child(2) > div > small")).getText().contains("El nombre del cliente es requerido"));

    }
    
    @Test
    public void test_05() throws InterruptedException {
//        PageLogin login = new PageLogin(driver);
//        login.IngresarLogin("admin", "12345");
//        sleep.SleepSeconds(5);
        PageCliente cliente = new PageCliente(driver);
        cliente.registrarCliente("Cliente", "Nuevo", "clin@hotmail.com", "2020/06/30");
        sleep.SleepSeconds(5);
        Assert.assertTrue(driver.findElement(By.cssSelector("body > header > div")).getText().contains("Cliente Creado con Exito"));

    }

}
