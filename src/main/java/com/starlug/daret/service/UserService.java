package com.starlug.daret.service;

import com.starlug.daret.dto.UserDto;
import com.starlug.daret.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
