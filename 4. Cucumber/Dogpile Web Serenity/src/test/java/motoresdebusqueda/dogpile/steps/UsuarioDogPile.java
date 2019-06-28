package motoresdebusqueda.dogpile.steps;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import motoresdebusqueda.dogpile.pageobject.DogPilePaginaResultado;
import motoresdebusqueda.dogpile.pageobject.DogpilePaginaPrincipal;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class UsuarioDogPile {
    String actor;

    @Steps
    DogpilePaginaPrincipal paginaPrincipal;

    @Steps
    DogPilePaginaResultado paginaResultado;
    
    @Dado("^Que el usuario entra en dogpile$")
    public void ingresa_a_dogpile() {
        paginaPrincipal.setDefaultBaseUrl("https://www.dogpile.com/");
        paginaPrincipal.open();
    }

    @Cuando("^El usuario realiza una busqueda de: (.*)$")
    public void busca_por_palabra_clave(String palabraClave) {
        paginaPrincipal.ingresarPalabraClave(palabraClave);
        paginaPrincipal.realizarBusqueda();
    }

    @Entonces("^El usuario deberia poder ver resultados que contengan la palabra: (.*)$")
    public void deberia_ver_resutlados_con_palabra(String palabraEsperada) {
        List<String> resultados = paginaResultado.obtenerResultados();
        resultados.replaceAll(String::toLowerCase);
        for (int i = 0; i < resultados.size(); i++) {
            System.out.println(resultados.get(i));
        }

        assertThat(resultados, Matchers.everyItem(containsString(palabraEsperada)));
    }

    @Entonces("^El usuario deberia ver un texto: (.*) relevante con el titulo: (.*)$")
    public void deberia_ver_resultado_de_titulo_con_texto_correcto(String textoDeResultadoEsperado, String tituloDeResultado) {
        String texto = paginaResultado.obtenerTextoDeTituloResultado(tituloDeResultado);
        System.out.println(texto);
        System.out.println(textoDeResultadoEsperado);
        assertThat(texto, containsString(textoDeResultadoEsperado));
    }
}
