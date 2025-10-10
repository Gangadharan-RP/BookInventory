package com.example.bookInventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/{roleNumber}")
	public ResponseEntity<PermRole> getPermRoleByRole(@PathVariable Integer roleNumber){
		return ResponseEntity.ok(permRoleService.getPermRoleById(roleNumber));
	}
	
	@PostMapping("/post")
	public ResponseEntity<PermRole> addPermRole(@RequestBody PermRole permRole){
		return ResponseEntity.ok(permRoleService.addPermRole(permRole));
	}
	
	@PutMapping("/update/permrole/{roleNumber}")
	public ResponseEntity<PermRole> updatePermRoleByRoleNumber(@PathVariable Integer roleNumber, @RequestBody String permRole){
		return ResponseEntity.ok(permRoleService.updatePermRoleById(roleNumber, permRole));
	}
}
