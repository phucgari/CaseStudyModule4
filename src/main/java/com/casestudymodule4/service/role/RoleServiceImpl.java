package com.casestudymodule4.service.role;

import com.casestudymodule4.model.user.Role;
import com.casestudymodule4.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;
    @Override
    public Optional<Role> findByName(Role.RoleType name) {
        return roleRepository.findByName(name);
    }
}
