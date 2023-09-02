package com.zhassurbek.mixproject.model;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@Entity
@Table(name = "user", schema = "content")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    @NotNull
    @Column(unique = true)
    private String username;
    private String email;
    private String password;

}
