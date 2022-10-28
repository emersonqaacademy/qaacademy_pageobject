package pages;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import scenarios.TesteCadastro;
import scenarios.TesteLogin;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    String senhaIncorreta = "4567890";
    ChromeOptions options;
    WebDriver driver;
    TesteLogin testeLogin;
    TesteCadastro testeCadastro;

    @Before
    public void setupBrowser(){
        options = new ChromeOptions();
        options.addArguments("--window-size=1810,1000");
        driver = new ChromeDriver(options);
        testeCadastro = new TesteCadastro(driver);
        testeLogin = new TesteLogin(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:3000/#");
    }

    @Test
    public void loginComSucesso(){
        testeLogin.preencheLoginEmail();
        testeLogin.preencheSenha("123456");
        testeLogin.clicarBotaoAcessar();
    }

    @Test
    public void loginComExcecaoSenha(){
        testeLogin.preencheLoginEmail();
        testeLogin.preencheSenha(senhaIncorreta);
        testeLogin.clicarBotaoAcessar();
        String textoEsperado = "Usuário ou senha inválido.\nTente novamente ou verifique suas informações!";
        Assert.assertTrue(driver.getPageSource().contains(textoEsperado));
    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
