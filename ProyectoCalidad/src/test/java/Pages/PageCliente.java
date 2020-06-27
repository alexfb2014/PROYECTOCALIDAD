package Pages;

import Helpers.HelperSleep;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class PageCliente {

    private final WebDriver driver;
    private final HelperSleep splee;
    private final By nombre;
    private final By apellido;
    private final By email;
    private final By fecha;
    private final By btnEliminar;
    private final By btnGuardar;
    private final By btnCrear;
    private By btnModificar;
    private final By btnDetalle;
    
    public PageCliente(WebDriver driver) {
        this.driver = driver;
        this.splee = new HelperSleep();
        btnCrear = By.cssSelector("#crearCliente");
        nombre = By.cssSelector("#nombre");
        apellido = By.cssSelector("#apellido");
        email = By.cssSelector("#email");
        fecha = By.cssSelector("#createAt");
        btnGuardar = By.cssSelector("#btnguardar");
        btnEliminar = By.cssSelector("body > div > div > div.card-body > table > tbody > tr:nth-child(1) > td:nth-child(8) > a");
        btnModificar = By.cssSelector("body > div > div > div.card-body > table > tbody > tr:nth-child(1) > td:nth-child(7) > a");
        btnDetalle = By.cssSelector("body > div > div > div.card-body > table > tbody > tr:nth-child(5) > td:nth-child(1) > a");
    }

    public void registrarCliente(String nom, String ape, String correo, String fec) {
        driver.findElement(btnCrear).click();
        splee.SleepSeconds(5);
        driver.findElement(nombre).sendKeys(nom);
        driver.findElement(apellido).sendKeys(ape);
        driver.findElement(email).sendKeys(correo);
        driver.findElement(fecha).sendKeys(fec);
        splee.SleepSeconds(3);
        driver.findElement(btnGuardar).click();
    }

    public void registrarClienteVacio() {
        driver.findElement(btnCrear).click();
        splee.SleepSeconds(5);
        driver.findElement(btnGuardar).click();
    }

    public void eliminarCliente() {
        driver.findElement(btnEliminar).click();
        Alert alert = driver.switchTo().alert();
        splee.SleepSeconds(5);
        alert.accept();

    }
    public void modificarCliente(String nom, String ape, String correo, String fec){
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
        driver.findElement(btnModificar).click();
        splee.SleepSeconds(3);
        driver.findElement(nombre).clear();  
        driver.findElement(apellido).clear();
        driver.findElement(email).clear();
        driver.findElement(fecha).clear();
        driver.findElement(nombre).sendKeys(nom);  
        driver.findElement(apellido).sendKeys(ape);
        driver.findElement(email).sendKeys(correo);
        driver.findElement(fecha).sendKeys(fec);
        splee.SleepSeconds(3);
        driver.findElement(btnGuardar).click();
        
    }
      public void modificarClienteVacio(){
  
        driver.findElement(btnModificar).click(); 
        splee.SleepSeconds(3);
        driver.findElement(nombre).clear();  
        driver.findElement(apellido).clear();
        driver.findElement(email).clear();
        driver.findElement(fecha).clear();
        splee.SleepSeconds(4);
        driver.findElement(btnGuardar).click();
  
    }
      
      public void mostrarCliente(){
          driver.findElement(btnDetalle).click();
      }
    
}
