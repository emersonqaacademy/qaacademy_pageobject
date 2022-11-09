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
    String BOTAOFECHARCADASTROSUCESSO = "//a[@id='btnCloseModal']";

    public TesteCadastro(WebDriver driverParametro){
        this.driver = driverParametro;
    }

    public void clicarBotaoRegistrar(){
        driver.findElement(By.xpath(BOTAOREGISTRAR)).click();
    }

    public void preencherEmail(String email){
        driver.findElement(By.xpath(EMAIL)).sendKeys(email);
    }

    public void preencherNome(String nome){
        driver.findElement(By.xpath(NOME)).sendKeys(nome);
    }

    public void preencherSenha(String senha){
        driver.findElement(By.xpath(SENHA)).sendKeys(senha);
    }

    public void preencherConfirmacaoSenha(String senha){
        driver.findElement(By.xpath(CONFIRMASENHA)).sendKeys(senha);
    }

    public void selecionaSaldo(){
        driver.findElement(By.xpath(CRIARSALDO)).click();
    }

    public void clicaBotaoCadastrar(){
        driver.findElement(By.xpath(BOTAOCADASTRAR)).click();
    }

    public void clicaBotaoFecharContaCriada(){
        driver.findElement(By.xpath(BOTAOFECHARCADASTROSUCESSO)).click();
    }
}
