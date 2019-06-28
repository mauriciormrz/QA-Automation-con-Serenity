package pruebas;

import org.junit.After;
import org.junit.Before;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pageobjects.*;

import java.util.concurrent.TimeUnit;

public class BaseTestSuit {

     WebDriver firefoxDriver;

    PaginaPrincipal paginaPrincipal;
    PaginaSignIn paginaSignIn;
    PaginaCategoriaTShirts paginaCategoriaTShirts;
    PaginaSummary paginaSummary;
    PaginaAddress paginaAddress;
    PaginaShipping paginaShipping;
    PaginaPayment  paginaPayment;

    public void inicializarPaginas(WebDriver driver){

        paginaPrincipal = new PaginaPrincipal(driver);
        paginaSignIn = new PaginaSignIn(driver);
        paginaCategoriaTShirts = new PaginaCategoriaTShirts(driver);
        paginaSummary = new PaginaSummary(driver);
        paginaAddress = new PaginaAddress(driver);
        paginaShipping = new PaginaShipping(driver);
        paginaPayment = new PaginaPayment(driver);
    }

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

        inicializarPaginas(firefoxDriver);

        //abrimos una URL
        firefoxDriver.get("http://automationpractice.com/index.php");

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
