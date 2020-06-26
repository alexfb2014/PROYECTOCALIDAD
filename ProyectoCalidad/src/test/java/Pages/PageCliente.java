/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

/**
 *
 * @author KAROLINE
 */
public class PageCliente {
    private WebDriver driver;
    private By nombre;
    private By apellido;
    private By email;
    private By fecha;
    private By btnGuardar;
    private By btnCrear;
    
    public PageCliente(WebDriver driver) {
        this.driver = driver;
        nombre = By.cssSelector("#nombre");
        apellido = By.cssSelector("#apellido");
        email = By.cssSelector("#email");
        fecha = By.cssSelector("#createAt");
        btnCrear = By.cssSelector("body > div > div > div.card-body > h4 > a");
        btnGuardar = By.id("btnguardar"); // tiene que agregar el id al boton de guardar para que reconozca
        
    }
    
    public void registrarCliente(String nom, String ape, String correo, String fec){
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(btnCrear).click();
        driver.findElement(nombre).sendKeys(nom);  
        driver.findElement(apellido).sendKeys(ape);
        driver.findElement(email).sendKeys(correo);
        driver.findElement(fecha).sendKeys(fec);
        driver.findElement(btnGuardar).click();
    }
    
    public void registrarClienteVacio(){
      
        driver.findElement(btnCrear).click();        
        driver.findElement(btnGuardar).click();
    }
    
    
}
