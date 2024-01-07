package com.senso.mboukhenaif.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity(name = "project_senso")
@Getter
@Setter
@NoArgsConstructor
public class Project {
    @Id
    @Column(name = "project_id")
    private String projectId;
    @Column(name = "project_start_date")
    private Date startDate;
    @Column(name = "project_end_date")
    private Date endDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User assignedUser;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "budget_id")
    private Budget projectBudget;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private Category projectCategory;
}
