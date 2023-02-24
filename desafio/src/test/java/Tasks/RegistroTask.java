package Tasks;

import org.openqa.selenium.WebDriver;

import PageObjects.CadastroPage;
import PageObjects.LoginPage;
import Validations.ValidaCadastro;
import Validations.ValidaLogin;
import framework.Utils.FakersGeneration;
import framework.Utils.FilesOperation;

public class RegistroTask {
	private WebDriver driver;
	private LoginPage loginPage;
	private CadastroPage cadastroPage;
	private ValidaLogin validaHome;
	private ValidaCadastro validaCadastro;
	private FakersGeneration fakers;

	public RegistroTask(WebDriver driver) {
		this.driver = driver;
		loginPage = new LoginPage(this.driver);
		cadastroPage = new CadastroPage(this.driver);
		validaHome = new ValidaLogin(this.driver);
		validaCadastro = new ValidaCadastro(this.driver);
		fakers = new FakersGeneration();
	}

	public void acessarCadastro() {
		validaHome.validaLogin();
		loginPage.getRegistrarButton().click();
		validaCadastro.validaCadastro();
	}

	public void cadastraPessoa(String pessoa) {

		String name = fakers.getName();
		String email = fakers.getEmail();
		String pass = fakers.getPass();
		
		FilesOperation.setProperties("cadastro", pessoa + ".name", name);
		FilesOperation.setProperties("cadastro", pessoa + ".email", email);
		FilesOperation.setProperties("cadastro", pessoa + ".pass", pass);

		cadastroPage.getEmailInput().clear();
		cadastroPage.getEmailInput().sendKeys(email);
		cadastroPage.getNomeInput().clear();
		cadastroPage.getNomeInput().sendKeys(name);
		cadastroPage.getSenhaInput().clear();
		cadastroPage.getSenhaInput().sendKeys(pass);
		cadastroPage.getConfirmaSenhaInput().clear();		
		cadastroPage.getConfirmaSenhaInput().sendKeys(pass);
		cadastroPage.getCriarContaComSaldoButton().click();
		cadastroPage.getCadastrarButton().click();

		String[] conta = cadastroPage.getTextoContaCriada().getText().replaceAll("[^\\d-]", "").split("-");
		FilesOperation.setProperties("cadastro", pessoa + ".conta", conta[0]);
		FilesOperation.setProperties("cadastro", pessoa + ".digito", conta[1]);

		validaCadastro.validaCriacaoConta();		
		cadastroPage.getFecharModalButton().click();

	}

}
