package mystore;

import mystore.preguntas.LaPaginaMyAccount;
import mystore.tareas.Decidido;
import mystore.tareas.IngresarCon;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.Matchers.equalTo;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


@RunWith(SerenityRunner.class)
public class CuandoUsuarioSeLoguea {

    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void prepararEscenario(){

        actor = Actor.named("Mauricio");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @Test
    public void ingresarAMyAccountCorrectamente(){
        //El actor se registra en nuestra plataforma de ventas
        //Dado
        actor.has(Decidido.ingresarConUsuarioYContrasegnia());

        //El actor quiere ingresar a su cuenta
        //Cuando
        actor.attemptsTo(IngresarCon.usuario("ramirezmauricio@hotmail.com").contrasegnia("dmlg068@A"));

        //El actor puede ver el subtitulo de la cuenta My Account
        //Entonces
        actor.should(
                seeThat("Subtitulo de pagina My Account", LaPaginaMyAccount.subtitulo(),
                        equalTo("Welcome to your account. Here you can manage all of your personal information and orders."))
        );
    }

}
