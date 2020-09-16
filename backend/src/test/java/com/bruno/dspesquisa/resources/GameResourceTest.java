package com.bruno.dspesquisa.resources;

import java.util.Arrays;
import java.util.Date;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.bruno.dspesquisa.dto.GameDTO;
import com.bruno.dspesquisa.entities.enums.Platform;
import com.bruno.dspesquisa.services.GameService;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest(controllers = GameResource.class)
@AutoConfigureMockMvc
public class GameResourceTest {

	String GAME_URI = "/games";

	@MockBean
	private GameService gameService;

	@Autowired
	MockMvc mvc;

	@Test
	@DisplayName("Should return a list of gamesDTO")
	public void findAllTest() throws Exception {
		Long id = 123L;
		String title = "tlou2";
		Platform platform = Platform.PLAYSTATION;

		GameDTO gameDto = new GameDTO();
		gameDto.setId(id);
		gameDto.setTitle(title);
		gameDto.setPlatform(platform);

		BDDMockito.given(gameService.findAll()).willReturn(Arrays.asList(gameDto));

		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(GAME_URI).accept(MediaType.APPLICATION_JSON);

		mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0]").isNotEmpty());

		Mockito.verify(gameService, Mockito.times(1)).findAll();
	}

}
