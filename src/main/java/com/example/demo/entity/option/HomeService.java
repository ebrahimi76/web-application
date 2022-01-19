package com.example.demo.entity.option;

import com.example.demo.entity.core.BaseEntity;
import lombok.*;
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
public class HomeService extends BaseEntity {
    private String name;
    @OneToMany(mappedBy = "homeService", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<HomeServiceOption> subServices = new ArrayList<>();
}
