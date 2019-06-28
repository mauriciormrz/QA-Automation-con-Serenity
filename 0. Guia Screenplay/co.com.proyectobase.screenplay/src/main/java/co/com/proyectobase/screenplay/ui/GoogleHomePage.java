package co.com.proyectobase.screenplay.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://www.google.com/")
public class GoogleHomePage extends PageObject {

    public static final Target BOTON_APLICACIONES = Target.the("El boton que muestra las aplicaciones")
            .located(By.id("gbwa"));

    public static final Target BOTON_GOOGLE_TRANSLATE = Target.the("Boton de app traductor")
            .located(By.id("gb51"));
}
