package mystore.preguntas;

import mystore.ui.PaginaMiCuenta;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class LaPaginaMyAccount {

    public static Question<String> subtitulo(){
        return actor -> Text.of(PaginaMiCuenta.SUBTITULO)
                .viewedBy(actor).asString();
    }
}
