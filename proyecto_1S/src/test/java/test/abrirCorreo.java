package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;


public class abrirCorreo {

    @BeforeTest
    public  void chromedriver() {
        WebDriverManager.chromedriver().setup();


    }



@Test
    public void EmailTemporal () throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mohmal.com/es");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"choose\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"enterEmail\"]/div[1]/input")).sendKeys("pruebas.payrol");
        driver.findElement(By.id("next")).click();
        driver.findElement(By.id("create")).click();
        Thread.sleep(8000);
        driver.findElement(By.xpath("//*[@id=\"inbox-table\"]/tbody/tr/td[1]/a")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Aceptar términos y condiciones')]")).click();





    }


/*


@Test
    public void openEmail () throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.gmail.com");
    driver.manage().window().maximize();
    driver.findElement(By.id("identifierId")).sendKeys("apis.tvs@gmail.com");
    driver.findElement(By.id("identifierNext")).click();
    Thread.sleep(2000);
    driver.findElement(By.name("password")).sendKeys("apistvs2022*");
    driver.findElement(By.id("passwordNext")).click();
    Thread.sleep(2000);



    }

*/
    }
