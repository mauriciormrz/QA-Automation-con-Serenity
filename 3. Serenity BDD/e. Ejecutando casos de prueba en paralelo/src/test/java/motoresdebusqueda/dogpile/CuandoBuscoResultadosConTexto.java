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
public class CuandoBuscoResultadosConTexto {

    @Steps
    UsuarioDogPile mauricio;

    @Managed
    WebDriver driver;

    @Before
    public void inicializar_test(){
        System.out.println("Inicio programa");
    }

    @Test
    public void resultado_de_wikipedia_contiene_texto_correcto(){
        mauricio.ingresa_a_dogpile();

        mauricio.busca_por_palabra_clave("rock nacional");

        mauricio.deberia_ver_resultado_de_titulo_con_texto_correcto("Rock de Argentina - Wikipedia",
                "Este álbum provocó un gran impacto en el rock nacional y latino");
    }

    @After
    public void finalizar_test(){
        System.out.println("Final programa");
    }
}
