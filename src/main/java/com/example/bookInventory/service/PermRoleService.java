package com.example.bookInventory.service;

import java.util.List;

import com.example.bookInventory.entity.PermRole;

public interface PermRoleService {
	PermRole addPermRole(PermRole permRole);
	PermRole getPermRoleById(Integer roleNumber);
	PermRole updatePermRoleById(Integer roleNumber, String permRole);
	List<PermRole> getAllPermRole();
}
