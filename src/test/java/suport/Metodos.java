package suport;

import io.appium.java_client.AppiumBy;
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
    public void scrollFiltroFaca(int quantidadeScroll){

        for (int i = 1; i <= quantidadeScroll;i++){
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).setAsVerticalList().scrollForward(10)"));
        }
    }


    public void tapPorCordenadas(int x, int y){
        new TouchAction(driver).tap(PointOption.point(x,y)).perform();
    }
}
