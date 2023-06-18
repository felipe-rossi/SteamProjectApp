package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import suport.BasePage;
import suport.Metodos;

import java.time.Duration;

public class HomePagePO extends BasePage {
    public HomePagePO(AndroidDriver driver) {
        super(driver);
    }
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
    Metodos metodos = new Metodos(driver);

    public MenuPagePO acessarMenu(){

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text = 'MENU']")));
        metodos.tapPorCordenadas(971,1712);

        return new MenuPagePO(driver);
    }

}
