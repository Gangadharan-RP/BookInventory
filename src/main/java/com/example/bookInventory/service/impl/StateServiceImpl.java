package com.example.bookInventory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookInventory.entity.State;
import com.example.bookInventory.repository.StateRepository;
import com.example.bookInventory.service.StateService;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	private StateRepository stateRepository;
	
	@Override
	public State addState(State state) {
		// TODO Auto-generated method stub
		return stateRepository.save(state);
	}

	@Override
	public List<State> getAllState() {
		// TODO Auto-generated method stub
		return stateRepository.findAll();
	}

	@Override
	public State getStateByCode(String code) {
		// TODO Auto-generated method stub
		State state = stateRepository.getByStateCode(code);
		if(state==null)
			throw new RuntimeException(); 
		return state;
	}

	@Override
	public State updateStateName(String code, String name) {
		// TODO Auto-generated method stub
		State state = getStateByCode(code);
		state.setStateName(name);
		return stateRepository.save(state);
	}

}
