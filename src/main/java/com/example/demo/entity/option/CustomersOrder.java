package com.example.demo.entity.option;

import com.example.demo.entity.core.BaseEntity;
import com.example.demo.entity.users.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CustomersOrder extends BaseEntity {
    @ManyToOne(cascade = CascadeType.ALL)
    private HomeServiceOption service;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    @Builder.Default
    private List<Suggestion> suggestions=new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Suggestion selectSuggestion;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
