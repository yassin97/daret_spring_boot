package com.starlug.daret.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DaretDto {
    private Long id;

    private Long created_by;

    @NotEmpty(message = "Specify the name of your daret!")
    private String name;

    @NotEmpty(message = "Specify the number of your daret!")
    private Integer participant_number;

    @NotEmpty(message = "Specify the frequency of your daret using days only! (7days = week; 30days = month)")
    private Integer frequency_by_days;

    private String start_date;

    @NotEmpty(message = "Specify the target amount of your daret")
    private Double amount;
    private String draw;
    private Long turn_user_id;
    private Integer step_number;
}
