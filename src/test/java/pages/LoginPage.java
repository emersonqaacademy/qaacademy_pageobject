package pages;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import scenarios.TesteCadastro;
import scenarios.TesteLogin;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    String senhaCorreta = "123456";
    String senhaIncorreta = "0000000";
    ChromeOptions options;
    WebDriver driver;
    TesteLogin testeLogin;
    TesteCadastro testeCadastro;
    String MSGUSUARIOSENHAINVALIDA = "Usuário ou senha inválido.\nTente novamente ou verifique suas informações!";
    String EMAIL = "teste@teste.com";
    String NOME = "Emerson";

    @Before
    public void setupBrowser(){
        options = new ChromeOptions();
        options.addArguments("--window-size=1810,1000");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        testeCadastro = new TesteCadastro(driver);
        testeLogin = new TesteLogin(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:3000/#");
        cadastrarUsuario(); //Para testes de LOGIN precisamos de usuario cadastrado.

    }

    @Test
    public void loginComSucesso() throws InterruptedException {
        testeLogin.preencheLoginEmail(EMAIL);
        testeLogin.preencheSenha("123456");
        Thread.sleep(2000);
        testeLogin.clicarBotaoAcessar();
        String msgBemVindoBugBank = driver.findElement(By.xpath("//p[contains(text(),'bem vindo ao BugBank :)')]")).getText();
        validarMensagem(msgBemVindoBugBank);//Exemplo de validacao de msg apos LOGIN
        validarUrl("/home");//Exemplo validacao de pagina apos LOGIN (url)

    }

    @Test
    public void loginComExcecaoSenha(){
        testeLogin.preencheLoginEmail(EMAIL);
        testeLogin.preencheSenha(senhaIncorreta);
        testeLogin.clicarBotaoAcessar();
        validarMensagem(MSGUSUARIOSENHAINVALIDA); //Exemplo de assert.
    }

    @Test
    public void validaBotaoRequisitos(){
        testeLogin.clicarBotaoRequisitos();
        String msgRequirements = driver.findElement(By.xpath("//p[contains(text(),'Gostou do projeto e quer contribuir?')]")).getText();
        validarMensagem(msgRequirements);
        validarUrl("/requirements");//Exemplo validacao de pagina apos LOGIN (url)
    }

    public void cadastrarUsuario(){
        testeCadastro.clicarBotaoRegistrar();
        testeCadastro.preencherEmail(EMAIL);
        testeCadastro.preencherNome(NOME);
        testeCadastro.preencherSenha(senhaCorreta);
        testeCadastro.preencherConfirmacaoSenha(senhaCorreta);
        testeCadastro.selecionaSaldo();
        testeCadastro.clicaBotaoCadastrar();
        testeCadastro.clicaBotaoFecharContaCriada();
    }

    public void validarMensagem(String mensagem){
        Assert.assertTrue(driver.getPageSource().contains(mensagem));
    }
    public void validarUrl(String urlPagina) {
        Assert.assertTrue(driver.getCurrentUrl().contains(urlPagina));
    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
