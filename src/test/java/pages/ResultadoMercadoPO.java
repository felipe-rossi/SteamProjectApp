package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import suport.BasePage;
import suport.EnviarEmail;
import suport.Metodos;

import javax.sound.midi.Soundbank;
import java.time.Duration;
import java.util.List;

public class ResultadoMercadoPO extends BasePage {
    public ResultadoMercadoPO(AndroidDriver driver) {
        super(driver);
    }
    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    public boolean comprarSkin;
    public static String nomeItem;
    public static String valorItem;
    public static String linkItem;
    public static int valorItemTratado;

    Metodos metodos = new Metodos(driver);
    public ResultadoMercadoPO ordernarPeloMenorPreco(){

        WebElement ordernarpreco = driver.findElement(By.xpath("//*[@text='PREÇO']"));
        ordernarpreco.click();
        metodos.scroll(1);

        return this;
    }


    public boolean validarValorDaSkin(){
        comprarSkin = false;

        try{
            Thread.sleep(5000);
        }catch (Exception e){
            System.out.println("Erro ao esperar 5s");
        }

        WebElement nomeSkinMaisBarata = driver.findElement(By.xpath("//*[@resource-id = 'result_0_name']"));
        nomeItem = nomeSkinMaisBarata.getText();
        System.out.println("Nome da Skin: " + nomeItem);

        List<WebElement> listaPrecos = driver.findElements(By.xpath("//*[contains(@text,'A partir de')]"));
        valorItem = listaPrecos.get(0).getText().substring(11);

        System.out.println("Skin mais barata custa: " + valorItem.replace("\n", ""));

        WebElement linkSkin = driver.findElement(By.xpath("//*[@resource-id='resultlink_0']"));

        valorItemTratado = tratarValorSkin(valorItem);

        if (valorItemTratado <= 15000){
            System.out.println("Valor da Skin é MENOR OU IGUAL que 30 dolares (150 reais)");

            linkSkin.click();

            System.out.println("Realizando compra da Skin...");

            driver.findElement(MobileBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().description(\"Comprar agora\"))")).click();
            driver.findElement(By.xpath("//*[@resource-id = 'market_buynow_dialog_accept_ssa']")).click();
            try{
                driver.findElement(MobileBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).setAsHorizontalList().scrollIntoView(new UiSelector().resourceId(\"market_buynow_dialog_purchase\"))"));
                driver.findElement(By.xpath("//*[@resource-id='market_buynow_dialog_purchase']")).click();
                //metodos.tapPorCordenadas(959, 1133);

            }catch (Exception e){
                System.out.println("Erro ao Clicar");
            }
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Ver inventário']")));
            driver.findElement(By.xpath("//*[@text='Ver inventário']")).click();
            System.out.println("Compra realizada com sucesso");
            System.out.println("Enviando e-mail...");
            EnviarEmail.enviarEmail(nomeItem,valorItem);
            comprarSkin = true;

        }else{
            System.out.println("Valor da Skin é MAIOR que 30 dolares (150 reais)");
            comprarSkin = false;
        }

        return comprarSkin;
    }


    public int tratarValorSkin(String preco){
        preco = preco.replace("\n", "");
        preco = preco.replace(" ", "");
        preco = preco.replace(":", "");
        preco = preco.replace("R$", "");
        preco = preco.replace(",", "");

        int valor = Integer.parseInt(preco);

        return valor;
    }

}
