import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.not;

@RunWith(SerenityRunner.class)
public class WhePregunto {

    private static Target CAJA_DE_BUSQUEDA = Target.the("Caja de busqueda de localidad")
            .located(By.id("qf-0q-destination"));

    private static Target HABITACIONES = Target.the("Selector de habitaciones")
            .located(By.id("qf-0q-compact-occupancy"));

    private static Target TITULO_DE_BUSQUEDA = Target.the("Titulo de modal realizar búsqueda")
            .located(By.xpath("//h1[@class='cont-hd-alt widget-query-heading']"));

    private static Target BOTON_DE_BUSQUEDA = Target.the("Boton de busqueda")
            .located(By.xpath("//button[@type='submit']"));

    private static Target CHECKBOX_CUATRO_ESTRELLAS = Target.the("checkbox de 4 estrellas")
            .located(By.cssSelector("#f-star-rating-4"));

    private static Target CHECKBOX_CINCO_ESTRELLAS = Target.the("checkbox de 5 estrellas")
            .located(By.cssSelector("#f-star-rating-5"));

    private static Target CHECKBOX_TRES_ESTRELLAS = Target.the("checkbox de 3 estrellas")
            .located(By.cssSelector("#f-star-rating-3"));

    private static Target HOTEL_NH = Target.the("HOTEL NH CORDOBA")
            .located(By.xpath("//a[contains(text(),'NH Córdoba Panorama')]"));

    private static Target DESCRIPCION_HABITACIONES = Target.the("Descripción de habitaciones seleccionadas")
            .located(By.xpath("//span[@class='search-rooms']"));

    private static String CONTINUAR_EN_HOTEL_COM = ".footer-continue-link";

    Actor actor;


    @Managed
    WebDriver navegador;

    @Before
    public void prepararEscennario(){

        actor = Actor.named("Mauricio");

        actor.can(BrowseTheWeb.with(navegador));
    }

    @Test
    public void realizandoPreguntasAElementos(){

        actor.attemptsTo(Open.url("https://ar.hoteles.com/"));

        //if (getDriver().findElement(By.cssSelector(CONTINUAR_EN_HOTEL_COM)).isDisplayed()) {
        //    actor.attemptsTo(Click.on(CONTINUAR_EN_HOTEL_COM));
        //}

        actor.attemptsTo(
                Enter.theValue("Córdoba, Argentina").into(CAJA_DE_BUSQUEDA).thenHit(Keys.ARROW_DOWN).thenHit(Keys.ENTER),
                SelectFromOptions.byIndex(0).from(HABITACIONES)
        );

        actor.should(
                seeThat(TheTarget.valueOf(CAJA_DE_BUSQUEDA), is("Córdoba, Argentina")),
                seeThat(TheTarget.valueOf(TITULO_DE_BUSQUEDA), is("")),
                seeThat(TheTarget.selectedValueOf(HABITACIONES), is("1 habitación, 1 adulto"))
        );

        actor.attemptsTo(
                Click.on(BOTON_DE_BUSQUEDA),
                Scroll.to(CHECKBOX_CUATRO_ESTRELLAS),
                Click.on(CHECKBOX_CUATRO_ESTRELLAS)
        );

        actor.should(
                seeThat(WebElementQuestion.the(CHECKBOX_CINCO_ESTRELLAS), not(WebElementStateMatchers.isEnabled())),
                seeThat(the(CHECKBOX_CUATRO_ESTRELLAS), isSelected()),
                seeThat(the(CHECKBOX_TRES_ESTRELLAS), Matchers.not(isSelected())),
                seeThat(the(HOTEL_NH), isVisible())
                //seeThat(the(DESCRIPCION_HABITACIONES), containsText("1 habitación, 1 adulto"))
        );


    }

}
