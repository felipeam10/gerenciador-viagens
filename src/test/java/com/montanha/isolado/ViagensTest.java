package com.montanha.isolado;

import com.montanha.pojo.Usuario;
import com.montanha.pojo.Viagem;
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

        Usuario usuarioAdm = new Usuario();
        usuarioAdm.setEmail("admin@email.com");
        usuarioAdm.setSenha("654321");

        String token = given()
            .contentType(ContentType.JSON)
            .body(usuarioAdm)
        .when()
            .post("/v1/auth")
        .then()
            .extract()
                .path("data.token");


        Viagem viagem = new Viagem();
        viagem.setAcompanhante("AcompanhanteTeste");
        viagem.setDataPartida("2021-14-10");
        viagem.setDataRetorno("2021-14-10");
        viagem.setLocalDeDestino("Ceara");
        viagem.setRegiao("Norte");

        given()
            .contentType(ContentType.JSON)
            .body(viagem)
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
