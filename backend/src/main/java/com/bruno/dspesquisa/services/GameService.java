package com.bruno.dspesquisa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bruno.dspesquisa.dto.GameDTO;
import com.bruno.dspesquisa.entities.Game;
import com.bruno.dspesquisa.repository.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;

	@Transactional(readOnly = true)
	public List<GameDTO> findAll() {
		List<Game> list = gameRepository.findAll();
		List<GameDTO> listDto = list.stream().map(e -> new GameDTO(e)).collect(Collectors.toList());
		return listDto;
	}

}
