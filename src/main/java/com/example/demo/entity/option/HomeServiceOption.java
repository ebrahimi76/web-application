package com.example.demo.entity.option;

import com.example.demo.entity.core.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class HomeServiceOption extends BaseEntity {
    private String name;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private HomeService homeService;
    private BigDecimal basePrice;
    private String description;
}
