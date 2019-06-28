package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaSignIn {

    @FindBy(id = "email")
    private WebElement txtEmail;

    @FindBy(id = "passwd")
    private WebElement txtPass;

    @FindBy(id = "SubmitLogin")
    private WebElement btnSummit;

    public PaginaSignIn(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    private void setTxtEmail(String email){
        txtEmail.sendKeys(email);
    }

    private void setTxtPass(String passwd){
        txtPass.sendKeys(passwd);
    }

    private void clicBtnSummit(){
        btnSummit.click();
    }

    public void login(String email, String passwd){
        setTxtEmail(email);
        setTxtPass(passwd);
        clicBtnSummit();
    }
}
