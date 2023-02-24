package Tasks;

import org.openqa.selenium.WebDriver;

import PageObjects.HomePage;
import PageObjects.TransferenciaPage;
import Validations.ValidaTransferencia;
import framework.Utils.FilesOperation;

public class TransferenciaTask {
	private WebDriver driver;
	private HomePage homePage;
	private TransferenciaPage transferenciaPage;
	private ValidaTransferencia validaTransferencia;

	public TransferenciaTask(WebDriver driver) {
		this.driver = driver;
		transferenciaPage = new TransferenciaPage(this.driver);
		validaTransferencia = new ValidaTransferencia(this.driver);
		homePage = new HomePage(this.driver);
	}

	public void acessarTranferencia() {
		homePage.getTranferenciaButton().click();
		validaTransferencia.validaTransferencia();
	}

	public void realizarTransferencia() {

		String conta = FilesOperation.getProperties("cadastro").getProperty("pessoa2.conta");
		String digito = FilesOperation.getProperties("cadastro").getProperty("pessoa2.digito");

		transferenciaPage.getNumeroContaInput().clear();
		transferenciaPage.getNumeroContaInput().sendKeys(conta);
		transferenciaPage.getDigitoContaInput().clear();
		transferenciaPage.getDigitoContaInput().sendKeys(digito);
		transferenciaPage.getValorTransferenciaInput().sendKeys("500.00");
		transferenciaPage.getDescricaoInput().clear();
		transferenciaPage.getDescricaoInput().sendKeys("TESTE TRANFERENCIA");
		transferenciaPage.getTransferirButton().click();

		validaTransferencia.validaTransferenciaRealizada();

		transferenciaPage.getFecharButtonAlert().click();

	}

}
