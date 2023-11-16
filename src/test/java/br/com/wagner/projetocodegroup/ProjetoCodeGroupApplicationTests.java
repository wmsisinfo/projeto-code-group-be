package br.com.wagner.projetocodegroup;
import static org.junit.jupiter.api.Assertions.assertTrue;
import br.com.wagner.projetocodegroup.dto.projetos.ReadProjetoDto;
import br.com.wagner.projetocodegroup.dto.projetos.UpdateProjetoDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import br.com.wagner.projetocodegroup.dto.projetos.CreateProjetoDto;
import br.com.wagner.projetocodegroup.resources.ProjetoResource;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProjetoCodeGroupApplicationTests {

	@Autowired
	private ProjetoResource projetoResource;

	private static final String API_ENDPOINT = "/api/v1/projeto";

	@Autowired
	private MockMvc mvc;

	public static ObjectMapper mapper() {
		final ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		return objectMapper;
	}

	List<ReadProjetoDto> list;

	@Test
	void contextLoads() throws Exception {
		assertThat(projetoResource).isNotNull();
	}

	@Test
	public void shouldReturnBadRequestWhenDeletingProjectIniciado() throws Exception {

		mvc.perform(MockMvcRequestBuilders.delete(API_ENDPOINT + "/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void shouldReturn201WhenInsertingNewProject() throws Exception {

		var dto = new CreateProjetoDto();
		dto.setNome("TRADUZIR O PARAISO PERDIDO");
		dto.setRisco("BAIXO");
		dto.setOrcamento(15000.00);
		dto.setIdGerente(2l);
		dto.setDescricao("TRADUIR O PARAISO PERDIDO DE JOHN MILTON PARA TUPI GUARANI");
		dto.setStatus("EM ANALISE");
		dto.setDataPrevisaoFim(LocalDate.of(2024,11,20));
		dto.setDataInicio(LocalDate.of(2024,1,20));


		var jsonStr = mapper().writeValueAsString(dto);
		mvc.perform(MockMvcRequestBuilders.post(API_ENDPOINT)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonStr)).andExpect(status().isCreated());
	}


	@Test
	public void shouldReturn200WhenUpdatingProject() throws Exception {

		var dto = new UpdateProjetoDto();
		dto.setId(1l);
		dto.setNome("MELHORAR AS ESTORIAS DO TIO PATINHAS");
		dto.setRisco("ALTO");
		dto.setOrcamento(15001.00);
		dto.setIdGerente(2l);
		dto.setDescricao("CORRIGIR O ESTILO DE DESENHO ITALIANO DAS ESTORIAS DO TIO PATINHAS PARA O PADRAO DO CARL BARKS");
		dto.setStatus("INICIADO");
		dto.setDataPrevisaoFim(LocalDate.of(2024,11,20));
		dto.setDataInicio(LocalDate.of(2024,1,20));

		var jsonStr = mapper().writeValueAsString(dto);

		mvc.perform(MockMvcRequestBuilders.put(API_ENDPOINT)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonStr)).andExpect(status().isOk());
	}

	@Test
	public void shouldReturnProjectList() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get(API_ENDPOINT)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(result -> {
					var response = result.getResponse().getContentAsString();
					list = mapper().readValue(response, new TypeReference<ArrayList<ReadProjetoDto>>() {});
				});
		assertTrue(!list.isEmpty());

	}

}
