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

    @NotEmpty(message = "Specify the name of your daret!")
    private String name;

    @NotEmpty(message = "Specify the number of your daret!")
    private Integer participant_number;

//    @NotEmpty(message = "Specify the frequency of your daret using days only! (7days = week; 30days = month)")
    private String frequency;

//    @NotEmpty(message = "Specify the name of your daret!")
    private String start_date;

    private String created_at;

//    @NotEmpty(message = "Specify the target amount of your daret")
    private Double amount;

    private String amountString;
    private String draw;
    private Long turn_user_id;
    private Integer step_number;

    private Boolean active;
}
