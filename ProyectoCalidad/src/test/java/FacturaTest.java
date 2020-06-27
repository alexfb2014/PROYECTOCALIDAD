
import Helpers.HelperSleep;
import Pages.PageFactura;
import Pages.PageLogin;
import java.io.File;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class FacturaTest {
    
    WebDriver driver;
    HelperSleep sleep;
    
    @Before
    public void testBefore() {
        
        File file = new File("driver/phantomjs.exe");
        System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
        driver = new PhantomJSDriver();
        driver.get("http://localhost:8080/login");
        

//        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
//        driver= new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.navigate().to("http://localhost:8080/login");  
        
        sleep = new HelperSleep();
    }
    @After
    public void tearDown(){        
      driver.close(); //Cierra Ventana
      driver.quit();  //Cierra Sesion

    }
    
    @Test
    public void test_19() throws InterruptedException {        
        PageLogin login = new PageLogin(driver);
        PageFactura factura = new PageFactura(driver);
        login.IngresarLogin("admin", "12345");
        sleep.SleepSeconds(4);
        
        factura.ClickBtnNuevaFactura();
        sleep.SleepSeconds(4);
        factura.ClickBtnCrearFactura();
        sleep.SleepSeconds(2);
        Assert.assertTrue(driver.findElement(By.className("invalid-feedback"))
                .getText().contains("La descripcion es requerida"));
    }
    
    @Test
    public void test_20() throws InterruptedException {        
        PageLogin login = new PageLogin(driver);
        PageFactura factura = new PageFactura(driver);
        login.IngresarLogin("admin", "12345");
        sleep.SleepSeconds(4);
        factura.ClickBtnNuevaFactura();
        sleep.SleepSeconds(4);
        factura.IngresarDescYObserv("abcd", "abcd");
        factura.ClickBtnCrearFactura();
        sleep.SleepSeconds(2);
        Assert.assertTrue(driver.findElement(By.cssSelector("body > header > div"))
                .getText().contains("Error: La factura debe tener minimo un producto"));
    }
    
     @Test
    public void test_21() throws InterruptedException {        
        PageLogin login = new PageLogin(driver);
        PageFactura factura = new PageFactura(driver);
        login.IngresarLogin("admin", "12345");
        sleep.SleepSeconds(4);
        factura.ClickBtnNuevaFactura();
        sleep.SleepSeconds(4);
        factura.IngresarDescYObserv("abcd", "abcd");
        sleep.SleepSeconds(2);
        factura.IngresarBuscarProducto("Panasonic");
        sleep.SleepSeconds(2);
        Assert.assertTrue(driver.findElement(By.id("ui-id-1"))
                .getText().contains("Panasonic Pantalla LCD"));
        Assert.assertTrue(driver.findElement(By.id("ui-id-1"))
                .getText().contains("Panasonic Televisor"));
        Assert.assertTrue(driver.findElement(By.id("ui-id-1"))
                .getText().contains("Panasonic Laptop"));
    }
    
         @Test
    public void test_22() throws InterruptedException {        
        PageLogin login = new PageLogin(driver);
        PageFactura factura = new PageFactura(driver);
        login.IngresarLogin("admin", "12345");
        sleep.SleepSeconds(4);
        factura.ClickBtnNuevaFactura();
        sleep.SleepSeconds(4);
        factura.IngresarDescYObserv("abcd", "abcd");
        sleep.SleepSeconds(2);
        factura.SeleccionarProducto("Sony Camara",3);
        factura.ClickBtnCrearFactura();
        sleep.SleepSeconds(2);
        Assert.assertTrue(driver.findElement(By.cssSelector("body > header > div"))
                    .getText().contains("Factura creada con exito"));
       
    }
    
     @Test
    public void test_23() throws InterruptedException {        
        PageLogin login = new PageLogin(driver);
        PageFactura factura = new PageFactura(driver);
        login.IngresarLogin("admin", "12345");
        sleep.SleepSeconds(4);
        factura.ClickBtnNuevaFactura();
        sleep.SleepSeconds(4);
        factura.IngresarDescYObserv("abcd", "abcd");
        sleep.SleepSeconds(2);
        factura.SeleccionarProducto("Sony Camara",3);
        
        int obtenido = Integer.parseInt(driver.findElement(By.id("total_importe_2")).getText());
        Assert.assertEquals(1800,obtenido); 
    }
    
      @Test
    public void test_24() throws InterruptedException {        
        PageLogin login = new PageLogin(driver);
        PageFactura factura = new PageFactura(driver);
        login.IngresarLogin("admin", "12345");
        sleep.SleepSeconds(4);
        factura.ClickBtnNuevaFactura();
        sleep.SleepSeconds(4);
        factura.IngresarDescYObserv("abcd", "abcd");
        sleep.SleepSeconds(2);
        
        factura.SeleccionarProducto("Sony Camara",4);

        int subtotal = Integer.parseInt(driver.findElement(By.id("total_importe_2")).getText());
        
        int totalfactura = Integer.parseInt(driver.findElement(By.id("gran_total")).getText());

        Assert.assertEquals(totalfactura,subtotal); 
    }
}



