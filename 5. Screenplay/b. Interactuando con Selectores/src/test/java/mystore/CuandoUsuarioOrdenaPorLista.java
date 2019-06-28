package mystore;

import mystore.acciones.IrACategoria;
import mystore.acciones.Ordenar;
import mystore.tareas.Decidido;
import mystore.preguntas.LaPaginaWomen;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static java.time.temporal.ChronoUnit.SECONDS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;


@RunWith(SerenityRunner.class)
public class CuandoUsuarioOrdenaPorLista {

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
        BrowseTheWeb.as(actor).setImplicitTimeout(20,SECONDS);
        actor.has(Decidido.ingresarConUsuarioYContrasegnia());

        actor.attemptsTo(IrACategoria.women());

        actor.attemptsTo(Ordenar.ordenAlfabeticoDesdeA());

        actor.should(
                seeThat("Titulo del primer resultado por orden alfabetico es blouse",
                        LaPaginaWomen.primerTituloDeProducto(),
                        equalTo("Blouse")));
    }

}
