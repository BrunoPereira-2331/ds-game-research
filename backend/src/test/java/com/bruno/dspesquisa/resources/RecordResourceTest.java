package com.bruno.dspesquisa.resources;

import static org.hamcrest.CoreMatchers.containsString;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.bruno.dspesquisa.dto.RecordDTO;
import com.bruno.dspesquisa.dto.RecordInsertDTO;
import com.bruno.dspesquisa.entities.enums.Platform;
import com.bruno.dspesquisa.services.RecordService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = RecordResource.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class RecordResourceTest {
	
	String RECORD_URI = "/records";
	
	@MockBean
	private RecordService recordService;
	
	@Autowired
	MockMvc mvc;
	
	@Test
	@DisplayName("should insert a RecordInsertDto and return a RecordDTO with status 200")
	public void insertTest() throws Exception {
		String name = "bruno";
		Integer age = 21;
		Long gameId = 1L;
		
		RecordInsertDTO recordInsertDto = new RecordInsertDTO();
		recordInsertDto.setName(name);
		recordInsertDto.setAge(age);
		recordInsertDto.setGameId(gameId);
		
		RecordDTO recordDto = new RecordDTO();
		recordDto.setName(name);
		recordDto.setAge(age);
		
		BDDMockito.when(recordService.insert(recordInsertDto)).thenReturn(recordDto);
		
		String json = new ObjectMapper().writeValueAsString(recordInsertDto);
		
		mvc.perform(MockMvcRequestBuilders.post(RECORD_URI)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
//				.andExpect(MockMvcResultMatchers.jsonPath("name").value(recordDto.getName()))
//				.andExpect(MockMvcResultMatchers.jsonPath("age").value(recordDto.getAge()))
//				.andExpect(MockMvcResultMatchers.jsonPath("gameId").isNotEmpty());
		
	}

//	public Game createNewGame() {
//		return new Game(1, "tlou2", Platform.PLAYSTATION);
//	}
}
