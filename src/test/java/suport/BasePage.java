package suport;

import io.appium.java_client.android.AndroidDriver;

public class BasePage {
    public AndroidDriver driver;
    public BasePage(AndroidDriver driver){
        this.driver = driver;
    }
}
