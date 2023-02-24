package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.Browser.Waits;

public class HomePage {
	private WebDriver driver;
	private Waits wait;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		wait = new Waits(this.driver);
	}
	
	public WebElement getVoltarButton() {
		return driver.findElement(By.id("btnBack"));
	}

	public WebElement getTranferenciaButton() {
		return driver.findElement(By.id("btn-TRANSFERÊNCIA"));
	}

	public WebElement getPagamentosButton() {
		return driver.findElement(By.id("btn-PAGAMENTOS"));
	}		
	
	public WebElement getExtratoButton() {
		return driver.findElement(By.id("btn-EXTRATO"));
	}
	
	public WebElement getSaqueButton() {
		return driver.findElement(By.id("btn-SAQUE"));
	}	

	public WebElement getSairButton() {
		return driver.findElement(By.id("btnExit"));
	}

	// validacao
	public WebElement getContaTexto() {
		return wait.visibilityOfElement(By.id("textAccountNumber"));
	}

	public WebElement getContaDigitalTexto() {
		return driver.findElement(By.id("textAccountNumber"));
	}

}
