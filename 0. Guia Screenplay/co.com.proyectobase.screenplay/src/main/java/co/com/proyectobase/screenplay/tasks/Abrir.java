package co.com.proyectobase.screenplay.tasks;

import co.com.proyectobase.screenplay.ui.GoogleHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Abrir implements Task {

    private GoogleHomePage googleHomePage;

    public Abrir(){
    }

    public static Performable laPaginaDeGoogle() {

        return instrumented(Abrir.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Open.browserOn(googleHomePage));
    }
}
