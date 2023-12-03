package com.starlug.daret.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Table(name = "darets")
public class Daret {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long created_by;

    @JsonFormat(pattern="yyyy-MM--dd HH:mm:ss")
    private Date created_at;

    @Column(unique = true)
    private String name;

    private Integer participant_number;
    private Integer frequency_by_days; // 7 -> week; 14; 2 weeks;

    @JsonFormat(pattern="yyyy-MM--dd HH:mm:ss")
    private Date start_date;

    private Double amount;
    private String draw;
    private Long turn_user_id;
    private Integer step_number;

    @Column(columnDefinition="tinyint(1) default 0")
    private Boolean active;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="darets_users",
            joinColumns={@JoinColumn(name="daret_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="user_id", referencedColumnName="id")})
    private List<User> participants = new ArrayList<>();


}
