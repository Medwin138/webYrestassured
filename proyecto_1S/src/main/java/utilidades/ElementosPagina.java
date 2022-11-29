package utilidades;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class ElementosPagina {

    static WebDriver driver;

    public static String texto = "return document.querySelector(\"#root > bdb-tp-progress > bdb-ml-basic-data\").shadowRoot.querySelector(\"#bdb-ml-basic-data > div.bdb-mol-basic-data__input > bdb-at-input\").shadowRoot.querySelector(\"#idNumber\")";
    public static String clickBtnContinuar = "return document.querySelector(\"#root > bdb-tp-progress > bdb-ml-basic-data\").shadowRoot.querySelector(\"#bdb-ml-basic-data > div.bdb-mol-basic-data__button > button\")";
    public static String txtGastosMensuales = "return document.querySelector(\"#root > bdb-tp-progress > bdb-ml-financial-data\").shadowRoot.querySelector(\"#gastos\").shadowRoot.querySelector(\"#Gastos\")";
    public static String txtValorBienes = "return document.querySelector(\"#root > bdb-tp-progress > bdb-ml-financial-data\").shadowRoot.querySelector(\"#bienes\").shadowRoot.querySelector(\"#Bienes\")";
    public static String txtValorDeudas = "return document.querySelector(\"#root > bdb-tp-progress > bdb-ml-financial-data\").shadowRoot.querySelector(\"#deudas\").shadowRoot.querySelector(\"#Deudas\")";
    public static String clickBtnContinuar2 = "return document.querySelector(\"#root > bdb-tp-progress > bdb-ml-financial-data\").shadowRoot.querySelector(\"#boton\")";
    public static String clickBtnTratamientoDatos = "return document.querySelector(\"#root > bdb-tp-progress > bdb-ml-accept-docs\").shadowRoot.querySelector(\"#check__0\").shadowRoot.querySelector(\"#check_0 > div\")";
    public static String clickBtnAcepCuentAhorro = "return document.querySelector(\"#root > bdb-tp-progress > bdb-ml-accept-docs\").shadowRoot.querySelector(\"#check__1\").shadowRoot.querySelector(\"#check_0 > div\")";
    public static String clickBtnDeclaracionRecur = "return document.querySelector(\"#root > bdb-tp-progress > bdb-ml-accept-docs\").shadowRoot.querySelector(\"#check__2\").shadowRoot.querySelector(\"#check_0 > div\")";
    public static String clickBtnContinuar3 = "return document.querySelector(\"#root > bdb-tp-progress > div > button\")";
    public static String clickBtnFatca = "return document.querySelector(\"#root > bdb-tp-progress > bdb-ml-accept-docs\").shadowRoot.querySelector(\"#check__3\").shadowRoot.querySelector(\"#check_0 > div\")";
    public static String txtIngresepais = "document.querySelector(\"#root > bdb-tp-progress > bdb-ml-accept-docs\").shadowRoot.querySelector(\"#fatca > div.container__fatca__input--sm > bdb-at-autocomplete\").shadowRoot.querySelector(\"#bdb-at-autocomplete > bdb-at-input\").shadowRoot.querySelector(\"#bdb-at-autocomplete\")";
    public static String txtNumeroTributaria = "document.querySelector(\"#root > bdb-tp-progress > bdb-ml-accept-docs\").shadowRoot.querySelector(\"#fatca > div.container__fatca__input--sm2 > bdb-at-input\").shadowRoot.querySelector(\"#bdb-at-input\")";
    public static String txtToken1 = "return document.querySelector(\"#root > bdb-tp-progress > bdb-ml-bm-token\").shadowRoot.querySelector(\"#inputs > bdb-at-input-token\").shadowRoot.querySelector(\"#input_0\")";
    public static String txtToken2 = "return document.querySelector(\"#root > bdb-tp-progress > bdb-ml-bm-token\").shadowRoot.querySelector(\"#inputs > bdb-at-input-token\").shadowRoot.querySelector(\"#input_1\")";
    public static String txtToken3 = "return document.querySelector(\"#root > bdb-tp-progress > bdb-ml-bm-token\").shadowRoot.querySelector(\"#inputs > bdb-at-input-token\").shadowRoot.querySelector(\"#input_2\")";
    public static String txtToken4 = "return document.querySelector(\"#root > bdb-tp-progress > bdb-ml-bm-token\").shadowRoot.querySelector(\"#inputs > bdb-at-input-token\").shadowRoot.querySelector(\"#input_3\")";
    public static String txtToken5 = "return document.querySelector(\"#root > bdb-tp-progress > bdb-ml-bm-token\").shadowRoot.querySelector(\"#inputs > bdb-at-input-token\").shadowRoot.querySelector(\"#input_4\")";
    public static String txtToken6 = "return document.querySelector(\"#root > bdb-tp-progress > bdb-ml-bm-token\").shadowRoot.querySelector(\"#inputs > bdb-at-input-token\").shadowRoot.querySelector(\"#input_5\")";
    public static String clickBtnContinuar4 = "return document.querySelector(\"#root > bdb-tp-progress > bdb-ml-bm-token\").shadowRoot.querySelector(\"div > div.bdb-ml-bm-token__actions > div.bdb-ml-bm-token__actions__send > button\")";
    public static String btnFinalizar = "return document.querySelector(\"#root > bdb-tp-progress > div.bdb-ml-otp__buttons > button.bdb-ml-otp__buttons__link.bdb-at-btn.bdb-at-btn--text.bdb-at-btn--lg\")";
// Elementos de correo temporal



    public ElementosPagina(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static void CedulaX() throws InterruptedException {

        System.out.println("------------------------------------------- paso 0 Cargar PG");
        Thread.sleep(8000);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(texto)))
                .sendKeys("1024000034");
        System.out.println("-------------------------------------------1er paso ingresar Doc");

    }
    public static void clickBtnContinuarX() throws InterruptedException {

        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                .executeScript(clickBtnContinuar))).click();
        System.out.println("-------------------------------------------2do paso clic boton continuar");
        Thread.sleep(8000);
    }


    public static void txtGastosMensualesX() throws InterruptedException {

        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                .executeScript(txtGastosMensuales))).sendKeys("89000000");


        System.out.println("-------------------------------------------3ro Ingresar gastos mensuales");}

    public static void txtValorBienesX() throws InterruptedException {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                .executeScript(txtValorBienes))).sendKeys("39000000");
        System.out.println("-------------------------------------------4o Valor Bienes");

    }

    public static void txtValorDeudasX() throws InterruptedException {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                .executeScript(txtValorDeudas))).sendKeys("78007760");
        System.out.println("-------------------------------------------5o Valor Deudas");
    }

    public static void clickBtnContinuar2X() throws InterruptedException {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                .executeScript(clickBtnContinuar2))).click();
        System.out.println("-------------------------------------------6to clic boton continuar");


        Thread.sleep(9000);
    }

    public static void clickBtnTratamientoDatosX() throws InterruptedException {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                .executeScript(clickBtnTratamientoDatos))).click();
        System.out.println("-------------------------------------------7to clic boton clickBtnTratamientoDatos");

    }

    public static void clickBtnAcepCuentAhorroX() throws InterruptedException {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                .executeScript(clickBtnAcepCuentAhorro))).click();
        System.out.println("-------------------------------------------8to clic boton clickBtnAcepCuentAhorro");

    }

    public static void clickBtnDeclaracionRecurX() throws InterruptedException {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                .executeScript(clickBtnDeclaracionRecur))).click();
        System.out.println("-------------------------------------------9to clic boton clickBtnDeclaracionRecur");

    }

    public static void clickBtnContinuar3X() throws InterruptedException {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                .executeScript(clickBtnContinuar3))).click();
        System.out.println("-------------------------------------------11to clic boton ClickBtnContinuar3");
    }

    public void clickBtnFatcaX() throws InterruptedException {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement)((JavascriptExecutor)driver)
                .executeScript(clickBtnFatca))).click();
        System.out.println("-------------------------------------------10o clic boton clickBtnfatca");
    }

    public void txtIngresepaisX() throws InterruptedException {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                .executeScript(txtIngresepais))).sendKeys("Panamá");
        System.out.println("-------------------------------------------12to clic boton ClickBtnContinuar3");

    }

    public void txtNumeroTributariaX() throws InterruptedException {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement)((JavascriptExecutor)driver)
                .executeScript(txtNumeroTributaria))).sendKeys("890988");
        Thread.sleep(8000);}


    public static void txtToken1X() throws InterruptedException {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                .executeScript(txtToken1))).sendKeys("3");

    }

    public static void txtToken2X() throws InterruptedException {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                .executeScript(txtToken2))).sendKeys("3");

    }

    public static void txtToken3X() throws InterruptedException {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                .executeScript(txtToken3))).sendKeys("3");

    }

    public static void txtToken4X() throws InterruptedException {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                .executeScript(txtToken4))).sendKeys("3");

    }

    public static void txtToken5X() throws InterruptedException {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                .executeScript(txtToken5))).sendKeys("3");
    }

    public static void txtToken6X() throws InterruptedException {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                .executeScript(txtToken6))).sendKeys("3");
        System.out.println("-------------------------------------------12to Ingresar token");

    }

    public static void clickBtnContinuar4X() throws InterruptedException {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                .executeScript(clickBtnContinuar4))).click();

        Thread.sleep(8000);

    }

    public static void btnFinalizarX() throws InterruptedException {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                .executeScript(btnFinalizar))).click();
        System.out.println("-------------------------------------------13to Clic btn finalizar");

    }


    public static void AbrircorreoTemporal() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"choose\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"enterEmail\"]/div[1]/input")).sendKeys("pruebas1");
        driver.findElement(By.id("next")).click();
        driver.findElement(By.id("create")).click();
        System.out.println("-------------------------------------------Se crea la cuenta satisfacoriamente");
        Thread.sleep(500);
        //driver.findElement(By.xpath("//*[contains(text(),'Renovar')]")).click();
        System.out.println("-------------------------------------------Clic en el boton renovar");
        driver.findElement(By.xpath("//*[contains(text(),'Renovar')]")).click();

    }

    public static void VerificacionCorreo() throws InterruptedException {


        Thread.sleep(20000);
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
    }




}}}







