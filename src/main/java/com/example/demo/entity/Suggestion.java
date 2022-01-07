package com.example.demo.entity;

import com.example.demo.entity.core.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Suggestion extends BaseEntity {

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Employee employee;
    private String description;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private CustomersOrder order;

}
