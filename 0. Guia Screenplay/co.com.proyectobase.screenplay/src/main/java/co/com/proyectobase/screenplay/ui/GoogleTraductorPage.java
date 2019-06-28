package co.com.proyectobase.screenplay.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import sun.security.provider.PolicySpiFile;

public class GoogleTraductorPage {

    public static final Target BOTON_LENGUAJE_ORIGEN = Target.the("Boton del idioma origen")
            .located(By.cssSelector(".tlid-open-source-language-list"));

    public static final Target CAJA_TEXTO_LENGUAJE_ORIGEN = Target.the("Caja de texto de idioma origen")
            .located(By.id("sl_list-search-box"));

    public static final Target BOTON_LENGUAJE_DESTINO = Target.the("Boton del idioma destino")
            .located(By.cssSelector(".tlid-open-target-language-list"));

    public static final Target CAJA_TEXTO_LENGUAJE_DESTINO = Target.the("Caja de texto de idioma origen")
            .located(By.id("tl_list-search-box"));

    public static final Target AREA_DE_TRADUCCION = Target.the("El lugar donde se escriben las palabras a traducir")
            .located(By.id("source"));

    public static final Target AREA_TRADUCIDA = Target.the("El area donde ya se presenta la palabra traducida")
            .located(By.xpath("//div[@class='text-wrap tlid-copy-target']"));
}
