package com.casestudymodule4.service.user;

import com.casestudymodule4.model.user.User;
import com.casestudymodule4.service.IGeneralService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User> {
    Optional<User> findByUsername(String user);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
