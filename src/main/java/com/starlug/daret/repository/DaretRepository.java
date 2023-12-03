package com.starlug.daret.repository;

import com.starlug.daret.dto.DaretDto;
import com.starlug.daret.entity.Daret;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaretRepository extends JpaRepository<Daret, Long> {
    Daret findByName(String name);
}
