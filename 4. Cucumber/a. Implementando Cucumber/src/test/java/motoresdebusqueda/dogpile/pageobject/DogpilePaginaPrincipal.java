package motoresdebusqueda.dogpile.pageobject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.dogpile.com/")
public class DogpilePaginaPrincipal extends PageObject {

    @FindBy(css = "#q")
    WebElementFacade cajaDeBusqueda;

    @FindBy(css = ".search-form-home__button")
    WebElementFacade botonDeBusqueda;

    public void ingresarPalabraClave(String palabraClave) {
        cajaDeBusqueda.type(palabraClave);
    }

    public void realizarBusqueda() {
        botonDeBusqueda.click();
    }
}
