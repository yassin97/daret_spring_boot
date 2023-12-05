package com.starlug.daret.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DaretDto {
    private Long id;

    private String created_by;
    private String created_by_email;

    @NotEmpty(message = "Spécifiez le nom de votre daret!")
    private String name;

//    @NotEmpty(message = "Spécifiez le numéro de participants!")
    private Integer participant_number;

//    @NotEmpty(message = "Spécifiez la périodicité de votre daret en utilisant uniquement les jours! (7 jours = semaine ; 30 jours = mois)")
    private String frequency;

//    @NotEmpty(message = "Spécifiez la date démarrage!")
    private String start_date;

    private String created_at;

//    @NotEmpty(message = "Précisez le Montant de chaque période pour chaque personne")
    private Double amount;

    private String amountString;
    private String draw;
    private Long turn_user_id;
    private Integer step_number;

    private Boolean active;
}
