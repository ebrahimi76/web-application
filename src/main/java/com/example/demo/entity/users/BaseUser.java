package com.example.demo.entity.users;

import com.example.demo.entity.core.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class BaseUser extends BaseEntity {
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
    @Lob
    @Builder.Default
    private byte[] photo = new byte[300_000];
}
