package pages;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import scenarios.TesteCadastro;

import java.util.concurrent.TimeUnit;

public class CadastroPage {

    ChromeOptions options;
    WebDriver driver;
    TesteCadastro testeCadastro;

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
        testeCadastro.preencherEmail();
        testeCadastro.preencherNome();
        testeCadastro.preencherSenha();
        testeCadastro.preencherConfirmacaoSenha();
        testeCadastro.selecionaSaldo();
        testeCadastro.clicaBotaoCadastrar();
    }

    @Test
    public void testeExcecaoSemEmailCampoObrigatorio(){
        testeCadastro.clicarBotaoRegistrar();
        testeCadastro.preencherNome();
        testeCadastro.preencherSenha();
        testeCadastro.preencherConfirmacaoSenha();
        testeCadastro.selecionaSaldo();
        testeCadastro.clicaBotaoCadastrar();
    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}