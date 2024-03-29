package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import suport.BasePage;
import suport.Metodos;
import java.time.Duration;
import java.util.List;

public class MercadoComunidadeHomePO extends BasePage {

    public MercadoComunidadeHomePO(AndroidDriver driver) {
        super(driver);
    }
    Metodos metodos = new Metodos(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    public MercadoComunidadeHomePO escolherJogoCSGO(){

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc=\"Anunciar um item\"]")));
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]")).click();
        WebElement cs2 = driver.findElement(By.xpath("//*[contains(@text, 'Counter-Strike 2')]"));
        cs2.click();
        wait.until(ExpectedConditions.stalenessOf(cs2));
        return this;
    }

    public ResultadoMercadoPO pesquisarPorFacas(){
       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@resource-id='market_search_advanced_show']")));
       driver.findElement(By.xpath("//*[@resource-id='market_search_advanced_show']")).click();

       //WebElement checkFacas = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\"tag_730_Type_CSGO_Type_Knife\"))")); //tag_730_Type_CSGO_Type_Rifle  tag_730_Type_CSGO_Type_Knife
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@resource-id='market_advancedsearch_options']")));

        metodos.scrollFiltroFaca(2);

        try{
            WebElement botaoFacas = driver.findElement(By.xpath("//*[@resource-id='tag_730_Type_CSGO_Type_Knife']"));
            wait.until(ExpectedConditions.visibilityOf(botaoFacas)).click();
        }catch (Exception e){
            System.out.println("Cai no Exception!!!");
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\"tag_730_Type_CSGO_Type_Knife\"))"));
            WebElement botaoFacas = driver.findElement(By.xpath("//*[@resource-id='tag_730_Type_CSGO_Type_Knife']"));
            wait.until(ExpectedConditions.visibilityOf(botaoFacas)).click();
        }
       metodos.scroll(1);
       WebElement btnBuscar = driver.findElement(By.xpath("//*[@text='Buscar']"));
       btnBuscar.click();

        wait.until(ExpectedConditions.stalenessOf(btnBuscar));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//android.view.View[@content-desc='Faca']"))));

        return new ResultadoMercadoPO(driver);
    }
}
