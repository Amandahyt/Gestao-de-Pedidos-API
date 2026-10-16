package com.amanda.gestao_pedido;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GestaoPedidoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private Validator validator;

	@Test
	void contextLoads() {
	}

	@Test
	void deveRejeitarPedidoSemCliente() {
		Pedido pedido = new Pedido(
				null,
				"",
				new BigDecimal("100.00")
		);

		Set<ConstraintViolation<Pedido>> erros =
				validator.validate(pedido);

		assertFalse(erros.isEmpty());
	}

	@Test
	void deveCriarPedido() throws Exception {
		mockMvc.perform(post("/pedidos")
						.contentType(MediaType.APPLICATION_JSON)
						.content("""
                                {
                                  "cliente": "Amanda",
                                  "valorTotal": 100.00
                                }
                                """))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.cliente").value("Amanda"))
				.andExpect(jsonPath("$.valorTotal").value(100.00));
	}

	@Test
	void deveRetornar400QuandoPedidoForInvalido() throws Exception {
		mockMvc.perform(post("/pedidos")
						.contentType(MediaType.APPLICATION_JSON)
						.content("""
                                {
                                  "cliente": "",
                                  "valorTotal": 0
                                }
                                """))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.status").value(400))
				.andExpect(jsonPath("$.erros.cliente").exists())
				.andExpect(jsonPath("$.erros.valorTotal").exists());
	}
}