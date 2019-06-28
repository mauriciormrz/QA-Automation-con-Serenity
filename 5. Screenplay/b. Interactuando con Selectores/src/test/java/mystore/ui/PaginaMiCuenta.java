package mystore.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;


public class PaginaMiCuenta {

    public static final Target SUBTITULO = Target.the("Subtitulo de la pagina My Account")
            .located(By.cssSelector(".info-account"));
}
