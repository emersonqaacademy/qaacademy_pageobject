package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TesteLogin {

    WebDriver driver;

    String SENHACORRETA = "123456";
    String LOGINEMAIL = "//body/div[@id='__next']//form[1]/div[1]/input[1]";
    String SENHA = "//body/div[@id='__next']//form[1]/div[2]/div[1]/input[1]";
    String BOTAOACESSAR = "//button[contains(text(),'Acessar')]";
    String BOTAOREQUISITOS = "//a[contains(text(),'Conheça nossos requisitos')]";

    public TesteLogin(WebDriver driverParametro){
        this.driver = driverParametro;
    }

    public void preencheLoginEmail(String email){
        driver.findElement(By.xpath(LOGINEMAIL)).sendKeys(email);
    }

    public void preencheSenha(String senha){
        driver.findElement(By.xpath(SENHA)).sendKeys(senha);
    }

    public void clicarBotaoAcessar(){driver.findElement(By.xpath(BOTAOACESSAR)).click();
    }

    public void clicarBotaoRequisitos(){
        driver.findElement(By.xpath(BOTAOREQUISITOS)).click();
    }
}
