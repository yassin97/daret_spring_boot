package com.starlug.daret.controller;

import com.starlug.daret.dto.DaretDto;
import com.starlug.daret.service.DaretService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DaretController {
    private final DaretService daretService;

    public DaretController(DaretService daretService) {
        this.daretService = daretService;
    }

    @GetMapping("/darets")
    public String listOfDarets(Model model) {
        List<DaretDto> darets = daretService.findAllDarets();
        model.addAttribute("users", darets);
        return "darets";
    }

    @GetMapping("/daret/create")
    public String createDaret() {
        return "create_daret";
    }

    @GetMapping("/daret/update")
    public String updateDaret() {
        return "update_daret";
    }
}

