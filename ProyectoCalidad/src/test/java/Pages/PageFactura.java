/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages;

import Helpers.HelperSleep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author ANDERSSON
 */
public class PageFactura {
    HelperSleep sleep;
    private WebDriver driver;
    private By btnNuevaFactura;
    private By btnCrearFactura;
    private By CajaDescripcion;
    private By CajaObservacion;
    private By BuscarProducto;

    public PageFactura(WebDriver driver) {
        this.driver = driver;
        sleep = new HelperSleep();
        btnNuevaFactura = By.cssSelector("body > div > div > div.card-body > table > tbody > tr:nth-child(3) > td:nth-child(6) > a");
        btnCrearFactura = By.cssSelector("body > div.container.py-4 > div > div.card-body > form > div:nth-child(9) > div > input");
        CajaDescripcion = By.id("descripcion");
        CajaObservacion = By.id("observacion");
        BuscarProducto = By.id("buscar_producto");
    
    }
    
    public void ClickBtnNuevaFactura(){
        
        driver.findElement(btnNuevaFactura).click();    
    }
    
    public void ClickBtnCrearFactura(){
        driver.findElement(btnCrearFactura).click();
    }
    
    public void IngresarDescYObserv(String descripcion, String observacion){
        
        driver.findElement(CajaDescripcion).sendKeys(descripcion);
        sleep.SleepSeconds(2);
        driver.findElement(CajaObservacion).sendKeys(observacion);
    }
    
    public void IngresarBuscarProducto(String producto){
        
        driver.findElement(BuscarProducto).sendKeys(producto);
        sleep.SleepSeconds(2);
    }
    
    public void SeleccionarProducto(String producto, int cantidad){
        driver.findElement(BuscarProducto).sendKeys(producto);
        sleep.SleepSeconds(2);
        driver.findElement(By.id("ui-id-2")).click();
        sleep.SleepSeconds(2);
        driver.findElement(By.id("cantidad_2")).clear();
        sleep.SleepSeconds(2);
        driver.findElement(By.id("cantidad_2")).sendKeys(cantidad+"");
        sleep.SleepSeconds(2);
        driver.findElement(BuscarProducto).sendKeys("a");
        sleep.SleepSeconds(2);
    }
    
    public void LimpiarBuscarProducto(){
        
        driver.findElement(BuscarProducto).clear();
        
    }
}
