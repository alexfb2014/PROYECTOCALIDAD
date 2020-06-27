
import Helpers.HelperSleep;
import Pages.PageCliente;
import Pages.PageLogin;
import java.io.File;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class ClienteTestsPhantomjs {

    WebDriver driver;
    HelperSleep sleep;

    @Before
    public void testBefore() {
        File file = new File("driver/phantomjs.exe");
        System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
        driver = new PhantomJSDriver();
        driver.navigate().to("http://localhost:8080/login");
        sleep = new HelperSleep();
        PageLogin login = new PageLogin(driver);
        login.IngresarLogin("admin", "12345");
        sleep.SleepSeconds(5);
    }

    @After
    public void tearDown() {
        driver.close(); //Cierra Ventana
        driver.quit();  //Cierra Sesion

    }

    @Test
    public void test_04(){
        PageCliente cliente = new PageCliente(driver);
        cliente.registrarClienteVacio();
        sleep.SleepSeconds(5);
        Assert.assertTrue(driver.findElement(By.cssSelector("body > div > div > div.card-body > form > div:nth-child(2) > div > small")).getText().contains("El nombre del cliente es requerido"));

    }
    
    @Test
    public void test_05() throws InterruptedException {
        PageCliente cliente = new PageCliente(driver);
        cliente.registrarCliente("Maria", "Perez", "mairap@gmail.com", "2020/06/30");
        sleep.SleepSeconds(5);
        Assert.assertTrue(driver.findElement(By.cssSelector("body > header > div")).getText().contains("Cliente Creado con Exito"));

    }
    
    @Test
    public void test_06() {
        PageCliente cliente = new PageCliente(driver);
        cliente.registrarCliente("", "Chavez", "kchavezz@gmail.com", "2020/06/25");
        sleep.SleepSeconds(5);
        Assert.assertTrue(driver.findElement(By.cssSelector("body > div > div > div.card-body > form > div:nth-child(2) > div > small")).getText().contains("El nombre del cliente es requerido"));
    }
    
    @Test
    public void test_07() {
        PageCliente cliente = new PageCliente(driver);
        cliente.registrarCliente("Karo", "", "kchavezz@gmail.com", "2020/06/25");
        sleep.SleepSeconds(5);
        Assert.assertTrue(driver.findElement(By.cssSelector("body > div > div > div.card-body > form > div:nth-child(3) > div > small")).getText().contains("El apellido del cliente es requerido"));
    }
    
    @Test
    public void test_08() {
        PageCliente cliente = new PageCliente(driver);
        cliente.registrarCliente("Karo", "Chavez", "", "2020/06/25");
        sleep.SleepSeconds(5);
        Assert.assertTrue(driver.findElement(By.cssSelector("body > div > div > div.card-body > form > div:nth-child(4) > div > small")).getText().contains("El email del cliente es requerido"));
    }

    @Test
    public void test_09() {
        PageCliente cliente = new PageCliente(driver);
        cliente.registrarCliente("Karo", "Chavez", "kchavezz@gmail.com", "");
        sleep.SleepSeconds(5);
        Assert.assertTrue(driver.findElement(By.cssSelector("body > div > div > div.card-body > form > div:nth-child(5) > div > small")).getText().contains("Ingrese Fecha"));
    }
    
    @Test
    public void test_10() {
        PageCliente cliente = new PageCliente(driver);
        cliente.registrarCliente("Karo", "Chavez", "kchavezz@gmail.com", "2020-06-25");
        sleep.SleepSeconds(5);
        Assert.assertTrue(driver.findElement(By.cssSelector("body > div > div > div.card-body > form > div:nth-child(5) > div > small")).getText().contains("El formato de la fecha es invalido, debe ser yyyy/MM/dd"));
    }
    
    // Modificar Cliente Campos Vacios
  @Test
    public void test_12() throws InterruptedException {

        PageCliente cliente = new PageCliente(driver);
        cliente.modificarClienteVacio();
        sleep.SleepSeconds(5);
        Assert.assertTrue(driver.findElement(By.cssSelector("body > div > div > div.card-body > form > div:nth-child(2) > div > small")).getText().contains("El nombre del cliente es requerido"));
                                                                
    }
    //Modificar Cliente Nombre Vacio
        @Test
    public void test_13() throws InterruptedException {

        PageCliente cliente = new PageCliente(driver);
        cliente.modificarCliente("", "Fernandez", "alexafb_12@hotmail.com", "2017/08/28");
        sleep.SleepSeconds(5);
      //  Assert.assertTrue(driver.findElement(By.cssSelector("body > header > div")).getText().contains("Cliente Editado con exito"));
        Assert.assertTrue(driver.findElement(By.cssSelector("body > div > div > div.card-body > form > div:nth-child(2) > div > small")).getText().contains("El nombre del cliente es requerido"));
   
    }
 
    //Modificar Cliente Apellido Vacio    
        @Test
    public void test_14() throws InterruptedException {

        PageCliente cliente = new PageCliente(driver);
        cliente.modificarCliente("Alex", "", "alexafb_12@hotmail.com", "2017/08/28");
        sleep.SleepSeconds(5);
        Assert.assertTrue(driver.findElement(By.cssSelector("body > div > div > div.card-body > form > div:nth-child(3) > div > small")).getText().contains("El apellido del cliente es requerido"));

    }
    //Modificar Cliente Email Vacio    
        @Test
    public void test_15() throws InterruptedException {

        PageCliente cliente = new PageCliente(driver);
        cliente.modificarCliente("Alex", "Fernandez", "", "2017/08/28");
        sleep.SleepSeconds(5);
        Assert.assertTrue(driver.findElement(By.cssSelector("body > div > div > div.card-body > form > div:nth-child(4) > div > small")).getText().contains("El email del cliente es requerido"));

    }
        //Modificar Cliente Fecha Vacio    
        @Test
    public void test_16() throws InterruptedException {

        PageCliente cliente = new PageCliente(driver);
        cliente.modificarCliente("Alex", "Fernandez", "alexafb_12@hotmail.com", "");
        sleep.SleepSeconds(5);
        Assert.assertTrue(driver.findElement(By.cssSelector("body > div > div > div.card-body > form > div:nth-child(5) > div > small")).getText().contains("Ingrese Fecha"));

    }
    //Modificar Cliente Exito 
        @Test
    public void test_17() throws InterruptedException {

        PageCliente cliente = new PageCliente(driver);
        cliente.modificarCliente("Alex", "Fernandez", "alexafb_12@hotmail.com", "2017/08/28");
        sleep.SleepSeconds(5);
      Assert.assertTrue(driver.findElement(By.cssSelector("body > header > div")).getText().contains("Cliente Editado con exito"));

    }       
}
