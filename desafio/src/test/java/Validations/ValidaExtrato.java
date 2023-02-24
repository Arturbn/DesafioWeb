package Validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import PageObjects.ExtratoPage;
import framework.Report.Report;
import framework.Report.Screenshot;

public class ValidaExtrato {
	private WebDriver driver;
	private ExtratoPage extrato;

	public ValidaExtrato(WebDriver driver) {
		this.driver = driver;
		extrato = new ExtratoPage(this.driver);
	}

	public void validaAcessoExtrato() {
		try {
			String message = extrato.getSaldoDisponivelTexto().getText();
			Assertions.assertTrue(extrato.getSaldoDisponivelTexto().isDisplayed());
			Report.log(Status.PASS, "Extrato carregado com sucesso: " + message, Screenshot.captureBase64(driver));
		} catch (Exception e) {
			Report.log(Status.FAIL, "Erro ao validar Extrato: " + e);
		}
	}
}
