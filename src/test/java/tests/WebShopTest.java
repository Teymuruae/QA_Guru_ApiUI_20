package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class WebShopTest extends TestBase {


    @Test
    void addAddress(){
        Map<String, ?> body = new HashMap<>(){{
            put("Address.Id", "0");
            put("Address.FirstName", "Simba");
            put("Address.LastName", "Petrovich");
            put("Address.Email", "SimPet@ya.com");
            put("Address.Company","");
            put("Address.CountryId", "66");
            put("Address.StateProvinceId", "0");
            put("Address.City", "Moscow");
            put("Address.Address1", "Moscow");
            put("Address.Address2","");
            put("Address.ZipPostalCode", "1111");
            put("Address.PhoneNumber", "2222");
            put("Address.FaxNumber", "");
        }};

        RestAssured
                .given()
                .contentType("application/x-www-form-urlencoded")
                .cookie(Api.authCookieKey,api.getAuthCookie(login, password))
                .formParams(body)
//                .filter(new AllureRestAssured())
                .when()
                .post("/customer/addressadd")
                .then()
                .statusCode(302);
    }

    @Test
    void t(){
        System.out.println(api.getAuthCookie(login,password));
    }

}
