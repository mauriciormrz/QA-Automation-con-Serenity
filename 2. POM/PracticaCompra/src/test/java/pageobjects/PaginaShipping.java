package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaShipping {

    @FindBy(css="#cgv")
    WebElement chkAceptoCondiciones;

    @FindBy(name="processCarrier")
    WebElement btnCheckOut;

    public PaginaShipping(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void finalizarCompra(){
        chkAceptoCondiciones.click();
        btnCheckOut.click();
    }
}
