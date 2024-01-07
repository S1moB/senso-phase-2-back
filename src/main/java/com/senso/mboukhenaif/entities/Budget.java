package com.senso.mboukhenaif.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "budget_senso")
@Getter
@Setter
@NoArgsConstructor
public class Budget {
    @Id
    @Column(name = "budget_code")
    private String budgetCode;
    @Column(name = "budget_amount")
    private Integer budgetAmount;
    @Column(name = "budget_duration")
    private Integer budgetDuration;
}
