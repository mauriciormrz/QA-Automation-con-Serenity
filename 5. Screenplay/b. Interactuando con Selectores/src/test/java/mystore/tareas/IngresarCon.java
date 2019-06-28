package mystore.tareas;

import mystore.ui.PaginaLogin;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

public class IngresarCon implements Task {

    private String usuario;
    private String contrasegnia;

    public IngresarCon(String usuario, String contrasegnia){
        this.usuario = usuario;
        this.contrasegnia = contrasegnia;
    }

    public static IngresarConBuilder usuario(String usuario) {
        return new IngresarConBuilder(usuario);
    }

    @Override
    @Step("{0} ingresa a su cuenta con usuario: #usuario, y contrasegnia: #contrasegnia")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Enter.theValue(usuario).into(PaginaLogin.EMAIL).thenHit(Keys.TAB),
                Enter.theValue(contrasegnia).into(PaginaLogin.PASSWORD),
                Click.on(PaginaLogin.BOTON_SIGN_IN)
        );
    }

    public static class IngresarConBuilder{
        private String usuario;

        public IngresarConBuilder(String usuario){
            this.usuario = usuario;
        }

        public Performable contrasegnia(String contrasegnia) {
            return Instrumented.instanceOf(IngresarCon.class).withProperties(usuario, contrasegnia);
        }
    }
}
