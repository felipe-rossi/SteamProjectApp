package suport;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Metodos extends BasePage {

    public Metodos(AndroidDriver driver) {
        super(driver);
    }

    public void scroll(int quantidadeScroll) {
        System.out.println("Dando Scroll");
        Dimension dimensions = driver.manage().window().getSize();
        int startpoint = (int) (dimensions.getHeight() * 0.5);
        int scrollEnd = (int) (dimensions.getHeight() * 0.2);

        for (int i = 1; i <= quantidadeScroll;i++){
            new TouchAction(driver)
                    .press(PointOption.point(0,startpoint))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(0, scrollEnd))
                    .release().perform();
        }

    }

    public void scrollPorArea(WebElement element, int quantidadeScroll){
        int xInicial = (int) (element.getSize().getWidth() * 0.5);
        int xFinal = (int) (element.getSize().getHeight() * 0.2);
        ; // Defina a porcentagem de deslize desejada

        // Execute a ação de scroll
        for (int i = 1; i <= quantidadeScroll;i++) {
            System.out.println("Dando Scroll por área");
            TouchAction action = new TouchAction(driver);
            new TouchAction(driver)
                    .press(PointOption.point(0,xInicial))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(0, xFinal))
                    .release().perform();
        }
    }

    public void scrollPorLocalizacao(int xInicial, int xFinal,int quantidadeScroll){

        for (int i = 1; i <= quantidadeScroll;i++){
            System.out.println("Dando Scroll em área");
            new TouchAction(driver)
                    .press(PointOption.point(0,xInicial))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(0, xFinal))
                    .release().perform();
        }

    }


    public void tapPorCordenadas(int x, int y){
        new TouchAction(driver).tap(PointOption.point(x,y)).perform();
    }
}
