package pruebas;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Compra extends BaseTestSuit {

    @Test
    public void hacer_una_compra() {

        paginaPrincipal.irASignIn();
        paginaSignIn.login("ramirezmauricio@hotmail.com","dmlg068@A");
        paginaPrincipal.irACategoriaTShirts();
        paginaCategoriaTShirts.comprarFadeShortSleave();
        paginaSummary.clickBtnCheckOut();
        paginaAddress.clickBtnCheckOut();
        paginaShipping.finalizarCompra();
        paginaPayment.pagarCheque();
        paginaPayment.confirmarOrden();
        Assert.assertTrue(paginaPayment.resultadoOrden("Your order on My Store is complete."));
    }
}
