package com.zhassurbek.mixproject.model;

import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
import javax.validation.constraints.NotNull;
import lombok.Data;

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
