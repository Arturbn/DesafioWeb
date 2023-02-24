package Validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import PageObjects.CadastroPage;
import framework.Report.Report;
import framework.Report.Screenshot;

public class ValidaCadastro {
	private WebDriver driver;
	private CadastroPage cadastroPage;

	public ValidaCadastro(WebDriver driver) {
		this.driver = driver;
		cadastroPage = new CadastroPage(this.driver);
	}

	public void validaCadastro() {
		try {
			String message = cadastroPage.getCriarContaComSaldoText().getText();
			Assertions.assertEquals("Criar conta com saldo ?", message);
			Assertions.assertTrue(cadastroPage.getCriarContaComSaldoText().isDisplayed());
			Report.log(Status.PASS, "Cadastro carregado com sucesso: " + message, Screenshot.captureBase64(driver));
		} catch (Exception e) {
			Report.log(Status.FAIL, "Nao esta na Cadastro: " + e);
		}

	}

	public void validaCriacaoConta() {
		try {

			// wait.(cadastroPage.getCriarContaComSaldoText().isDisplayed());
			String message = cadastroPage.getTextoContaCriada().getText();
			Assertions.assertNotNull(message);
			Assertions.assertTrue(cadastroPage.getCriarContaComSaldoText().isDisplayed());
			Report.log(Status.PASS, "Conta criada com sucesso: " + message, Screenshot.captureBase64(driver));
		} catch (Exception e) {
			Report.log(Status.FAIL, "Nao criou conta: " + e);
		}

	}

}
