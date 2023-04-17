package com.casestudymodule4.service.role;

import com.casestudymodule4.model.user.Role;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(Role.RoleType name);
}
