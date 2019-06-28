import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;


public class PruebaTest {

 private WebDriver firefoxDriver;

   @Before
   public void abrirDriver(){

    //encontrar archivo exe de geckodriver
    System.setProperty("webdriver.gecko.driver","src\\main\\resources");

    //creamos opciones sobre nuestro driver
    FirefoxOptions options = new FirefoxOptions();
    options.setCapability("marionette",false);

    //nueva instancia de firefox
    firefoxDriver = new FirefoxDriver(options);

    //definimos tiempo de espera
    firefoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

   }

   @Test
    public void hacer_una_busqueda(){

     //abrimos una URL
     firefoxDriver.get("https://www.google.com/");

    //encontrar e interactuar con elementos
    //ingresar texto en el buscador
     firefoxDriver.findElement(By.xpath("//input[@name='q']")).sendKeys("Cantidad de paises de America");

     //presionamos la tecla ENTER
    firefoxDriver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);

    //hacer clic sobre el link deseado
    firefoxDriver.findElement(By.xpath("//h3[contains(text(),'¿Cuántos países tiene América? | Saber es práctico')]")).click();

    //creamos un elemento web para poder hacer acciones avanzadas
    WebElement subtitulo = firefoxDriver.findElement(By.id("listado"));

    //verificamos la cantidad de pasises en America
    Assert.assertTrue(subtitulo.getText().contains("35"));

    }

    @After
    public void cerrarDriver(){

     //cerrar ventana, apagar driver
     firefoxDriver.quit();
    }
}
