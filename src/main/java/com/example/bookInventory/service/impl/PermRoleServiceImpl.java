package com.example.bookInventory.service.impl;

import java.util.List;

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
	public List<PermRole> getAllPermRole(){
		return permRoleRepository.findAll();
	}

	@Override
	public PermRole addPermRole(PermRole permRole) {
		// TODO Auto-generated method stub
		return permRoleRepository.save(permRole);
	}

	@Override
	public PermRole getPermRoleById(Integer roleNumber) {
		// TODO Auto-generated method stub
		PermRole permRole = permRoleRepository.getByRoleNumber(roleNumber);
		if(permRole==null)
			throw new RuntimeException();
		return permRole;
	}

	@Override
	public PermRole updatePermRoleById(Integer roleNumber, String permRole) {
		// TODO Auto-generated method stub
		PermRole pr = getPermRoleById(roleNumber);
		pr.setPermRole(permRole);
		return permRoleRepository.save(pr);
	}

}
