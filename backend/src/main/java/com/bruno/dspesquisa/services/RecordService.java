package com.bruno.dspesquisa.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bruno.dspesquisa.dto.RecordDTO;
import com.bruno.dspesquisa.dto.RecordInsertDTO;
import com.bruno.dspesquisa.entities.Game;
import com.bruno.dspesquisa.entities.Record;
import com.bruno.dspesquisa.repository.GameRepository;
import com.bruno.dspesquisa.repository.RecordRepository;

@Service
public class RecordService {
	
	@Autowired
	private RecordRepository recordRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional
	public RecordDTO insert(RecordInsertDTO dto) {
		Record entity = new Record();
		entity.setName(dto.getName());
		entity.setAge(dto.getAge());
		entity.setMoment(Instant.now());
		
		Game game = gameRepository.getOne(dto.getGameId());
		entity.setGame(game);
		entity = recordRepository.save(entity);
		return new RecordDTO(entity);
		
	}
}
