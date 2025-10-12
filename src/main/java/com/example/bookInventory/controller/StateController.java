package com.example.bookInventory.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookInventory.entity.State;
import com.example.bookInventory.service.StateService;

@RestController
@RequestMapping("/api/state")
public class StateController {
	
	@Autowired
	private StateService stateService;
	
	@GetMapping()
	public ResponseEntity<List<State>> getAllState(){
		return ResponseEntity.ok(stateService.getAllState());
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<State> getStateByCode(@PathVariable String code){
		return ResponseEntity.ok(stateService.getStateByCode(code));
	}
	
	@PostMapping("/post")
	public ResponseEntity<Map<String,String>> addState(@RequestBody State state){
		Map<String, String> response = new LinkedHashMap<>();
		try {
				stateService.getStateByCode(state.getStateCode());
				response.put("code", "ADDFAILS");
				response.put("message", "State already exists");
				return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
			}
		
		catch(RuntimeException e) {
		}
		
		stateService.addState(state);
		response.put("code", "POSTSUCCESS");
		response.put("message", "State added successfully");
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping("/update/statename/{code}")
	public ResponseEntity<State> updateStateName(@PathVariable String code, @RequestBody String name){
		return ResponseEntity.ok(stateService.updateStateName(code, name));
	}
}
