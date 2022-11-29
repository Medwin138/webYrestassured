package test;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ApiCrearCuenta {
    WebDriver driver;
    public static String Token;
    public static String Rqid;
    public static String Rqid1;
    static Response response;
    public static String Token2;
    public static JsonPath jsonPathEvaluator;
    public static int statusCode;
    static int num=102400089;


    public static  void a() {


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
}
