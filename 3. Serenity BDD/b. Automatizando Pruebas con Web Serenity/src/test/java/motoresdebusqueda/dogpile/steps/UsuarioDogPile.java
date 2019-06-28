package motoresdebusqueda.dogpile.steps;

import motoresdebusqueda.dogpile.pageobject.DogPilePaginaResultado;
import motoresdebusqueda.dogpile.pageobject.DogpilePaginaPrincipal;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;

public class UsuarioDogPile {

    DogpilePaginaPrincipal paginaPrincipal;
    DogPilePaginaResultado paginaResultado;

    @Step()
    public void ingresa_a_dogpile() {
        paginaPrincipal.open();
    }

    @Step()
    public void busca_por_palabra_clave(String palabraClave) {
        paginaPrincipal.ingresarPalabraClave(palabraClave);
        paginaPrincipal.realizarBusqueda();
    }

    @Step()
    public void deberia_ver_resutlados_con_palabra(String palabraEsperada) {
        List<String> resultados = paginaResultado.obtenerResultados();
        resultados.replaceAll(String::toLowerCase);
        for (int i = 0; i < resultados.size(); i++) {
            System.out.println(resultados.get(i));
        }
        assertThat(resultados, Matchers.everyItem(Matchers.containsString(palabraEsperada)));
    }
}
