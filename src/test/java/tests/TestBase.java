package tests;

import com.codeborne.selenide.Configuration;
//import io.qameta.allure.restassured.AllureRestAssured;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.configs.Configs;


public class TestBase {
    protected Api api = new Api();
    protected Helpers helpers = new Helpers();
    static Configs configs = ConfigFactory.create(Configs.class, System.getProperties());
    String login = configs.getLogin();
    String password = configs.getPassword();


    @BeforeAll
    static void beforeALl(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = configs.getBaseUrl();
        RestAssured.baseURI = configs.getBaseUrl();


    }
    @BeforeEach
    void setUp(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

    }
}
