package com.montanha.isolado;

import com.montanha.config.Configuracoes;
import com.montanha.factory.UsuarioDataFactory;
import com.montanha.factory.ViagemDataFactory;
import com.montanha.pojo.Usuario;
import com.montanha.pojo.Viagem;
import io.restassured.http.ContentType;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class ViagensTest {

    private String token;

    @Before
    public void setup() {

        // Configurações Rest-Assured
        Configuracoes configuracoes = ConfigFactory.create(Configuracoes.class);

        baseURI = configuracoes.baseURI();
        port =  configuracoes.port();
        basePath = configuracoes.basePath();

        Usuario usuarioAdm = UsuarioDataFactory.criarUsuarioAdm();

        this.token = given()
            .contentType(ContentType.JSON)
            .body(usuarioAdm)
        .when()
            .post("/v1/auth")
        .then()
            .extract()
                .path("data.token");
    }

    @Test
    public void testCadastroDeViagemValidoRetornaSucesso() throws IOException {

        Viagem viagem = ViagemDataFactory.criarViagemValida();

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

    @Test
    public void testCadastroDeViagemSemLocalDestinoRetorna400() throws IOException {

        Viagem viagem = ViagemDataFactory.criarViagemSemLocalDeDestino();

        given()
            .contentType(ContentType.JSON)
            .body(viagem)
            .header("Authorization", token)
        .when()
            .post("/v1/viagens")
        .then()
            .assertThat()
                .statusCode(400);
                //.body("data.localDeDestino", equalTo("Ceara"))
                //.body("data.acompanhante", equalToIgnoringCase("acompanhanteteste"));
    }

    @Test
    public void testCadastroDeViagemValidaContrato() throws IOException {

        Viagem viagem = ViagemDataFactory.criarViagemValida();

        given()
            .contentType(ContentType.JSON)
            .body(viagem)
            .header("Authorization", token)
        .when()
            .post("/v1/viagens")
        .then()
            .assertThat()
                .statusCode(201)
                .body(matchesJsonSchemaInClasspath("schemas/postV1ViagensViagemValida.json"))
        ;
    }
}
