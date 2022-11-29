package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilidades.ElementosPagina;

import java.io.File;
import java.util.Set;

public class ejecutarFlujoPayrollFinal {

    WebDriver driver;
    private String Token;
    private String Rqid;
    private String Rqid1;
    Response response;
    private String Token2;
    private static JsonPath jsonPathEvaluator;
    private static int statusCode;
    int num=102400089;
    ElementosPagina elementos;
    ApiCrearCuenta apiCrearCuenta;

    static String btnAceptarTerminos = "return /html/body/center/table/tbody/tr[4]/td/table[1]/tbody/tr[3]/td/table/tbody/tr/td[2]/a/button";

    @BeforeTest
    public void chromedriver() {
        System.out.println("Before");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mohmal.com/es");
        driver.manage().window().maximize();
        System.out.println("El driver es "+driver);
        elementos=new ElementosPagina(driver);

    }








    @Test
    public void b() throws InterruptedException {
                ElementosPagina.AbrircorreoTemporal();
                ApiCrearCuenta.a();
                ElementosPagina.VerificacionCorreo();
                ElementosPagina.CedulaX();
                ElementosPagina.clickBtnContinuarX();
                ElementosPagina.txtGastosMensualesX();
                ElementosPagina.txtValorBienesX();
                ElementosPagina.txtValorDeudasX();
                ElementosPagina.clickBtnContinuar2X();
                ElementosPagina.clickBtnTratamientoDatosX();
                ElementosPagina.clickBtnAcepCuentAhorroX();
                ElementosPagina.clickBtnDeclaracionRecurX();
                ElementosPagina.clickBtnContinuar3X();
                ElementosPagina.txtToken1X();
                ElementosPagina.txtToken2X();
                ElementosPagina.txtToken3X();
                ElementosPagina.txtToken4X();
                ElementosPagina.txtToken5X();
                ElementosPagina.txtToken6X();
                ElementosPagina.clickBtnContinuar4X();
                ElementosPagina.btnFinalizarX();





            }
        }



