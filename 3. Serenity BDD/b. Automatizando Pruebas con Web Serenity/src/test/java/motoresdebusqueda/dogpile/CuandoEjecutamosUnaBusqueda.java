package motoresdebusqueda.dogpile;

import motoresdebusqueda.dogpile.steps.UsuarioDogPile;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CuandoEjecutamosUnaBusqueda {

    @Steps
    UsuarioDogPile mauricio;

    @Managed
    WebDriver driver;

    @Before
    public void inicializar_test(){
        System.out.println("Inicio programa");
    }

    @Test
    public void deberiamos_ver_resultados_relevantes(){
        mauricio.ingresa_a_dogpile();

        mauricio.busca_por_palabra_clave("rock nacional");

        mauricio.deberia_ver_resutlados_con_palabra("rock");
    }


    @After
    public void finalizar_test(){
        System.out.println("Final programa");
    }
}
