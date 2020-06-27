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
}