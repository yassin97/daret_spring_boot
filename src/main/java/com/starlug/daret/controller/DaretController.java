package com.starlug.daret.controller;

import com.starlug.daret.dto.DaretDto;
import com.starlug.daret.dto.UserDto;
import com.starlug.daret.entity.Daret;
import com.starlug.daret.entity.User;
import com.starlug.daret.repository.DaretRepository;
import com.starlug.daret.service.DaretService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class DaretController {
    private final DaretService daretService;
    @Autowired
    private DaretRepository daretRepository;

    public DaretController(DaretService daretService) {
        this.daretService = daretService;
    }

    @GetMapping("/darets")
    public String listOfDarets(Model model) {
        List<DaretDto> darets = daretService.findAllDarets();
        model.addAttribute("darets", darets);
        return "darets";
    }

    @GetMapping("/darets/new")
    public String create(Model model) {
        model.addAttribute("currentDate", LocalDate.now());
        return "create_daret";
    }

    @PostMapping("/daret/save")
    public String saveDaret(@Valid @ModelAttribute("daret") DaretDto daret,
                               BindingResult result,
                               Model model){
        Daret existing = daretService.findByName(daret.getName());
        if (existing != null) {
            result.rejectValue("name", null, "Il y a déjà un Daret enregistré avec ce nom");
        }
        if (result.hasErrors()) {
            model.addAttribute("daret", daret);
            return "create_daret";
        }
        daretService.saveDaret(daret);
        return "redirect:/darets";
    }

    @GetMapping("/daret/{name}")
    public String daret(Model model, Authentication authentication, @PathVariable String name) {
        DaretDto daret = daretService.findByNameDto(name);
        model.addAttribute("authentication", authentication);
        model.addAttribute("daret", daret);
        return "daret";
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

