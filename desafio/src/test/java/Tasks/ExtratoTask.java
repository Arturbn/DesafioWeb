package Tasks;

import org.openqa.selenium.WebDriver;

import PageObjects.ExtratoPage;
import Validations.ValidaExtrato;
import Validations.ValidaHome;

public class ExtratoTask {

	private WebDriver driver;
	private ExtratoPage extratoPage;
	private ValidaExtrato validaExtrato;
	private ValidaHome validaHome;

	public ExtratoTask(WebDriver driver) {
		this.driver = driver;
		extratoPage = new ExtratoPage(this.driver);
		validaHome = new ValidaHome(this.driver);		
	}

	public void acessarExtrato() {
		validaExtrato.validaAcessoExtrato();
	}
	
	public void sairExtrato() {
		extratoPage.getVoltarButton().click();
		
		validaHome.validaHome();
	}
			
}
