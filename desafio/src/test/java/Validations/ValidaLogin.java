package Validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import PageObjects.LoginPage;
import framework.Report.Report;
import framework.Report.Screenshot;

public class ValidaLogin {
	private WebDriver driver;
	private LoginPage login;

	public ValidaLogin(WebDriver driver) {
		this.driver = driver;
		login = new LoginPage(this.driver);
	}

	public void validaLogin() {
		try {
			String message = login.getConhecaNossosRequesitosHiperLink().getText();
			Assertions.assertEquals("Conheça nossos requisitos", message);
			Report.log(Status.PASS, "Home carregado com sucesso: " + message, Screenshot.captureBase64(driver));
		} catch (Exception e) {
			Report.log(Status.FAIL, "Erro ao validar Home: " + e);
		}
	}
}
