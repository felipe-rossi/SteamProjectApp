package suport;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CreateDriver {

    public AndroidDriver criarNovoDriverAndroid() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appium:deviceName", "emulator-5554");
        capabilities.setCapability("automationName","uiautomator2");
        capabilities.setCapability("platformVersion","12.0");
        capabilities.setCapability("appPackage","com.valvesoftware.android.steam.community");
        capabilities.setCapability("appActivity", "com.valvesoftware.android.steam.community.MainActivity");
        capabilities.setCapability("noReset","true");

       AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

       return driver;
    }
}
