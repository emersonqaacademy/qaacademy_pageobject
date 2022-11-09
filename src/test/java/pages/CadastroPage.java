package pages;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import scenarios.TesteCadastro;

import java.util.concurrent.TimeUnit;

public class CadastroPage {

    ChromeOptions options;
    WebDriver driver;
    TesteCadastro testeCadastro;

    String SENHACORRETA = "123456";
    String EMAIL = "teste@teste.com";
    String NOME = "Emerson";
    String CAMPOSOBRIGATORIOS = "É campo obrigatório";

    @Before
    public void setupBrowser(){
        options = new ChromeOptions();
        options.addArguments("--window-size=1810,1000");
        driver = new ChromeDriver(options);
        testeCadastro = new TesteCadastro(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:3000/#");
    }

    @Test
    public void testeCadastroComSucesso(){
        testeCadastro.clicarBotaoRegistrar();
        testeCadastro.preencherEmail(EMAIL);
        testeCadastro.preencherNome(NOME);
        testeCadastro.preencherSenha(SENHACORRETA);
        testeCadastro.preencherConfirmacaoSenha(SENHACORRETA);
        testeCadastro.selecionaSaldo();
        testeCadastro.clicaBotaoCadastrar();
        validarMensagem("foi criada com sucesso");
        testeCadastro.clicaBotaoFecharContaCriada();
    }

    @Test
    public void testeExcecaoSemEmailCampoObrigatorio(){
        testeCadastro.clicarBotaoRegistrar();
        testeCadastro.preencherNome(NOME);
        testeCadastro.preencherSenha(SENHACORRETA);
        testeCadastro.preencherConfirmacaoSenha(SENHACORRETA);
        testeCadastro.selecionaSaldo();
        testeCadastro.clicaBotaoCadastrar();
        validarMensagem(CAMPOSOBRIGATORIOS);
    }

    @Test
    public void testeCamposVazios(){
        testeCadastro.clicarBotaoRegistrar();
        testeCadastro.clicaBotaoCadastrar();
        validarMensagem(CAMPOSOBRIGATORIOS);
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
