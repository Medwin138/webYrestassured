package test;

import io.ous.jtoml.impl.Token;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import jdk.dynalink.beans.StaticClass;
import net.bytebuddy.build.Plugin;
import org.apache.http.HttpStatus;
import org.codehaus.groovy.ast.Variable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.sql.SQLOutput;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Crearcuenta {
    private String Token;
    private String Token1;
    Response response;
    private String Token2;
    private static JsonPath jsonPathEvaluator;
    private static int statusCode;





@Test
    public void CreacionCliente() {
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
        System.out.println("Este es el segundo metodo -->");



        System.out.println("Este es el token -->" + Token);


        File jsonDataInFile = new File("/Users/mlaguna/Documents/GitHub/proyecto_1S/src/test/resources/web_driver/Body/body.json");
        RestAssured.baseURI = "https://api-openbanking.labdigitalbdbtvsstg.com/public/V1/Enterprise/saving-account/payroll/customer-add";
        RequestSpecification request = (RequestSpecification) RestAssured.given()
                .body(jsonDataInFile)
                .config(RestAssured.config()
                        .encoderConfig(EncoderConfig
                                .encoderConfig()
                                .encodeContentTypeAs("x-www-form-urlencoded", ContentType.URLENC)))
                .header("x-rquid", "0d0eb128-ef2b-475c-ba35-051451e907c6")
                .header("x-custidentnum", "1024000089")
                .header("x-name", "BDB")
                .header("x-ipaddr", "190.159.164.72")
                .header("x-api-key", "uGTRR0b1R96HW9zyPb8hh3PhmiYufJyb4OS6WO1r")
                .header("x-custidenttype", "CC")
                .header("Content-Type", "application/json")
                .header("x-authorization", Token )
                .header("x-custom-header-dt", "HqVzi87d:f%jVlWhnufMkfL=Aho3+X")
                .header("x-origin-cloudfront", "labdigitalbdbtvsstg.com")
                .header("user-agent", "Amazon CloudFront")
                ;
                        ;
                //.proxy("piscis01.bancodebogota.net",8003)
        System.out.println(request.post().then().extract().response()
                .then().log().all().extract().response());





    }


}
