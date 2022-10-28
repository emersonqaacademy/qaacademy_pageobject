package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TesteCadastro {
    WebDriver driver;

    String BOTAOREGISTRAR = "//button[contains(text(),'Registrar')]";
    String EMAIL = "//body/div[@id='__next']//form[1]/div[2]/input[1]";
    String NOME = "//body/div[@id='__next']//form[1]/div[3]/input[1]";
    String SENHA = "//body/div[@id='__next']//form[1]/div[4]//input[1]";
    String CONFIRMASENHA = "//body/div[@id='__next']//form[1]/div[5]//input[1]";
    String CRIARSALDO = "//label[@id='toggleAddBalance']";
    String BOTAOCADASTRAR = "//button[contains(text(),'Cadastrar')]";

    public TesteCadastro(WebDriver driverParametro){
        this.driver = driverParametro;
    }

    public void clicarBotaoRegistrar(){
        driver.findElement(By.xpath(BOTAOREGISTRAR)).click();
    }

    public void preencherEmail(){
        driver.findElement(By.xpath(EMAIL)).sendKeys("teste@teste.com");
    }

    public void preencherNome(){
        driver.findElement(By.xpath(NOME)).sendKeys("Emerson");
    }

    public void preencherSenha(){
        driver.findElement(By.xpath(SENHA)).sendKeys("123456");
    }

    public void preencherConfirmacaoSenha(){
        driver.findElement(By.xpath(CONFIRMASENHA)).sendKeys("123456");
    }

    public void selecionaSaldo(){
        driver.findElement(By.xpath(CRIARSALDO)).click();
    }

    public void clicaBotaoCadastrar(){
        driver.findElement(By.xpath(BOTAOCADASTRAR)).click();
    }
}
