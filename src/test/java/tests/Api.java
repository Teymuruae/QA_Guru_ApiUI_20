package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.openqa.selenium.Cookie;

public class Api {

    public static String authCookieKey = "NOPCOMMERCE.AUTH";
   public String getAuthCookie(String login, String password) {
       return RestAssured
               .given().log().all()
               .contentType("application/x-www-form-urlencoded")
               .formParam("Email", login)
               .formParam("Password", password)
               .when()
               .post("/login")
               .then()
               .log().all()
               .statusCode(302)
               .extract()
               .cookie(authCookieKey);

   }

}
