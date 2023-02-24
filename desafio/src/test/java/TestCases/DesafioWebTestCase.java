package TestCases;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import Tasks.ExtratoTask;
import Tasks.HomeTask;
import Tasks.LoginTask;
import Tasks.RegistroTask;
import Tasks.TransferenciaTask;
import framework.TestBase;
import framework.Report.Report;
import framework.Report.ReportType;
import framework.Report.Screenshot;
import framework.Utils.FilesOperation;

public class DesafioWebTestCase extends TestBase {

	private WebDriver driver = TestBase.getDriver();
	private HomeTask homeTask = new HomeTask(this.driver); 
	private RegistroTask registroTask = new RegistroTask(this.driver);
	private LoginTask loginTask = new LoginTask(this.driver);
	private TransferenciaTask transferenciaTask = new TransferenciaTask(this.driver);
	private ExtratoTask extratoTask = new ExtratoTask(this.driver);

	@BeforeEach
	public void initialTest() throws IOException {
		getDriver().get(FilesOperation.getProperties("url").getProperty("urlProva"));
	}

	@Test
	public void rodarTesteCompleto() {

		try {
			Report.createTest("Realizar Transferência entre Contas", ReportType.GROUP);
			Report.createStep("Acessar Tela Registro");
			registroTask.acessarCadastro();
			Report.createStep("Cadastrar - PESSOA 1");
			registroTask.cadastraPessoa("pessoa1");
			Report.createStep("Acessar Tela Registro");
			registroTask.acessarCadastro();			
			Report.createStep("Cadastrar - PESSOA 2");
			registroTask.cadastraPessoa("pessoa2");
			Report.createStep("Acessar Tela Login");
			loginTask.acessarLogin();
			Report.createStep("Logar - PESSOA 1");
			loginTask.logarPessoa("pessoa1");
			Report.createStep("Acessar Tela Tranferencia");
			transferenciaTask.acessarTranferencia();
			Report.createStep("Iniciar Tranferencia - PESSOA 1 -> PESSOA 2");
			transferenciaTask.realizarTransferencia();
			Report.createStep("Retornar para home");
			homeTask.retornarParaHome();
			Report.createStep("Verificar extrato - PESSOA 1");	
			homeTask.verExtrato();
			Report.createStep("Sair da Conta - PESSOA 1");
			homeTask.sair();
			Report.createStep("Logar - PESSOA 2");
			loginTask.logarPessoa("pessoa2");
			Report.createStep("Verificar extrato - PESSOA 2");	
			homeTask.verExtrato();
			Report.createStep("Sair da Conta - PESSOA 2");
			homeTask.sair();
			Report.createStep("DEBUG DE DADOS UTILIZADOS");
			Report.log(Status.PASS, FilesOperation.getProperties("cadastro").toString());

		} catch (Exception e) {
			Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
		}

	}

}
