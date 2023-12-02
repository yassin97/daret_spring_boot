package com.starlug.daret.service.impl;

import com.starlug.daret.dto.DaretDto;
import com.starlug.daret.entity.Daret;
import com.starlug.daret.repository.DaretRepository;
import com.starlug.daret.service.DaretService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DaretServiceImpl implements DaretService {

    private DaretRepository daretRepository;

    public DaretServiceImpl(DaretRepository daretRepository) {
        this.daretRepository = daretRepository;
    }

    @Override
    public void saveDaret(DaretDto daretDto) {
        Daret daret = new Daret();
        daret.setName(daretDto.getName());
        //..
        daretRepository.save(daret);
    }

    @Override
    public Daret findByName(String name) {
        return daretRepository.findByName(name);
    }

    @Override
    public List<DaretDto> findAllDarets() {
        List<Daret> darets = daretRepository.findAll();
        return darets.stream().map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    private DaretDto convertEntityToDto(Daret daret){
        DaretDto daretDto = new DaretDto();
        daretDto.setName(daret.getName());
        return daretDto;
    }
}
