package tests;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePagePO;
import suport.CreateDriver;

import java.net.MalformedURLException;

public class T001KnifeTest {

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        CreateDriver cd = new CreateDriver();
        driver = cd.criarNovoDriverAndroid();
    }

    @Test
    public void acessarSteam(){
        boolean comprarSkin = new HomePagePO(driver)
        .acessarMenu()
        .acessarMercadoDaComunidade()
        .escolherJogoCSGO()
        .pesquisarPorFacas()
        .ordernarPeloMenorPreco()
        .validarValorDaSkin();

        Assert.assertFalse(comprarSkin);
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
