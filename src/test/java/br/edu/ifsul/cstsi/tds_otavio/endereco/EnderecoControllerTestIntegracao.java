package br.edu.ifsul.cstsi.tds_otavio.endereco;

import br.edu.ifsul.cstsi.tds_otavio.BaseAPIIntegracaoTest;
import br.edu.ifsul.cstsi.tds_otavio.TdsOtavioApplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = TdsOtavioApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestRestTemplate
@ActiveProfiles("test")
public class EnderecoControllerTestIntegracao extends BaseAPIIntegracaoTest{

    private ResponseEntity<EnderecoDto> getEndereco(String url) {
        return get(url, EnderecoDto.class);
    }

    private ResponseEntity<List<EnderecoDto>> getEnderecosList(String url) {
        var headers = getHeaders();

        return rest.exchange(
                url,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                new ParameterizedTypeReference<>() {
                });
    }

    @Test
    void findAll() {
        var data = getEnderecosList("/api/v1/enderecos").getBody();
        assertNotNull(data);
        assertFalse(data.isEmpty());
    }

    @Test
    void findById() {
        assertEquals(HttpStatus.OK, getEndereco("/api/v1/enderecos/1").getStatusCode());
        assertEquals(HttpStatus.NOT_FOUND, getEndereco("/api/v1/enderecos/100000").getStatusCode());
    }

    @Test
    void findByCep() {
        var data = getEnderecosList("/api/v1/enderecos/cep/96300000").getBody();
        assertNotNull(data);
        assertFalse(data.isEmpty());
    }

    @Test
    void testInsertEspera201Created() {
        var enderecoDtoPost = new EnderecoDto(
                1L,
                "96300000",
                "RS",
                "Pelotas",
                "centro",
                "Rua 1",
                "123",
                "",
                true,
                1L
        );

        var response = post("/api/v1/enderecos", enderecoDtoPost, null);

        // ASSERT
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        var location = response.getHeaders().get("location").get(0);
        var endereco = getEndereco(location).getBody();
        assertNotNull(endereco);
        assertEquals("96300000", endereco.cep());
        assertEquals("RS", endereco.estado());
        assertEquals("Pelotas", endereco.cidade());

        // ACT
        delete(location, null);

        // ASSERT
        assertEquals(HttpStatus.NOT_FOUND, getEndereco(location).getStatusCode());

    }

    @Test
    void testUpdateEspera200OkE404NotFound() {
        // ARRANGE
        var enderecoDtoPost = new EnderecoDto(
                null, "96300000", "RS", "Pelotas",
                "centro", "Rua 1", "123", "", true, 1L
        );

        var responsePost = post("/api/v1/enderecos", enderecoDtoPost, null);
        assertEquals(HttpStatus.CREATED, responsePost.getStatusCode());

        var location = responsePost.getHeaders().get("location").get(0);
        var endereco = getEndereco(location).getBody();

        assertNotNull(endereco);

        // Prepara um DTO para o PUT
        var enderecoDtoPut = new EnderecoDto(
                endereco.id(), "96000000", "RS", "Pelotas",
                "Fragata", "Rua 2", "456", "", true, 1L
        );

        // ACT
        var responsePUT = put(location, enderecoDtoPut, EnderecoDto.class);

        // ASSERT
        assertEquals(HttpStatus.OK, responsePUT.getStatusCode());
        assertEquals("96000000", responsePUT.getBody().cep());
        assertEquals("Fragata", responsePUT.getBody().bairro());
        assertEquals("Rua 2", responsePUT.getBody().rua());

        // ACT
        delete(location, null);

        // ASSERT
        assertEquals(HttpStatus.NOT_FOUND, getEndereco(location).getStatusCode());
    }

    @Test
    void delete() {
        // ARRANGE
        var enderecoDtoPost = new EnderecoDto(
                null,
                "96300000",
                "RS",
                "Pelotas",
                "centro",
                "Rua 1",
                "123",
                "",
                true,
                1L
        );

        var responsePost = post("/api/v1/enderecos", enderecoDtoPost, null);
        assertEquals(HttpStatus.CREATED, responsePost.getStatusCode());

        var location = responsePost.getHeaders().get("location").get(0);

        // ACT
        var responseDelete = delete(location, null);

        // ASSERT
        assertEquals(HttpStatus.OK, responseDelete.getStatusCode());
        assertEquals(HttpStatus.NOT_FOUND, getEndereco(location).getStatusCode());
    }
}