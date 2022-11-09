package pages;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import scenarios.TesteCadastro;
import scenarios.TesteRequirements;

import java.util.concurrent.TimeUnit;

public class RequirementsPage {
    ChromeOptions options;
    WebDriver driver;

    TesteRequirements testeRequirements;

    @Before
    public void setupBrowser(){
        options = new ChromeOptions();
        options.addArguments("--window-size=1810,1000");
        driver = new ChromeDriver(options);
        testeRequirements = new TesteRequirements(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://0.0.0.0:3000/requirements");
    }

    @Test
    public void validarConteudoLogin(){
        testeRequirements.clicarBotaoLoginRequirements();
        validarMensagem("- Email e Senha são campos obrigatórios.");
    }

    @Test
    public void validarConteudoCadastro(){
        testeRequirements.clicarCadastroRequirements();
        validarMensagem("- Os campos Nome, Email, Senha e Confirmação de senha são de preenchimento obrigatório");
    }

    @Test
    public void validarConteudoTransferencia(){
        testeRequirements.clicarTransferenciaRequirements();
        validarMensagem("- Só é permitido transferência para contas válidas");
    }

    @Test
    public void validarConteudoPagamento(){
        testeRequirements.clicarBotaoPagamentoRequirements();
        validarMensagem("- Em desenvolvimento");
    }

    @Test
    public void validarConteudoExtrato(){
        testeRequirements.clicarBotaoExtratoRequirements();
        validarMensagem("- Deve exibir o saldo disponível no momento");
    }

    @Test
    public void validarConteudoSaque(){
        testeRequirements.clicarBotaoSaqueRequirements();
        validarMensagem("- Em desenvolvimento");
    }

    public void validarMensagem(String msgExibida){
        Assert.assertTrue(driver.getPageSource().contains(msgExibida));
    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}
