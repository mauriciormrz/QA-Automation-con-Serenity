package co.com.proyectobase.screenplay.tasks;

import co.com.proyectobase.screenplay.ui.GoogleHomePage;
import co.com.proyectobase.screenplay.ui.GoogleTraductorPage;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class Traducir implements Task {

    private String palabra;

    public Traducir(String palabra){
        this.palabra = palabra;
    }

    public static Performable deInglesAEspanolLa(String palabra) {
       // return instrumented(Traducir.class, palabra);
        return Instrumented.instanceOf(Traducir.class).withProperties(palabra);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(GoogleHomePage.BOTON_APLICACIONES));

        /*
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */

        actor.attemptsTo(
                WaitUntil.the(GoogleHomePage.BOTON_GOOGLE_TRANSLATE, isEnabled()).forNoMoreThan(30).seconds(),
                Click.on(GoogleHomePage.BOTON_GOOGLE_TRANSLATE)
        );

       // actor.attemptsTo(Click.on(GoogleHomePage.BOTON_GOOGLE_TRANSLATE));
/*
        actor.attemptsTo(Click.on(GoogleTraductorPage.BOTON_LENGUAJE_ORIGEN),
                Enter.theValue("English")
                        .into(GoogleTraductorPage.CAJA_TEXTO_LENGUAJE_ORIGEN)
                        .thenHit(Keys.ENTER)
        );

        actor.attemptsTo(Click.on(GoogleTraductorPage.BOTON_LENGUAJE_DESTINO),
                Enter.theValue("Spanish")
                        .into(GoogleTraductorPage.CAJA_TEXTO_LENGUAJE_DESTINO)
                        .thenHit(Keys.ENTER)
        );
*/
        actor.attemptsTo(Enter.theValue(palabra)
                .into(GoogleTraductorPage.AREA_DE_TRADUCCION)
        );
    }
}
