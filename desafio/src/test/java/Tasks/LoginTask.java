package Tasks;

import org.openqa.selenium.WebDriver;

import PageObjects.LoginPage;
import Validations.ValidaHome;
import Validations.ValidaLogin;
import framework.Utils.FilesOperation;

public class LoginTask {
	
	private WebDriver driver;
	private LoginPage loginPage;
	private ValidaLogin validaLogin;
    private ValidaHome validaHome;

	public LoginTask(WebDriver driver) {
		this.driver = driver;
		loginPage = new LoginPage(this.driver);
		validaLogin = new ValidaLogin(this.driver);		
		validaHome = new ValidaHome(this.driver);
	}
	
	public void acessarLogin() {
		validaLogin.validaLogin();
	}
	
	public void logarPessoa(String pessoa) {
		String email = FilesOperation.getProperties("cadastro").getProperty(pessoa + ".email");
		String pass = FilesOperation.getProperties("cadastro").getProperty(pessoa + ".pass");
		
		loginPage.getEmailInput().clear();
		loginPage.getEmailInput().sendKeys(email);
		loginPage.getSenhalInput().clear();		
		loginPage.getSenhalInput().sendKeys(pass);
		loginPage.getAcessarButton().click();
		
		validaHome.validaHome();
	}	
	
}
