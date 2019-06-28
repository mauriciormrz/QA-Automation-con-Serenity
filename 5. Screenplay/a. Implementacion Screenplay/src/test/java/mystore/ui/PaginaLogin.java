package mystore.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class PaginaLogin {

    public static final Target EMAIL = Target.the("Entrada de EMAIL").located(By.id("email"));
    public static final Target PASSWORD = Target.the("Entrada de PASSWORD").located(By.id("passwd"));
    public static final Target BOTON_SIGN_IN = Target.the("Botond de sign-in").located(By.id("SubmitLogin"));

}
