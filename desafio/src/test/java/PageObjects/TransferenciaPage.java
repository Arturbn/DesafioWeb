package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.Browser.Waits;

public class TransferenciaPage {
	private WebDriver driver;
	private Waits wait;

	public TransferenciaPage(WebDriver driver) {
		this.driver = driver;
		wait = new Waits(this.driver);
	}

	public WebElement getVoltarButton() {
		return driver.findElement(By.id("btnBack"));
	}

	public WebElement getSairButton() {
		return driver.findElement(By.id("btnExit"));
	}

	public WebElement getTransferirButton() {
		return driver.findElement(
				By.xpath("//form[@class='styles__ContainerFormTransfer-sc-1oow0wh-0 hehMDu']/button [@type='submit']"));
	}

	public WebElement getNumeroContaInput() {
		return driver.findElement(By.xpath(
				"//div[@class='style__ContainerFieldInput-sc-s3e9ea-0 gQAEIG input__child']/input[@type='accountNumber']"));
	}

	public WebElement getDigitoContaInput() {
		return driver.findElement(By.xpath(
				"//div[@class='style__ContainerFieldInput-sc-s3e9ea-0 gQAEIG input__child']/input[@type='digit']"));

	}

	public WebElement getValorTransferenciaInput() {
		return driver.findElement(By.xpath(
				"//div[@class='style__ContainerFieldInput-sc-s3e9ea-0 gQAEIG input__child']/input[@type='transferValue']"));

	}

	public WebElement getDescricaoInput() {
		return driver.findElement(By.xpath(
				"//div[@class='style__ContainerFieldInput-sc-s3e9ea-0 gQAEIG input__child']/input[@type='description']"));

	}

	// validacao
	public WebElement getTexto() {
		return wait.visibilityOfElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/p"));
	}

	// alert
	public WebElement getTextoAlert() {
		return wait.visibilityOfElement(By.id("modalText"));
	}

	// alert
	public WebElement getFecharButtonAlert() {
		return driver.findElement(By.id("btnCloseModal"));
	}

}
