package com.example.demo.entity.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@SuperBuilder
public class Admin extends User {
}
