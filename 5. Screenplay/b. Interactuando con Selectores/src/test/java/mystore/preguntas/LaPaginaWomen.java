package mystore.preguntas;

import mystore.ui.PaginaCategoriaWomen;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class LaPaginaWomen {

    public static Question<String> primerTituloDeProducto(){

        return actor -> Text.of(PaginaCategoriaWomen.TITULO_PRIMER_RESULTADO)
                .viewedBy(actor).asString();
    }
}
