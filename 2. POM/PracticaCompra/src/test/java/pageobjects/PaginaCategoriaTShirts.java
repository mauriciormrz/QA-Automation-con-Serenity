package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaCategoriaTShirts {

    WebDriver driver;
    //JavascriptExecutor js;

    @FindBy(xpath = "//a[contains(text(),'Faded Short Sleeve T-shirts')]")
    private WebElement imgProducto;

    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    private WebElement btnAgregarACarrito;

    @FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
    private WebElement btnCheckOut;

    public PaginaCategoriaTShirts(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void comprarFadeShortSleave(){

        //js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,600)");
        Actions accion = new Actions(driver);
        accion.moveToElement(imgProducto).moveToElement(btnAgregarACarrito).click().build().perform();
        btnCheckOut.click();
    }
}
