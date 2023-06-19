package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import suport.BasePage;
import suport.Metodos;

import java.time.Duration;

public class MercadoComunidadeHomePO extends BasePage {

    public MercadoComunidadeHomePO(AndroidDriver driver) {
        super(driver);
    }

    Metodos metodos = new Metodos(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    public MercadoComunidadeHomePO escolherJogoCSGO(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc=\"Anunciar um item\"]")));


        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]")).click();

        driver.findElement(By.xpath("//*[@content-desc = 'Counter-Strike: Global OffensiveCounter-Strike: Global Offensive']")).click();
        return this;
    }

    public ResultadoMercadoPO pesquisarPorFacas(){
       driver.findElement(By.xpath("//*[@resource-id='market_search_advanced_show']")).click();
       WebElement checkFacas = driver.findElement(MobileBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\"market_advancedsearch_filters\").className(\"android.view.View\").className(\"android.widget.CheckBox\").resourceId(\"tag_730_Type_CSGO_Type_Knife\"))")); //tag_730_Type_CSGO_Type_Rifle  tag_730_Type_CSGO_Type_Knife
       wait.until(ExpectedConditions.visibilityOf(checkFacas)).click();
       metodos.scroll(1);
       WebElement btnBuscar = driver.findElement(By.xpath("//*[@text='Buscar']"));
       btnBuscar.click();

        wait.until(ExpectedConditions.stalenessOf(btnBuscar));
        return new ResultadoMercadoPO(driver);
    }
}
