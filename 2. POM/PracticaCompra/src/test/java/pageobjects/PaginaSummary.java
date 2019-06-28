package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaSummary {

    @FindBy(xpath = "//p//*[contains(text(),'Proceed to checkout')]")
    WebElement btnCheckOut;

    public PaginaSummary(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickBtnCheckOut(){
        btnCheckOut.click();
    }
}
