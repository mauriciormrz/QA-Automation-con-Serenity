package mystore.acciones;

import mystore.ui.PaginaPrincipal;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class IrACategoria implements Task {

    private Target categoriaTarget;
    private static String categoriaEleggida;

    public IrACategoria(Target categoria) {
        this.categoriaTarget = categoria;
    }

    public static Performable women() {

        categoriaEleggida = "Categoria Women";
        return Instrumented.instanceOf(IrACategoria.class)
                .withProperties(PaginaPrincipal.CATEGORIA_WOMEN);
    }

    @Override
    @Step("{0} decide ir hacia la categoria: #categoriaEleggida")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(this.categoriaTarget));
    }
}

