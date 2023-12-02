package com.starlug.daret.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Table(name = "darets")
public class Daret {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long created_by;
    private String name;
    private Integer participant_number;
    private Integer frequency_by_days; // 7 -> week; 14; 2 weeks;

    private String start_date;
    private Double amount;
    private String draw;
    private Long turn_user_id;
    private Integer step_number;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="darets_users",
            joinColumns={@JoinColumn(name="daret_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="user_id", referencedColumnName="id")})
    private List<User> participants = new ArrayList<>();


}
