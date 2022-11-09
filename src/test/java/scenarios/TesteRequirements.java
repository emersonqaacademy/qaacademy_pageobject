package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TesteRequirements {

    WebDriver driver;

    public TesteRequirements(WebDriver driverParametro){
        this.driver = driverParametro;
    }

    public void clicarBotaoLoginRequirements(){
        driver.findElement(By.xpath("//div[@id='accordionLogin']")).click();
    }

    public void clicarCadastroRequirements(){
        driver.findElement(By.xpath("//div[@id='accordionCadastro']")).click();
    }

    public void clicarTransferenciaRequirements(){
        driver.findElement(By.xpath("//div[@id='accordionTransferência']")).click();
    }

    public void clicarBotaoPagamentoRequirements(){
        driver.findElement(By.xpath("//div[@id='accordionPagamento']")).click();
    }

    public void clicarBotaoExtratoRequirements(){
        driver.findElement(By.xpath("//div[@id='accordionExtrato']")).click();
    }

    public void clicarBotaoSaqueRequirements(){
        driver.findElement(By.xpath("//div[@id='accordionSaque']")).click();
    }
}
