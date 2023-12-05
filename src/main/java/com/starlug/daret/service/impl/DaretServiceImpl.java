package com.starlug.daret.service.impl;

import com.starlug.daret.dto.DaretDto;
import com.starlug.daret.entity.Daret;
import com.starlug.daret.entity.User;
import com.starlug.daret.repository.DaretRepository;
import com.starlug.daret.repository.UserRepository;
import com.starlug.daret.service.DaretService;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class DaretServiceImpl implements DaretService {

    private DaretRepository daretRepository;
    private UserRepository userRepository;

    public DaretServiceImpl(DaretRepository daretRepository, UserRepository userRepository) {
        this.daretRepository = daretRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void saveDaret(DaretDto daretDto) {
        Daret daret = new Daret();
        daret.setName(daretDto.getName());
        daret.setCreated_at(new Date());
        daret.setCreated_by(2L); //
        daret.setActive(false); //
        daret.setParticipant_number(10);
        daret.setAmount(1000d);
        daret.setStart_date(new Date());
        daret.setFrequency_by_days(30); //
        //..
        daretRepository.save(daret);
    }

    @Override
    public Daret findByName(String name) {
        return daretRepository.findByName(name);
    }

    public DaretDto findByNameDto(String name) {
        return this.convertEntityToDto(daretRepository.findByName(name));
    }

    @Override
    public List<DaretDto> findAllDarets() {
        List<Daret> darets = daretRepository.findAll();
        return darets.stream().map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    private String getUserNameById(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        return (user != null) ? user.getName() : null;
    }
    private String getUserEmailById(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        return (user != null) ? user.getEmail() : null;
    }

    private String getFrequency(Integer days) {
        if (days <= 7) return "Chaque semaine";
        else if (days <= 15) return "Toutes les deux semaines";
        else if (days <= 23) return "Toutes les trois semaines";
        else if (days <= 31) return "Mensuel";
        else if (days <= 62) return "Tous les deux mois";
        else if (days <= 93) return "Tous les trois mois";
        return "";
    }

    private String getFormattedDateTime(Date d) {
        SimpleDateFormat sdf_fr = new SimpleDateFormat("dd MMMM yyyy",Locale.FRANCE);
        String output = sdf_fr.format(d);
        try { return sdf_fr.format(sdf_fr.parse(output));}
        catch (ParseException e) {e.printStackTrace();}
        return "";
    }

    private String formatNumber(Double number) throws IllegalArgumentException {
        return NumberFormat.getInstance(Locale.FRENCH).format(number);
    }

    private DaretDto convertEntityToDto(Daret daret) {
        DaretDto daretDto = new DaretDto();
        daretDto.setName(daret.getName());
        daretDto.setStart_date(this.getFormattedDateTime(daret.getStart_date()));
        daretDto.setCreated_by(this.getUserNameById(daret.getCreated_by()));
        daretDto.setCreated_by_email(this.getUserEmailById(daret.getCreated_by()));
        daretDto.setAmountString(this.formatNumber(daret.getAmount()));
        daretDto.setDraw(daret.getDraw());
        daretDto.setParticipant_number(daret.getParticipant_number());
        daretDto.setFrequency(this.getFrequency(daret.getFrequency_by_days()));
        daretDto.setTurn_user_id(daret.getTurn_user_id());
        daretDto.setStep_number(daret.getStep_number());
        daretDto.setActive(daret.getActive());
        daretDto.setCreated_at(this.getFormattedDateTime(daret.getCreated_at()));
        return daretDto;
    }
}
