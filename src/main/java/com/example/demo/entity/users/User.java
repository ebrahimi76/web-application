package com.example.demo.entity.users;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class User extends BaseUser {
    @Builder.Default
    private Date date = new Date();
    private BigDecimal balance;
    private long points;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserRole> roles;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserStatus> statuses;

}
