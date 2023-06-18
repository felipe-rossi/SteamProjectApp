package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import suport.BasePage;
import suport.Metodos;

import java.time.Duration;

public class MenuPagePO extends BasePage {
    public MenuPagePO(AndroidDriver driver) {
        super(driver);
    }
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    Metodos metodos = new Metodos(driver);

    public MercadoComunidadeHomePO acessarMercadoDaComunidade(){

        WebElement menuComunidade = driver.findElement(By.xpath("//*[@text = 'Comunidade']"));
        wait.until(ExpectedConditions.visibilityOf(menuComunidade)).click();

        metodos.scroll(1);

        WebElement submenuMercado = driver.findElement(By.xpath("//*[@text = 'Mercado']"));
        wait.until(ExpectedConditions.visibilityOf(submenuMercado)).click();

        return new MercadoComunidadeHomePO(driver);
    }
}
