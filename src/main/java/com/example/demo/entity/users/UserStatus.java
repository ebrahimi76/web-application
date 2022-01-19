package com.example.demo.entity.users;

import com.example.demo.entity.core.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserStatus extends BaseEntity {
    private String status;
}
