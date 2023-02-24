package Validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import PageObjects.TransferenciaPage;
import framework.Report.Report;
import framework.Report.Screenshot;

public class ValidaTransferencia {
	private WebDriver driver;
	private TransferenciaPage transferenciaPage;

	public ValidaTransferencia(WebDriver driver) {
		this.driver = driver;
		transferenciaPage = new TransferenciaPage(this.driver);
	}

	public void validaTransferencia() {
		try {
			String message = transferenciaPage.getTexto().getText();
			// Assertions.assertEquals("Criar conta com saldo ?", message);
			Assertions.assertTrue(transferenciaPage.getTexto().isDisplayed());
			Report.log(Status.PASS, "Transferencia carregada com sucesso: " + message, Screenshot.captureBase64(driver));
		} catch (Exception e) {
			Report.log(Status.FAIL, "Transferencia nao carregada: " + e);
		}

	}
	
	public void validaTransferenciaRealizada() {
		try {

			// wait.(cadastroPage.getCriarContaComSaldoText().isDisplayed());
			String message = transferenciaPage.getTextoAlert().getText();
			Assertions.assertEquals("Transferencia realizada com sucesso", message);
			Assertions.assertTrue(transferenciaPage.getFecharButtonAlert().isDisplayed());
			Report.log(Status.PASS, "Transferencia realizada com sucesso: " + message, Screenshot.captureBase64(driver));
		} catch (Exception e) {
			Report.log(Status.FAIL, "Nao Transferiu: " + e);
		}

	}	
}
