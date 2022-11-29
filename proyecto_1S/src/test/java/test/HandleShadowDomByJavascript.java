package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import test.Crearcuenta.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class HandleShadowDomByJavascript {



    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("chrome://settings");
        

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(500);
        String clickPrivacySafetySelector = "document.querySelector(\"body > settings-ui\").shadowRoot.querySelector(\"#leftMenu\").shadowRoot.querySelector(\"a[href='/privacy']\").click()";

        js.executeScript(clickPrivacySafetySelector);

        String clickClearDataSelector = "document.querySelector(\"body > settings-ui\").shadowRoot.querySelector(\"#main\").shadowRoot.querySelector(\"settings-basic-page\").shadowRoot.querySelector(\"#basicPage > settings-section:nth-child(9) > settings-privacy-page\").shadowRoot.querySelector(\"#clearBrowsingData\").shadowRoot.querySelector(\"#label\").click()";

        js.executeScript(clickClearDataSelector);

        String clickCancelSelector = "document.querySelector(\"body > settings-ui\").shadowRoot.querySelector(\"#main\").shadowRoot.querySelector(\"settings-basic-page\").shadowRoot.querySelector(\"#basicPage > settings-section:nth-child(9) > settings-privacy-page\").shadowRoot.querySelector(\"settings-clear-browsing-data-dialog\").shadowRoot.querySelector(\"#clearBrowsingDataConfirm\").click()";
        js.executeScript(clickCancelSelector);
        String clickGuiaPrivacidad = "document.querySelector(\"body > settings-ui\").shadowRoot.querySelector(\"#main\").shadowRoot.querySelector(\"settings-basic-page\").shadowRoot.querySelector(\"#basicPage > settings-section:nth-child(9) > settings-privacy-page\").shadowRoot.querySelector(\"#privacyGuideLinkRow\").click()";
        js.executeScript(clickGuiaPrivacidad);

       /* driver.get("https://www.w3schools.com/howto/howto_js_toggle_hide_show.asp");
        WebElement shadowRoot = (WebElement) ((JavascriptExecutor) driver).executeScript("return document.querySelector('howto-tabs').shadowRoot");
        WebElement tab = shadowRoot.findElement(By.cssSelector("div.tablinks:nth-child(2)"));
        tab.click();*/

        driver.quit();




    }

    }



