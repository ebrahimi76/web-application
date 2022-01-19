package com.example.demo.entity.users;

import com.example.demo.entity.option.CustomersOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Customer extends User {

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @Builder.Default
    private List<CustomersOrder> orders = new ArrayList<>();

}
