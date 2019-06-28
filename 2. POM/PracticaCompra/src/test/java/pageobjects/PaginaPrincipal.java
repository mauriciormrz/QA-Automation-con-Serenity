package pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaPrincipal {

    @FindBy(className = "login")
    private WebElement botonSignIn;

    @FindBy(xpath = "//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a[contains(text(),\"T-shirts\")]")
    private  WebElement tabTshirts;

    public void irASignIn(){
        botonSignIn.click();
    }

    public void irACategoriaTShirts(){
        tabTshirts.click();
    }

    public PaginaPrincipal(WebDriver driver){

        PageFactory.initElements(driver, this);
    }
}
