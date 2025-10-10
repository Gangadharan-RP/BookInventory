package com.example.bookInventory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookInventory.entity.PermRole;
import com.example.bookInventory.repository.PermRoleRepository;
import com.example.bookInventory.service.PermRoleService;

@Service
public class PermRoleServiceImpl implements PermRoleService{
	
	@Autowired
	private PermRoleRepository permRoleRepository;

	@Override
	public PermRole addPermRole(PermRole permRole) {
		// TODO Auto-generated method stub
		return permRoleRepository.save(permRole);
	}

	@Override
	public PermRole getPermRoleById(Integer roleNumber) {
		// TODO Auto-generated method stub
		return permRoleRepository.getByRoleNumber(roleNumber);
	}

	@Override
	public PermRole updatePermRoleById(Integer roleNumber, String permRole) {
		// TODO Auto-generated method stub
		PermRole pr = getPermRoleById(roleNumber);
		pr.setPermRole(permRole);
		return permRoleRepository.save(pr);
	}

}
