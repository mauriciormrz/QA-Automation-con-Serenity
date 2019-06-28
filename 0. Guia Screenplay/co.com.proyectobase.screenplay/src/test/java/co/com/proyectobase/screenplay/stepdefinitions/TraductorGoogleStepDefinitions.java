package co.com.proyectobase.screenplay.stepdefinitions;

import co.com.proyectobase.screenplay.questions.LaRespuesta;
import co.com.proyectobase.screenplay.tasks.Abrir;
import co.com.proyectobase.screenplay.tasks.Traducir;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class TraductorGoogleStepDefinitions {

    @Managed(driver = "chrome")
    private WebDriver hisBrowser;
    private Actor mauricio = Actor.named("Mauricio");

    @Before
    public void configuracionInicial() {
        mauricio.can(BrowseTheWeb.with(hisBrowser));
    }

    @Given("^That Mauricio want to use Google Translate$")
    public void thatMauricioWantToUseGoogleTranslate() {
        mauricio.wasAbleTo(Abrir.laPaginaDeGoogle());
    }

    @When("^he translate the word (.*) from English to Spanish$")
    public void heTranslateTheWordTableFromEnglishToSpanish(String palabra) {
        mauricio.attemptsTo(Traducir.deInglesAEspanolLa(palabra));
    }

    @Then("^he should see the word (.*) on the screen$")
    public void heShouldSeeTheWordMesaOnTheScreen(String palabraEsperada) {
        mauricio.should(seeThat(LaRespuesta.es(), equalTo(palabraEsperada)));
    }

    @After
    public void finalizarEscenario() {
        System.out.println("Final Programa");
    }
}
