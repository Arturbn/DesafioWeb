package Validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import PageObjects.HomePage;
import framework.Report.Report;
import framework.Report.Screenshot;

public class ValidaHome {
	private WebDriver driver;
	private HomePage homePage;

	public ValidaHome(WebDriver driver) {
		this.driver = driver;
		homePage = new HomePage(this.driver);
	}

	public void validaHome() {
		try {
			String message = homePage.getContaTexto().getText();
			Assertions.assertTrue(homePage.getContaTexto().isDisplayed());
			Report.log(Status.PASS, "Home: " + message, Screenshot.captureBase64(driver));
		} catch (Exception e) {
			Report.log(Status.FAIL, "Nao navegou para a home: " + e);
		}

	}
}
