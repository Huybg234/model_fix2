package com.example.recruitmentwebsitesystem.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "users")
public class Users implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ")
    @SequenceGenerator(name = "USERS_SEQ", sequenceName = "USERS_SEQ", allocationSize = 1, initialValue = 1)
    int id;

    @OneToOne(targetEntity = Profiles.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "profiles_id", nullable = false)
    Profiles profiles;

    @Column(name = "full_name", nullable = false)
    String fullName;

    @Column(name = "email", nullable = false)
    String email;

    @Column(name = "user_name", nullable = false)
    String userName;

    @Column(name = "password", nullable = false)
    String passWord;

    @Column(name = "phone_number", nullable = false)
    String phone_number;

    @Column(name = "homeTown", nullable = false)
    String homeTown;

    @Column(name = "gender", nullable = false)
    String gender;

    @Column(name = "birthday", nullable = false)
    Date birthday;

    @Column(name = "avatar", nullable = false)
    String avatar;

    @Column(name = "user_status", nullable = false)
    Integer userStatus;

    @Column(name = "is_delete", nullable = false)
    boolean isDelete;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "authority",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles=new HashSet<>();
}
