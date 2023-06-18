package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suport.BasePage;
import suport.Metodos;

import java.time.Duration;
import java.util.List;

public class OpcoesAvancadasPO extends BasePage {
    public OpcoesAvancadasPO(AndroidDriver driver) {
        super(driver);
    }

    Metodos metodos = new Metodos(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    public void pesquisarFacas(){

        WebElement campoSelecionar = driver.findElement(By.xpath("//*[@resource-id ='market_advancedsearch_appselect']"));
        campoSelecionar.click();

       // WebElement campoSelecionarJogo = driver.findElement(By.xpath("//*[@resource-id = 'market_advancedsearch_appselect_options_apps']"));
        WebElement areaScroll = driver.findElement(By.xpath("//*[@resource-id = 'market_advancedsearch_appselect_options_apps']"));


        //metodos.scrollPorArea(jogos.get(4), jogos.get(0),5);

        WebElement CSGO = areaScroll.findElement(By.xpath("//*[@resource-id = 'app_option_730']"));
        CSGO.click();

        //campoSelecionarJogo.findElement(By.xpath("//*[@resource-id = 'app_option_730']")).click();

//        while (!wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@resource-id = 'tag_730_Type_CSGO_Type_Knife']"))).isDisplayed()){
//            metodos.scroll();
//        }

        WebElement campoSelecioneFaca = driver.findElement(By.xpath("//*[@resource-id = 'tag_730_Type_CSGO_Type_Knife']"));
        campoSelecioneFaca.click();
    }
}
