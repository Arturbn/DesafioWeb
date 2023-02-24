package Tasks;

import org.openqa.selenium.WebDriver;

import PageObjects.HomePage;
import Validations.ValidaExtrato;
import Validations.ValidaHome;
import Validations.ValidaLogin;

public class HomeTask {
	
	private WebDriver driver;
	private HomePage homePage;
    private ValidaHome validaHome;
    private ValidaLogin validaLogin;    
    private ValidaExtrato validaExtrato;

	public HomeTask(WebDriver driver) {
		this.driver = driver;
		homePage = new HomePage(this.driver);
		validaHome = new ValidaHome(this.driver);
		validaLogin= new ValidaLogin(this.driver);
		validaExtrato = new ValidaExtrato(this.driver);
	}
	
	public void acessarHome() {
		validaHome.validaHome();
	}
	
	public void retornarParaHome() {		
		homePage.getVoltarButton().click();
		validaHome.validaHome();
	}
	
	public void verExtrato() {
		homePage.getExtratoButton().click();
		validaExtrato.validaAcessoExtrato();
	}
	
	public void sair() {
		homePage.getSairButton().click();
		validaLogin.validaLogin();		
	}
}
