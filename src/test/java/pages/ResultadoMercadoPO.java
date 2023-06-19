package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import suport.BasePage;
import suport.Metodos;

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

//        try {
//            Thread.sleep(3000);
//        }catch (Exception e){
//            System.out.println("Erro ao esperar 3s");
//        }


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

        List<WebElement> listaPrecos = driver.findElements(By.xpath("//*[contains(@text(),'A partir de')]"));
        valorItem = listaPrecos.get(0).getText();
        System.out.println("Skin mais barata custa: " + valorItem);

        WebElement linkSkin = driver.findElement(By.xpath("//*[@resource-id='resultlink_0']"));

        valorItemTratado = tratarValorSkin(listaPrecos.get(0).getText());

        if (tratarValorSkin(listaPrecos.get(0).getText()) <= 3000){
            System.out.println("Valor da Skin é MENOR OU IGUAL que 30 dolares (150 reais)");

            //EnviarEmail.enviarEmail(nomeItem,valorItem,linkItem);

            comprarSkin = true;

        }else{
            System.out.println("Valor da Skin é MAIOR que 30 dolares (150 reais)");
            comprarSkin = false;
        }

        return comprarSkin;
    }


    public int tratarValorSkin(String preco){

        preco = preco.replace(" ", "");
        preco = preco.replace("R$", "");
        preco = preco.replace(",", "");

        int valor = Integer.parseInt(preco);

        return valor;
    }

}
