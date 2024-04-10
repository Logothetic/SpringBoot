package com.distributed.systems.service;

import com.distributed.systems.dto.UserDto;
import com.distributed.systems.entity.User;
import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByUsername(String email);

    List<UserDto> findAllUsers();
}
