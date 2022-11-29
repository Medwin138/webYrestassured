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
import utilidades.*;

import java.io.File;
import java.util.Set;

public class ejecutarFlujoPayroll {

    WebDriver driver;
    private String Token;
    private String Rqid;
    private String Rqid1;
    Response response;
    private String Token2;
    private static JsonPath jsonPathEvaluator;
    private static int statusCode;
    int num=102400089;
    terminosCondiciones termCond;

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
        termCond=new terminosCondiciones(driver);

    }






    public void a() {


        RestAssured.baseURI = "https://www.uuidtools.com/api/generate/v4/";
        response = RestAssured.given()
                .config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig()))
                .contentType(ContentType.URLENC.withCharset("UTF-8"))
                .get().then().extract().response().then().log().all().extract().response();
        System.out.println(response.getStatusCode());
        Rqid = response.jsonPath().get().toString();
        System.out.println("________>>>>>>>>>"+Rqid);
        Rqid= Rqid.substring(1,37);
        System.out.println("________>>>>>>>>>"+Rqid);

        RestAssured.baseURI = "https://bdb-dt-staging.auth.us-east-1.amazoncognito.com/oauth2/token";
        response = RestAssured.given()
                .config(RestAssured.config()
                        .encoderConfig(EncoderConfig
                                .encoderConfig()
                                .encodeContentTypeAs("x-www-form-urlencoded", ContentType.URLENC)))
                .contentType(ContentType.URLENC.withCharset("UTF-8"))
                .formParam("client_id", "50venuf55v7tcuqde1quptmth6")
                .formParam("client_secret", "hsn7h6ra6g7hcpe81sipti3c0kn485a6pinkpsf2q609ms4ta7k")
                .formParam("grant_type", "client_credentials")
                .post().then().extract().response()
                .then().log().all().extract().response();

        System.out.println(response.getTime());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        Token = response.jsonPath().get("access_token");
        System.out.println("-------------------------------------------Este es el segundo metodo -->");
        System.out.println("Este es el token -->" + Token);

        File jsonDataInFile = new File("/Users/mlaguna/Documents/GitHub/proyecto_1S/src/test/resources/web_driver/Body/body.json");
        RestAssured.baseURI = "https://api-openbanking.labdigitalbdbtvsstg.com/public/V1/Enterprise/saving-account/payroll/customer-add";
        RequestSpecification request = (RequestSpecification) RestAssured.given()
                .body(jsonDataInFile)
                .config(RestAssured.config()
                        .encoderConfig(EncoderConfig
                                .encoderConfig()
                                .encodeContentTypeAs("x-www-form-urlencoded", ContentType.URLENC)))
                .header("x-rquid", Rqid)
                .header("x-custidentnum", num)
                .header("x-name", "BDB")
                .header("x-ipaddr", "190.159.164.72")
                .header("x-api-key", "uGTRR0b1R96HW9zyPb8hh3PhmiYufJyb4OS6WO1r")
                .header("x-custidenttype", "CC")
                .header("Content-Type", "application/json")
                .header("x-authorization", Token)
                .header("x-custom-header-dt", "HqVzi87d:f%jVlWhnufMkfL=Aho3+X")
                .header("x-origin-cloudfront", "labdigitalbdbtvsstg.com")
                .header("user-agent", "Amazon CloudFront");
        ;
        //.proxy("piscis01.bancodebogota.net",8003)
        System.out.println(request.post().then().extract().response()
                .then().log().all().extract().response());


    }


    @Test
    public void b() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"choose\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"enterEmail\"]/div[1]/input")).sendKeys("pruebas1");
        driver.findElement(By.id("next")).click();
        driver.findElement(By.id("create")).click();
        System.out.println("-------------------------------------------Se crea la cuenta satisfacoriamente");
        Thread.sleep(500);
        //driver.findElement(By.xpath("//*[contains(text(),'Renovar')]")).click();
        System.out.println("-------------------------------------------Clic en el boton renovar");
        driver.findElement(By.xpath("//*[contains(text(),'Renovar')]")).click();
        a();
        System.out.println("-------------------------------------------Se genero el token");
        Thread.sleep(8000);
        driver.findElement(By.xpath("//*[contains(text(),'Renovar')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Renovar')]")).click();
        System.out.println("-------------------------------------------Clic en el boton renovar");
        driver.findElement(By.xpath("//*[@id=\"inbox-table\"]/tbody/tr/td[1]/a")).click();
        System.out.println("-------------------------------------------Dar clic en el correo bandeja de entrada");
        Thread.sleep(1500);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");
        System.out.println("-------------------------------------------Damos scroll para que se visualice todo el correo");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[contains(text(),'Renovar')]")).sendKeys(Keys.TAB);
        new Actions(driver).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        System.out.println("-------------------------------------------damos tab y enter");
        String parent = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        int count = allWindows.size();
        System.out.println("Number of windows:" + count);
        for (String child : allWindows) {
            if (!parent.equals(child)) {
                driver.switchTo().window(child);
                Thread.sleep(3000);
                System.out.println("------------------------------------------- paso 0 Cargar PG");
                Thread.sleep(20000);
                new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                                .executeScript(terminosCondiciones.texto)))
                        .sendKeys(""+num);
                System.out.println("-------------------------------------------1er paso ingresar Doc");
                new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(terminosCondiciones.clickBtnContinuar))).click();
                System.out.println("-------------------------------------------2do paso clic boton continuar");
                Thread.sleep(8000);
                new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(terminosCondiciones.txtGastosMensuales))).sendKeys("89000000");
                System.out.println("-------------------------------------------3ro Ingresar gastos mensuales");
                new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(terminosCondiciones.txtValorBienes))).sendKeys("39000000");
                System.out.println("-------------------------------------------4o Valor Bienes");
                new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(terminosCondiciones.txtValorDeudas))).sendKeys("78007760");
                System.out.println("-------------------------------------------5o Valor Deudas");
                new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(terminosCondiciones.clickBtnContinuar2))).click();
                System.out.println("-------------------------------------------6to clic boton continuar");
                Thread.sleep(9000);
                new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(terminosCondiciones.clickBtnTratamientoDatos))).click();
                System.out.println("-------------------------------------------7to clic boton clickBtnTratamientoDatos");
                new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(terminosCondiciones.clickBtnAcepCuentAhorro))).click();
                System.out.println("-------------------------------------------8to clic boton clickBtnAcepCuentAhorro");
                new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(terminosCondiciones.clickBtnDeclaracionRecur))).click();
                System.out.println("-------------------------------------------9to clic boton clickBtnDeclaracionRecur");
                new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(terminosCondiciones.clickBtnContinuar3))).click();
                System.out.println("-------------------------------------------11to clic boton ClickBtnContinuar3");

      /*

        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement)((JavascriptExecutor)driver)
                .executeScript(clickBtnFatca))).click();
        System.out.println("-------------------------------------------10o clic boton clickBtnfatca");

        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement)((JavascriptExecutor)driver)
                .executeScript(txtIngresepais))).sendKeys("Panamá");
        System.out.println("-------------------------------------------12to clic boton ClickBtnContinuar3");
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement)((JavascriptExecutor)driver)
                .executeScript(txtNumeroTributaria))).sendKeys("890988");*/
                Thread.sleep(8000);
                new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(terminosCondiciones.txtToken1))).sendKeys("3");
                new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(terminosCondiciones.txtToken2))).sendKeys("3");
                new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(terminosCondiciones.txtToken3))).sendKeys("3");
                new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(terminosCondiciones.txtToken4))).sendKeys("3");
                new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(terminosCondiciones.txtToken5))).sendKeys("3");
                new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(terminosCondiciones.txtToken6))).sendKeys("3");
                System.out.println("-------------------------------------------12to Ingresar token");
                new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(terminosCondiciones.clickBtnContinuar4))).click();

                Thread.sleep(8000);
                new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(terminosCondiciones.btnFinalizar))).click();
                System.out.println("-------------------------------------------13to Clic btn finalizar");
                Thread.sleep(3000);
                driver.close();
            }
        }
    }
}


