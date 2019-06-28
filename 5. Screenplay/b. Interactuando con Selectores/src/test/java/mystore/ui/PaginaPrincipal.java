package mystore.ui;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaPrincipal {

    public static final Target CATEGORIA_WOMEN = Target.the("Boton de categoria Women en pagina principal")
            .located(By.xpath("//a[@title='Women']"));
}
