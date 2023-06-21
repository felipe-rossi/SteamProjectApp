package tests;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePagePO;
import pages.MercadoComunidadeHomePO;
import suport.CreateDriver;
import suport.Screenshot;

import java.net.MalformedURLException;

public class T001KnifeTest {

    private AndroidDriver driver;
    Screenshot screenshot;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        CreateDriver cd = new CreateDriver();
        driver = cd.criarNovoDriverAndroid();
        screenshot = new Screenshot(driver);
    }

    @Test
    public void validarPrecosDasSkinsDeFaca(){
        boolean comprarSkin = new MercadoComunidadeHomePO(driver)
        .escolherJogoCSGO()
        .pesquisarPorFacas()
        .ordernarPeloMenorPreco()
        .validarValorDaSkin();

        Assert.assertFalse(comprarSkin);
    }

//    @Test
//    public void teste(){
//        new MercadoComunidadeHomePO(driver)
//        .escolherJogoCSGO()
//        .pesquisarPorFacas();
//    }


    @AfterMethod
    public void tearDown(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            System.out.println("Teste Deu erro");
            screenshot.tirarPrint();
        }
        driver.quit();
    }
}
