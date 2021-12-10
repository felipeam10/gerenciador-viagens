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

        String token = given()
            .contentType(ContentType.JSON)
            .body("{\"email\":\"admin@email.com\",\"senha\":\"654321\"}")
        .when()
            .post("/v1/auth")
        .then()
            .extract()
                .path("data.token");


        given()
            .contentType(ContentType.JSON)
            .body("{\n" +
                    "  \"acompanhante\": \"AcompanhanteTeste\",\n" +
                    "  \"dataPartida\": \"2021-14-10\",\n" +
                    "  \"dataRetorno\": \"2021-14-10\",\n" +
                    "  \"localDeDestino\": \"Ceara\",\n" +
                    "  \"regiao\": \"Norte\"\n" +
                    "}")
            .header("Authorization", token)
        .when()
                .post("/v1/viagens")
        .then()
            .assertThat()
                .statusCode(201)
                .body("data.localDeDestino", equalTo("Ceara"))
                .body("data.acompanhante", equalToIgnoringCase("acompanhanteteste"));

    }

}
