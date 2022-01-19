package com.example.demo.entity.users;

import com.example.demo.entity.core.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserRole extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private UserRoleOption role;
}
