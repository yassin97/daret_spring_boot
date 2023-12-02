package com.starlug.daret.service;

import com.starlug.daret.dto.DaretDto;
import com.starlug.daret.dto.UserDto;
import com.starlug.daret.entity.Daret;
import com.starlug.daret.entity.User;

import java.util.List;

public interface DaretService {
    void saveDaret(DaretDto daretDto);

    Daret findByName(String name);

    List<DaretDto> findAllDarets();
}
