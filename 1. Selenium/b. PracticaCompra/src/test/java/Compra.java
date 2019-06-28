import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

public class Compra {

    private WebDriver firefoxDriver;
    private JavascriptExecutor js;

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

        js = (JavascriptExecutor) firefoxDriver;
    }

    @Test
    public void hacer_una_compra(){

        //abrimos una URL
        firefoxDriver.get("http://automationpractice.com/index.php");

        //boton de Sign In
        WebElement btnSignIn = firefoxDriver.findElement(By.cssSelector(".login"));
        btnSignIn.click();

        // This  will scroll down the page by  300 pixel vertical
        //js.executeScript("window.scrollBy(0,300)");

        //input de email
        WebElement txtEmail = firefoxDriver.findElement(By.id("email"));
        txtEmail.sendKeys("ramirezmauricio@hotmail.com");

        //input de password
        WebElement txtPass = firefoxDriver.findElement(By.id("passwd"));
        txtPass.sendKeys("dmlg068@A");

        //boton summit login
        WebElement btnSummit = firefoxDriver.findElement(By.id("SubmitLogin"));
        btnSummit.click();

        //pestaña de T-shirts
        WebElement tabTshirts = firefoxDriver.findElement(By.xpath("//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a[contains(text(),\"T-shirts\")]"));
        tabTshirts.click();

        //crear accion
        Actions accion = new Actions(firefoxDriver);

        // This  will scroll down the page by  600 pixel vertical
        //js.executeScript("window.scrollBy(0,600)");

        //encontrar la imagen del producto
        WebElement imgProducto =firefoxDriver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"));

        accion.moveToElement(imgProducto)
                .moveToElement(firefoxDriver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")))
                .click().build().perform();

        WebElement botonDeCompra1 = firefoxDriver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]"));

        //here, wait time is 20 seconds
        //WebDriverWait wait = new WebDriverWait(firefoxDriver, 20);

        //this will wait for element to be visible for 20 seconds
        //wait.until(ExpectedConditions.visibilityOf(botonDeCompra1));

        //now it clicks on element
        botonDeCompra1.click();

        WebElement botonDeCompra2 = firefoxDriver.findElement(By.xpath("//p//*[contains(text(),'Proceed to checkout')]"));
        botonDeCompra2.click();

        WebElement botonDeCompra3 = firefoxDriver.findElement(By.xpath("//button//span[contains(text(),'Proceed to checkout')]"));
        botonDeCompra3.click();

        WebElement checkbox = firefoxDriver.findElement(By.cssSelector("#cgv"));
        checkbox.click();

        WebElement botonDeCompra4 = firefoxDriver.findElement(By.xpath("//button[@name='processCarrier']"));
        botonDeCompra4.click();

        WebElement botonCheque = firefoxDriver.findElement(By.cssSelector(".cheque"));
        botonCheque.click();

        WebElement botonConfirmarCompra = firefoxDriver.findElement(By.xpath("//button[@class='button btn btn-default button-medium']"));
        botonConfirmarCompra.click();

        WebElement bannerOrdenCompleta = firefoxDriver.findElement(By.className("alert"));

        Assert.assertTrue(bannerOrdenCompleta.isDisplayed());

    }

    @After
    public void cerrarDriver(){

        //espera antes de cerrar ventana para observar resultado
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //cerrar ventana, apagar driver
        firefoxDriver.quit();
    }

}
