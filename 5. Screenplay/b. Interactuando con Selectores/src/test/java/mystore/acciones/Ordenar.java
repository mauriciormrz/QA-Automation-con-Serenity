package mystore.acciones;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class Ordenar implements Task {

    private final String orden;

    public Ordenar(String orden){
        this.orden = orden;
    }

    public static Performable ordenAlfabeticoDesdeA() {
        return Instrumented
                .instanceOf(Ordenar.class)
                .withProperties("Product Name: A to Z");
    }

    @Override
    @Step("{0} ordena los resultados con el criterio: #orden")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Scroll.to(By.id("uniform-selectProductSort")),
                SelectFromOptions.byVisibleText(orden).from(By.id("uniform-selectProductSort")),
                Click.on(By.xpath("//span[@class='cat-name']"))
        );
    }
}
