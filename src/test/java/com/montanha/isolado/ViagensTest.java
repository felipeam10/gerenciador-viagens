package com.montanha.isolado;

import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ViagensTest {

    @Test
    public void testCadastroDeViagemValidoRetornaSucesso() {
        // Configurações Rest-Assured
        baseURI = "http://localhost";
        port =  8089;
        basePath = "/api";

        given()
            .contentType(ContentType.JSON)
            .body("{\"email\":\"admin@email.com\",\"senha\":\"654321\"}")
        .when()
            .post("/v1/auth")
        .then()
            .log()
                .all();
    }


}
