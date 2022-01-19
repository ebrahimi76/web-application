package com.example.demo.entity.users;

import com.example.demo.entity.option.HomeServiceOption;
import com.example.demo.entity.option.Suggestion;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Employee extends User {
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<Suggestion> suggestions = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Builder.Default
    private List<HomeServiceOption> expertises = new ArrayList<>();

}
