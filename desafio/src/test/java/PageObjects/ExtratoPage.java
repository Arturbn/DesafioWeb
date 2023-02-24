package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.Browser.Waits;

public class ExtratoPage {
	private WebDriver driver;
	private Waits wait;	

	public ExtratoPage(WebDriver driver) {
		this.driver = driver;
		wait = new Waits(this.driver);
	}

	public WebElement getVoltarButton() {
		return driver.findElement(By.id("btnBack"));
	}

	public WebElement getSairButton() {
		return driver.findElement(By.id("btnExit"));

	}

//validacao
	public WebElement getSaldoDisponivelTexto() {
		return wait.visibilityOfElement(By.id("textBalanceAvailable"));
	}
}
