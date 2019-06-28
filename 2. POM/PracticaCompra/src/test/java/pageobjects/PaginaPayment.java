package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaPayment {

    @FindBy(css = ".cheque")
    WebElement btnPagarCheque;

    @FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
    WebElement btnConfirmarOrden;

    @FindBy(className="alert")
    WebElement lblOrdenCompleta;

    public PaginaPayment(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void pagarCheque(){
        btnPagarCheque.click();
    }

    public void confirmarOrden(){
        btnConfirmarOrden.click();
    }

    public boolean resultadoOrden(String mensaje){

        System.out.println(mensaje);
        System.out.println(lblOrdenCompleta.getText());
        return mensaje.equals(lblOrdenCompleta.getText());
    }
}
