package ru.cyberherbs.cactus.Models;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;
    @Column(name = "email")
    @Email(message = "*Пожалуйста, введите верный email")
    @NotEmpty(message = "*Пожалуйста, введите email")
    private String email;
    @Column(name = "password")
    @Length(min = 5, message = "*Пароль должен содержать минимум 5 символов")
    @NotEmpty(message = "*Введите парль")
    private String password;
    @Column(name = "name")
    @NotEmpty(message = "*Введите ваше имя")
    private String name;
    @Column(name = "last_name")
    @NotEmpty(message = "*Введите вашу фамилию")
    private String lastName;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}