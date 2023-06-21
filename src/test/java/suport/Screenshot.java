package suport;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class Screenshot extends BasePage{

    public Screenshot(AndroidDriver driver) {
        super(driver);
    }

    public void tirarPrint(){
        try{
            File arquivo = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(arquivo, new File("Screenshots\\ultimo_erro.png"));
        }catch (Exception e){
            System.out.println("Erro ao tirar print da tela: " + e.getMessage());
        }

    }
}
