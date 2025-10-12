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

import com.example.bookInventory.entity.PermRole;
import com.example.bookInventory.service.PermRoleService;

@RestController
@RequestMapping("/api/permrole")
public class PermRoleController {
	
	@Autowired
	private PermRoleService permRoleService;
	
	@GetMapping()
	public ResponseEntity<List<PermRole>> getAllPermRole(){
		return ResponseEntity.ok(permRoleService.getAllPermRole());
	}
	
	@GetMapping("/{roleNumber}")
	public ResponseEntity<PermRole> getPermRoleByRole(@PathVariable Integer roleNumber){
		return ResponseEntity.ok(permRoleService.getPermRoleById(roleNumber));
	}
	
	@PostMapping("/post")
	public ResponseEntity<Map<String, String>> addPermRole(@RequestBody PermRole permRole){
		Map<String, String> response = new LinkedHashMap<>();
		try {

				permRoleService.getPermRoleById(permRole.getRoleNumber());
				response.put("code", "ADDFAILS");
				response.put("message", "Perm Role already exists");
				return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
			}
		
		catch(RuntimeException e) {
		}
		
		permRoleService.addPermRole(permRole);
		response.put("code", "POSTSUCCESS");
		response.put("message", "Perm Role added successfully");
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping("/update/permrole/{roleNumber}")
	public ResponseEntity<PermRole> updatePermRoleByRoleNumber(@PathVariable Integer roleNumber, @RequestBody String permRole){
		return ResponseEntity.ok(permRoleService.updatePermRoleById(roleNumber, permRole));
	}
}
